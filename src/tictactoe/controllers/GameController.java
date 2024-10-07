package tictactoe.controllers;

import multipleinterfaces.B;
import tictactoe.models.Board;
import tictactoe.models.Game;
import tictactoe.models.GameState;
import tictactoe.models.Player;
import tictactoe.strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    // Public API for users to start a game.
    public Game startGame(
            int dimension,
            List<Player> players,
            List<WinningStrategy> winningStrategies
    ) {
        return Game.getBuilder()
                .setBoard(new Board(dimension))
                .setGameState(GameState.INITIALISING)
                .setMoves(new ArrayList<>())
                .setPlayers(players)
                .setCurrentPlayerIndex(0)
                .setWinningStrategies(winningStrategies)
                .build();
    }



}
