package ru.napadovskiy.bomberMan;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Package of Multithreading.
 * Main class for test.
 * @author Napadovskiy Bohdan
 * @version 1.0
 * @since 10.10.2017
 */
public class Game {


    private final int countOfMonsters = 5;

    private final int xSizeBoard = 8;

    private final int ySizeBoard = 8;

    private  final GameBoard board;


    private static ExecutorService service = Executors.newCachedThreadPool();

    private Game(int xSize, int ySize) {
        this.board = new GameBoard(xSize, ySize);

    }

    private void addHero() {

        if (this.board.getBoard()[0][0] != null) {
            if (this.board.getBoard()[0][0].tryLock()) {
                Hero hero = new Hero(0, 0, board, service);
            }
        } else {
            Hero hero = new Hero(0, 0, board, service);
        }
    }

    private void addMonster() {
        if (this.board.getBoard()[3][3] != null) {
            if (this.board.getBoard()[3][3].tryLock()) {
                Monster monster = new Monster(3,3, board,service);
            }
        } else {
            Monster monster = new Monster(3,3, board,service);
        }
    }
    private void initGame() {
        addHero();
        addMonster();

    }



    /**
     * Main method for game.
     * @param args array string.
     */
    public static void main(String[] args) {

        Game game = new Game(8, 8);
        game.initGame();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdown();

    }

}
