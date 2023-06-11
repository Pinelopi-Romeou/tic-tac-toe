import java.util.Scanner;

/**
 * Tic Tac Toe game
 */
public class TicTacToeApp {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] board = {{' ', '|', ' ', '|', ' '},
                {'-', '-', '-', '-', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '-', '-', '-', '-'},
                {' ', '|', ' ', '|', ' '}};
        printBoard(board);

        while (true) {
            playerTurn(board, 'X');
            if (isGameOver(board)) {
                break;
            }

            playerTurn(board, 'O');
            if (isGameOver(board)) {
                break;
            }
        }
        printBoard(board);
        in.close();
    }

    /**
     * Prints a simple game board
     *
     * @param board    the game board
     */
    private static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char ch : row) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }

    /**
     * Checks if the game is finished
     *
     * @param board    the game board
     * @return         true if the game is over, false otherwise
     */
    private static boolean isGameOver(char[][] board) {
        if (hasPlayerWon(board, 'X')) {
            System.out.println("Player1 wins!");
            return true;
        }

        if (hasPlayerWon(board, 'O')) {
            System.out.println("Player2 wins!");
            return true;
        }

        if (isBoardFull(board)) {
            System.out.println("The game is a tie!");
            return true;
        }
        printBoard(board);
        return false;
    }

    /**
     * Traverses the board until an empty spot is found
     *
     * @param board    the game board
     * @return         true if the board is full, false otherwise
     */
    public static boolean isBoardFull(char[][] board) {
        for (char[] row : board) {
            for (char ch : row) {
                if (ch == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks if a player has won by adding 3 symbols at any dimension:
     * horizontally, vertically or diagonally
     *
     * @param board     the game board
     * @param symbol    the player's symbol
     * @return          true if the player has won, false otherwise
     */
    private static boolean hasPlayerWon(char[][] board, char symbol) {
        return (board[0][0] == symbol && board[0][2] == symbol && board[0][4] == symbol) ||
                (board[2][0] == symbol && board[2][2] == symbol && board[2][4] == symbol) ||
                (board[4][0] == symbol && board[4][2] == symbol && board[4][4] == symbol) ||

                (board[0][0] == symbol && board[2][0] == symbol && board[4][0] == symbol) ||
                (board[0][2] == symbol && board[2][2] == symbol && board[4][2] == symbol) ||
                (board[0][4] == symbol && board[2][4] == symbol && board[4][4] == symbol) ||

                (board[0][0] == symbol && board[2][2] == symbol && board[4][4] == symbol) ||
                (board[0][4] == symbol && board[2][2] == symbol && board[4][0] == symbol);
    }

    /**
     * Asks player to pick a spot on the board (between 1 and 9)
     *
     * @param board     the game board
     * @param symbol    the player's symbol
     */
    public static void playerTurn(char[][] board, char symbol) {
        String userInput;

        while (true) {
            System.out.println("Player" + symbol + ", it's your turn. Please pick a placement (1-9)");
            userInput = in.nextLine();
            if (isMoveValid(board, userInput)) {
                break;
            } else {
                System.out.println(userInput + " is not a valid move");
            }
        }
        placeMove(board, userInput, symbol);
    }

    /**
     * Places the player's symbol on board, according to his/her choice
     *
     * @param board       the game board
     * @param position    the position of the symbol
     * @param symbol      the player's symbol
     */
    private static void placeMove(char[][] board, String position, char symbol) {
        switch (position) {
            case "1":
                board[0][0] = symbol;
                break;
            case "2":
                board[0][2] = symbol;
                break;
            case "3":
                board[0][4] = symbol;
                break;
            case "4":
                board[2][0] = symbol;
                break;
            case "5":
                board[2][2] = symbol;
                break;
            case "6":
                board[2][4] = symbol;
                break;
            case "7":
                board[4][0] = symbol;
                break;
            case "8":
                board[4][2] = symbol;
                break;
            case "9":
                board[4][4] = symbol;
                break;
            default:
                System.out.println("Failed to place the move");
        }
    }

    /**
     * Checks if the move is valid
     *
     * @param board       the game board
     * @param position    the symbol's position
     * @return            true if the move is valid, false otherwise
     */
    public static boolean isMoveValid(char[][] board, String position) {
        switch (position) {
            case "1":
                return (board[0][0] == ' ');
            case "2":
                return board[0][2] == ' ';
            case "3":
                return board[0][4] == ' ';
            case "4":
                return board[2][0] == ' ';
            case "5":
                return board[2][2] == ' ';
            case "6":
                return board[2][4] == ' ';
            case "7":
                return board[4][0] == ' ';
            case "8":
                return board[4][2] == ' ';
            case "9":
                return board[4][4] == ' ';
            default:
                return false;
        }
    }
}
