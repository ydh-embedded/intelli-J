package pListExcamples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class cListExamples {
  public static void main(String[] args) {
    mAddAndRemoveElements();
    mProcessElements();
    mSortElements();
    mSearchElements();


  }

  public static void mAddAndRemoveElements() {
    // Erzeuge eine Instanz des Datentyps ArrayList<String>.
    // Wir weisen diese Instanz der Variable names zu.
    // Der Datentyp von names ist jedoch nicht ArrayList, sondern
    // List<String>.
    List<String> names = new ArrayList<>();
    names.add("alice");
    names.addFirst("bob");
    names.addLast("charlie");
    System.out.printf("Names: %s\n", names);
    names.add(1, "damian");
    System.out.printf("Names: %s\n", names);
    names.add(0, "elon");
    System.out.printf("Names: %s\n", names);
    // Ergebnis: [elon, bob, damian, alice, charlie]
    names.removeFirst(); // Entferne elon
    names.removeLast(); // Entferne charlie
    System.out.printf("Names: %s\n", names);
    // Ergebnis: [bob, damian, alice]
    names.remove(1); // Entferne damian
    System.out.printf("Names: %s\n", names);
    // Ergebnis: [bob, alice]
    names.addFirst("anton");
    names.addLast("anton");
    names.add(1, "anton");
    System.out.printf("Names: %s\n", names);
    // Ergebnis: [anton, anton, bob, alice, anton]
    names.remove("anton"); // Entferne erstes Element mit Wert "anton"
    System.out.printf("Names: %s\n", names);
    // Ergebnis: [anton, bob, alice, anton]
    // Entferne alle Elemente, deren erster Buchstabe ein a ist.
    names.removeIf(n -> !n.isEmpty() && n.charAt(0) == 'a');
    System.out.printf("Names: %s\n", names);
    // Ergebnis: [bob]
    // SubList's sind dazu geeignet, Teilbereiche einer Liste zu entfernen,
    // zu ersetzen oder Elemente einzufügen.
    List<String> range = names.subList(0, 0);
    range.add("alice");
    range.add("charlie");
    range.add("damian");
    System.out.printf("Names: %s\n", names);
    // Ergebnis: [alice, charlie, damian, bob]
    range = names.subList(1, 3); // [charlie, damian]
    range.clear(); // Entferne alle Elemente in Subliste.
    System.out.printf("Names: %s\n", names);
    // Ergebnis: [alice, bob]
    range.add("charlie");
    System.out.printf("Names: %s\n", names);
  }

  public static void mProcessElements() {
    // Jede Collection lässt sich mit der foreach Schleife abarbeiten
    // wir erstellen eine Liste von Integer. Um mehrere Elemente
    // anzugeben, benötigen wir eine temporäre Collection, die sich mit List.of
    // bilden lässt.
    List<Integer> primes = new ArrayList<>(List.of(2, 3, 5, 7, 11, 13));
    for (int i : primes) {
      System.out.printf("%02d ", i);
    }
    System.out.println();
    // Eine andere Möglichkeit, um durch die Elemente zu navigieren, ist ein Iterator.
    Iterator<Integer> iterator = primes.iterator();
    while (iterator.hasNext()) {
      int i = iterator.next();
      System.out.printf("%02d ", i);
    }
    System.out.println();

    iterator = primes.iterator();
    while (iterator.hasNext()) {
      int p = iterator.next();
      if (p > 5) {
        iterator.remove();
      }
    }
    System.out.printf("Ergebnis nach Filter %s: ", primes);



    System.out.println();
    // Liste leeren und dann mit neuen Elementen befüllen.
    primes.clear();
    primes.addAll(List.of(2, 3, 5, 7, 11, 13));
    // Einen Teilbereich der Liste ausgeben. [3,5,7]
    for (int p : primes.subList(1, 4)) {
      System.out.printf("%02d ", p);
    }
    System.out.println();
  }

  public static void mSortElements() {
    List<String> names = new ArrayList<>(List.of("bob", "alice", "Charlie", "elon", "anton"));
//    names.sort((first, second) -> first.compareToIgnoreCase(second));
    names.sort(String::compareToIgnoreCase);
    System.out.println("Sortierte Namensliste: " + names);
//    names.sort((first, second) -> first.length() - second.length());
    names.sort(Comparator.comparingInt(String::length));
    System.out.println("Sortierte Namensliste nach Namenslänge: " + names);

      List<Entry> originalData = new ArrayList<>(List.of(
            new Entry("Anton", "Müller", 20),
            new Entry("Max", "Müller", 10),
            new Entry("Max", "Austermann", 20)
    ));
//    entries.addAll(originalData);
      List<Entry> entries = new ArrayList<>(originalData);
    System.out.println(entries);
    // Sortiere die Entries nach Punktzahl absteigend. Falls zwei Entries dieselbe Punktzahl haben,
    // sortiere nach Namen aufsteigend.
    entries.sort((first, second) -> {
      int scoreDiff = second.score() - first.score();
      // Wenn sich die Punktezahlen unterscheiden, steht die Sortierreihenfolge schon fest.
      if (scoreDiff != 0) return scoreDiff;
      // Falls die Punktezahlen gleich sind, muss nach Name aufsteigend sortiert werden.
      return first.lastName().compareToIgnoreCase(second.lastName());
    });
    // Die obige Lambda-Funktion kann man auch in eine benannte Methode auslagern
    // und hier wiederverwenden.
    // entries.sort(ListExamples::compareEntries);
    System.out.println(entries);

    // Kombinieren von Vergleichsfunktionen.
    entries.clear();
    entries.addAll(originalData);
    System.out.println(entries);
    // Wir definieren zwei Vergleichsfunktionen und kombinieren diese anschließend.
//    Comparator<Entry> compareByScore = (f, s) -> f.score() - s.score();
    Comparator<Entry> compareByScore = Comparator.comparingInt(Entry::score);
    Comparator<Entry> compareByLastName = (f, s) -> f.lastName().compareToIgnoreCase(s.lastName());
    // Kombiniere die obigen Vergleichsfunktionen.
    var compareByScoreThenByLastName = compareByScore.reversed().thenComparing(compareByLastName);
    entries.sort(compareByScoreThenByLastName);
    System.out.println(entries);

  }

  public static void mSearchElements() {
    List<Entry> allEntries = generateTestEntries();
    List<Entry> searchResults = new ArrayList<>();
    // Finde alle Einträge, deren Punktzahl >= 10 ist.
    for (Entry e : allEntries) {
      if (e.score() >= 10) {
        searchResults.add(e);
      }
    }
    System.out.println(searchResults);

    // Finde alle Entries, deren Punktzahl >= 10 ist _und_ deren Vorname aus maximal 4
    // Zeichen besteht.
    searchResults.clear();
    for (Entry e : allEntries) {
      if (e.score() >= 10 && e.firstName().length() <= 4) {
        searchResults.add(e);
      }
    }
    System.out.println(searchResults);

    // Wir suchen Elemente unter Verwendung von kombinierten Prädikaten.
    // Ein Prädikat kann man sich wie eine Testfunktion vorstellen: Sie prüft, ob ein
    // Wert ein Kriterium erfüllt oder nicht.
    Predicate<Entry> scoreIsAtLeast10 = entry -> entry.score() >= 10;
    Predicate<Entry> firstNameIsShorterThan5 = entry -> entry.firstName().length() < 5;
    var combined = scoreIsAtLeast10.and(firstNameIsShorterThan5);
//    Predicate<Entry> combined2 = scoreIsAtLeast10.and(e -> firstNameIsShorterThanN(5, e));

      searchResults.clear();
    for (Entry e : allEntries) {
      // Wenn das zusammengesetzte Prädikat zutrifft, füge Element e
      // in Suchergebnisliste hinzu.
      if (combined.test(e)) {
        searchResults.add(e);
      }
    }

  }

  private static boolean mScoreIsAtLeast10(Entry entry) {
    return entry.score() >= 10;
  }

  private static boolean mFirstNameIsShorterThanN(int n, Entry entry) {
    return entry.firstName().length() < n;
  }

  private static int mCompareEntries(Entry first, Entry second) {
    int scoreDiff = second.score() - first.score();
    // Wenn sich die Punktezahlen unterscheiden, steht die Sortierreihenfolge schon fest.
    if (scoreDiff != 0) return scoreDiff;
    // Falls die Punktezahlen gleich sind, muss nach Name aufsteigend sortiert werden.
    return first.lastName().compareToIgnoreCase(second.lastName());
  }

  private static List<Entry> generateTestEntries() {
    return new ArrayList<>(List.of(
            new Entry("Alice", "Wonderland", 5),
            new Entry("Bob", "Ross", 15),
            new Entry("Charlie", "Brown", 7),
            new Entry("Damian", "Rice", 15),
            new Entry("Elon", "Musk", 15),
            new Entry("Fred", "Flintstone", 12)
    ));
  }
}

// Definiere einen neuen Datentyp namens pListExcamples. Entry. Er hat drei
// nicht veränderliche Felder (Properties) firstName, lastName und score.
record Entry(String firstName, String lastName, int score) {
}
