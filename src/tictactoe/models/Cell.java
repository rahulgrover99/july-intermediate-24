package tictactoe.models;

public class Cell {
    public Player player;
    public CellState cellState;
    public int row;
    public int col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.cellState = CellState.FREE;
    }
}
