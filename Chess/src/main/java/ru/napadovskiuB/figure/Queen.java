//package ru.napadovskiuB.figure;
//
//import ru.napadovskiuB.board.*;
//import ru.napadovskiuB.moves.*;
//
///**
// * Created by program on 08.10.2016.
// */
//public class Queen implements Figure {
//
//    private Position position;
//    private boolean isWhite;
//
//    public Queen(Position position,boolean isWhite){
//        this.position = position;
//        this.isWhite = isWhite;
//    }
//
//    public void setPosition(Position position){
//        this.position = position;
//    }
//
//    public void setWhite(boolean isWhite){
//        this.isWhite = isWhite;
//    }
//
//    public Position getPosition(){
//        return this.position;
//    }
//
//    public boolean getIsWhite(){
//        return this.isWhite;
//    }
//
//    public Position[] getAllAvailableMove(Board board){
//        Position[] result = new Position[32];
//
//        Position[] allLinesMoves = new MovesByLine(this,board).TakeAllAvailableMoves(result.length);
//
//        Position[] allDiagonalMoves = new MoveByDiagonale(this,board).TakeAllAvailableMoves(result.length);
//
//        int counter = 0;
//        for (int i=0; i<allLinesMoves.length;i++){
//            if(allLinesMoves[i] != null){
//                result[i] = allLinesMoves[i];
//                counter++;
//            }
//        }
//        for (int i=0; i<allDiagonalMoves.length;i++){
//            if(allDiagonalMoves[i] != null){
//                result[counter] = allDiagonalMoves[i];
//                counter++;
//            }
//        }
//        return result;
//
//    }
//
//}
