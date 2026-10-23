public class Fahrrad extends Fahrzeug
{
    private int anzahlGaenge;

    public Fahrrad(String kennzeichen, double tagespreis, boolean verfuegbar, int anzahlGaenge)
    {
        super(kennzeichen, tagespreis, verfuegbar);
        this.anzahlGaenge = anzahlGaenge;
    }

    public int getAnzahlGaenge() { return anzahlGaenge; }
}
