package ru.napadovskiuB.figure;

import ru.napadovskiuB.board.*;


///**
// * Created by program on 08.10.2016.
// */
public class Elephant implements Figure {

    private Position position;
    private boolean isWhite;

    public Elephant(int y, int x, boolean isWhite){
        this.position = new Position(y,x);
        this.isWhite   = isWhite;
    }

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

    private Position[] getAvailableMoves(int newY, int newX, Board board) {
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

    public void setPosition(int y,int x){
        this.position = new Position(y,x);
    }

    public  void setColorFigure(boolean isWhite){
        this.isWhite = isWhite;
    }

    public int getPositionY(){
        return this.position.getPositionY();

    }

    public int getPositionX(){
        return this.position.getPositionX();

    }

    public void moveFigure(int newY, int newX, Board board){
        Position[] availableMoves = getAvailableMoves(newY,newX,board);

        boolean canMove =false;

        for (int i=0; i < availableMoves.length; i++){
            if (availableMoves[i] == null){
                continue;
            }
            if (availableMoves[i].getPositionY() == newY && availableMoves[i].getPositionX() == newX){
                canMove=true;
                break;
            }
        }

        if(canMove){
            this.setPosition(newY,newX);
        }
        else {
            System.out.println("Inaccessible move");
        }

    }
}

