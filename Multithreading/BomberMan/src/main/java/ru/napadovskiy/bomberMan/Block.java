package ru.Napadovskiy.bomberMan;

/**
 * Package of Multithreading test task.
 * Class block.
 * @author Napadovskiy Bohdan
 * @version 1.0
 * @since 10.10.2017

 */
public class Block extends Unit {

    /**
     * Constructor for class.
     * @param board game board.
     */
    public Block(GameBoard board) {
        super(board);
    }

    /**
     * Set block in board and lock this position.
     * @param positionX position x.
     * @param positionY position y.
     */
    public void setBlockInPosition(int positionX, int positionY) {
        this.setXCoordinate(positionX);
        this.setYCoordinate(positionY);

        this.getBoard().getBoard()[positionX][positionY].lock();
    }
}
