public class Fahrrad extends Fahrzeug
{
    private int anzahlGaenge;

    public Fahrrad(String kennzeichen, double tagespreis, boolean verfuegbar, int anzahlGaenge)
    {
        super(kennzeichen, tagespreis, verfuegbar);
        this.anzahlGaenge = anzahlGaenge;
    }

    // Fahrrad: Tagespreis × Mietdauer
    @Override
    public double mietpreis(int mietdauer)
    {
        return getTagespreis() * mietdauer;
    }

    public int getAnzahlGaenge() { return anzahlGaenge; }
}