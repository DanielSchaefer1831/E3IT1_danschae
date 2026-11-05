import java.util.ArrayList;
import java.util.List;

public class Mietvertrag
{
    private int vertragsnummer;
    private Kunde kunde;
    private List<Fahrzeug> fahrzeuge;   // Liste statt nur ein Fahrzeug
    private int mietdauer;              // Mietdauer in Tagen

    public Mietvertrag(int vertragsnummer, Kunde kunde, Fahrzeug fahrzeug, int mietdauer)
    {
        this.vertragsnummer = vertragsnummer;
        this.kunde = kunde;
        this.mietdauer = mietdauer;
        this.fahrzeuge = new ArrayList<>();   // leere Liste anlegen
        this.fahrzeuge.add(fahrzeug);         // erstes Fahrzeug hineinlegen
    }

    // weiteres Fahrzeug zum Vertrag hinzufügen
    public void hinzufuegenFahrzeug(Fahrzeug fahrzeug)
    {
        fahrzeuge.add(fahrzeug);
    }

    // Summe der Mietpreise aller Fahrzeuge (ersetzt mietpreis())
    public double gesamtpreis()
    {
        double summe = 0;
        for (Fahrzeug fahrzeug : fahrzeuge)
        {
            summe += fahrzeug.mietpreis(mietdauer);
        }
        return summe;
    }

    // Alle Fahrzeuge vermieten, aber nur, wenn wirklich alle verfügbar sind
    public void starten()
    {
        for (Fahrzeug fahrzeug : fahrzeuge)
        {
            if (!fahrzeug.istVerfuegbar())
            {
                throw new IllegalStateException("Fahrzeug " + fahrzeug.getKennzeichen() + " ist bereits vermietet.");
            }
        }
        for (Fahrzeug fahrzeug : fahrzeuge)
        {
            fahrzeug.vermieten();
        }
    }

    // Alle Fahrzeuge zurückgeben
    public void beenden()
    {
        for (Fahrzeug fahrzeug : fahrzeuge)
        {
            fahrzeug.zurueckgeben();
        }
    }

    public int getVertragsnummer() { return vertragsnummer; }
    public Kunde getKunde() { return kunde; }
    public int getMietdauer() { return mietdauer; }

    // Kopie der Liste, damit niemand von außen Fahrzeuge einschmuggeln kann
    public List<Fahrzeug> getFahrzeuge() { return List.copyOf(fahrzeuge); }
}