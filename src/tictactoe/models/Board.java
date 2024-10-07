package tictactoe.models;

import multipleinterfaces.A;

import java.util.ArrayList;
import java.util.List;

public class Board {

    public int N;
    public List<List<Cell>> cells;

    public Board(int n) {
        N = n;
        this.cells = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            cells.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                cells.get(i).add(new Cell(i, j));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Cell cell = cells.get(i).get(j);
                if (cell.cellState == CellState.FREE) {
                    stringBuilder.append("|  ");
                } else {
                    stringBuilder.append(String.format("| %c ", cell.player.symbol));
                }
            }
            stringBuilder.append("|\n");
        }
        return stringBuilder.toString();
    }
}
