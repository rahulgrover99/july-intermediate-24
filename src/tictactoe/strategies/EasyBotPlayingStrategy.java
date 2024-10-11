package tictactoe.strategies;

import tictactoe.models.*;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{

    @Override
    public Move suggestMove(Board board) {

        // Whatever first cell is available
        // suggest that cell as a move.

        int n = board.N;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board.cells.get(i).get(j).cellState.equals(CellState.FREE)) {
                    return new Move(i, j);
                }
            }
        }
        return null;
    }
}
