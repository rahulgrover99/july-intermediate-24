package tictactoe.strategies;

import tictactoe.models.Board;
import tictactoe.models.Cell;
import tictactoe.models.CellState;
import tictactoe.models.Move;

public class ColumnWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move lastMove) {
        int column = lastMove.cell.col;
        for (int i = 0; i < board.N; i++) {
            Cell cell = board.cells.get(i).get(column);
            // If any cell in the row is not occupied or
            // the cell is occupied by some other player.
            // In that scenario, noone wins.
            if (cell.cellState == CellState.FREE
                    || cell.player != lastMove.cell.player) {
                return false;

            }
        }
        return true;
    }
}
