public class HvitResept extends Resept {

    protected Legemiddel legemiddel;
    
    HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        super(legemiddel, utskrivendeLege, pasientId, reit);

        this.legemiddel = legemiddel; 
    }

    public String farge() {
        return "Hvit";
    }

    public int prisAaBetale() {
        return legemiddel.hentPris();
    }
}
