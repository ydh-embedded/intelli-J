package pGame;

import java.util.Map;
import java.util.TreeMap;

public class hShip {
    public static Map<String , hShip> hShipById = new TreeMap<>(Map.of(
            "S001" , new hShip ( "S001" ,"#" ,  "Schlauchboot" ) ,
            "S002" , new hShip ( "S002" ,"##" ,  "Angelboot"    ) ,
            "S003" , new hShip ( "S003" ,"###" ,  "Speedboot"    ) ,
            "S004" , new hShip ( "S004" ,"####" ,  "Jacht"        ) ,
            "S005" , new hShip ( "S005" ,"#####" ,  "Schiff"       ) ,
            "S006" , new hShip ( "S006" ,"######" ,  "Fregatte"      ) ,
            "S007" , new hShip ( "S007" ,"#######" ,  "Flugzeugträger" )
    ));

    public hShip(String Key, String Größe, String Typ) {

    }
}
