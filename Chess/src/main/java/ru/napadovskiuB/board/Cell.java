package ru.napadovskiuB.board;

import ru.napadovskiuB.figure.*;

/**
 * Created by program on 06.10.2016.
 */
public class Cell {

    private Position position;
    private Figure figure;

    public Cell(Position position,Figure figure){
        this.figure = figure;
        this.position = position;

    }

    public void setPosition(Position position){
        this.position = position;
    }

    public void setFigure(Figure figure){
        this.figure = figure;
    }

    public Position getPosition(){
        return this.position;
    }

    public Figure getFigure(){
        return this.figure;
    }



}
