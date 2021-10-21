public class HvitResept extends Resept {

    protected Legemiddel legemiddel;
    
    public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
        super(legemiddel, utskrivendeLege, pasient, reit);

     
    }

    public String farge() {
        return "Hvit";
    }

    public int prisAaBetale() {
        return legemiddelet.hentPris();
    }
}
