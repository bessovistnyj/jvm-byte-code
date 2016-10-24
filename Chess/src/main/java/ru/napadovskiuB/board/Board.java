package ru.napadovskiuB.board;

import  ru.napadovskiuB.figure.*;

public class Board{
    private final Figure[][] board = new Figure[8][8];

    public Figure[][] getBoard(){
        return this.board;
    }

    /**
     *Method fills the board with pawns
     */
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

    /**
     *Method fills the board with figurs
     */
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

    /**
     *Method fills the board
     */
    public void fillBoard(boolean isWhite){
        this.fillPawn(isWhite);
        this.fillFigure(isWhite);
    }

    /**
     *Method return figure
     *@param y
     *@param x
     *@return figure
     */
    public Figure getFigureByPosition (int y, int x){
        return  this.board[y][x];
    }

    /**
     *Method clear position of the board
     *@param y
     *@param x
     */
    public void clearPosition(int y, int x){
        this.board[y][x] = null;
    }

    /**
     *Method sets the figure to the position of board
     *@param figure
     */
    public void setFigureByPosition(Figure figure){
        this.board[figure.getPositionY()][figure.getPositionX()] = figure;

    }

    /**
     *Method clears the position on the board
     *@param figure
     *@param positionY
     *@param positionX
     */
    private boolean occupiedCell(Figure figure, int positionY,int positionX){
        boolean result = true;
        if (!(figure instanceof Horse)){
            if(this.getFigureByPosition(positionY,positionX)!=null){
                result =false;
            }
        }
        return result;
    }

    /**
     *Method takes shape
     *@param newY
     *@param newX
     */
    private void takeShape(int newY, int newX){
        if(this.getFigureByPosition(newY,newX) !=null){
            clearPosition(newY,newX);
        }
    }

    /**
     *Method checks the possibility of move
     *@param figure
     *@param newY
     *@param newX
     */
    private boolean canMoveFigure(Figure figure,int newY, int newX){
        boolean result = false;
        Position[] allAvailableMoves = figure.getAvailableMoves();
        for (int i=0; i < allAvailableMoves.length; i++){
            if (allAvailableMoves[i] == null){
                continue;
            }
            if(!occupiedCell(figure,allAvailableMoves[i].getPositionY(),allAvailableMoves[i].getPositionX())){
                result =false;
                break;
            }
            if (allAvailableMoves[i].getPositionY() == newY && allAvailableMoves[i].getPositionX() == newX){
                result=true;
                break;
            }
        }
        return result;
    }

    /**
     *Method move figure on the board
     *@param figure
     *@param newPositionY
     *@param newPositionX
     */
    public void moveFigure(Figure figure,int newPositionY,int newPositionX){

        if(this.canMoveFigure(figure,newPositionY,newPositionX)){
            clearPosition(figure.getPositionY(),figure.getPositionX());

            takeShape(newPositionY,newPositionX);

            figure.setPosition(newPositionY,newPositionX);

            setFigureByPosition(figure);
        }else{
            System.out.println("Inaccessible move");
        }

    }

}