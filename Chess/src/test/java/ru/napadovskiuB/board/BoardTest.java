package ru.napadovskiuB.board;

import  ru.napadovskiuB.figure.*;

import static org.hamcrest.core.Is.is;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void whenMoveWhiteRookIsCorrectThenMoveFigure(){
        Board board  = new Board();
        Figure whiteRook = new Rook(2,2,true);
        board.setFigureByPosition(whiteRook);
        whiteRook.moveFigure(7,2,board);
        assertThat(board.getFigureByPosition(7,2),is(whiteRook));

    }

    @Test
    public void whenMoveWhiteRookIsUnCorrectThenDontMove(){
        Board board  = new Board();
        Figure whiteRook = new Rook(2,2,true);
        board.setFigureByPosition(whiteRook);
        Figure blackPawn = new Pawn(4,2,false);
        board.setFigureByPosition(blackPawn);
        whiteRook.moveFigure(7,2,board);
        assertThat(board.getFigureByPosition(2,2),is(whiteRook));
    }


    @Test
    public void whenMoveWhiteElephantIsCorrect(){
        Board board  = new Board();
        Figure whiteElephant = new Elephant(0,1,true);
        board.setFigureByPosition(whiteElephant);
        whiteElephant.moveFigure(4,5,board);
        assertThat(board.getFigureByPosition(4,5),is(whiteElephant));

    }

    @Test
    public void whenMoveWhiteHorseIsCorrect(){
        Board board  = new Board();
        Figure whiteHorse = new Horse(2,2,true);
        board.setFigureByPosition(whiteHorse);
        whiteHorse.moveFigure(3,3,board);
        assertThat(board.getFigureByPosition(2,2),is(whiteHorse));
    }

    @Test
    public void whenMoveWhiteHorseIsUnCorrectThenDontMove(){
        Board board  = new Board();
        Figure whiteHorse = new Horse(2,2,true);
        board.setFigureByPosition(whiteHorse);
        Figure blackPawn = new Pawn(4,1,false);
        board.setFigureByPosition(blackPawn);
        whiteHorse.moveFigure(4,1,board);
        assertThat(board.getFigureByPosition(2,2),is(whiteHorse));
    }

    @Test
    public void whenMoveWhiteKingIsCorrect(){
        Board board  = new Board();
        Figure whiteKing = new King(2,2,true);
        board.setFigureByPosition(whiteKing);
        whiteKing.moveFigure(1,1,board);
        assertThat(board.getFigureByPosition(1,1),is(whiteKing));

    }

    @Test
    public void whenMoveWhiteQueenIsCorrect(){
        Board board  = new Board();
        Figure whiteHorse = new Queen(3,3,true);
        board.setFigureByPosition(whiteHorse);
        whiteHorse.moveFigure(6,0,board);
        assertThat(board.getFigureByPosition(6,0),is(whiteHorse));

    }


}
