package tictactoe.models;

public class BotPlayer extends Player{
    BotDifficultyLevel botDifficultyLevel;

    public BotPlayer(String name, String id, Character symbol) {
        super(name, id, symbol);
    }

    @Override
    public Move makeMove(Board board) {
        // TODO: Decide how a bot makes a move.
        // Implement all the bot playing strategies.
        return new Move(0, 0);
    }
}
