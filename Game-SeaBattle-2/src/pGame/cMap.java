package pGame;

import java.util.Objects;

public class cMap {

    public static boolean mIsInMap(boolean[][] map, int row, int column) {
        Objects.requireNonNull(map);
        return row >= 0 && row < map.length && column >= 0 && column < map[row].length;
    }

    public static void mAssertIsInMap(boolean[][] map, int row, int column, String template) {
        if (!mIsInMap(map, row, column)) {
            throw new IllegalArgumentException(template.formatted(row, column));
        }
    }



    public static boolean[][] mCreateMap(int rows, int columns) {
        if (rows <= 0) throw new IllegalArgumentException("Number of rows must be >= 1");
        if (columns <= 0) throw new IllegalArgumentException("Number of columns must be >= 1");
        return new boolean[rows][columns];
    }
}
