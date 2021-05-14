import java.util.Scanner;
import java.util.LinkedList;

/**
 * Name: Kien Do 300163370
 * Class: SEG2105[Z] Intro to Software Engineering (Spring 2021)
 * Professor Omar Badreddin
 * <p>
 * Purpose: Assignment 1
 */
public class Battleship {

    static Scanner input = new Scanner(System.in);

    // ********* helper method ********* //

    static void displayWelcomeMenu() {
        System.out.println("Enter the 9x9 battleship board coordinates and I will tell you the following:");
        System.out.println("-> Edge-adjacent squares");
        System.out.println("-> Corner-adjacent squares");
        System.out.println("-> Squares which are not adjacent at all\n");

        System.out.println("Enter the coordinates in any of the 5 formats below.");
        System.out.println("(5, 5) | 3 0 | 4,1 | a7 | b 2");
//        System.out.println("Example input/output:");
//        System.out.println(">> (5, 5)");
//        System.out.println("Sides are (6, 5), (4, 5), (5, 6), (5, 4)");
//        System.out.println("Corners are (6, 6), (4, 4), (6, 4), (4, 6)");
        System.out.println("=================================");
    } // end of method displayWelcomeMenu


    public static void displayCoordList(LinkedList<char[]> listOfCoords) {

        while (listOfCoords.peek() != null) {
            System.out.print("(" + listOfCoords.peek()[0] + ", " + listOfCoords.peek()[1] + ")");
            listOfCoords.pop();
            if (listOfCoords.peek() != null) {
                System.out.print(", ");
            }
        } // end of while loop
        System.out.println();
    } // end of displayCoordList


    public static String cleanString(String str) {

        // throw exception if input string is null
        if (str == null) {
            throw new NullPointerException("ERROR: Input string cannot be null.");
        }

        String cleanStr = str.toLowerCase(); // convert input string to lower case
        cleanStr = cleanStr.replaceAll("\\s", ""); // remove all spaces within the string including trailing spaces
        cleanStr = cleanStr.replaceAll("[^a-zA-Z0-9]", ""); // remove all commas
        cleanStr = cleanStr.replaceAll("[\\[\\](){}]", ""); // removes the following characters: [ ] ( ) { }

        if (cleanStr.length() > 2) {
            throw new IllegalArgumentException("ERROR: Unexpected invalid input.");
        }

        return cleanStr;
    } // end of cleanString method


    public static boolean isValidCoordinate(char[] coord) {
        boolean isValid = true;

        char x = coord[0];
        char y = coord[1];

        boolean xIsInBounds = (x >= 48 && x <= 56) || (x >= 97 && x <= 105);
        boolean yIsInBounds = (y >= 48 && y <= 56);

        // return false if x and/or y is not within the bounds of the board
        if (!xIsInBounds || !yIsInBounds) {
            isValid = false;
        }

        return isValid;
    } // end of isValidCoordinate


    public static LinkedList<char[]> getEdgeAdjacentSquares(char[] coord) {

        // error trap
        if (!isValidCoordinate(coord)) {
            throw new IllegalArgumentException("ERROR: x and/or y is not within the bounds of the battleship board.");
        }

        // list to store valid edge adjacent squares
        LinkedList<char[]> listOfCoords = new LinkedList<>();
        char x = coord[0];
        char y = coord[1];

        // set the default lower and upper bound to the ASCII value of the characters 0 and 8, respectively
        int xLowerBound = 48;
        int xUpperBound = 56;
        int yLowerBound = 48;
        int yUpperBound = 56;

        // change the lower and upper bound of x if it is a CHARACTER from a to i, inclusive (as opposed to an int)
        if (x >= 97) {
            xLowerBound = 97;
            xUpperBound = 105;
        }

        // add valid edge adjacent squares to the list
        if (x + 1 <= xUpperBound) {
            char[] temp = new char[2];
            temp[0] = (char) (x + 1);
            temp[1] = y;
            listOfCoords.add(temp);
        }
        if (x - 1 >= xLowerBound) {
            char[] temp = new char[2];
            temp[0] = (char) (x - 1);
            temp[1] = y;
            listOfCoords.add(temp);
        }

        if (y + 1 <= yUpperBound) {
            char[] temp = new char[2];
            temp[0] = x;
            temp[1] = (char) (y + 1);
            listOfCoords.add(temp);
        }
        if (y - 1 >= yLowerBound) {
            char[] temp = new char[2];
            temp[0] = x;
            temp[1] = (char) (y - 1);
            listOfCoords.add(temp);
        }

        return listOfCoords;

    } // end of method getEdgeAdjacentSquares


    public static LinkedList<char[]> getCornerAdjacentSquares(char[] coord) {

        // error trap
        if (!isValidCoordinate(coord)) {
            throw new IllegalArgumentException("ERROR: x and/or y is not within the bounds of the battleship board.");
        }

        // list to store valid corner adjacent squares
        LinkedList<char[]> listOfCoords = new LinkedList<>();
        char x = coord[0];
        char y = coord[1];

        // set the default lower and upper bound to the ASCII value of the characters 0 and 8, respectively
        int xLowerBound = 48;
        int xUpperBound = 56;
        int yLowerBound = 48;
        int yUpperBound = 56;

        // change the lower and upper bound of x if it is a CHARACTER from a to i, inclusive (as opposed to an int)
        if (x >= 97) {
            xLowerBound = 97;
            xUpperBound = 105;
        }

        // add valid corner adjacent squares to the list
        if (x + 1 <= xUpperBound && y + 1 <= yUpperBound) {
            char[] temp = new char[2];
            temp[0] = (char) (x + 1);
            temp[1] = (char) (y + 1);
            listOfCoords.add(temp);
        }
        if (x - 1 >= xLowerBound && y - 1 >= yLowerBound) {
            char[] temp = new char[2];
            temp[0] = (char) (x - 1);
            temp[1] = (char) (y - 1);
            listOfCoords.add(temp);
        }
        if (x + 1 <= xUpperBound && y - 1 >= yLowerBound) {
            char[] temp = new char[2];
            temp[0] = (char) (x + 1);
            temp[1] = (char) (y - 1);
            listOfCoords.add(temp);
        }
        if (x - 1 >= xLowerBound && y + 1 <= yUpperBound) {
            char[] temp = new char[2];
            temp[0] = (char) (x - 1);
            temp[1] = (char) (y + 1);
            listOfCoords.add(temp);
        }

        return listOfCoords;
    } // end of method getCornerAdjacentSquares


