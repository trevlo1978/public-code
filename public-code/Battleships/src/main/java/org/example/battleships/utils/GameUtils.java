package org.example.battleships.utils;

public class GameUtils {

    public static int convertAlpha(String alpha) {
        char ch = alpha.toLowerCase().charAt(0);
        int n = (int)ch - (int)'a';
        return n;
    }
}
