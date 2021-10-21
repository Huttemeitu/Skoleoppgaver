public class Lege implements Comparable<Lege>{

    protected String navn; 
    protected Lenkeliste<Resept> utskrevedeResepter = new Lenkeliste<Resept>();

    public Lege(String navn) {
        this.navn = navn;
    }

    public String hentNavn() {
        return navn; 
    }

    @Override
    public String toString() {
        return navn; 
    } 
    
    @Override 
    public int compareTo(Lege lege) {
        if(lege.navn.compareTo(this.navn) < 0) {
            return 1;
        }
        else if(lege.navn.compareTo(this.navn) > 0) {
            return -1;
        }
        else {
            return 0;
        }
    }
    public Lege sorterLeger(Lege lege) {
        if(lege.compareTo(this) < 0) { 
            return this;
        }
        else {
            return lege;
        }
    }

    public void hentResepter() {
        for(Resept r : utskrevedeResepter) {
            System.out.println(r);
        }
    }
    // Hvit
    public Resept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        if(legemiddel instanceof Narkotisk && this instanceof Spesialist == false) {
            throw new UlovligUtskrift(this, legemiddel);
        }
        else{
            HvitResept nyResept = new HvitResept(legemiddel, this, pasient, reit);
            utskrevedeResepter.leggTil(nyResept);
            return nyResept;
        }
    }
    // Millitaer
    public Resept skrivMillitaerResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk && this instanceof Spesialist == false) {
            throw new UlovligUtskrift(this, legemiddel);
        } else {
            MilitaerResept nyResept = new MilitaerResept(legemiddel, this, pasient, reit);
            utskrevedeResepter.leggTil(nyResept);
            return nyResept;
        }
    }
    // PResept
    public Resept skrivPResept(Legemiddel legemiddel, Pasient pasient) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk && this instanceof Spesialist == false) {
            throw new UlovligUtskrift(this, legemiddel);
        } else {
            PResepter nyResept = new PResepter(legemiddel, this, pasient);
            utskrevedeResepter.leggTil(nyResept);
            return nyResept;
        }
    }
    // Blaa 
    public Resept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk && this instanceof Spesialist == false) {
            throw new UlovligUtskrift(this, legemiddel);
        } else {
            BlaaResept nyResept = new BlaaResept(legemiddel, this, pasient, reit);
            utskrevedeResepter.leggTil(nyResept);
            return nyResept;
        }
    }
}
