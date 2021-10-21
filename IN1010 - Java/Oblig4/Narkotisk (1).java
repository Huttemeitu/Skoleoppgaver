public class Narkotisk extends Legemiddel{
    
    protected int styrke; 

    public Narkotisk(String navn, int pris, double virkestoff, int styrke) { 
        super(navn, pris, virkestoff); 
        this.styrke = styrke;
    }

    public int hentNarkotiskStyrke() {
        return styrke;
    }

    @Override
    public String toString() {
        return "Navn: " + navn + "\nPris: " + pris + "\nVirkestoff: " + virkestoff + "\nStyrke: " + styrke;
    }
    
}
