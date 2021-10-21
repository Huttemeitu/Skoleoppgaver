import java.util.ArrayList;
class Aapning extends HvitRute{

    public Aapning(Labyrint lab, int rad, int kolonne) {
        super(lab, rad, kolonne);
    }

    
    public void gaa(String vei, Rute forrige, boolean lagVei, ArrayList<Tuppel> forelopig) {    
        nySti = new ArrayList<>(forelopig);
        nySti.add(new Tuppel(this.rad, this.kolonne));
        lab.utveiTuppel.add(nySti);
        
    }

    boolean aapen() {
        return true;
    }
}
