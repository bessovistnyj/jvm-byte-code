package ru.napadovskiuB.board;

/**
 * Created by program on 24.10.2016.
 */
public class Position {
    private int positionY;
    private int positionX;

    public Position(int y, int x){
        this.positionY =y;
        this.positionX =x;
    }

    public int getPositionY(){
        return this.positionY;
    }
    public int getPositionX(){
        return this.positionX;
    }

    public void setPositionY(int y){
        this.positionY = y;
    }
    public void  setPositionX(int x){
        this.positionX = x;
    }

}
