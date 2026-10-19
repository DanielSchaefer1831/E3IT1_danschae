public class Mietvertrag
{
    private int vertragsnummer;
    private Kunde kunde;        // Pfeil zu Kunde
    private Fahrzeug fahrzeug;  // Pfeil zu Fahrzeug
    private int mietdauer;      // Mietdauer in Tagen

    public Mietvertrag(int vertragsnummer, Kunde kunde, Fahrzeug fahrzeug, int mietdauer)
    {
        this.vertragsnummer = vertragsnummer;
        this.kunde = kunde;
        this.fahrzeug = fahrzeug;
        this.mietdauer = mietdauer;
    }

    // Preis = Grundpreis pro Tag × Anzahl Tage
    public double mietpreis()
    {
        return fahrzeug.getGrundpreis() * mietdauer;
    }

    public void beenden()
    {
        // wird später noch umgesetzt
    }

    public int getVertragsnummer() { return vertragsnummer; }
    public Kunde getKunde() { return kunde; }
    public Fahrzeug getFahrzeug() { return fahrzeug; }
    public int getMietdauer() { return mietdauer; }
}