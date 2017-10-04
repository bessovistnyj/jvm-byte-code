

public abstract class Unit {

    private final int xCoordinate;

    private final int yCoordinate;

    private final GameBoard board;

    private final String typeOfUnit;

    public Unit(int xCoordinate, int yCoordinate, String typeOfUnit, GameBoard board) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.typeOfUnit = typeOfUnit;
        this.board  = board;
    }

    public int getXCoordinate() {
        return this.xCoordinate;
    }

    public int getYCoordinate() {
        return this.yCoordinate;
    }

    public String getTypeOfUnit() {
        return this.typeOfUnit;
    }


    public boolean tryMoveUnit(int newPositionX, int newPositionY) {
        boolean result = false;
        if(newPositionX <= this.getBoard().getxSize() || newPositionX > 0 || newPositionY <= this.getBoard().getySize() || newPositionY > 0) {
            result = true;
        }
        return result;
    }

    public GameBoard getBoard() {
        return board;
    }


}