    public static LinkedList<char[]> getNonAdjacentSquares(char[] coord) {

        // error trap
        if (!isValidCoordinate(coord)) {
            throw new IllegalArgumentException("ERROR: x and/or y is not within the bounds of the battleship board.");
        }

        LinkedList<char[]> nonAdjList = new LinkedList<>();

        int x = coord[0];
        int y = coord[1];

        // default bound values that assume x is an integer from 0 to 8, inclusive
        int xLowerBound = 48;
        int xUpperBound = 57;
        int yLowerBound = 48;
        int yUpperBound = 57;

        // change the x bounds if x is a character from a to i, inclusive
        if (x >= 97 && x <= 105) {
            xLowerBound = 97;
            xUpperBound = 105;
        }

        for (int i = xLowerBound; i < xUpperBound; i++) {
            for (int j = yLowerBound; j < yUpperBound; j++) {
                if (!(i == x + 1 || i == x || i == x - 1 || j == y + 1 || j == y || j == y - 1)) {
                    char[] temp = new char[2];
                    temp[0] = (char) (i);
                    temp[1] = (char) (j);
                    nonAdjList.add(temp);
                } // if
            } // inner for
        } // outer for

        return nonAdjList;

    } // end of method getNonAdjacentSquares


    // ********* main method ********* //

    public static void main(String[] args) {

        String coordsStr;
        char[] coordsArr = new char[2];

        // display welcome menu and ask user to input coordinates
        displayWelcomeMenu();
        System.out.print("Enter your coordinates: ");
        coordsStr = input.nextLine();

        // clean the input of spaces, special characters, check input validity; convert input to type int
        coordsStr = cleanString(coordsStr);

        // determine the necessary adjacent squares; stores them in arrays

        coordsArr[0] = coordsStr.charAt(0);
        coordsArr[1] = coordsStr.charAt(1);

        System.out.println("Input x: " + coordsArr[0]);
        System.out.println("Input y: " + coordsArr[1]);

        System.out.print("Edge-adjacent squares: ");
        displayCoordList(getEdgeAdjacentSquares(coordsArr));

        System.out.print("Corner-adjacent squares: ");
        displayCoordList(getCornerAdjacentSquares(coordsArr));

        System.out.print("Non-adjacent squares: ");
        displayCoordList(getNonAdjacentSquares(coordsArr));

        // the two method calls that are commented out below are the methods that generated the test results
        // that I put in the txt file

        // testNumbers();
        // testChars();

    } // end of main method


    public static void testNumbers() {

        System.out.println("#######  All test cases where the x coordinate is an INTEGER from 0 to 8, inclusive  #######");
        // test x is number
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.println("============================================================================");
                String coordsStr;
                char[] coordsArr = new char[2];

                // display welcome menu and ask user to input coordinates
                System.out.println("Coordinates: " + "(" + i + ", " + j + ")");
                coordsStr = "" + i + j;

                // determine the necessary adjacent squares; stores them in arrays

                coordsArr[0] = coordsStr.charAt(0);
                coordsArr[1] = coordsStr.charAt(1);

                System.out.print("Edge-adjacent squares: ");
                displayCoordList(getEdgeAdjacentSquares(coordsArr));

                System.out.print("Corner-adjacent squares: ");
                displayCoordList(getCornerAdjacentSquares(coordsArr));

                System.out.print("Non-adjacent squares: ");
                displayCoordList(getNonAdjacentSquares(coordsArr));

                System.out.println("============================================================================");
            } // inner loop
        } // outer loop


    } // end of testNumbers method


    public static void testChars() {

        System.out.println("#######  All test cases where the x coordinate is a CHAR from a to i, inclusive  #######");
        // test x is character
        for (int i = 97; i < 106; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.println("============================================================================");
                String coordsStr;
                char[] coordsArr = new char[2];

                // display welcome menu and ask user to input coordinates
                System.out.println("Coordinates: " + "(" + (char) i + ", " + j + ")");
                coordsStr = "" + (char) i + j;

                // determine the necessary adjacent squares; stores them in arrays

                coordsArr[0] = coordsStr.charAt(0);
                coordsArr[1] = coordsStr.charAt(1);

                System.out.print("Edge-adjacent squares: ");
                displayCoordList(getEdgeAdjacentSquares(coordsArr));

                System.out.print("Corner-adjacent squares: ");
                displayCoordList(getCornerAdjacentSquares(coordsArr));

                System.out.print("Non-adjacent squares: ");
                displayCoordList(getNonAdjacentSquares(coordsArr));

                System.out.println("============================================================================");
            } // inner loop
        } // outer loop


    } // end of testChars method

} // end of Battleship class
