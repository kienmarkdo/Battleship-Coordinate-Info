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
                () -> {
                    Battleship.cleanString(nullStr);
                }, "failed null string");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Battleship.cleanString(tooLong);
                }, "failed string with length greater than 2");

    }

    @Test
    public void isValidCoordinate() {
        char[] inBounds = {'1', '5'}; // 15 represents (1,5)

        // 00 is (0,0), 08 is (0,8), etc . . .
        // this array contains the bottom left, bottom right, top left, top right coordinates in the 9x9 board
        //      from left to right where the x coordinate is an integer.
        char[][] cornerInt = {{'0', '0'}, {'0', '8'}, {'8', '0'}, {'8', '8'}};
        for (char[] corner : cornerInt) {
            Assertions.assertTrue(Battleship.isValidCoordinate(corner),
                    "(" + corner[0] + ", " + corner[1] + ")\nfailed corner coordinates (int)");
        }

        // a0 is (a,0), a8 is (a,8), etc . . .
        // this array contains the bottom left, bottom right, top left, top right coordinates in the 9x9 board
        //      from left to right where the x coordinate is a character.
        char[][] cornerChar = {{'a', '0'}, {'0', '8'}, {'i', '0'}, {'i', '8'}};
        for (char[] corner : cornerChar) {
            Assertions.assertTrue(Battleship.isValidCoordinate(corner),
                    "(" + corner[0] + ", " + corner[1] + ")\nfailed corner coordinates (char)");
        }

        // out of bounds and incorrect format tests, these should return false
        char[][] errorCases = {{'9', '9'}, {'9', '5'}, {'1', '9'}, {'j', 'j'}, {'l', 'l'}, {'j', '9'}};
        for (char[] error : errorCases) {
            Assertions.assertFalse(Battleship.isValidCoordinate(error),
                    "(" + error[0] + ", " + error[1] + ")\n" +
                            "failed out of bounds or incorrect coordinate format (character in y coordinate)");
        }

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