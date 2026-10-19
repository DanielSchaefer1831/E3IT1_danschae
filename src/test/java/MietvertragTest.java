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
}
