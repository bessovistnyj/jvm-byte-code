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
            Position tmpPosition = new Position(firstLine,i);
            this.board[firstLine][i] = new Pawn(new Position(firstLine,i),isWhite);
        }
    }

    public void fillFigure(boolean isWhite){
        int firstLine = 0;
        if(!isWhite){
            firstLine =7;
        }
        this.board[firstLine][0] = new Rook(new Position(firstLine,0),isWhite);//new Cell(new Rook(new Position(firstLine,0),isWhite).getPosition(),new Rook(new Position(firstLine,0),isWhite));
//        this.board[firstLine][7] = new Cell(new Rook(new Position(firstLine,7),isWhite).getPosition(),new Rook(new Position(firstLine,7),isWhite));
//        this.board[firstLine][1] = new Cell(new Horse(new Position(firstLine,1),isWhite).getPosition(),new Horse(new Position(firstLine,1),isWhite));
//        this.board[firstLine][6] = new Cell(new Horse(new Position(firstLine,6),isWhite).getPosition(),new Horse(new Position(firstLine,6),isWhite));
//        this.board[firstLine][2] = new Cell(new Elephant(new Position(firstLine,2),isWhite).getPosition(),new Elephant(new Position(firstLine,2),isWhite));
//        this.board[firstLine][5] = new Cell(new Elephant(new Position(firstLine,5),isWhite).getPosition(),new Elephant(new Position(firstLine,5),isWhite));
//        this.board[firstLine][4] = new Cell(new Queen(new Position(firstLine,4),isWhite).getPosition(),new Queen(new Position(firstLine,4),isWhite));
//        this.board[firstLine][3] = new Cell(new King(new Position(firstLine,3),isWhite).getPosition(),new King(new Position(firstLine,3),isWhite));


    }

    public Figure getFigureByPosition (Position position){
        Figure  result;
        try {
            result =this.board[position.getPositionY()][position.getPositionX()].getFigure();
        }
        catch (Exception ex){
            result = null;
        }

        return  result;
    }

    public void fillBoard(boolean isWhite){
            this.fillPawn(isWhite);
            this.fillFigure(isWhite);
    }

    private boolean findPosition(Position[] allMoves,Position newPosition){
        boolean result = false;
        if(allMoves.length != 0){
            for (Position tmpPosition : allMoves) {
                if (tmpPosition != null) {
                    if (tmpPosition.getPositionX() == newPosition.getPositionX() && tmpPosition.getPositionY() == newPosition.getPositionY()) {
                        result = true;
                        break;
                    }
                }
            }
        }
        else{
            System.out.println("inaccessible move");
        }
        return result;
    }

    private void clearOldCell(Figure figure){
//        Cell oldCell = this.board[figure.getPosition().getPositionY()][figure.getPosition().getPositionX()];
//        oldCell.setFigure(null);
        this.board[figure.getPosition().getPositionY()][figure.getPosition().getPositionX()] =null;

    }

    public void setFigureByPosition(Figure figure){
        this.board[figure.getPosition().getPositionY()][figure.getPosition().getPositionX()]  = figure;

    }

    public void moveFigure(Position[] allMoves,Figure figure,Position newPosition){
        if(this.findPosition(allMoves,newPosition)){
//            clearOldCell(figure);
//            Cell newCell = new Cell(newPosition,figure);
//            figure.setPosition(newPosition);
//            this.board[newPosition.getPositionY()][newPosition.getPositionX()] =newCell;
        }
        else{
            System.out.println("inaccessible move");
        }
    }



}