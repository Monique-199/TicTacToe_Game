/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package javaapplication47;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author inven
 */
public class TicTacToe {
// The Tic Tac Toe board
    private char[][] board = new char[3][3];

    // The human player's marker
    private char humanMarker;

    // The AI player's marker
    private char aiMarker;

    // The current player
    private char currentPlayer;

    // The scanner for input
    private Scanner scanner = new Scanner(System.in);

    // The random number generator for the AI player
    private Random random = new Random();

    // Initialize the board with empty spaces
    public void initBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Display the current state of the board
    public void displayBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // Allow the human player to make a move
    public void humanMove() {
        int row, col;
        do {
            System.out.print("Enter the row and column of your move (e.g. 1 2): ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
        } while (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ');
        board[row][col] = humanMarker;
        currentPlayer = aiMarker;
    }

    // Allow the AI player to make a move
    public void aiMove() {
        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (board[row][col] != ' ');
        board[row][col] = aiMarker;
        currentPlayer = humanMarker;
    }

    // Check if the game has been won
    public boolean isWon(char marker) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == marker && board[i][1] == marker && board[i][2] == marker) {
                return true;
            }
            if (board[0][i] == marker && board[1][i] == marker && board[2][i] == marker) {
                return true;
            }
        }
        if (board[0][0] == marker && board[1][1] == marker && board[2][2] == marker) {
            return true;
        }
        if (board[0][2] == marker && board[1][1] == marker && board[2][0] == marker) {
            return true;
        }
        return false;
    }

    // Check if the game is a tie
    public boolean isTie() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    // Play the game


}
