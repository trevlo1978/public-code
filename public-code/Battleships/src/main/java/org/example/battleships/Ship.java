package org.example.battleships;

import org.example.battleships.utils.Orientation;

public class Ship {
    private int shipLength;
    private int row[];
    private int col[];
    private boolean isHit[];
    private int numHits;

    public Ship(int rowIndex, int colIndex, int length, Orientation o) {
        row = new int[length];
        col = new int[length];
        isHit = new boolean[length];
        numHits = 0;
        shipLength = length;

        for (int i = 0; i < shipLength; i++) {
            row[i] = rowIndex;
            col[i] = colIndex;
            isHit[i] = false;
            if (o == Orientation.BOW)
                rowIndex++;
            else
                colIndex++;
        }
    }

    public boolean registerHit(int rowIndex, int colIndex) {
        for (int i = 0; i < shipLength; i++) {
            if (row[i] == rowIndex && col[i] == colIndex) {
                if (!isHit[i]) {
                    System.out.println("That is a HIT!");
                    isHit[i] = true;
                    numHits++;
                } else {
                    System.out.println("That is a MISS!");
                }
                return true;
            }
        }
        return false;
    }

    public boolean isSunk() {
        return (numHits == shipLength) ? true : false;
    }
}
