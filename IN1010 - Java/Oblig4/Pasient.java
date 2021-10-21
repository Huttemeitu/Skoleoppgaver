
public class Pasient {
    protected String navn;
    protected String fNummer;

    protected Stabel<Resept> resepter = new Stabel<Resept>();
    
    private static int teller = 0;
    protected int id;
    
    public Pasient(String navn, String fNum) {
        this.navn = navn;
        fNummer = fNum;
        id = teller;
        teller++;
    }

    public void hentResepter() {
        for(Resept r : resepter) {
            System.out.println(r.toString());
        }
    }

    public void leggTil(Resept resept) {
        resepter.leggPaa(resept);
    }
    
    public int hentId() {
        return id;
    }

    @Override
    public String toString() {
        return "Navn: " + navn + "\nFoedselsnummer: " + fNummer;
    }
}
