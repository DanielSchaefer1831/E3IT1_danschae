import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MietvertragTest 
{
    // Vorgegebener Test aus Sprint 1
    @Test
    void mietpreisBerechnen()
    {
        Kunde kunde = new Kunde("Mina Beispiel", 123);
        Fahrzeug fahrzeug = new Fahrzeug("AB-CD 123", 30.00, true);

        Mietvertrag mietvertrag = new Mietvertrag(1001, kunde, fahrzeug, 3);

        assertEquals(90.00, mietvertrag.mietpreis(), 0.001);
    }

    // Eigener Test aus Sprint 1: eine Woche mit krummem Tagespreis
    @Test
    void mietpreisFuerEineWoche()
    {
        Kunde kunde = new Kunde("Daniel Schäfer", 456);
        Fahrzeug fahrzeug = new Fahrzeug("SHA-DS 2026", 45.50, true);

        Mietvertrag mietvertrag = new Mietvertrag(1002, kunde, fahrzeug, 7);

        assertEquals(318.50, mietvertrag.mietpreis(), 0.001);
    }

    // Vorgegebener Test aus Sprint 2
    @Test
    void fahrzeugstatusWirdKontrolliertGeaendert()
    {
        Kunde kunde = new Kunde("Mina Beispiel", 123);
        Fahrzeug fahrzeug = new Fahrzeug("AB-CD 123", 30.00, true);
        Mietvertrag mietvertrag = new Mietvertrag(1001, kunde, fahrzeug, 3);

        assertTrue(fahrzeug.istVerfuegbar());
        assertEquals(90.00, mietvertrag.mietpreis(), 0.001);

        mietvertrag.starten();
        assertFalse(fahrzeug.istVerfuegbar());

        mietvertrag.beenden();
        assertTrue(fahrzeug.istVerfuegbar());
    }

    // Eigener Test aus Sprint 2: Ein vermietetes Fahrzeug kann nicht nochmal vermietet werden
    @Test
    void fahrzeugKannNichtDoppeltVermietetWerden()
    {
        Kunde mina = new Kunde("Mina Beispiel", 123);
        Kunde daniel = new Kunde("Daniel Schäfer", 456);
        Fahrzeug fahrzeug = new Fahrzeug("AB-CD 123", 30.00, true);

        Mietvertrag ersterVertrag = new Mietvertrag(1001, mina, fahrzeug, 3);
        Mietvertrag zweiterVertrag = new Mietvertrag(1002, daniel, fahrzeug, 2);

        ersterVertrag.starten();

        assertThrows(IllegalStateException.class, () -> zweiterVertrag.starten());
        assertFalse(fahrzeug.istVerfuegbar());
    }

    // Vorgegebener Test aus Sprint 3
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
        assertEquals(45.00, mietvertragFahrrad.mietpreis(), 0.001);

        assertEquals(30.00, eBike.getTagespreis(), 0.001);
        assertEquals(500, eBike.getAkkukapazitaet());
        assertEquals(90.00, mietvertragEBike.mietpreis(), 0.001);
    }

    // Eigener Test aus Sprint 3: Starten und Beenden funktionieren auch beim E-Bike
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

        assertEquals(60.00, mietvertrag.mietpreis(), 0.001);
    }
}