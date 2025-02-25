package battleship;

import lombok.Data;

@Data
public class Coordinate {
    int xCoordinate;
    int yCoordinate;

    public Coordinate(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    boolean areCoordinatesEqual(Coordinate coordinateA, Coordinate coordinateB) {
        if(coordinateA.xCoordinate == coordinateB.xCoordinate && coordinateA.yCoordinate == coordinateB.yCoordinate) {
            return true;
        }
        return false;
    }
}
