/*
Thomas Gadacy
Assignment 1 Part 2
2/18/21
 */

package edu.quinnipiac.gadacy.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * TicTacToe class implements the interface
 *
 * @author relkharboutly
 * @date 1/5/2017
 */
public class TicTacToe implements ITicTacToe {

    // The game board and the game status
    private static final int ROWS = 5, COLS = 5; // number of rows and columns
    private int[][] board = new int[ROWS][COLS]; // game board in 2D array
    private int spaceUsed = 0;
    private boolean gameOver = false;

    /**
     * clear board and set current player
     */
    public TicTacToe() {
        clearBoard();
    }

    @Override
    public void clearBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = EMPTY;
            }
        }
        gameOver = false;
        spaceUsed = 0;
    }

    @Override
    public void setMove(int player, int location) {
        if (location > 24 || location < 0) {
            return;
        }
        if (board[location / 5][location % 5] != EMPTY) {
            return;
        } else {
            board[location / 5][location % 5] = player;
            spaceUsed++;
        }
    }

    @Override
    public int getComputerMove() {
        if (gameOver) {
            return 0;
        }
        if (spaceUsed < 24) {
            int bestMove = 0;
            do {
                Random move = new Random();
                bestMove = move.nextInt(25);
            } while (!openSpot(bestMove));
            return bestMove;
        }

        return 0;
    }

    public boolean openSpot(int spot) {
        if (board[spot / 5][spot % 5] == EMPTY) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int checkForWinner() {

        for (int i = 0; i < 5; i++) {
            if (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == board[3][i]
                    && board[0][i] != EMPTY) {
                gameOver = true;
                return getWinner(board[0][i]);
            } else if (board[4][i] == board[1][i] && board[4][i] == board[2][i] && board[4][i] == board[3][i]
                    && board[4][i] != EMPTY) {
                gameOver = true;
                return getWinner(board[4][i]);
            } else if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == board[i][3]
                    && board[i][0] != EMPTY) {
                gameOver = true;
                return getWinner(board[i][0]);
            } else if (board[i][4] == board[i][1] && board[i][4] == board[i][2] && board[i][4] == board[i][3]
                    && board[i][4] != EMPTY) {
                gameOver = true;
                return getWinner(board[i][4]);
            }
        }

        if (board[1][0] == board[2][1] && board[1][0] == board[3][2] && board[1][0] == board[4][3]
                && board[1][0] != EMPTY) {
            gameOver = true;
            return getWinner(board[1][0]);
        }
        if (board[0][1] == board[1][2] && board[0][1] == board[2][3] && board[0][1] == board[3][4]
                && board[0][1] != EMPTY) {
            gameOver = true;
            return getWinner(board[0][1]);
        }

        if (board[0][3] == board[1][2] && board[0][3] == board[2][1] && board[0][3] == board[3][0]
                && board[0][3] != EMPTY) {
            gameOver = true;
            return getWinner(board[0][3]);
        }
        if (board[1][4] == board[2][3] && board[1][4] == board[3][2] && board[1][4] == board[4][1]
                && board[1][4] != EMPTY) {
            gameOver = true;
            return getWinner(board[1][4]);
        }

        if (board[0][4] == board[1][3] && board[0][4] == board[2][2] && board[0][4] == board[3][1]
                && board[0][4] != EMPTY) {
            gameOver = true;
            return getWinner(board[0][4]);
        }
        if (board[4][0] == board[1][3] && board[4][0] == board[2][2] && board[4][0] == board[3][1]
                && board[4][0] != EMPTY) {
            gameOver = true;
            return getWinner(board[4][0]);
        }

        if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == board[3][3]
                && board[0][0] != EMPTY) {
            gameOver = true;
            return getWinner(board[0][0]);
        }
        if (board[4][4] == board[1][1] && board[4][4] == board[2][2] && board[4][4] == board[3][3]
                && board[4][4] != EMPTY) {
            gameOver = true;
            return getWinner(board[4][4]);
        }

        if (spaceUsed == 25) {
            gameOver = true;
            return TIE;
        }

        return PLAYING;
    }



    public boolean isGameOver() {
        return gameOver;
    }

    public int getWinner(int win) {
        switch (win) {
            case 0:
                return PLAYING;
            case 1:
                return CROSS_WON;
            case 2:
                return NOUGHT_WON;
            default:
                return PLAYING;
        }
    }

}
