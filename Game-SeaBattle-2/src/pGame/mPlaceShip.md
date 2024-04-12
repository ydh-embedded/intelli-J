
# Methode

## Dies ist eine statische Methode namens mIsInMap das braucht drei Parameter

### map:    
- Ein boolesches 2D-Array, das nicht null sein darf.
### row:    
- Eine Ganzzahl, die einen Zeilenindex in der map Array.
### column: 
- Eine Ganzzahl, die einen Spaltenindex in der map Array.

Die Methode gibt den booleschen Wert zurück, ob die  angegebenen Werte von row und column Indizes innerhalb der Grenzen des map Arrays liegen.

Hier ist eine schrittweise Aufschlüsselung der Methode:

- Die erste Zeile ```Objects.requireNonNull(map)```; prüft, ob die map Parameter null ist.
- Wenn der Parameter Null ist wird die NullPointerException geworfen.
- Die nächste Zeile ```return row >= 0 && row < map.length && column >= 0 && column < map[row].length;``` ist die Rückgabeerklärung, die bestimmt, ob die angegebene row und column Indizes liegen innerhalb der Grenzen des map Array.
row >= 0 prüft, ob die row Index ist nicht negativ.
row < map.length prüft, ob die row Index ist kleiner als die Anzahl der Zeilen in der map Array.
column >= 0 prüft, ob die column Index ist nicht negativ.
column < map[row].length prüft, ob die column Index ist kleiner als die Anzahl der Spalten in der row der map Array.
Die Rückgabeanweisung wird bewertet an true wenn alle Bedingungen erfüllt sind, was darauf hinweist, dass die gegebenen row und column Indizes liegen innerhalb der Grenzen des map Array. Andernfalls wird es ausgewertet, um false.
Zusammenfassend ist diese Methode eine Dienstprogrammmethode, mit der überprüft wird, ob eine bestimmte Methode vorliegt row und column Der Index liegt innerhalb der Grenzen eines booleschen 2D-Arrays. Es ist nützlich, um zu verhindern ArrayIndexOutOfBoundsException beim Zugriff auf Elemente in einem 2D-Array.