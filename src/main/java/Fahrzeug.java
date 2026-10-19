public class Fahrzeug
{
    private String kennzeichen;
    private double grundpreis;
    private boolean verfuegbar;

    public Fahrzeug(String kennzeichen, double grundpreis, boolean verfuegbar)
    {
        this.kennzeichen = kennzeichen;
        this.grundpreis = grundpreis;
        this.verfuegbar = verfuegbar;
    }

    public String getKennzeichen() { return kennzeichen; }
    public double getGrundpreis() { return grundpreis; }
    public boolean isVerfuegbar() { return verfuegbar; }
}
