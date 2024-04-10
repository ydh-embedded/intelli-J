package packageMAP;

import com.example.employment.Employee;

import java.util.Map.Entry;
// Das * steht für "alle". Hier bedeutet es:
// Importiere alle öffentlichen Klassen, Interfaces etc. aus dem Package java.util
import java.util.*;

public class MapExamples {

  public static void main(String[] args) {
//    createMaps();
//    generateWordStatistics();
    groupElements();
  }


  public static void createMaps() {
    // Bei einer Map darf man nicht davon ausgehen, dass die Reihenfolge, in der Einträge
    // hinzugefügt werden, auch automatisch der Reihenfolge entspricht, in der die Einträge
    // der Map aufgezählt werden.
    Map<String, Employee> employeeById = new HashMap<>(Map.of(
            "AW001", new Employee("Alice Wonderland", "AW001", "Sales"),
            "BR001", new Employee("Bob Ross", "BR001", "Development"),
            "CB002", new Employee("Charlie Brown", "CB002", "Marketing"),
            "DR001", new Employee("Damian Rice", "DR001", "Entertainment")
    ));

    // Füge ein neues Key-Value-Pair zur Map hinzu.
    employeeById.put("EM001", new Employee("Elon Musk", "EM001", "CEO"));
    // Entferne ein Key-Value-Pair. Hier entfernen wir Bob Ross.
    // Es ist kein Fehler einen Schlüssel zu entfernen, der gar nicht existiert.
    employeeById.remove("BR001");
    employeeById.remove("XYZ"); // kein Effekt

    printEmployeeMap(employeeById);
  }

  public static void printEmployeeMap(Map<String, Employee> map) {
    for (String id : map.keySet()) {
      // Mit der get Methode erhält man das Value, welches zu einem Key gehört.
      Employee employee = map.get(id);
      System.out.printf("ID: %-10s Name: %-20s Department: %-10s\n",
              id, employee.name(), employee.department());
    }
  }

  public static void generateWordStatistics() {
    String text = "Das ist das Haus vom Nikolaus. Freibier für alle: der letzte zahlt.";
    Map<Character, Integer> countByChar = new TreeMap<>();
    for (char c : text.toCharArray()) {
      // Falls Zeichen schon in der Map vorhanden, lies das Value aus.
      // Andernfalls verwende den Default-Wert 0.
//      int count = countByChar.containsKey(c) ? countByChar.get(c) : 0;
      int count = countByChar.getOrDefault(c, 0);
      count++;
      // Schreibe den aktualisierten Count in die Map zurück bzw. erstelle
      // einen neuen Eintrag in der Map, sofern der Buchstabe noch nicht
      // vorhanden war.
      countByChar.put(c, count);
    }
    // Stelle die Statistik dar.
    for (char c : countByChar.keySet()) {
      System.out.printf("%c : %02d\n", c, countByChar.get(c));
    }
    // Sortiere die Schlüssel der Map, indem du die Entries in einer Liste
    // ablegst und dann diese Liste sortierst.
    List<Entry<Character, Integer>> mapEntries = new ArrayList<>(countByChar.entrySet());
    // Sortiere die Key-Value-Pairs in der Liste nach den Values absteigend.
    mapEntries.sort((e1, e2) -> e2.getValue() - e1.getValue());
//    System.out.println(mapEntries);
    System.out.println();
    for (Entry e : mapEntries) {
      System.out.println(e);
    }
  }

  public static void groupElements() {
    List<String> names = List.of("alice", "bob", "anton", "billy", "berta", "charlie");
    Map<Character, List<String>> namesByChar = new TreeMap<>();
    for (String name : names) {
      char key = name.length() > 0 ? name.charAt(0) : ' ';
      List<String> value = namesByChar.getOrDefault(key, new ArrayList<>());
      value.addLast(name);
      namesByChar.put(key, value);
    }

    namesByChar.compute('a', (key, value) -> {
      value.addLast("test");
      return value;
    });

    // Berechne die Values für alle Keys neu.
    namesByChar.replaceAll((key, value) -> {
      value.addFirst("added");
      return value;
    });

    System.out.println(namesByChar);
  }


}
