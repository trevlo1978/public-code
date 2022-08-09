package org.example.battleships.players;

import org.example.battleships.Battleships;
import org.example.battleships.GameBoard;

import java.util.Random;

public class ComputerPlayer implements Player {

    GameBoard gameBoard;
    int boardSize;

    public ComputerPlayer(GameBoard gameBoard, int boardSize){
        this.gameBoard = gameBoard;
        this.boardSize = boardSize;
    }

    @Override
    public void takeTurn() {
        System.out.println("\nCOMPUTER TURN");

        Random rn = new Random();
        int row = rn.nextInt(Battleships.BOARD_SIZE);
        int col = rn.nextInt(Battleships.BOARD_SIZE);

        if ((col >= 0 && col < boardSize) && (row >= 0 && row < boardSize)) {
            gameBoard.processAttack(row,col);
        }
    }

    @Override
    public boolean gameOver() {
        return gameBoard.shipsLeft() == 0;
    }
}
