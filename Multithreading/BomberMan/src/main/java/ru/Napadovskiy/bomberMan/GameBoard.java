package ru.Napadovskiy.bomberMan;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Package of Multithreading.
 * Class board with lock.
 * @author Napadovskiy Bohdan
 * @version 1.0
 * @since 10.10.2017
 */
public class GameBoard {

    /**
     * x size board.
     */
    private final int xSize;

    /**
     * y size board.
     */
    private final int ySize;

    /**
     * board for game.
     */
    private final ReentrantLock[][] board;

    /**
     * Constructor for class.
     * @param xSize x size.
     * @param ySize y size.
     */
    public GameBoard(int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.board = new ReentrantLock[xSize][ySize];
    }

    /**
     * Method return x size the board.
     * @return x size.
     */
    public int getXSize() {
        return this.xSize;
    }

    /**
     * Method return y size the board.
     * @return y size.
     */
    public int getYSize() {
        return this.ySize;
    }

    /**
     * Method return board.
     * @return board.
     */
    public ReentrantLock[][] getBoard() {
        return this.board;
    }

    /**
     *Method fill board.
     */
    public void generateBoard() {
        for (int i = 0; i < this.xSize; i++) {
            for (int j = 0; j < this.ySize; j++) {
                this.board[i][j] = new ReentrantLock();
            }
        }
    }


}
