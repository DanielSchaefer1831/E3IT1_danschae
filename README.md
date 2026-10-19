# Fahrzeugverleih

Schulprojekt (E3IT1, Projektkompetenz bei Herrn Frank):
Objektorientierte Konsolenanwendung in Java für einen Fahrzeugverleih.

## Aufbau
- `src/main/java/`: Klassen Kunde, Fahrzeug und Mietvertrag
- `src/test/java/`: JUnit-Tests
- `diagramme/`: Klassen- und Objektdiagramme (UMLet, .uxf und .png)
- `screenshots/`: Screenshots der Testausführung

## Tests ausführen
In IntelliJ: Rechtsklick auf `MietvertragTest` → *Run 'MietvertragTest'*
oder im Terminal: `mvn test`

## Entscheidungen

### Sprint 0
- Attribute sind in Java `private` und werden über Getter gelesen (Kapselung),
  auch wenn sie im Klassendiagramm mit `+` stehen.

### Sprint 1
- `grundpreis` im Fahrzeug bedeutet den Preis **pro Tag**.
- `mietbeginn` und `mietende` wurden durch `mietdauer` (in Tagen) ersetzt,
  weil der vorgegebene Test nur eine Mietdauer übergibt. Mit beiden Varianten
  gleichzeitig könnten sich die Angaben widersprechen.
- Die Datentypen im Klassendiagramm wurden an Java angepasst
  (`String` statt `str`, `boolean` statt `bool`, `double` statt `float`).
- Der vorgegebene pytest-Test wurde in einen JUnit-5-Test übersetzt,
  weil das Projekt in Java umgesetzt ist. Kommazahlen werden mit einer
  Toleranz von 0.001 verglichen.

## Probleme und Lösungen
- Der Projektordner auf dem Desktop wurde in IntelliJ nicht angezeigt.
  Lösung: Pfad im Explorer kopiert und in IntelliJ eingefügt.
- Die Aufgaben für Sprint 1 standen zuerst nur als Kommentar in einem Issue
  und waren nicht mit dem Board verknüpft. Lösung: Issue dem Board zugeordnet
  und die Aufgaben als Sub-Issues angelegt.
- JUnit wurde in der pom.xml zuerst rot angezeigt.
  Lösung: Maven-Projekt neu geladen (Load Maven Changes).

## Testergebnisse Sprint 1

Vorgegebener Test (Mietpreis 30,00 € × 3 Tage = 90,00 €):

![Vorgegebener Test](screenshots/test_vorgegeben.png)

Eigener Test (Mietpreis 45,50 € × 7 Tage = 318,50 €):

![Eigener Test](screenshots/test_eigener.png)

## Diagramme Sprint 1

Klassendiagramm:

![Klassendiagramm](diagramme/fahrzeugverleih_sprint1.png)

Objektdiagramm zum vorgegebenen Test:

![Objektdiagramm](diagramme/objektdiagramm_sprint1.png)