package ru.napadovskiuB.figure;

import ru.napadovskiuB.board.*;

/**
 * Created by Napadovskiy
 *@author napadovskiy
 *@since 14.10.2016
 *@version 1
 */
public class Elephant implements Figure {

    private Position position;
    private boolean isWhite;

    public Elephant(int y, int x, boolean isWhite){
        this.position = new Position(y,x);
        this.isWhite   = isWhite;
    }

    /**

     */
    private class Position{
        private int positionY;
        private int positionX;

        private Position(int y, int x){
            this.positionY =y;
            this.positionX =x;
        }

        private int getPositionY(){
            return this.positionY;
        }
        private int getPositionX(){
            return this.positionX;
        }

    }

    /**
     *The method get array of all available moves
     */

    private Position[] getAvailableMoves() {
         Position[] result = new Position[16];


        int counter = 0;

         int tmpY = this.getPositionY();
         int tmpX = this.getPositionX();
         while (tmpY < 7 && tmpX < 7) {
             result[counter] = new Position(++tmpY,++tmpX);
             counter++;
         }

         tmpY = this.getPositionY();
         tmpX = this.getPositionX();
         while (tmpX > 0 && tmpY < 7) {
             result[counter] = new Position(++tmpY,--tmpX);
             counter++;
         }
        tmpY = this.getPositionY();
        tmpX = this.getPositionX();
         while (tmpX < 7 && tmpY > 0) {
            result[counter] = new Position(--tmpY,++tmpX);
            counter++;

         }
        tmpY = this.getPositionY();
        tmpX = this.getPositionX();
        while (tmpX > 0 && tmpY > 0) {
            result[counter] = new Position(--tmpY, --tmpX);
            counter++;
        }

        return result;
     }

    /**
     *The method check opportunity move the figure
     *@param newY
     *@param newX
     *@param board
     *@return result
     */
    private boolean canMoveTheFigure(int newY, int newX, Board board){
        boolean result = false;
        Position[] availableMoves = getAvailableMoves();

        for (int i=0; i < availableMoves.length; i++){
            if (availableMoves[i] == null){
                continue;
            }
            if(board.getFigureByPosition(availableMoves[i].getPositionY(),availableMoves[i].getPositionX())!=null){
                result =false;
                break;
            }

            if (availableMoves[i].getPositionY() == newY && availableMoves[i].getPositionX() == newX){
                result=true;
                break;
            }

        }
        return result;
    }

    /**
     *The method set position
     */
    public void setPosition(int y,int x){
        this.position = new Position(y,x);
    }

    /**
     *The method set color
     */
    public  void setColorFigure(boolean isWhite){
        this.isWhite = isWhite;
    }

    /**
     *The method get position Y
     */
    public int getPositionY(){
        return this.position.getPositionY();

    }

    /**
     *The method get position X
     */
    public int getPositionX(){
        return this.position.getPositionX();

    }

    /**
     *The method move figure by new position
     *@param newY
     *@param newX
     *@param board
     */
    public void moveFigure(int newY, int newX, Board board){

        if (canMoveTheFigure(newY, newX, board)){
            this.setPosition(newY,newX);
            board.setFigureByPosition(this);
        }
        else {
            System.out.println("Inaccessible move");
        }

    }
}

