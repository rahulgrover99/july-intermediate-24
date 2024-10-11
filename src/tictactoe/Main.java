package tictactoe;

import tictactoe.controllers.GameController;
import tictactoe.models.*;
import tictactoe.strategies.ColumnWinningStrategy;
import tictactoe.strategies.DiagnolWinningStrategy;
import tictactoe.strategies.RowWinningStrategy;
import tictactoe.strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController();

        Player player = new HumanPlayer("Rahul", "1", 'X');
        Player bPlayer = new BotPlayer("Sanchit", "2", 'O', BotDifficultyLevel.EASY);

        List<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new ColumnWinningStrategy());
        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new DiagnolWinningStrategy());

        Game game = gameController.startGame(
                3,
                List.of(player, bPlayer),
                winningStrategies);

        System.out.println(game.board);

        while (gameController.getGameState(game) == GameState.ONGOING) {
            gameController.makeNextMove(game);
            System.out.println(gameController.displayBoard(game));
            System.out.println("Would you like to undo the last move.");
            Scanner sc = new Scanner(System.in);
            String c = sc.next();

            if (c.equals("Y")) {
                gameController.undoMove(game);
                System.out.println(gameController.displayBoard(game));
            }

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

