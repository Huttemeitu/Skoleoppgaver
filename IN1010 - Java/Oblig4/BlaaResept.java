public class BlaaResept extends Resept {

    protected Legemiddel legemiddel; 
    
    public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
        super(legemiddel, utskrivendeLege, pasient, reit);

        
    }

    public String farge() {
        return "Blaa";
    }

    @Override
    public int prisAaBetale() {
        return legemiddelet.hentPris()/4;
    }

}
