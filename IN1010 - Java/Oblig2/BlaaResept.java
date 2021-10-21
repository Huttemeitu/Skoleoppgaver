public class BlaaResept extends Resept {

    protected Legemiddel legemiddel; 
    
    BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        super(legemiddel, utskrivendeLege, pasientId, reit);

        this.legemiddel = legemiddel;
    }

    public String farge() {
        return "Blaa";
    }

    public int prisAaBetale() {
        return legemiddel.hentPris()/4;
    }

}
