package org.example.battleships.ships;

import org.example.battleships.Coordinate;
import org.example.battleships.ships.Ship;
import org.example.battleships.utils.Orientation;

import java.util.HashMap;
import java.util.Map;

public class ShipImpl implements Ship {
    private int shipLength;
    private Map<Coordinate,Boolean> hitMap = new HashMap<>();

    public ShipImpl(int rowIndex, int colIndex, int length, Orientation o) {
        shipLength = length;

        for (int i = 0; i < shipLength; i++) {
            Coordinate c = new Coordinate(rowIndex,colIndex);
            hitMap.put(c,false);
            if (o == Orientation.BOW)
                rowIndex++;
            else
                colIndex++;
        }
    }

    public void registerHit(int row, int col) {
        Coordinate c = new Coordinate(row,col);
        if (hitMap.containsKey(c)) {
            boolean hit = hitMap.get(c);
            if (!hit) {
                System.out.println("That is a HIT!");
                hitMap.put(c,true);
            } else {
                System.out.println("That is a MISS!");
            }
        }
    }

    public boolean isSunk() {
        return (!hitMap.containsValue(false)) ? true : false;
    }
}
