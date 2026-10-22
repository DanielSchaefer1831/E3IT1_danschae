public class Fahrzeug
{
    private String kennzeichen;
    private double grundpreis;   // Preis pro Tag
    private boolean verfuegbar;

    public Fahrzeug(String kennzeichen, double grundpreis, boolean verfuegbar)
    {
        this.kennzeichen = kennzeichen;
        this.grundpreis = grundpreis;
        this.verfuegbar = verfuegbar;
    }

    //Fahrzeug als vermietet kennzeichnen
    public void vermieten()
    {
        if (!verfuegbar)
        {
            throw new IllegalStateException("Fahrzeug " + kennzeichen + " ist bereits vermietet.");
        }
        verfuegbar = false;
    }

    //Fahrzeug wieder als verfügbar kennzeichnen
    public void zurueckgeben()
    {
        verfuegbar = true;
    }

    public String getKennzeichen() { return kennzeichen; }
    public double getGrundpreis() { return grundpreis; }
    public boolean istVerfuegbar() { return verfuegbar; }  //umbenannt (vorher isVerfuegbar)
}