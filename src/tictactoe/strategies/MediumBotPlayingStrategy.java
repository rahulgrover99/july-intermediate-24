package tictactoe.strategies;

import tictactoe.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

public class MediumBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move suggestMove(Board board) {
        int n = board.N;
        List<Cell> availableCells = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board.cells.get(i).get(j).cellState.equals(CellState.FREE)) {
                    availableCells.add(board.cells.get(i).get(j));
                }
            }
        }

        int x = RandomGenerator.getDefault().nextInt() % availableCells.size();

        Cell cell = availableCells.get(x);

        return new Move(cell.row, cell.col);
    }
}
