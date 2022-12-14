package org.example.battleships;

import org.example.battleships.ships.ShipImpl;
import org.example.battleships.utils.Orientation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ShipTest {
    private String absolutePath;

    @Before
    public void setUp() throws Exception {
        Path resourceDirectory = Paths.get("src","test","resources");
        absolutePath = resourceDirectory.toFile().getAbsolutePath();
    }

    @Test
    public void sinkNewBowShip() {
        ShipImpl ship = new ShipImpl(0,0,2, Orientation.BOW);

        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));

        ship.registerHit(0,0);
        ship.registerHit(1,0);

        final String standardOutput = myOut.toString();
        String expected = "That is a HIT!\n" +
                "That is a HIT!\n";

        Assert.assertEquals(expected, standardOutput);

        Assert.assertEquals(true, ship.isSunk());
    }

    @Test
    public void sinkNewPortShip() {
        ShipImpl ship = new ShipImpl(0,0,2, Orientation.PORT);

        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));

        ship.registerHit(0,0);
        ship.registerHit(0,1);

        final String standardOutput = myOut.toString();
        String expected = "That is a HIT!\n" +
                "That is a HIT!\n";

        Assert.assertEquals(expected, standardOutput);

        Assert.assertEquals(true, ship.isSunk());
    }

    @Test
    public void missNewPortShip() {
        ShipImpl ship = new ShipImpl(0,0,2, Orientation.PORT);

        final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));

        ship.registerHit(0,0);
        ship.registerHit(0,0);

        final String standardOutput = myOut.toString();
        String expected = "That is a HIT!\n" +
                "That is a MISS!\n";

        Assert.assertEquals(expected, standardOutput);

        Assert.assertEquals(false, ship.isSunk());
    }
}
