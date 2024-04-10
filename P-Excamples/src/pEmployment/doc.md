# List

## Methode: Compute

Hier ist eine Aufschlüsselung der compute Methodenaufruf:

vNamesByChar.compute('a' , (key, value) -> { value.addLast("test"); return value; });

```vNamesByChar```
Die Karte, auf der die compute Methode wird aufgerufen.

```compute```
Die Methode, die auf der Karte aufgerufen wird.

```'a'```
Der Schlüssel, für den die Berechnung durchgeführt wird.

```(key, value) -> { value.addLast("test"); return value; }```

Die Lambda-Funktion, die die Berechnung durchführt. Das key Parameter wird in diesem Fall nicht verwendet, ist jedoch der Vollständigkeit halber enthalten. Das value Parameter ist der aktuelle Wert, der dem Schlüssel zugeordnet ist 'a' in der Karte, die a List<String> enthält die Namen, die mit dem Buchstaben 'a' beginnen'. Die Lambda-Funktion fügt die Zeichenfolge "Test" am Ende der Liste hinzu und gibt dann die aktualisierte Liste zurück.