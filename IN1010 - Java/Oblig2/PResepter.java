public class PResepter extends HvitResept{

    PResepter(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId) {

        super(legemiddel, utskrivendeLege, pasientId, 3);
    }

    public int prisAaBetale() {
        if(legemiddel.hentPris() > 108) {
            return legemiddel.hentPris() - 108;
        }
        return 0;   
    }
}
