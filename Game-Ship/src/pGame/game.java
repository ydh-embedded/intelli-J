package pGame;

import java.util.Scanner;

import static pGame.rHeader.mHeader;
import static pGame.cPlate.*;

public class game {

    public static void main(String[] args) {

        //  Logo
        mHeader();

        //  Eingabe des Feldes
        Scanner scanner = new Scanner(System.in);
                    System.out.print("Insert the Rows: ");
            int rows = scanner.nextInt();
                    System.out.print("Insert the columns: ");
             int cols = scanner.nextInt();

        cPlate mPlate = new cPlate(rows, cols);
//        System.out.println("The dimensions of the plate are: " +
//                mPlate.mGetDimensions()[1] + " x " + mPlate.mGetDimensions()[1]);




    }
}
