package ru.napadovskiy.bomberMan;


import java.util.Random;
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
    private void setHeroInPosition(int positionX, int positionY) {
        this.setXCoordinate(positionX);
        this.setYCoordinate(positionY);

        this.getBoard().getBoard()[positionX][positionY].lock();
    }


    public void clearPosition(int x, int y) {
        this.getBoard().getBoard()[x][y].unlock();
        this.getBoard().getBoard()[x][y] = null;
    }

    public int getNewXCoordinate(int oldx, Direction direction) {
        int result = oldx;
        if (direction.equals(Direction.LEFT)) {
            result--;
        } else if(direction.equals(Direction.RIGHT)) {
            result++;
        }

        return result;
    }

    private int getNewYCoordinate(int oldy, Direction direction) {
        int result = oldy;
        if (direction.equals(Direction.DOWN)) {
            result--;
        } else if(direction.equals(Direction.UP)) {
            result++;
        }

        return result;
    }

    /**
     *
     * @return direction
     */
    private Direction getRandomDirection() {
        Direction result = null;
        Random random = new Random();
        int randomCount = random.nextInt(4);
        if (randomCount == 0) {
            result = Direction.DOWN;
        } else if(randomCount == 1) {
            result = Direction.LEFT;
        } else if (randomCount == 2) {
            result = Direction.RIGHT;
        } else if (randomCount == 3) {
            result = Direction.UP;
        }
        return result;
    }

    /**
     * Method move the hero.
     * @throws InterruptedException exception.
     */
    private void moveHero() throws InterruptedException {

        Direction direction = getRandomDirection();

        int y = getNewYCoordinate(this.getYCoordinate(), direction);

        int x = getNewXCoordinate(this.getXCoordinate(), direction);

        ReentrantLock newCell = this.getBoard().getBoard()[x][y];

        ReentrantLock oldCell = this.getBoard().getBoard()[this.getXCoordinate()][this.getYCoordinate()];

        if (newCell.tryLock()) {
            clearPosition(this.getXCoordinate(), this.getYCoordinate());
            //newCell.lock();
            setHeroInPosition(x, y);
        }




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
