import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MietvertragTest
{
    // Vorgegebener Test aus Sprint 1
    @Test
    void mietpreisBerechnen() {
        Kunde kunde = new Kunde("Mina Beispiel", 123);
        Fahrzeug fahrzeug = new Fahrzeug("AB-CD 123", 30.00, true);

        Mietvertrag mietvertrag = new Mietvertrag(1001, kunde, fahrzeug, 3);

        assertEquals(90.00, mietvertrag.mietpreis(), 0.001);
    }

    // Eigener Test: eine Woche mit krummem Tagespreis
    @Test
    void mietpreisFuerEineWoche()
    {
        Kunde kunde = new Kunde("Daniel Schäfer", 456);
        Fahrzeug fahrzeug = new Fahrzeug("SHA-DS 2026", 45.50, true);

        Mietvertrag mietvertrag = new Mietvertrag(1002, kunde, fahrzeug, 7);

        assertEquals(318.50, mietvertrag.mietpreis(), 0.001);
    }
}
