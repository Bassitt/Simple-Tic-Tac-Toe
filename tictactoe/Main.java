package tictactoe;
import java.util.Scanner;

public class Main {
    public static final int GRID = 3;

    public static char[][] createTwoDimArray(char[] input) {
        char[][] twoDimArray = new char[GRID][GRID];
        int row = 0;
        for (int i = 0; i < GRID * GRID; i += 3) {
            for (int j = 0; j < GRID; j++) {
                twoDimArray[row][j] = input[i + j];
            }
            row++;
        }
        return twoDimArray;
    }

    public static void print(char[][] twoDimArray) {
        System.out.println("---------");
        for (int i = 0; i < GRID; i++) {
            System.out.print("| ");
            for (int j = 0; j < GRID; j++) {
                System.out.printf("%c ", twoDimArray[i][j]);
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static void turn(char[][] twoDimArray, String i, String j) {
        int noOfXs = 0;
        int noOfOs = 0;
        int rowI = Integer.parseInt(i) - 1;
        int colL = Integer.parseInt(j) - 1;

        for (int ii = 0; ii < GRID; ii++) {
            for (int jj = 0; jj < GRID; jj++) {
                if (twoDimArray[ii][jj] == 'X') {
                    noOfXs++;
                } else if (twoDimArray[ii][jj] == 'O') {
                    noOfOs++;
                }
            }
        }

        boolean xTurn = noOfXs <= noOfOs;
        if (xTurn) {
            for (int ii = 0; ii < GRID; ii++) {
                for (int jj = 0; jj < GRID; jj++) {
                    twoDimArray[rowI][colL] = 'X';
                }
            }
            noOfXs++;
        } else {
            for (int ii = 0; ii < GRID; ii++) {
                for (int jj = 0; jj < GRID; jj++) {
                    twoDimArray[rowI][colL] = 'O';

                }
            }
            noOfOs++;
        }

    }

    public static boolean coordinatesCheck(char[][] twoDimArray, String i, String j) {

        int rowI = Integer.parseInt(i) - 1;
        int colL = Integer.parseInt(j) - 1;
        if ((rowI < 0 || rowI > 2) || (colL < 0 || colL > 2)) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }
        if (twoDimArray[rowI][colL] != '_') {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }

        turn(twoDimArray, i, j);

        print(twoDimArray);
        return true;

    }

    public static boolean gridCheck(char[][] twoDimArray) {
        int xCount = 0;
        int oCount = 0;
        int emptyCount = 0;
        boolean xWin = false;
        boolean oWin = false;
        int xThree = 0;
        int oThree = 0;

        for (int i = 0; i < GRID; i++) {
            for (int j = 0; j < GRID; j++) {
                if (twoDimArray[i][j] == 'X') {
                    xCount++;
                } else if (twoDimArray[i][j] == 'O') {
                    oCount++;
                } else {
                    emptyCount++;
                }
            }
            if (i == 0) {
                if (twoDimArray[i][GRID - 3] == 'X' && twoDimArray[i + 1][GRID - 3] == 'X' && twoDimArray[i + 2][GRID - 3] == 'X') {
                    xWin = true;
                    xThree++;
                } else if (twoDimArray[i][GRID - 3] == 'O' && twoDimArray[i + 1][GRID - 3] == 'O' && twoDimArray[i + 2][GRID - 3] == 'O') {
                    oWin = true;
                    oThree++;
                }
                if (twoDimArray[i][GRID - 2] == 'X' && twoDimArray[i + 1][GRID - 2] == 'X' && twoDimArray[i + 2][GRID - 2] == 'X') {
                    xWin = true;
                    xThree += 1;
                } else if (twoDimArray[i][GRID - 2] == 'O' && twoDimArray[i + 1][GRID - 2] == 'O' && twoDimArray[i + 2][GRID - 2] == 'O') {
                    oWin = true;
                    oThree++;
                }
                if (twoDimArray[i][GRID - 1] == 'X' && twoDimArray[i + 1][GRID - 1] == 'X' && twoDimArray[i + 2][GRID - 1] == 'X') {
                    xWin = true;
                    xThree += 1;
                } else if (twoDimArray[i][GRID - 1] == 'O' && twoDimArray[i + 1][GRID - 1] == 'O' && twoDimArray[i + 2][GRID - 1] == 'O') {
                    oWin = true;
                    oThree++;
                }
                if (twoDimArray[i][GRID - 3] == 'X' && twoDimArray[i][GRID - 2] == 'X' && twoDimArray[i][GRID - 1] == 'X') {
                    xWin = true;
                    xThree += 1;
                } else if (twoDimArray[i][GRID - 3] == 'O' && twoDimArray[i][GRID - 2] == 'O' && twoDimArray[i][GRID - 1] == 'O') {
                    oWin = true;
                    oThree++;
                }
                if (twoDimArray[i][GRID - 3] == 'X' && twoDimArray[i + 1][GRID - 2] == 'X' && twoDimArray[i + 2][GRID - 1] == 'X') {
                    xWin = true;
                    xThree += 1;
                } else if (twoDimArray[i][GRID - 3] == 'O' && twoDimArray[i + 1][GRID - 2] == 'O' && twoDimArray[i + 2][GRID - 1] == 'O') {
                    oWin = true;
                    oThree++;
                }
                if (twoDimArray[i][GRID - 1] == 'X' && twoDimArray[i + 1][GRID - 2] == 'X' && twoDimArray[i + 2][GRID - 3] == 'X') {
                    xWin = true;
                    xThree += 1;
                } else if (twoDimArray[i][GRID - 1] == 'O' && twoDimArray[i + 1][GRID - 2] == 'O' && twoDimArray[i + 2][GRID - 3] == 'O') {
                    oWin = true;
                    oThree++;
                }
            }
            if (i == 1) {
                if (twoDimArray[i][GRID - 3] == 'X' && twoDimArray[i][GRID - 2] == 'X' && twoDimArray[i][GRID - 1] == 'X') {
                    xWin = true;
                    xThree++;
                } else if (twoDimArray[i][GRID - 3] == 'O' && twoDimArray[i][GRID - 2] == 'O' && twoDimArray[i][GRID - 1] == 'O') {
                    oWin = true;
                    oThree++;
                }
            }
            if (i == 2) {
                if (twoDimArray[i][GRID - 3] == 'X' && twoDimArray[i][GRID - 2] == 'X' && twoDimArray[i][GRID - 1] == 'X') {
                    xWin = true;
                    xThree++;
                } else if (twoDimArray[i][GRID - 3] == 'O' && twoDimArray[i][GRID - 2] == 'O' && twoDimArray[i][GRID - 1] == 'O') {
                    oWin = true;
                    oThree++;
                }
            }
        }

        if (!xWin && !oWin && emptyCount == 0) {
            System.out.println("Draw");
            return true;
        } else if (xWin) {
            System.out.println("X wins");
            return true;
        } else if (oWin) {
            System.out.println("O wins");
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String line = "_________";
        char[] array = line.toCharArray();
        char[][] twoDimArray = createTwoDimArray(array);
        print(twoDimArray);

        System.out.println("Please, Enter Coordinates");

        boolean result = false;
        boolean isNumber;

        String i = null;
        String j = null;


        while (!result) {
            boolean coordinatesValid = false;
            while (!coordinatesValid) {
                do {
                    if (scanner.hasNextInt() || scanner.hasNextInt()) {
                        i = scanner.next();
                        j = scanner.next();
                        isNumber = true;
                    } else {
                        System.out.println("You should enter numbers!");
                        isNumber = false;
                        scanner.next();
                    }
                } while (!isNumber);
                coordinatesValid = coordinatesCheck(twoDimArray, i, j);
            }
            result = gridCheck(twoDimArray);
        }
    }
}
