package ru.Napadovskiy.bomberMan;

/**
 * Package of Multithreading test task.
 * abstract class for all unit in game.
 * @author Napadovskiy Bohdan
 * @version 1.0
 * @since 10.10.2017
 */
public abstract class Unit {

    /**
     * x coordinate.
     */
    private int xCoordinate;

    /**
     * y coordinate.
     */
    private int yCoordinate;

    /**
     * board for game.
     */
    private GameBoard board;

    /**
     * Constructor for all unit.
     * @param board board for game.
     */
    public Unit(GameBoard board) {
        this.board  = board;
    }

    /**
     * Method return x coordinate.
     * @return x coordinate.
     */
    public int getXCoordinate() {
        return this.xCoordinate;
    }

    /**
     * Method return y coordinate.
     * @return y coordinate.
     */
    public int getYCoordinate() {
        return this.yCoordinate;
    }

    /**
     * Method set x coordinate.
     * @param xCoordinate x coordinate.
     */
    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    /**
     * Method set y coordinate.
     * @param yCoordinate y coordinate.
     */
    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    /**
     * Method return board for game.
     * @return board.
     */
    public GameBoard getBoard() {
        return board;
    }

}
