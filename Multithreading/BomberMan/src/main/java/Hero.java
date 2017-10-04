import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Hero extends Unit implements Runnable {


    public Hero(int xCoordinate, int yCoordinate, String typeOfUnit, GameBoard board) {
        super(xCoordinate, yCoordinate, typeOfUnit, board);
    }

    public void setUnitInPosition(int positionX, int positionY) {
        this.getBoard().getBoard()[positionX][positionY].lock();
    }


    private void moveHero() throws InterruptedException {
        boolean resultMovie = false;
        int x = 0;
        int y = 0;
        while (!resultMovie) {
            if (this.tryMoveUnit(x, y)) {
                ReentrantLock cell = this.getBoard().getBoard()[x][y];
                resultMovie = cell.tryLock(500, TimeUnit.MILLISECONDS);
            }
        }
        this.getBoard().getBoard()[this.getXCoordinate()][this.getYCoordinate()].unlock();
        this.setUnitInPosition(x, y);

    }


    @Override
    public void run() {

        try {
            this.moveHero();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.getBoard().getBoard()[this.getXCoordinate()][this.getYCoordinate()].unlock();

        }

    }
}
