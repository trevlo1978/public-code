package org.example.battleships;

import org.example.battleships.ships.Ship;
import org.example.battleships.ships.ShipImpl;
import org.example.battleships.utils.Orientation;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GameBoard {
    int[][] board = new int[Battleships.BOARD_SIZE][Battleships.BOARD_SIZE];
    private static int WATER = 0;
    private Map<Integer, Ship> shipMap = new HashMap<>();

    public void init(int[] shipTypes) {
        initBoard();
        for (int shipLength : shipTypes) {
            Ship ship = createShipOfLength(shipLength);
            shipMap.put(shipLength,ship);
        }
    }

    public int shipsLeft() {
        return shipMap.size();
    }

    public void processAttack(int row, int col) {
        int boardValue = board[row][col];
        Ship ship = null;
        if (boardValue != WATER) {
            //Can only be a ship
            ship = shipMap.get(boardValue);
        } else {
            System.out.println("That was a MISS IN THE WATER!");
            return;
        }
        if (ship != null) {
            ship.registerHit(row,col);
            if (ship.isSunk()) {
                System.out.println("SHIP SIZE " + boardValue + " IS SUNK!");
                shipMap.remove(boardValue);
            }
        }
    }

    private void initBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = WATER;
            }
        }
    }

    private Ship createShipOfLength(int shipLength) {
        boolean created = false;
        Ship ship = null;
        do {
            Random rn = new Random();
            int row = rn.nextInt(Battleships.BOARD_SIZE);
            int col = rn.nextInt(Battleships.BOARD_SIZE);
            Orientation orientation = (rn.nextInt(2) == 0) ? Orientation.BOW : Orientation.PORT;
            if (canPlaceShip(row, col, shipLength, orientation)) {
                ship = placeShip(row, col, shipLength, orientation);
                created = true;
            }
        } while (!created);
        return ship;
    }

    private boolean canPlaceShip(int row, int col, int shipLength, Orientation ori) {
        //Check OOB
        if (ori == Orientation.BOW) {
            if (row + shipLength > board.length - 1) return false;
        } else if (col + shipLength > board.length - 1) return false;

        //Check for ship intersection
        if (ori == Orientation.BOW) {
            for (int i = row; i < shipLength + row; i++) {
                if (board[i][col] > 0) return false;
            }
        } else {
            for (int i = col; i < shipLength + col; i++) {
                if (board[row][i] > 0) return false;
            }
        }
        return true;
    }

    private Ship placeShip(int row, int col, int shipLength, Orientation ori) {
        for (int i = 0; i < shipLength; i++) {
            if (ori == Orientation.BOW) {
                board[row + i][col] = shipLength;
            } else {
                board[row][col + i] = shipLength;
            }
        }
        return new ShipImpl(row, col, shipLength, ori);
    }
}
