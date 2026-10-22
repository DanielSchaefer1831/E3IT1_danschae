import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MietvertragTest
{

    //Vorgegebener Test aus Sprint 1
    @Test
    void mietpreisBerechnen()
    {
        Kunde kunde = new Kunde("Mina Beispiel", 123);
        Fahrzeug fahrzeug = new Fahrzeug("AB-CD 123", 30.00, true);

        Mietvertrag mietvertrag = new Mietvertrag(1001, kunde, fahrzeug, 3);

        assertEquals(90.00, mietvertrag.mietpreis(), 0.001);
    }

    //Eigener Test aus Sprint 1: eine Woche mit krummem Tagespreis
    @Test
    void mietpreisFuerEineWoche()
    {
        Kunde kunde = new Kunde("Daniel Schäfer", 456);
        Fahrzeug fahrzeug = new Fahrzeug("SHA-DS 2026", 45.50, true);

        Mietvertrag mietvertrag = new Mietvertrag(1002, kunde, fahrzeug, 7);

        assertEquals(318.50, mietvertrag.mietpreis(), 0.001);
    }

    //Vorgegebener Test aus Sprint 2
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

    //Eigener Test aus Sprint 2: Ein vermietetes Fahrzeug kann nicht nochmal vermietet werden
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
}