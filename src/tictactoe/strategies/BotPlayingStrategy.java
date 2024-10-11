package tictactoe.strategies;
import tictactoe.models.Board;
import tictactoe.models.Game;
import tictactoe.models.Move;
public interface BotPlayingStrategy {
    Move suggestMove(Board board);
}
