package tictactoe.models;

public abstract class Player {
    public String name;
    String id;
    Character symbol;

    public Player(String name, String id, Character symbol) {
        this.name = name;
        this.id = id;
        this.symbol = symbol;
    }

    public abstract Move makeMove(Board board);
}
