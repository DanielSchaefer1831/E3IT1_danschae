public class Kunde
{
    private String name;
    private int kundennummer;

    public Kunde(String name, int kundennummer)
    {
        this.name = name;
        this.kundennummer = kundennummer;
    }

    public String getName() { return name; }
    public int getKundennummer() { return kundennummer; }
}
