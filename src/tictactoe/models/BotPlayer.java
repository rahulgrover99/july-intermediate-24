package tictactoe.models;

import tictactoe.strategies.BotPlayingStrategy;
import tictactoe.strategies.BotPlayingStrategyFactory;

public class BotPlayer extends Player{
    BotDifficultyLevel botDifficultyLevel;

    public BotPlayer(String name, String id, Character symbol, BotDifficultyLevel difficultyLevel) {
        super(name, id, symbol);
        this.botDifficultyLevel = difficultyLevel;
    }

    @Override
    public Move makeMove(Board board) {
        // TODO: Decide how a bot makes a move.
        // Implement all the bot playing strategies.
        BotPlayingStrategy botPlayingStrategy = BotPlayingStrategyFactory.get(botDifficultyLevel);
        return botPlayingStrategy.suggestMove(board);
    }
}
