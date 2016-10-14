package ru.napadovskiuB.figure;

import ru.napadovskiuB.board.Board;
import ru.napadovskiuB.board.Cell;
import ru.napadovskiuB.board.Position;
import ru.napadovskiuB.moves.MovesByLine;

/**
 * Created by program on 08.10.2016.
 */
public class Pawn implements Figure {

    private Position position;
    private boolean isWhite;

    public Pawn(Position position,boolean isWhite){
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
        Position[] result;
        if(this.position.getPositionY() ==1 || this.position.getPositionY() == 6){
            result = new Position[2];
        }
        else{
            result = new Position[1];
        }

        result = new MovesByLine(this,board).TakeAllAvailableMoves(result.length);

        return result;
    }

}
