package org.example.battleships;

import org.example.battleships.players.ComputerPlayer;
import org.example.battleships.players.HumanPlayer;
import org.example.battleships.players.Player;
import org.example.battleships.utils.GameUtils;

import java.util.Random;
import java.util.Scanner;

public class Battleships {
    public static int BOARD_SIZE = 10;
    Player humanPlayer;
    Player computerPlayer;

    public void startGame() {
        //setup boards
        GameBoard playerBoard = new GameBoard();
        GameBoard computerBoard = new GameBoard();
        //deploy ships
        int[] ships = new int[]{2,3,4,5};
        playerBoard.init(ships);
        computerBoard.init(ships);

        humanPlayer = new HumanPlayer(computerBoard, BOARD_SIZE);
        computerPlayer = new ComputerPlayer(playerBoard, BOARD_SIZE);

        playGame();
    }

    private void playGame() {
        while (!gameOver()) {
            humanPlayer.takeTurn();
            computerPlayer.takeTurn();
        }
    }

    private boolean gameOver() {
        if (humanPlayer.gameOver()) {
            System.out.println("Human Player Wins!");
            return true;
        } else if (computerPlayer.gameOver()) {
            System.out.println("Computer Player Wins!");
            return true;
        }
        return false;
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
