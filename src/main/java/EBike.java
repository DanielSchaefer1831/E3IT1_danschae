public class EBike extends Fahrzeug
{
    private static final double AKKU_SERVICEPAUSCHALE = 5.00;   // pro Miettag

    private int akkukapazitaet;   // in Wattstunden (Wh)

    public EBike(String kennzeichen, double tagespreis, boolean verfuegbar, int akkukapazitaet)
    {
        super(kennzeichen, tagespreis, verfuegbar);
        this.akkukapazitaet = akkukapazitaet;
    }

    // E-Bike: (Tagespreis + 5 € Akku-Servicepauschale) × Mietdauer
    @Override
    public double mietpreis(int mietdauer)
    {
        return (getTagespreis() + AKKU_SERVICEPAUSCHALE) * mietdauer;
    }

    public int getAkkukapazitaet() { return akkukapazitaet; }
}