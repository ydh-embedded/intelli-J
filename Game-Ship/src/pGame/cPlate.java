package pGame;

import java.util.Arrays;
/*
    Wir erstllen ein Feld / Battle-Field
 */
public class cPlate {
    
    private char[][] plate;

    public cPlate(int rows, int cols) {
    }

    public int mPlate(int xAchse, int yAchse){
            this.plate = new char[xAchse][yAchse];

            for (int x = 0; x < xAchse; x++) {
                for (int y = 0; y < yAchse; y++){
                    this.plate[x][y] = '~' ;
                }
            }

    return mPlate(xAchse,yAchse);
    }

    public int[] mGetDimensions() {
        return new int[0];
    }

    public void mStatus() {

        System.out.println(     "  "
                + Arrays.toString(mGetDimensions()));

        for (int row = 0; row < mGetDimensions()[0]; row++) {
            System.out.print(row + " ");

            for (int col = 0; col < mGetDimensions()[1]; col++) {
                if (plate[row][col] == '~') {

                    System.out.print(". ");
                } else {

                    System.out.print("# ");
                }
            }
            System.out.println();
        }
        int[] aPlate = new int[2];
        int xAchse = 0;
        int yAchse = 0;

        cPlate mPlate = new cPlate(aPlate[0], aPlate[1]);
//        cPlate mPlate = new cPlate(xAchse, yAchse);

    }
}



