abstract class Legemiddel {

    protected String navn;
    protected int pris;
    protected double virkestoff;
    protected static int teller = 1; 
    protected int id;

    public Legemiddel(String navn, int pris, double virkestoff) {
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff; 
        id = teller;
        teller++;  
    }

    public int hentId() {
        return id; 
    }

    public String hentNavn() {
        return navn; 
    }

    public int hentPris() {
        return pris; 
    }

    public double hentVirkestoff() {
        return virkestoff; 
    }

    public void settNyPris(int nok) {
        pris = nok; 
    }
    
    @Override
    public String toString() {
        return "Navn: " + navn + "\nPris: " + pris + "\nVirkestoff: " + virkestoff;
    }

    
}