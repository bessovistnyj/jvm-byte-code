package ru.napadovskiy.bomberMan;


import java.util.Random;
import java.util.concurrent.ExecutorService;
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
     * x coordinate.
     */
    private int xCoordinate;

    /**
     * y coordinate.
     */
    private int yCoordinate;


    /**
     * Constructor for all unit.
     * @param board board for game.
     */
    public Monster(int x, int y, GameBoard board, ExecutorService service) {
        super(board,service);
        this.getBoard().getBoard()[x][y] = new ReentrantLock();
        setMonsterInPosition(x, y);
    }

    /**
     * Method set unit in position.
     * @param positionX position x.
     * @param positionY position y.
     */
    private void setMonsterInPosition(int positionX, int positionY)  {
        this.setXCoordinate(positionX);
        this.setYCoordinate(positionY);
        this.getBoard().getBoard()[positionX][positionY].lock();
    }


    private int calculateNewXCoordinate(int x, Direction direction) {
        int result = x;
        if (direction.equals(Direction.LEFT)) {
            result--;
        } else if(direction.equals(Direction.RIGHT)) {
            result++;
        }

        return result;

    }

    private int calculateNewYCoordinate(int oldy, Direction direction) {
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

    public void clearPosition(int x, int y) {
        this.getBoard().getBoard()[x][y].unlock();
        this.getBoard().getBoard()[x][y] = null;
    }


    private void moveMonster() throws InterruptedException {


        final int waitTime = 5;

        int newX = this.getXCoordinate();

        int newY = this.getYCoordinate();

        boolean canMove = false;

        while (!canMove) {
            Direction direction = getRandomDirection();
            newX = calculateNewXCoordinate(this.getXCoordinate(), direction);

            newY = calculateNewYCoordinate(this.getYCoordinate(), direction);

            if (this.getBoard().getBoard()[newX][newY].tryLock(waitTime, TimeUnit.SECONDS)) {
                canMove = true;
            }
        }
        this.clearPosition(this.getXCoordinate(), this.getYCoordinate());
        System.out.println("Убрали монстра "+ Thread.currentThread().getName()+" с координат "+this.getXCoordinate()+" "+this.getYCoordinate());
        this.setMonsterInPosition(newX, newY);
        System.out.println("Установили монстра "+ Thread.currentThread().getName()+" на координаты "+this.getXCoordinate()+" "+this.getYCoordinate());

    }

    /**
     * Method for start move hero.
     */
    @Override
    public void run() {
        while (!getService().isShutdown()) {
            try {
                moveMonster();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
