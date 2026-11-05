public abstract class Fahrzeug
{
    private String kennzeichen;
    private double tagespreis;
    private boolean verfuegbar;

    protected Fahrzeug(String kennzeichen, double tagespreis, boolean verfuegbar)
    {
        this.kennzeichen = kennzeichen;
        this.tagespreis = tagespreis;
        this.verfuegbar = verfuegbar;
    }

    // Jede Fahrzeugart muss selbst festlegen, wie sie ihren Preis berechnet
    public abstract double mietpreis(int mietdauer);

    public void vermieten()
    {
        if (!verfuegbar)
        {
            throw new IllegalStateException("Fahrzeug " + kennzeichen + " ist bereits vermietet.");
        }
        verfuegbar = false;
    }

    public void zurueckgeben()
    {
        verfuegbar = true;
    }

    public String getKennzeichen() { return kennzeichen; }
    public double getTagespreis() { return tagespreis; }
    public boolean istVerfuegbar() { return verfuegbar; }
}