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

        Player player = new HumanPlayer();
        Player bPlayer = new BotPlayer();

        List<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new ColumnWinningStrategy());
        winningStrategies.add(new RowWinningStrategy());

        Game game = gameController.startGame(
                3,
                List.of(player, bPlayer),
                winningStrategies);

        System.out.println(game.board);

    }

}

