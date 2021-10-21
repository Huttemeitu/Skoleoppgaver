import java.util.ArrayList;
class HvitRute extends Rute {

    public HvitRute(Labyrint lab, int rad, int kolonne) {
        super(lab, rad, kolonne);
    }

    public char tilTegn() {
        return '.';
    }

    boolean hvit() {
        return true;
    }

    boolean aapen() {
        return false;
    }


    public void gaa(String vei, Rute forrige, boolean lagVei, ArrayList<Tuppel> forelopig) {
        
        nySti = new ArrayList<>(forelopig);
        Rute siste = forrige;
        nySti.add(new Tuppel(rad, kolonne));
        
        if(nySti.size() > 1) {
            Tuppel forri = nySti.get(nySti.size() - 2);
            for(Rute r : naboListe){
                if(r != siste) {
                    r.gaa("", this, lagVei, nySti);
                    //System.out.println(nySti);
                    
                }
            }
        }
        else {
            for(Rute r : naboListe) {
                r.gaa("", this, lagVei, nySti);
                //System.out.println(nySti);
            }
            
        }
    }
}
