public class Vanedannende extends Legemiddel {

    protected int styrke;

    public Vanedannende(String navn, int pris, double virkestoff, int styrke) {
        super(navn, pris, virkestoff);
        this.styrke = styrke; 
    }

    public int hentVanedannendeStyrke() {
        return styrke; 
    }
    
    @Override
    public String toString() {
        return "Navn: " + navn + "\nPris: " + pris + "\nVirkestoff: " + virkestoff + "\nStyrke: " + styrke;
    }
}
