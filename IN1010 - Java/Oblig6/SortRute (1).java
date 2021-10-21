import java.util.ArrayList;
class SortRute extends Rute{

    public SortRute(Labyrint lab, int rad, int kolonne) {
        super(lab, rad, kolonne);
    }

    public char tilTegn() {
        return '#';
    }

    boolean hvit() {
        return false; 
    }

    boolean aapen() {
        return false;
    }


    public void gaa(String vei, Rute forrige, boolean lagVei, ArrayList<Tuppel> forelopig) {
        nySti = new ArrayList<>(forelopig);
        nySti.add(new Tuppel(rad, kolonne));
    }
}
