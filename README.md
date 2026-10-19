# Fahrzeugverleih

Schulprojekt (E3IT1, Projektkompetenz bei Herrn Frank):
Objektorientierte Konsolenanwendung in Java für einen Fahrzeugverleih.

## Aufbau
- `src/main/java/`: Klassen Kunde, Fahrzeug und Mietvertrag
- `src/test/java/`: JUnit-Tests
- `diagramme/`: Klassen- und Objektdiagramme (UMLet, .uxf und .png)

## Entscheidungen
- Sprint 0: Die Attribute sind in Java `private` und werden über Getter
  gelesen (Kapselung), auch wenn sie im Klassendiagramm mit `+` stehen.

## Tests ausführen
In IntelliJ mit Rechtsklick auf `src/test/java` → *Run 'All Tests'*
oder im Terminal: `mvn test`