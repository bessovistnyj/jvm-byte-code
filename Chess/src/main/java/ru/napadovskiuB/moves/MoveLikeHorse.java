package ru.napadovskiuB.moves;

import javafx.geometry.Pos;
import ru.napadovskiuB.board.*;
import ru.napadovskiuB.figure.*;


import java.security.PublicKey;

/**
 * Created by program on 08.10.2016.
 */
public class MoveLikeHorse implements Moves {

    private Board board;
    private Figure figure;

    public MoveLikeHorse(Figure figure, Board board) {
        this.figure = figure;
        this.board = board;
    }

    public Position[] TakeAllAvailableMoves(int arrayLenght) {
        Position[] result = new Position[arrayLenght];
        Position oldPosition = this.figure.getPosition();
        for(int i=0; i<result .length; i++){
            int oldX = oldPosition.getPositionX();
            int oldY = oldPosition.getPositionY();

            if(i==0){
                oldX = oldX+1;
                oldY = oldY+2;
            }
            else if(i==1){
                oldX = oldX-1;
                oldY = oldY+2;
            }
            else if(i==2){
                oldX = oldX-2;
                oldY = oldY+1;
            }
            else if(i==3){
                oldX = oldX-2;
                oldY = oldY-1;

            }
            else if(i==4){
                oldX = oldX+1;
                oldY = oldY-2;

            }
            else if(i==5){
                oldX = oldX+2;
                oldY = oldY-2;

            }
            else if(i==6){
                oldX = oldX+2;
                oldY = oldY+1;

            }
            else if(i==7){
                oldX = oldX+2;
                oldY = oldY-1;

            }
            if (oldX >=0 && oldY>=0){
                if(this.board.getFigureByPosition(new Position(oldY,oldX)) !=null){
                    continue;
                }
                result[i] = new Position(oldY,oldX);
            }
        }
        return result;
    }
}