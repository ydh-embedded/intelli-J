package pGame;

import java.util.Objects;

import static pGame.cException.mAssertValidity;
import static pGame.cMap.mAssertIsInMap;
/*
*
 */


public class cPlaceShip {

    public static void mPlaceShip(boolean[][] map, int startRow, int startColumn, int size, boolean isVertical) {
        Objects.requireNonNull(map);
        int endRow = isVertical ? startRow + size - 1 : startRow;
        int endColumn = !isVertical ? startColumn + size - 1 : startColumn;
        mAssertIsInMap(map, startRow, startColumn, "Start position (%02d, %02d) not in map");
        mAssertIsInMap(map, endRow, endColumn, "End position (%02d, %02d) not in map");

        if (isVertical) {
            for (int row = startRow; row <= endRow; row++) {
                if (mIsOccupied(map, row, startColumn)) {
                    throw new IllegalArgumentException("Collission: position (%02d, %02d) already occupied!".formatted(row, startColumn));
                }
                map[row][startColumn] = true;
            }
        } else {
            for (int column = startColumn; column <= endColumn; column++) {
                if (mIsOccupied(map, startRow, column)) {
                    throw new IllegalArgumentException("Collission: position (%02d, %02d) already occupied!".formatted(startRow, column));
                }
                map[startRow][column] = true;
            }
        }
    }

    public static boolean mIsOccupied(boolean[][] map, int row, int column) {
        mAssertValidity(map, row, column);
        return map[row][column];
    }

}

