import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class TestBattleship {

    @Test
    public void cleanString() {
        String regular = "55";
        String commas = "5,5";
        String spaces = " 5  5   ";
        String specialCharsSpaces = " (5, 5) ";
        String nullStr = null;
        String tooLong = "555";
        String expected = "55";


        Assertions.assertEquals(expected, Battleship.cleanString(regular), "Did not pass case: regular case");
        Assertions.assertEquals(expected, Battleship.cleanString(commas), "Did not pass case: string with commas");
        Assertions.assertEquals(expected, Battleship.cleanString(spaces), "Did not pass case: string with spaces");
        Assertions.assertEquals(expected, Battleship.cleanString(specialCharsSpaces), "Did not pass case: special characters and spaces");
        Assertions.assertThrows(NullPointerException.class,
                ()->{
                    Battleship.cleanString(nullStr);
                }, "Did not pass case: null string");
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->{
                    Battleship.cleanString(tooLong);
                }, "Did not pass case: string with length greater than 2");

    }

    @Test
    public void isValidCoordinate() {
    }

    @Test
    public void getEdgeAdjacentSquares() {
    }

    @Test
    public void getCornerAdjacentSquares() {
    }

    @Test
    public void getNonAdjacentSquares() {
    }
}