public class PResepter extends HvitResept{

    public PResepter(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient) {

        super(legemiddel, utskrivendeLege, pasient, 3);
    }
    
    @Override
    public int prisAaBetale() {
        if(legemiddel.hentPris() > 108) {
            return legemiddel.hentPris() - 108;
        }
        return 0;   
    }
}
