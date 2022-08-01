package org.example.battleships;

import org.example.battleships.utils.GameUtils;

import java.util.Random;
import java.util.Scanner;

public class Battleships {
    public static int BOARD_SIZE = 10;
    GameBoard playerBoard;
    GameBoard computerBoard;

    public void startGame() {
        //setup boards
        playerBoard = new GameBoard();
        computerBoard = new GameBoard();
        //deploy ships
        int[] ships = new int[]{2,3,4,5};
        playerBoard.init(ships);
        computerBoard.init(ships);

        playGame();
    }

    private void playGame() {
        while (!gameOver()) {
            playerTurn();
            computerTurn();
        }
    }

    private boolean gameOver() {
        if (computerBoard.shipsLeft() == 0) {
            System.out.println("Player Wins!");
            return true;
        } else if (playerBoard.shipsLeft() == 0) {
            System.out.println("Computer Wins!");
            return true;
        }
        return false;
    }

    private void playerTurn(){
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

            if ((col >= 0 && col < BOARD_SIZE) && (row >= 0 && row < BOARD_SIZE)) {
                computerBoard.processAttack(row,col);
            }
            else if ((col < 0 || col >= BOARD_SIZE) || (row < 0 || row >= BOARD_SIZE))
                System.out.println("You can't place ships outside the " + BOARD_SIZE + " by " + BOARD_SIZE + " grid");
        } while ((col < 0 || col >= BOARD_SIZE) || (row < 0 || row >= BOARD_SIZE));
    }

    public void computerTurn() {
        System.out.println("\nCOMPUTER TURN");

        Random rn = new Random();
        int row = rn.nextInt(Battleships.BOARD_SIZE);
        int col = rn.nextInt(Battleships.BOARD_SIZE);

        if ((col >= 0 && col < BOARD_SIZE) && (row >= 0 && row < BOARD_SIZE)) {
            playerBoard.processAttack(row,col);
        }
    }

    public static void main(String[] args) {
        String start;
        System.out.println("**** Welcome to iSpot BattleShips ****");
        do {
            System.out.println("Type s to start");
            Scanner input = new Scanner(System.in);
            start = input.next();
        } while (!start.equals("s"));

        Battleships game = new Battleships();
        game.startGame();

        System.out.println("**** Thank you for playing ****");
    }
}
