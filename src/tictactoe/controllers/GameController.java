package tictactoe.controllers;

import multipleinterfaces.B;
import tictactoe.models.*;
import tictactoe.strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    // TODO: Complete the undo move functionality.
    public void undoMove(Game game) {
        Move lastMove = game.moves.get(game.moves.size() - 1);
        game.moves.remove(lastMove);

        // Update the board and next player index.
        Cell cell = game.board.cells.get(lastMove.cell.row).get(lastMove.cell.col);
        cell.cellState = CellState.FREE;
        cell.player = null;

        // Update the last player index.


        game.currentPlayerIndex =
                (game.currentPlayerIndex + game.players.size() - 1)
                        % game.players.size();

//        game.currentPlayerIndex--;
//        if (game.currentPlayerIndex < 0) {
//            game.currentPlayerIndex = game.players.size() - 1;
//        }
    }

    // Public API for users to start a game.
    public Game startGame(
            int dimension,
            List<Player> players,
            List<WinningStrategy> winningStrategies
    ) {
        return Game.getBuilder()
                .setBoard(new Board(dimension))
                .setGameState(GameState.ONGOING)
                .setMoves(new ArrayList<>())
                .setPlayers(players)
                .setCurrentPlayerIndex(0)
                .setWinningStrategies(winningStrategies)
                .build();
    }

    // Public API to display the board.
    public String displayBoard(Game game) {
        return game.board.toString();
    }

    public GameState getGameState(Game game) {
        return game.gameState;
    }


    /**
     * Make next move allows the clients to make the next move in
     * the game
     *
     * If its a human player, they will be asked for the move
     * else bot playing strategy would simply suggest a move
     *
     * Validate the move against the board .
     *
     * Update the board with the suggested move.
     *
     * Change the game state if needed.
     *
     *
     * @param game
     */
    public void makeNextMove(Game game) {
        Player player = game.players.get(game.currentPlayerIndex);
        System.out.printf("Its %s move\n", player.name);
        // Something returned to us by the user or the bot algo.
        Move move = player.makeMove(game.board);
        move.cell.player = player;
        move.cell.cellState = CellState.OCCUPIED;

        // Validate if this is really valid.
        try {
            validate(move, game.board);
        } catch(IllegalArgumentException e) {
            // Handle gracefully.
        }

        // Update the board.
        updateBoard(game.board, move.cell, player);

        // Check if some player won -> If yes, update the game state.
        checkWinningStrategies(game, move);

        // Update the next Player index.
        game.moves.add(move);
        game.currentPlayerIndex += 1;
        game.currentPlayerIndex %= game.players.size();


        // What if there are no more cells to make a move.
        checkIfNoMoreCells(game);

    }

    private static void checkIfNoMoreCells(Game game) {
        if (game.moves.size() == game.board.N * game.board.N && game.gameState != GameState.COMPLETED) {
            game.gameState = GameState.DRAW;
        }
    }

    private static void checkWinningStrategies(Game game, Move move) {
        for (WinningStrategy winningStrategy: game.winningStrategies) {
            if (winningStrategy.checkWinner(game.board, move)) {
               game.gameState = GameState.COMPLETED;
               game.winner = move.cell.player;
            }
        }
    }

    private static void updateBoard(Board board, Cell cell, Player player) {
        int row = cell.row;
        int col = cell.col;

        Cell cellToBeUpdated = board.cells.get(row).get(col);

        cellToBeUpdated.cellState = CellState.OCCUPIED;
        cellToBeUpdated.player = player;
    }

    private static void validate(Move move, Board board) {
        Cell cell = move.cell;
        if (cell.row < 0 || cell.col < 0 || cell.row >= board.N || cell.col >= board.N) {
            throw new IllegalArgumentException("Cell out of bounds.");
        }

        if (board.cells.get(cell.row).get(cell.col).cellState == CellState.OCCUPIED) {
            throw new IllegalArgumentException("Cell occupied.");
        }
    }
}
