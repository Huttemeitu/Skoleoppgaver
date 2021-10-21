public class MilitaerResept extends HvitResept{

    MilitaerResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    public int prisAaBetale() {
        return 0;
    }


}

