package pGame;

import static pGame.cMap.mCreateMap;
import static pGame.cPrintMap.printMap;
import static pGame.cPlaceShip.mPlaceShip;



public class game {


        public static void main(String[] args) {

//         wir erzeugen eine Karte
            boolean[][] map = mCreateMap(5, 6);
//         wir platzieren die Eingabe
            mPlaceShip(map, 1, 2, 3, true);
            mPlaceShip(map, 2, 0, 2, false);
//         wir geben die Karte aus
            printMap(map);
        }
}


