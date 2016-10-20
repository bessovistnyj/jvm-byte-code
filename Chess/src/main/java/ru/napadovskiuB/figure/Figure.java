package ru.napadovskiuB.figure;


import ru.napadovskiuB.board.*;

public interface Figure{

    void setPosition(int y,int x);

    void setColorFigure(boolean isWhite);

    int getPositionY();

    int getPositionX();

    void moveFigure(int newY, int newX);



}