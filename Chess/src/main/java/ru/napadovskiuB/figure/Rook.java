package ru.napadovskiuB.figure;

import ru.napadovskiuB.board.Board;
import ru.napadovskiuB.board.Cell;
import ru.napadovskiuB.board.Position;
import ru.napadovskiuB.moves.MovesByLine;

/**
 * Created by program on 08.10.2016.
 */
public class Rook implements Figure {

    private Position position;
    private boolean isWhite;

    public Rook(Position position,boolean isWhite){
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

        result = new MovesByLine(this,board).TakeAllAvailableMoves(result.length);

        return result;
    }

}
