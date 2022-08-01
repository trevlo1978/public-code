package org.example.battleships;

import java.util.Objects;

public class Coordinate {
    private final int row;
    private final int col;
    private int hashCode;

    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
        this.hashCode = Objects.hash(row, col);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Coordinate that = (Coordinate) o;
        return row == that.row && col == that.col;
    }

    @Override
    public int hashCode() {
        return this.hashCode;
    }
}
