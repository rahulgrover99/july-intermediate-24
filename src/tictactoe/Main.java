package tictactoe;

import tictactoe.controllers.GameController;
import tictactoe.models.*;
import tictactoe.strategies.ColumnWinningStrategy;
import tictactoe.strategies.RowWinningStrategy;
import tictactoe.strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController();

        Player player = new HumanPlayer("Rahul", "1", 'X');
        Player bPlayer = new HumanPlayer("Sanchit", "2", 'O');

        List<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new ColumnWinningStrategy());
        winningStrategies.add(new RowWinningStrategy());

        Game game = gameController.startGame(
                3,
                List.of(player, bPlayer),
                winningStrategies);

        System.out.println(game.board);

        while (gameController.getGameState(game) == GameState.ONGOING) {
            System.out.println(gameController.displayBoard(game));
            gameController.makeNextMove(game);
        }
        System.out.println(gameController.displayBoard(game));
        if (gameController.getGameState(game) == GameState.DRAW) {
            System.out.println("Game ended in a draw");
        } else {
            System.out.printf("The winner is %s", game.winner.name);
        }
        // 1. While GameState is IN_PROGRESS
        // 2. Display board.
        // 3. call makeMove() method
        // 4. DRAW OR WINNER -> Give out the winner name.
    }

}

