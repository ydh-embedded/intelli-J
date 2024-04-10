package packageSET;

import java.util.*;

public class SetExamples {

  public static void main(String[] args) {
//    addAndRemoveElements();

//    setOperations();
    keepElementsSortedWithTreeSet();
  }

  public static void addAndRemoveElements() {
    // Eine Set ist eine Collection, die keine Duplikate zulässt.
    // Die Elemente in der Set haben keine spezifische Reihenfolge.
    // Man darf nicht erwarten, dass man die Elemente in der Reihenfolge
    // ausliest, in der man sie zur Set ursprünglich hinzugefügt hat.
    Set<String> words = new HashSet<>();
    words.add("house");
    words.addAll(Set.of("anton", "berta", "carla"));
    words.add("anton");
    words.add("anton");
    words.add("Anton");
    System.out.println(words);
    // Erstelle eine Liste aus den Elementen einer Set.
    List<String> friends = new ArrayList<>(words);
    // Und umgekehrt: Erstelle eine Set aus den Elementen einer Liste.
    Set<String> uniqueWords = new HashSet<>(List.of(
            "ich", "bin", "ich", "und", "du", "bist", "du"
    ));
    System.out.println(uniqueWords);
    // Entferne Element "du", sofern es vorhanden ist.
    uniqueWords.remove("du");
    System.out.println(uniqueWords);
  }

  public static List<Integer> playLotto(int n) {
    var generator = new Random();
    Set<Integer> randomNumbers = new HashSet<>();
    // Rate so lange Zahlen, bis n unterschiedliche Zahlen
    // ermittelt wurden.
    while (randomNumbers.size() < n) {
      int number = generator.nextInt(1, 50);
      randomNumbers.add(number);
    }
    // Nun wandeln wir die Elemente der Set in eine Liste um und sortieren
    // sie aufsteigend.
    var list = new ArrayList<>(randomNumbers);
    list.sort((a, b) -> a - b);
    return list;
  }

  public static void setOperations() {
    Set<String> myFriends = new TreeSet<>(Set.of("alice", "bob", "charlie"));
    Set<String> hisFriends = new TreeSet<>(Set.of("charlie", "damian", "elon"));
    Set<String> commonFriends = new TreeSet<>(myFriends);
    // Behalte nur Elemente bei, die auch in hisFriends vorhanden sind.
    // Mit anderen Worten: Bilde die Schnittmenge (Intersection) beider Sets.
    commonFriends.retainAll(hisFriends);
    System.out.println(commonFriends);

    // Bilde die Vereinigung (union) beider Sets, also alle Freunde.
    Set<String> allFriends = new TreeSet<>(myFriends);
    allFriends.addAll(hisFriends);
    System.out.println(allFriends);

    // Welche Freunde habe ich, die nicht Freunde der anderen Person sind?
    // Mit anderen Worten: Bilde die Differenz (difference) zweier Mengen.
    Set<String> onlyMyFriends = new TreeSet<>(myFriends);
    onlyMyFriends.removeAll(hisFriends);
    System.out.println(onlyMyFriends);

    // Ermittle alle Freunde, die wir nicht gemeinsam haben.
    // Mit anderen Worten: Bilde die symmetrische Differenz (symmetric difference) zweier Sets.
    // Symmetrische Differenz von A und B = union(A,B) - intersection(A,B)
    Set<String> nonCommonFriends = new TreeSet<>(allFriends);
    nonCommonFriends.removeAll(commonFriends);
    System.out.println(nonCommonFriends);
  }

  public static void keepElementsSortedWithTreeSet() {
    Employee e = new Employee("bla", "bla", false);
    Set<Employee> employees = new TreeSet<>();
    employees.add(new Employee("Max", "M01", false));
    employees.add(new Employee("Alice", "A00", false));
    employees.add(new Employee("Charlie", "C00", false));
    System.out.println("Mitarbeiter: " + employees);

    // Erstelle eine TreeSet, die ihre Elemente mit einer benutzerdefinierten Vergleichsfunktion sortiert.
    // Hier legen wir fest, dass ExamResult-Objekte aufsteigend nach Score zu sortieren sind.
    // HINWEIS: Im Gegensatz zu anderen Set-Implementierungen, die Elemente per equals vergleichen, verwendet
    // eine TreeSet ausschließlich die compareTo Methode! Im folgenden Beispiel heißt das: wenn zwei ExamResult-Objekte
    // dieselbe Punktzahl haben, dann wird nur eines der beiden ExamResults zur TreeSet hinzugefügt.
    Set<ExamResult> results = new TreeSet<>((first, second) -> (int) (first.score() - second.score()));
    results.add(new ExamResult("1Z0-811", 50.5));
    results.add(new ExamResult("1Z0-817", 20.5));
    results.add(new ExamResult("AZ-100", 75.0));
    results.add(new ExamResult("MD-102", 66.5));
    results.add(new ExamResult("MD-102", 75.0)); // wird nicht hinzugefügt, da AZ-100 mit 75.0 Punkten existiert!

    System.out.println(results);

    var r1 = new ExamResult("MD-102", 66.5);
    var r2 = new ExamResult("MD-102", 66.5);
    var r3 = new ExamResult("AZ-100", 66.5);
    System.out.println(r2.equals(r3)); // FALSE
    System.out.println(r1.equals(r2)); // TRUE
  }


}

// Die Klasse Employee ist ein benutzerdefinierter Datentyp.
// Um eine natürliche Ordnung (<,>,==) zu definieren, implementiert dieser Datentyp
// die Schnittstelle Comparable.
record Employee(String name, String id, boolean isLeader) implements Comparable<Employee> {

  // Vergleiche dieses Objekt mit einem anderen Objekt o.
  @Override
  public int compareTo(Employee o) {
    // Employees werden standardmäßig nach ID verglichen.
    return this.id().compareTo(o.id());
  }
}

// Ein benutzerdefinierter Datentyp, der keine natürliche Ordnung hat, also
// standardmäßig nicht verglichen werden kann.
record ExamResult(String examId, double score) {

}
