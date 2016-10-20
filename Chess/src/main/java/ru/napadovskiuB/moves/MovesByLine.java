//package ru.napadovskiuB.moves;
//
//import javafx.geometry.Pos;
//import ru.napadovskiuB.board.*;
//import ru.napadovskiuB.figure.*;
//
//
//import java.security.PublicKey;
//
///**
// * Created by program on 08.10.2016.
// */
//public class MovesByLine implements Moves {
//
//    private Board board;
//    private Figure figure;
//
//    public MovesByLine(Figure figure, Board board) {
//        this.figure = figure;
//        this.board = board;
//    }
//
//    private Position[] TakeAllAvailableMovesForPawn(int arrayLenght){
//        Position[] result = new Position[arrayLenght];
//
//        Position oldPosition = this.figure.getPosition();
//
//        int oldX = oldPosition.getPositionX();
//        int oldY = oldPosition.getPositionY();
//
//        for(int i=0; i<result .length; i++){
//            if(this.board.getFigureByPosition(new Position(++oldY,oldX)) ==null){
//                result[i] = new Position(oldY,oldX);
//            }
//            else {
//                break;
//            }
//        }
//
//        return result;
//    }
//
//    private Position[] TakeAllAvailableMovesForFigure(int lenghtArray){
//        Position[] result = new Position[lenghtArray];
//
//        Position oldPosition = this.figure.getPosition();
//        int oldX = oldPosition.getPositionX();
//        int oldY = oldPosition.getPositionY();
//
//        if(oldX > 0 ){
//            for(int i=0; i<result .length; i++){
//                if(oldX<=0){
//                    oldX =oldPosition.getPositionX();
//                    break;
//                }
//                if(result[i] !=null){ continue;}
//                oldX--;
//                if(this.board.getFigureByPosition(new Position(oldY,oldX)) !=null){
//                    oldX = oldPosition.getPositionX();
//                    break;
//                }
//                result[i] = new Position(oldY,oldX);
//            }
//        }
//        if(oldX<=7){
//             for(int i=0; i<result .length; i++){
//                if(oldX>=7){
//                    oldX =oldPosition.getPositionX();
//                    break;
//                }
//                if(result[i] !=null){continue;}
//                oldX++;
//                if(this.board.getFigureByPosition(new Position(oldY,oldX)) !=null){
//                    oldX = oldPosition.getPositionX();
//                    break;
//                }
//                result[i] = new Position(oldY,oldX);
//            }
//        }
//        if(oldY > 0 ){
//            for(int i=0; i<result .length; i++){
//                if(oldY<=0){
//                    oldY =oldPosition.getPositionY();
//                    break;
//                }
//                if(result[i] !=null){ continue;}
//                oldY--;
//                if(this.board.getFigureByPosition(new Position(oldY,oldX)) !=null){
//                    oldY = oldPosition.getPositionY();
//                    break;
//                }
//                result[i] = new Position(oldY,oldX);
//            }
//        }
//        if(oldY<=7){
//            for(int i=0; i<result .length; i++){
//                if(oldY>=7){
//                    oldY =oldPosition.getPositionY();
//                    break;
//                }
//                if(result[i] !=null){continue;}
//                oldY++;
//                if(this.board.getFigureByPosition(new Position(oldY,oldX)) !=null){
//                    oldY = oldPosition.getPositionY();
//                    break;
//                }
//                result[i] = new Position(oldY,oldX);
//            }
//        }
//
//        return result;
//    }
//
//    public Position[] TakeAllAvailableMoves(int lenghtArray) {
//        Position[] result = new Position[lenghtArray];
//        if (this.figure instanceof Pawn) {
//            result = TakeAllAvailableMovesForPawn(result.length);
//
//        } else {
//            result = TakeAllAvailableMovesForFigure(result.length);
//
//        }
//        return result;
//    }
//}