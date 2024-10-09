package tictactoe.strategies;
import tictactoe.models.Game;
import tictactoe.models.Move;
public interface BotPlayingStrategy {
    Move suggestMove(Game game);
}
