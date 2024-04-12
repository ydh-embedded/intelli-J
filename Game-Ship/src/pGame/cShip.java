package pGame;

import java.util.Map;
import java.util.TreeMap;

public class cShip {

//    Horizontale & Vertikale Schiffe

    private final String key;
    private final String size;
    private final String typ;

    public cShip(String key, String size, String typ) {
        this.key = key;
        this.size = size;
        this.typ = typ;
    }


    public static Map<String, cShip> shipsById = new TreeMap<>(Map.of(
                "S001", new cShip("S001", "#", "Schlauchboot"),
                "S002", new cShip("S002", "##", "Angelboot"),
                "S003", new cShip("S003", "###", "Speedboot"),
                "S004", new cShip("S004", "####", "Jacht"),
                "S005", new cShip("S005", "#####", "Schiff"),
                "S006", new cShip("S006", "######", "Fregatte"),
                "S007", new cShip("S007", "#######", "Flugzeugträger")
    ));


    public String getKey() {
        return key;
    }

    public String getSize() {
        return size;
    }

    public String getTyp() {
        return typ;
    }


}

