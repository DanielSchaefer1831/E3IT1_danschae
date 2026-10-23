public class EBike extends Fahrzeug 
{
    private int akkukapazitaet;   // in Wattstunden (Wh)

    public EBike(String kennzeichen, double tagespreis, boolean verfuegbar, int akkukapazitaet) {
        super(kennzeichen, tagespreis, verfuegbar);
        this.akkukapazitaet = akkukapazitaet;
    }

    public int getAkkukapazitaet() { return akkukapazitaet; }
}
