package org.example.battleships.ships;

public interface Ship {
    void registerHit(int row, int col);
    boolean isSunk();
}
