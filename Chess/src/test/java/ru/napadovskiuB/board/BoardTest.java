package ru.napadovskiuB.board;

import  ru.napadovskiuB.figure.*;

import static org.hamcrest.core.Is.is;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void whenMoveWhiteRookIsCorrect(){
        Board board  = new Board();
        Figure whiteRook = new Rook(2,2,true);
        board.setFigureByPosition(whiteRook);
        whiteRook.moveFigure(7,2,board);
        assertThat(board.getFigureByPosition(7,2),is(whiteRook));

    }

    @Test
    public void whenMoveWhiteElephantIsCorrect(){
        Board board  = new Board();
        Figure whiteElephant = new Elephant(0,1,true);
        board.setFigureByPosition(whiteElephant);
        whiteElephant.moveFigure(2,5,board);
        assertThat(board.getFigureByPosition(2,5),is(whiteElephant));

    }


}
