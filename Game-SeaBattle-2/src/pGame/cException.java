package pGame;

import static pGame.cMap.mAssertIsInMap;

public class cException {
    public static void mAssertValidity(boolean[][] map, int row, int column) {
        if (map == null) throw new IllegalArgumentException("map must be non-null");
        mAssertIsInMap(map, row, column, "Invalid position: (%02d, %02d)");
    }
}
