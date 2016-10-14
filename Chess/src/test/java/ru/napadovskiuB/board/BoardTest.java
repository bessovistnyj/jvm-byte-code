package ru.napadovskiuB.board;

import  ru.napadovskiuB.figure.*;

import static org.hamcrest.core.Is.is;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void whenMovePawnIsCorrectThenReturnNewPosition(){
        Board chessBoard = new Board();
        chessBoard.fillBoard(true);
        chessBoard.fillBoard(false);
        Position testPosition = new Position(1,4);

        Figure newPawn  = chessBoard.getFigureByPosition(testPosition);

        chessBoard.moveFigure(newPawn.getAllAvailableMove(chessBoard),newPawn,new Position(3,4));
        assertThat(chessBoard.getFigureByPosition(new Position(3,4)), is(newPawn));
    }

    @Test
    public void whenMoveFigureOccupiedPositionThenReturnOldPosition(){
        Board chessBoard = new Board();

        chessBoard.fillBoard(true);
        chessBoard.fillBoard(false);

        Position testPosition = new Position(0,2);

        Figure whiteElephant  = new Elephant(testPosition,true);

        chessBoard.setFigureByPosition(whiteElephant);

        chessBoard.moveFigure(whiteElephant.getAllAvailableMove(chessBoard),whiteElephant,new Position(2,4));
        assertThat(chessBoard.getFigureByPosition(new Position(0,2)), is(whiteElephant));
    }

    @Test
    public void whenMoveElephantIsCorrectThenReturnNewPosition(){
        Board chessBoard = new Board();

        Position testPosition = new Position(2,4);

        Figure whiteElephant  = new Elephant(testPosition,true);

        chessBoard.setFigureByPosition(whiteElephant);

        chessBoard.moveFigure(whiteElephant.getAllAvailableMove(chessBoard),whiteElephant,new Position(0,2));
        assertThat(chessBoard.getFigureByPosition(new Position(0,2)), is(whiteElephant));
    }

    @Test
    public void whenMoveHorseIsCorrectThenReturnNewPosition(){
        Board chessBoard = new Board();

        Position testPosition = new Position(2,2);

        Figure whiteHorse  = new Horse(testPosition,true);

        chessBoard.setFigureByPosition(whiteHorse);

        chessBoard.moveFigure(whiteHorse.getAllAvailableMove(chessBoard),whiteHorse,new Position(4,3));
        assertThat(chessBoard.getFigureByPosition(new Position(4,3)), is(whiteHorse));
    }

    @Test
    public void whenMoveOutOfRengeofBoard(){
        Board chessBoard = new Board();

        Position testPosition = new Position(5,4);

        Figure whiteQueen  = new Queen(testPosition,true);

        chessBoard.setFigureByPosition(whiteQueen);

        chessBoard.moveFigure(whiteQueen.getAllAvailableMove(chessBoard),whiteQueen,new Position(9,4));
        assertThat(chessBoard.getFigureByPosition(new Position(5,4)), is(whiteQueen));
    }


}
