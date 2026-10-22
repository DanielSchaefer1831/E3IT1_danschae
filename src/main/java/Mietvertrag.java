public class Mietvertrag 
{
    private int vertragsnummer;
    private Kunde kunde;        //Verbindung zu Kunde
    private Fahrzeug fahrzeug;  //Verbindung zu Fahrzeug
    private int mietdauer;      //Mietdauer in Tagen

    public Mietvertrag(int vertragsnummer, Kunde kunde, Fahrzeug fahrzeug, int mietdauer)
    {
        this.vertragsnummer = vertragsnummer;
        this.kunde = kunde;
        this.fahrzeug = fahrzeug;
        this.mietdauer = mietdauer;
    }

    //Preis = Grundpreis pro Tag × Anzahl Tage
    public double mietpreis()
    {
        return fahrzeug.getGrundpreis() * mietdauer;
    }

    //Miete beginnt, Fahrzeug wird als vermietet gekennzeichnet
    public void starten()
    {
        fahrzeug.vermieten();
    }

    //Miete endet, Fahrzeug ist wieder verfügbar
    public void beenden()
    {
        fahrzeug.zurueckgeben();
    }

    public int getVertragsnummer() { return vertragsnummer; }
    public Kunde getKunde() { return kunde; }
    public Fahrzeug getFahrzeug() { return fahrzeug; }
    public int getMietdauer() { return mietdauer; }
}