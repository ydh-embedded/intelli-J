package pGame;

import java.util.Map;
import java.util.TreeMap;

public class vShip {
    public static Map<String , vShip> vShipById = new TreeMap<>(Map.of(
            "S001" , new vShip ( "S001" ,"#" ,  "Schlauchboot" ) ,
            "S002" , new vShip ( "S002" ,"##" ,  "Angelboot"    ) ,
            "S003" , new vShip ( "S003" ,"###" ,  "Speedboot"    ) ,
            "S004" , new vShip ( "S004" ,"####" ,  "Jacht"        ) ,
            "S005" , new vShip ( "S005" ,"#####" ,  "Schiff"       ) ,
            "S006" , new vShip ( "S006" ,"######" ,  "Fregatte"      ) ,
            "S007" , new vShip ( "S007" ,"#######" ,  "Flugzeugträger" )
    ));

    public vShip(String Key, String Größe, String Typ) {

    }
}
