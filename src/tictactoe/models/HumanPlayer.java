package tictactoe.models;

import java.util.Scanner;

public class HumanPlayer extends Player{
    String email;

    public HumanPlayer(String name, String id, Character symbol) {
        super(name, id, symbol);
    }


    @Override
    public Move makeMove(Board board) {
        System.out.println("Please enter your move:");
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();

        return new Move(row, col);


    }
}
