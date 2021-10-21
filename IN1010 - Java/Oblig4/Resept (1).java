public abstract class Resept {

    protected static int teller = 0;
    protected int id;
    protected Legemiddel legemiddelet;
    protected Lege legen;
    protected int pasientId;
    protected int reit; 
    protected Pasient pasient;

    public Resept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
        legemiddelet = legemiddel; 
        legen = utskrivendeLege;
        this.pasient = pasient; 
        this.reit = reit; 
        id = teller; 
        teller++; 
    }

    public int hentId() {
        return id; 
    }

    public Legemiddel hentLegemiddel() {
        return legemiddelet; 
    }

    public Lege hentLege() {
        return legen; 
    }

    public int hentPasientId() {
        return pasientId; 
    }

    public int hentReit() {
        return reit;
    }

    public boolean bruk() {
        if (reit > 0) {
            reit = reit - 1;
            return true; 
        }
        return false; 
    }

    abstract public String farge();

    abstract public int prisAaBetale();

    @Override
    public String toString() {
        return "Legemiddel: " + legemiddelet.hentNavn() + "\nUtskrevet av: " + legen.hentNavn() + "\nPasientID: " + pasientId + "\nReit: " + reit;
    }  
    
}
