package ru.napadovskiy.bomberMan;

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

        final int xSize = 8;

        final int ySize = 8;

        final int countOfMonsters = 5;


        GameBoard gameBoard = new GameBoard(xSize, ySize);


//        for (int i =0; i < countOfMonsters; i++) {
//
//            //new Thread(new Monster(gameBoard).setUnitInPosition()).start();
//        }
//
//        Thread heroThread = new Thread(hero);
//        heroThread.start();
//        heroThread.interrupt();
    }

}
