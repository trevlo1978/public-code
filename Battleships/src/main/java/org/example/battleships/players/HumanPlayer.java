package org.example.battleships.players;

import org.example.battleships.GameBoard;
import org.example.battleships.utils.GameUtils;

import java.util.Scanner;

public class HumanPlayer implements Player {

    GameBoard gameBoard;
    int boardSize;

    public HumanPlayer(GameBoard gameBoard, int boardSize){
        this.gameBoard = gameBoard;
        this.boardSize = boardSize;
    }

    @Override
    public void takeTurn() {
        System.out.println("\nPLAYER TURN");
        String X;
        int col = -1;
        int row = -1;
        do {
            Scanner input = new Scanner(System.in);
            // X axis is the columns
            System.out.print("Enter X coordinate (A-J): ");
            X = input.next();
            col = GameUtils.convertAlpha(X);
            // Y axis is the rows
            System.out.print("Enter Y coordinate (1-10): ");
            row = input.nextInt();
            row -= 1;

            if ((col >= 0 && col < boardSize) && (row >= 0 && row < boardSize)) {
                gameBoard.processAttack(row,col);
            }
            else if ((col < 0 || col >= boardSize) || (row < 0 || row >= boardSize))
                System.out.println("You can't place ships outside the " + boardSize + " by " + boardSize + " grid");
        } while ((col < 0 || col >= boardSize) || (row < 0 || row >= boardSize));
    }

    @Override
    public boolean isGameOver() {
        return gameBoard.shipsLeft() == 0;
    }
}
