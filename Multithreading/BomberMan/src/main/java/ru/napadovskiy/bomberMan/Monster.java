package ru.napadovskiy.bomberMan;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Package of Multithreading test task.
 * Class monster extends from unit.
 * @author Napadovskiy Bohdan
 * @version 1.0
 * @since 10.10.2017
 */
public class Monster extends Unit implements Runnable {


    /**
     * Constructor for all unit.
     * @param board board for game.
     */
    public Monster(GameBoard board) {
        super(board);
    }

    /**
     * Method set unit in position.
     * @param positionX position x.
     * @param positionY position y.
     */
    public void setUnitInPosition(int positionX, int positionY)  {
        this.setXCoordinate(positionX);
        this.setYCoordinate(positionY);
        final int waitTime = 500;
        try {
            if (this.getBoard().getBoard()[positionX][positionY].tryLock(waitTime, TimeUnit.MILLISECONDS)) {
                this.getBoard().getBoard()[positionX][positionY].lock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

        }
    }

    /**
     * Method calculate new x coordinate.
     * @param oldX old coordinate x.
     * @return new coordinate x.
     */
    private int getNewXCoordinate(int oldX) {
        int newX = 0;
        if (oldX < this.getBoard().getXSize() - 1) {
            newX = oldX + 1;
        }
        return newX;
    }

    /**
     * Method calculate new y coordinate.
     * @param oldY old coordinate y.
     * @return new coordinate y.
     */
    private int getNewYCoordinate(int oldY) {
        int newY = 0;
        if (oldY < this.getBoard().getYSize() - 1) {
            newY = oldY + 1;
        }
        return newY;
    }

    /**
     * Method move the hero.
     * @throws InterruptedException exception.
     */
    private void moveHero() throws InterruptedException {

        boolean canMovie = false;

        int y = this.getNewYCoordinate(this.getYCoordinate());

        int x =  getNewXCoordinate(this.getXCoordinate());

        final int waitTime = 500;

        while (!canMovie) {
            if (tryMoveMonster(x, y)) {
                ReentrantLock cell = this.getBoard().getBoard()[x][y];
                canMovie = cell.tryLock(waitTime, TimeUnit.MILLISECONDS);
                if (!canMovie) {
                    y = getNewYCoordinate(y);
                    x = getNewXCoordinate(x);
                }
            }
        }
        this.getBoard().getBoard()[this.getXCoordinate()][this.getYCoordinate()].unlock();
        this.setUnitInPosition(x, y);
    }


    /**
     * Method check move the element.
     * @param newPositionX new position x.
     * @param newPositionY new position y.
     * @return result.
     */
    public boolean tryMoveMonster(int newPositionX, int newPositionY) {
        boolean result = false;
        if (newPositionX <= this.getBoard().getXSize() || newPositionX > 0 || newPositionY <= this.getBoard().getYSize() || newPositionY > 0) {
            result = true;
        }
        return result;
    }


    /**
     * Method for start move hero.
     */
    @Override
    public void run() {
        this.setUnitInPosition(0, 0);
        while (true) {
            try {
                this.moveHero();
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
