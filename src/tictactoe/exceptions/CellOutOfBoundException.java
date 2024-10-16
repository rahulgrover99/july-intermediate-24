package tictactoe.exceptions;

public class CellOutOfBoundException extends Exception{
    public CellOutOfBoundException() {
        super("Cell is out of bounds");
    }
}
