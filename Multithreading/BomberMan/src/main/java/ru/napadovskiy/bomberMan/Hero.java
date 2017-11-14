package ru.napadovskiy.bomberMan;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Package of Multithreading test task.
 * Class hero extends abstract class unit.
 * @author Napadovskiy Bohdan
 * @version 1.0
 * @since 10.10.2017
 */
public class Hero extends Unit implements Runnable {

    /**
     * Constructor for hero class.
     * @param board board game.
     */
    public Hero(int x, int y, GameBoard board, ExecutorService service) {
        super(board,service);
        this.getBoard().getBoard()[x][y] = new ReentrantLock();
    }

    /**
     * Method set unit in position.
     * @param positionX position x.
     * @param positionY position y.
     */
    public void setHeroInPosition(int positionX, int positionY) {
        this.setXCoordinate(positionX);
        this.setYCoordinate(positionY);

        this.getBoard().getBoard()[positionX][positionY].lock();
    }


    public void clearPosition(int x, int y) {
        this.getBoard().getBoard()[x][y] = null;
    }

    public int getNewXCoordinate(int oldx, Direction direction) {
        int result = 0;

        return result;
    }

    public int getNewYCoordinate(int oldy, Direction direction) {
        int result = 0;

        return result;
    }

    /**
     * Method move the hero.
     * @throws InterruptedException exception.
     */
    private void moveHero(Direction direction) throws InterruptedException {

        int y = this.getNewYCoordinate(this.getYCoordinate(), direction);

        int x =  getNewXCoordinate(this.getYCoordinate(), direction);


//        boolean canMovie = false;
//
//
//        final int waitTime = 500;
//
//        while (!canMovie) {
//            if (tryMoveUnit(x, y)) {
//                ReentrantLock cell = this.getBoard().getBoard()[x][y];
//                canMovie = cell.tryLock(waitTime, TimeUnit.MILLISECONDS);
//                if (!canMovie) {
//                    y = getNewYCoordinate(y);
//                    x = getNewXCoordinate(x);
//                }
//            }
//        }
//        this.getBoard().getBoard()[this.getXCoordinate()][this.getYCoordinate()].unlock();
//        this.setUnitInPosition(x, y);
    }


//    /**
//     * Method check move the element.
//     * @param newPositionX new position x.
//     * @param newPositionY new position y.
//     * @return result.
//     */
//    public boolean tryMoveHero(int newPositionX, int newPositionY) {
//        boolean result = false;
//        if (newPositionX <= this.getBoard().getXSize() || newPositionX > 0 || newPositionY <= this.getBoard().getYSize() || newPositionY > 0) {
//            result = true;
//        }
//        return result;
//    }

    @Override
    public void run() {
        while (!getService().isShutdown()) {
            try {
                this.moveHero();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
