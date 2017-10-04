import java.util.concurrent.locks.ReentrantLock;

public class GameBoard {

    private final int xSize;

    private final int ySize;

    private final ReentrantLock[][] board;

    public GameBoard(int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.board = new ReentrantLock[xSize][ySize];
    }

    public int getxSize() {
        return this.xSize;
    }

    public int getySize() {
        return this.ySize;
    }

    public ReentrantLock[][] getBoard() {
        return this.board;
    }

    public void generateBoard(int xSize, int ySize) {
        for (int i = 0; i < xSize; i++){
            for (int j = 0; j < ySize; j++) {
                this.board[i][j] = new ReentrantLock();
            }
        }
    }


}
