package tictactoe.models;

public class Move {
    public Cell cell;

    public Move(int row, int col) {
        this.cell = new Cell(row, col);
    }
}
