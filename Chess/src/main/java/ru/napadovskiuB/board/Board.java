package ru.napadovskiuB.board;

import  ru.napadovskiuB.figure.*;

public class Board{
    private final Figure[][] board = new Figure[8][8];

    public Figure[][] getBoard(){
        return this.board;
    }

    public void fillPawn(boolean isWhite){
        int firstLine = 1;
        if(!isWhite){
            firstLine = 6;
        }
        for(int i=0; i<8; i++){
            Figure pawn = new Pawn(firstLine,i,isWhite);
            this.setFigureByPosition(pawn);
        }
    }

    public void fillFigure(boolean isWhite){
        int firstLine = 0;
        if(!isWhite){
            firstLine =7;
        }
        this.setFigureByPosition(new Rook(firstLine,0,isWhite));
        this.setFigureByPosition(new Rook(firstLine,7,isWhite));
        this.setFigureByPosition(new Horse(firstLine,1,isWhite));
        this.setFigureByPosition(new Horse(firstLine,6,isWhite));
        this.setFigureByPosition(new Elephant(firstLine,2,isWhite));
        this.setFigureByPosition(new Elephant(firstLine,5,isWhite));
        this.setFigureByPosition(new Queen(firstLine,3,isWhite));
        this.setFigureByPosition(new King(firstLine,4,isWhite));
    }

    public Figure getFigureByPosition (int y, int x){
        return  this.board[y][x];
    }

    public void fillBoard(boolean isWhite){
            this.fillPawn(isWhite);
            this.fillFigure(isWhite);
    }

    public void setFigureByPosition(Figure figure){
        this.board[figure.getPositionY()][figure.getPositionX()] = figure;

    }

}