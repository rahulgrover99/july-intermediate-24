package tictactoe.models;

import tictactoe.strategies.WinningStrategy;

import java.util.List;

public class Game {
    public Board board;
    List<Player> players;
    int currentPlayerIndex;
    List<WinningStrategy> winningStrategies;
    List<Move> moves;
    GameState gameState;

    public static Builder getBuilder() {
        return new Builder();
    }

    private Game(Builder builder) {
        validate(builder);
        this.board = builder.board;
        this.gameState = builder.gameState;
        this.currentPlayerIndex = builder.currentPlayerIndex;
        this.players = builder.players;
        this.winningStrategies = builder.winningStrategies;
        this.moves = builder.moves;
    }

    private static void validate(Builder builder) {
        // 1. All players have different symbols.
        // 2. Only one bot player allowed in the game.
        // 3. Minimum 2 players to play the game.
        // 4. N > 1
    }

    public static class Builder {

        Board board;
        List<Player> players;
        int currentPlayerIndex;
        List<WinningStrategy> winningStrategies;
        List<Move> moves;
        GameState gameState;

        public Board getBoard() {
            return board;
        }

        public Builder setBoard(Board board) {
            this.board = board;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public int getCurrentPlayerIndex() {
            return currentPlayerIndex;
        }

        public Builder setCurrentPlayerIndex(int currentPlayerIndex) {
            this.currentPlayerIndex = currentPlayerIndex;
            return this;
        }

        public List<WinningStrategy> getWinningStrategies() {
            return winningStrategies;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public List<Move> getMoves() {
            return moves;
        }

        public Builder setMoves(List<Move> moves) {
            this.moves = moves;
            return this;
        }

        public GameState getGameState() {
            return gameState;
        }

        public Builder setGameState(GameState gameState) {
            this.gameState = gameState;
            return this;
        }

        public Game build() {
            return new Game(this);
        }

    }

}
