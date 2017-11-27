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

    private int xCoordinate;


    /**
     * Constructor for hero class.
     * @param board board game.
     */
    public Hero(int x, int y, GameBoard board, ExecutorService service) {
        super(board,service);
        this.getBoard().getBoard()[x][y] = new ReentrantLock();
        setHeroInPosition(x, y);
    }

    /**
     * Method set unit in position.
     * @param positionX position x.
     * @param positionY position y.
     */
    private void setHeroInPosition(int positionX, int positionY) {
        this.setXCoordinate(positionX);
        this.setYCoordinate(positionY);
        if (this.getBoard().getBoard()[positionX][positionY].tryLock()) {
            this.getBoard().getBoard()[positionX][positionY].lock();
        }
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


    private boolean checkCoordinate(int x, int y) {
        boolean result = false;

        if ((x >= 0 || x < this.getBoard().getXSize()) && ((y >= 0 || y < this.getBoard().getYSize())) ) {
            result = true;
        }

        return result;
     }


    /**
     * Method move the hero.
     * @throws InterruptedException exception.
     */
    private void moveHero() throws InterruptedException {


        int y = this.getYCoordinate();

        int x = this.getXCoordinate();


        while (!checkCoordinate(x, y)) {
            Direction direction = getRandomDirection();

            y = getNewYCoordinate(this.getYCoordinate(), direction);

            x = getNewXCoordinate(this.getXCoordinate(), direction);

        }

        ReentrantLock newCell = this.getBoard().getBoard()[x][y];

        if (newCell.tryLock()) {
            clearPosition(this.getXCoordinate(), this.getYCoordinate());
            System.out.println("Убрали героя с координат "+this.getXCoordinate()+ " "+ this.getYCoordinate() );
            setHeroInPosition(x, y);
            System.out.println("Установили героя на координаты координат "+this.getXCoordinate()+ " "+ this.getYCoordinate() );
        }
    }

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
