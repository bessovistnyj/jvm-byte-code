package ru.napadovskiuB.figure;


import ru.napadovskiuB.board.*;

public interface Figure{

    void setPosition(Position position);

    void setWhite(boolean isWhite);

    Position getPosition();

    boolean getIsWhite();

    Position[] getAllAvailableMove(Board board);

}