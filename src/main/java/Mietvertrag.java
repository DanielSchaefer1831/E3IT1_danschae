public class Mietvertrag
{
    private int vertragsnummer;
    private Kunde kunde;        // Pfeil zu Kunde
    private Fahrzeug fahrzeug;  // Pfeil zu Fahrzeug
    private String mietbeginn;
    private String mietende;

    public Mietvertrag(int vertragsnummer, Kunde kunde, Fahrzeug fahrzeug,
                       String mietbeginn, String mietende)
    {
        this.vertragsnummer = vertragsnummer;
        this.kunde = kunde;
        this.fahrzeug = fahrzeug;
        this.mietbeginn = mietbeginn;
        this.mietende = mietende;
    }

    public double mietpreis()
    {
        return 0; // wird in Sprint 1 umgesetzt
    }

    public void beenden()
    {
        // wird später umgesetzt
    }
}
