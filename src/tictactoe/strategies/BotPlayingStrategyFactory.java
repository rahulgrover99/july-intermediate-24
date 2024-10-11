package tictactoe.strategies;

import tictactoe.models.BotDifficultyLevel;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy get(BotDifficultyLevel difficultyLevel) {
        return switch (difficultyLevel) {
            case EASY -> new EasyBotPlayingStrategy();
            default -> new MediumBotPlayingStrategy();
        };
    }

}
