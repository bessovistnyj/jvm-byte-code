package ru.napadovskiuB.figure;

import ru.napadovskiuB.board.*;
import ru.napadovskiuB.moves.*;

/**
 * Created by program on 08.10.2016.
 */
public class Elephant implements Figure {

    private Position position;
    private boolean isWhite;

    public Elephant(Position position,boolean isWhite){
        this.position = position;
        this.isWhite = isWhite;
    }



    public void setPosition(Position position){
        this.position = position;
    }

    public void setWhite(boolean isWhite){
        this.isWhite = isWhite;
    }

    public Position getPosition(){
        return this.position;
    }

    public boolean getIsWhite(){
        return this.isWhite;
    }

    public Position[] getAllAvailableMove(Board board){
        Position[] result = new Position[16];

        result = new MoveByDiagonale(this,board).TakeAllAvailableMoves(result.length);

        return result;
    }

}
