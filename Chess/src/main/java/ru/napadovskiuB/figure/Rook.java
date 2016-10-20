package ru.napadovskiuB.figure;

import ru.napadovskiuB.board.Board;
import ru.napadovskiuB.moves.MovesByLine;

/**
 * Created by program on 08.10.2016.
 */
public class Rook implements Figure {

    private int positionY;
    private int positionX;
    private boolean isWhite;

//    private int[][]



    public Rook(int y, int x, boolean isWhite){
        this.positionY =y;
        this.positionX =x;
        this.isWhite   = isWhite;
    }


    public void setPosition(int y,int x){
        this.positionY = y;
        this.positionX = x;
    }

    public  void setColorFigure(boolean isWhite){
        this.isWhite = isWhite;
    }

    public int getPositionY(){
        return this.positionY;

    }

    public int getPositionX(){
        return this.positionX;

    }


    public void moveFigure(int newY, int newX){


    }


}
