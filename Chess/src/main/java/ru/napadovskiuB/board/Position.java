package ru.napadovskiuB.board;

/**
 * Created by program on 06.10.2016.
 */
public class Position {

    private int y;
    private int x;


    public Position(int y,int x){
        this.x = x;
        this.y = y;
    }

    public int getPositionX(){
        return this.x;
    }

    public int getPositionY(){
        return this.y;
    }

    public void setPositionX(int x){
        this.x = x;
    }

    public void setPositionY(int y){
        this.y = y;
    }

}
