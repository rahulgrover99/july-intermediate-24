package tictactoe.strategies;

import tictactoe.models.Board;
import tictactoe.models.Cell;
import tictactoe.models.CellState;
import tictactoe.models.Move;

public class DiagnolWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move lastMove) {
        int n = board.N;
        int row = lastMove.cell.row;
        int col = lastMove.cell.col;

        int count = 0;
        if (row == col) {
            for (int i = 0; i < n; i++) {
                Cell cell = board.cells.get(i).get(i);
                if (cell.cellState == CellState.OCCUPIED
                        && cell.player == lastMove.cell.player) {
                    count++;
                }
            }
            if (count == n) return true;
        }
        count = 0;
        if (row + col == n - 1) {
            for (int i = 0; i < n; i++) {
                Cell cell = board.cells.get(i).get(n - i - 1);
                if (cell.cellState == CellState.OCCUPIED
                        && cell.player == lastMove.cell.player) {
                    count++;
                }
            }
            return (count == n);
        }
        return false;
    }
}
