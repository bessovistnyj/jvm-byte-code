package ru.Napadovskiy.bomberMan;

/**
 * Package of Multithreading.
 * Main class for test.
 * @author Napadovskiy Bohdan
 * @version 1.0
 * @since 10.10.2017
 */
public class Game {

    /**
     * Main method for game.
     * @param args array string.
     */
    public static void main(String[] args) {

        Game game = new Game();

        final int xSize = 4;

        final int ySize = 4;


        GameBoard gameBoard = new GameBoard(xSize, ySize);
        gameBoard.generateBoard();
        Hero hero = new Hero(gameBoard);
        Block block = new Block(gameBoard);
        block.setBlockInPosition(2, 1);

        Thread heroThread = new Thread(hero);
        heroThread.start();
        heroThread.interrupt();
    }

}
