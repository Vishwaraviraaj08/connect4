import java.util.Scanner;

public class connect4 {
    public static int ROWS = 6;
    public static int COLUMNS = 7;
    public static char EMPTY = ' ';
    public static char PLAYER_1 = 'X', PLAYER_2 = 'O';

    public static void main(String[] args) {
        char[][] board = new char[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = EMPTY;
            }
        }

        Scanner sc = new Scanner(System.in);
        int currentPlayer = 1;
        while (true) {
            System.out.println("_______________");
            display(board);

            System.out.println("Player " + currentPlayer + ", enter a column (1-7):");
            int column = sc.nextInt() - 1;
            while (!isValid(board, column)) {
                System.out.println("Invalid move, enter a column (1-7):");
                column = sc.nextInt() - 1;
            }

            move(board, column, currentPlayer);
            if (isWin(board, column)) {
                display(board);
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }
            if (isDraw(board)) {
                System.out.println("Draw game.");
                break;
            }
            currentPlayer = currentPlayer == 1 ? 2 : 1;
        }
    }

    public static void display(char[][] board) {
        for (int i = ROWS - 1; i >= 0; i--) {
            System.out.print("|");
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("|1|2|3|4|5|6|7|");
    }

    public static boolean isValid(char[][] board, int column) {
        if (column < 0 || column >= COLUMNS) {
            return false;
        }
        for (int row = ROWS - 1; row >= 0; row--) {
            if (board[row][column] == EMPTY) {
                return true;
            }
        }
        return false;
    }


    public static void move(char[][] board, int column, int player) {
        for (int i = 0; i < ROWS; i++) {
            if (board[i][column] == EMPTY) {
                board[i][column] = player == 1 ? PLAYER_1 : PLAYER_2;
                break;
            }
        }
    }

    public static boolean isWin(char[][] board, int column) {
        int row = 0;
        for (int i = ROWS - 1; i >= 0; i--) {
            if (board[i][column] != EMPTY) {
                row = i;
                break;
            }
        }

        char currentPlayer = board[row][column];
        int consecutive = 1;
        for (int i = column - 1; i >= 0; i--) {
            if (board[row][i] != currentPlayer) {
                break;
            }
            consecutive++;
        }
        for (int i = column + 1; i < COLUMNS; i++) {
            if (board[row][i] != currentPlayer) {
                break;
            }
            consecutive++;
        }
        if (consecutive >= 4) {
            return true;
        }


        consecutive = 1;
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][column] != currentPlayer) {
                break;
            }
            consecutive++;
        }
        if (consecutive >= 4) {
            return true;
        }

        // left-up to right-down
        consecutive = 1;
        for (int i = row - 1, j = column + 1; i >= 0 && j < COLUMNS; i--, j++) {
            if (board[i][j] != currentPlayer) {
                break;
            }
            consecutive++;
        }
        for (int i = row + 1, j = column - 1; i < ROWS && j >= 0; i++, j--) {
            if (board[i][j] != currentPlayer) {
                break;
            }
            consecutive++;
        }
        if (consecutive >= 4) {
            return true;
        }

        // left-down to right-up
        consecutive = 1;
        for (int i = row + 1, j = column + 1; i < ROWS && j < COLUMNS; i++, j++) {
            if (board[i][j] != currentPlayer) {
                break;
            }
            consecutive++;
        }
        for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] != currentPlayer) {
                break;
            }
            consecutive++;
        }
        if (consecutive >= 4) {
            return true;
        }

        return false;
    }

    public static boolean isDraw(char[][] board) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

}