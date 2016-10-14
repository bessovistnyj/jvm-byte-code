package ru.napadovskiuB.moves;

import javafx.geometry.Pos;
import ru.napadovskiuB.board.*;
import ru.napadovskiuB.figure.*;


import java.security.PublicKey;

/**
 * Created by program on 08.10.2016.
 */
public class MoveByDiagonale implements Moves {

    private Board board;
    private Figure figure;

    public MoveByDiagonale(Figure figure, Board board) {
        this.figure = figure;
        this.board = board;
    }

    private Position[] TakeAllAvailableMovesForFigure(int arrayLenght){
        Position[] result = new Position[arrayLenght];
        Position oldPosition = this.figure.getPosition();
        int oldX = oldPosition.getPositionX();
        int oldY = oldPosition.getPositionY();
            for(int i=0; i<result .length; i++){
                if(oldX<=0){
                    oldX =oldPosition.getPositionX();
                    oldY = oldPosition.getPositionY();
                    break;
                }
                if(result[i] !=null){ continue;}
                oldX--;
                oldY++;
                if(this.board.getFigureByPosition(new Position(oldY,oldX)) !=null){
                    oldX = oldPosition.getPositionX();
                    oldY = oldPosition.getPositionY();
                    break;
                }
                result[i] = new Position(oldY,oldX);
            }
            for(int i=0; i<result .length; i++){
                if(oldX>=7){
                    oldX =oldPosition.getPositionX();
                    oldY = oldPosition.getPositionY();
                    break;
                }
                if(result[i] !=null){ continue;}
                oldX++;
                oldY++;
                if(this.board.getFigureByPosition(new Position(oldY,oldX)) !=null){
                    oldX = oldPosition.getPositionX();
                    oldY = oldPosition.getPositionY();
                    break;
                }
                result[i] = new Position(oldY,oldX);
            }
        for(int i=0; i<result .length; i++){
            if(oldY<=0){
                oldX =oldPosition.getPositionX();
                oldY = oldPosition.getPositionY();
                break;
            }
            if(result[i] !=null){ continue;}
            oldX--;
            oldY--;
            if(this.board.getFigureByPosition(new Position(oldY,oldX)) !=null){
                oldX = oldPosition.getPositionX();
                oldY = oldPosition.getPositionY();
                break;
            }
            result[i] = new Position(oldY,oldX);
        }
        for(int i=0; i<result .length; i++){
            if(oldY<=0){
                oldX =oldPosition.getPositionX();
                oldY = oldPosition.getPositionY();
                break;
            }
            if(result[i] !=null){ continue;}
            oldX++;
            oldY--;
            if(this.board.getFigureByPosition(new Position(oldY,oldX)) !=null){
                oldX = oldPosition.getPositionX();
                oldY = oldPosition.getPositionY();
                break;
            }
            result[i] = new Position(oldY,oldX);
        }


        return result;
    }

    public Position[] TakeAllAvailableMoves(int arrayLenght) {
        Position[] result; //= new Position[arrayLenght];
        return result = TakeAllAvailableMovesForFigure(arrayLenght);
        //return result;
    }
}