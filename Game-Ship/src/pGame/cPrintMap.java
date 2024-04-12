package pGame;

public class cPrintMap {
    public static void printOceanMap(){
        System.out.println();



        System.out.print("  ");
        int numCols = 1;
        for(int i = 0; i < numCols; i++)
                    System.out.print(i);
        System.out.println();


        boolean[][] grid = new boolean[10][10];

        for(int x = 0; x < grid.length; x++) {
            System.out.print(x + "|");

            for (int y = 0; y < grid[x].length; y++){
                System.out.print(grid[x][y]);
            }

            System.out.println("|" + x);
        }

        System.out.print("  ");
        for(int i = 0; i < numCols; i++)
            System.out.print(i);
        System.out.println();
    }
}
