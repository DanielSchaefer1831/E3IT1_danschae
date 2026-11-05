import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MietvertragTest
{
    // Vorgegebener Test aus Sprint 1
    // Sprint 4: Fahrrad statt Fahrzeug (Fahrzeug ist abstrakt), gesamtpreis() statt mietpreis()
    @Test
    void mietpreisBerechnen()
    {
        Kunde kunde = new Kunde("Mina Beispiel", 123);
        Fahrrad fahrrad = new Fahrrad("AB-CD 123", 30.00, true, 21);

        Mietvertrag mietvertrag = new Mietvertrag(1001, kunde, fahrrad, 3);

        assertEquals(90.00, mietvertrag.gesamtpreis(), 0.001);
    }

    // Eigener Test aus Sprint 1: eine Woche mit krummem Tagespreis
    @Test
    void mietpreisFuerEineWoche()
    {
        Kunde kunde = new Kunde("Daniel Schäfer", 456);
        Fahrrad fahrrad = new Fahrrad("SHA-DS 2026", 45.50, true, 21);

        Mietvertrag mietvertrag = new Mietvertrag(1002, kunde, fahrrad, 7);

        assertEquals(318.50, mietvertrag.gesamtpreis(), 0.001);
    }

    // Vorgegebener Test aus Sprint 2
    @Test
    void fahrzeugstatusWirdKontrolliertGeaendert()
    {
        Kunde kunde = new Kunde("Mina Beispiel", 123);
        Fahrrad fahrrad = new Fahrrad("AB-CD 123", 30.00, true, 21);
        Mietvertrag mietvertrag = new Mietvertrag(1001, kunde, fahrrad, 3);

        assertTrue(fahrrad.istVerfuegbar());
        assertEquals(90.00, mietvertrag.gesamtpreis(), 0.001);

        mietvertrag.starten();
        assertFalse(fahrrad.istVerfuegbar());

        mietvertrag.beenden();
        assertTrue(fahrrad.istVerfuegbar());
    }

    // Eigener Test aus Sprint 2: Ein vermietetes Fahrzeug kann nicht nochmal vermietet werden
    @Test
    void fahrzeugKannNichtDoppeltVermietetWerden()
    {
        Kunde mina = new Kunde("Mina Beispiel", 123);
        Kunde daniel = new Kunde("Daniel Schäfer", 456);
        Fahrrad fahrrad = new Fahrrad("AB-CD 123", 30.00, true, 21);

        Mietvertrag ersterVertrag = new Mietvertrag(1001, mina, fahrrad, 3);
        Mietvertrag zweiterVertrag = new Mietvertrag(1002, daniel, fahrrad, 2);

        ersterVertrag.starten();

        assertThrows(IllegalStateException.class, () -> zweiterVertrag.starten());
        assertFalse(fahrrad.istVerfuegbar());
    }

    // Vorgegebener Test aus Sprint 3
    // Sprint 4: E-Bike kostet jetzt 5 € Akku-Servicepauschale pro Tag mehr → 105 € statt 90 €
    @Test
    void unterschiedlicheFahrzeugarten()
    {
        Kunde kunde = new Kunde("Mina Beispiel", 123);

        Fahrrad fahrrad = new Fahrrad("F-100", 15.00, true, 21);
        EBike eBike = new EBike("E-200", 30.00, true, 500);

        Mietvertrag mietvertragFahrrad = new Mietvertrag(1001, kunde, fahrrad, 3);
        Mietvertrag mietvertragEBike = new Mietvertrag(1002, kunde, eBike, 3);

        assertEquals(15.00, fahrrad.getTagespreis(), 0.001);
        assertEquals(21, fahrrad.getAnzahlGaenge());
        assertEquals(45.00, mietvertragFahrrad.gesamtpreis(), 0.001);

        assertEquals(30.00, eBike.getTagespreis(), 0.001);
        assertEquals(500, eBike.getAkkukapazitaet());
        assertEquals(105.00, mietvertragEBike.gesamtpreis(), 0.001);
    }

    // Eigener Test aus Sprint 3: Starten und Beenden funktionieren auch beim E-Bike
    // Sprint 4: (30 € + 5 €) × 2 Tage = 70 € statt 60 €
    @Test
    void eBikeKannVermietetUndZurueckgegebenWerden()
    {
        Kunde kunde = new Kunde("Daniel Schäfer", 456);
        EBike eBike = new EBike("E-200", 30.00, true, 500);
        Mietvertrag mietvertrag = new Mietvertrag(1003, kunde, eBike, 2);

        assertTrue(eBike.istVerfuegbar());

        mietvertrag.starten();
        assertFalse(eBike.istVerfuegbar());

        mietvertrag.beenden();
        assertTrue(eBike.istVerfuegbar());

        assertEquals(70.00, mietvertrag.gesamtpreis(), 0.001);
    }

    // Vorgegebener Test aus Sprint 4: Fahrzeuge berechnen ihren Mietpreis unterschiedlich
    @Test
    void fahrzeugeBerechnenUnterschiedlicheMietpreise()
    {
        Kunde kunde = new Kunde("Mina Beispiel", 123);

        Fahrrad fahrrad = new Fahrrad("F-100", 15.00, true, 21);
        EBike eBike = new EBike("E-200", 30.00, true, 500);

        Mietvertrag mietvertrag = new Mietvertrag(1001, kunde, fahrrad, 3);
        mietvertrag.hinzufuegenFahrzeug(eBike);

        assertEquals(150.00, mietvertrag.gesamtpreis(), 0.001);
    }

    // Eigener Test Sprint 4: Ist ein Fahrzeug schon vermietet, wird kein Fahrzeug des Vertrags vermietet
    @Test
    void vertragMitVermietetemFahrzeugStartetNicht()
    {
        Kunde mina = new Kunde("Mina Beispiel", 123);
        Kunde daniel = new Kunde("Daniel Schäfer", 456);

        Fahrrad fahrrad = new Fahrrad("F-100", 15.00, true, 21);
        EBike eBike = new EBike("E-200", 30.00, true, 500);

        Mietvertrag vertragMina = new Mietvertrag(1001, mina, fahrrad, 1);
        vertragMina.starten();

        Mietvertrag vertragDaniel = new Mietvertrag(1002, daniel, eBike, 2);
        vertragDaniel.hinzufuegenFahrzeug(fahrrad);

        assertThrows(IllegalStateException.class, () -> vertragDaniel.starten());
        assertTrue(eBike.istVerfuegbar());
        assertEquals(2, vertragDaniel.getFahrzeuge().size());
        assertEquals(100.00, vertragDaniel.gesamtpreis(), 0.001);
    }
}