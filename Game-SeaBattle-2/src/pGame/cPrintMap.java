package pGame;

public class cPrintMap {

    public static void printMap(boolean[][] map) {
        for (boolean[] row : map) {
            for (boolean cell : row) {
                System.out.printf("%s ", cell ? "#" : ".");
            }
            System.out.println();
        }
    }
}
