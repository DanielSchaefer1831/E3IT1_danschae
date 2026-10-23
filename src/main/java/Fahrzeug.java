public class Fahrzeug
{
    private String kennzeichen;
    private double tagespreis;   // umbenannt (vorher grundpreis)
    private boolean verfuegbar;

    public Fahrzeug(String kennzeichen, double tagespreis, boolean verfuegbar)
    {
        this.kennzeichen = kennzeichen;
        this.tagespreis = tagespreis;
        this.verfuegbar = verfuegbar;
    }

    // Fahrzeug als vermietet kennzeichnen
    public void vermieten()
    {
        if (!verfuegbar)
        {
            throw new IllegalStateException("Fahrzeug " + kennzeichen + " ist bereits vermietet.");
        }
        verfuegbar = false;
    }

    // Fahrzeug wieder als verfügbar kennzeichnen
    public void zurueckgeben()
    {
        verfuegbar = true;
    }

    public String getKennzeichen() { return kennzeichen; }
    public double getTagespreis() { return tagespreis; }   // umbenannt (vorher getGrundpreis)
    public boolean istVerfuegbar() { return verfuegbar; }
}