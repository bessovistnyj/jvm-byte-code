package ru.napadovskiuB.figure;

import ru.napadovskiuB.board.Board;
//import ru.napadovskiuB.moves.MovesByLine;

/**
 * Created by program on 08.10.2016.
 */
public class Rook implements Figure {

    private Position position;
    private boolean isWhite;

    public Rook(int y, int x, boolean isWhite){
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

    private Position[] getAvailableMoves(Board board){
        Position[] result = new Position[16];

        int tmpY = this.getPositionY();
        int tmpX = this.getPositionX();
        int counter =0;
        boolean fillMinus = false;
        boolean fillPlus = false;

        for (; counter<result.length; ){
            if (tmpX >=7) {
               tmpX = this.getPositionX();
                break;
            }
            if (this.getPositionX() > 0 && !fillMinus){
                result[counter] = new Position(tmpY,--tmpX);
                counter++;
                fillMinus = (tmpX ==0) ? true : false;
                tmpX = (tmpX ==0) ? this.getPositionX() : tmpX;
                continue;
            }

            if (!fillPlus){
                result[counter] = new Position(tmpY,++tmpX);
                counter++;
                fillMinus = (tmpX ==7) ? true : false;

            }
        }
        fillMinus = false;
        fillPlus =false;
        for (; counter<result.length; ){
            if (tmpY >=7){
               tmpY = this.getPositionY();
               break;
            }
            if (this.getPositionY() > 0 && !fillMinus){
                result[counter] = new Position(--tmpY,tmpX);
                counter++;
                fillMinus = (tmpY ==0) ? true : false;
                tmpY = (tmpY ==0) ? this.getPositionY() : tmpY;
                continue;
            }
            if (!fillPlus){
                result[counter] = new Position(++tmpY,tmpX);
                counter++;
                fillPlus = (tmpY ==7) ? true : false;

            }
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
        Position [] availableMoves = getAvailableMoves(board);

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
