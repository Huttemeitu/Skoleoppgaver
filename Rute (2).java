import java.util.ArrayList;
abstract class Rute {

    int rad, kolonne;
    Labyrint lab;
    Rute naboNord, naboOest, naboVest, naboSoer;
    ArrayList<Rute> naboListe;
    ArrayList<Tuppel> nySti;
    
    public Rute(Labyrint lab, int rad, int kolonne) {
        this.lab = lab;
        this.rad = rad;
        this.kolonne = kolonne; 
        naboListe = new ArrayList<Rute>();
    }

    public void finnNaboer(int posRad, int posKolonne) {
        // Ikke hjørne eller kant
        if(posRad > 0 && posRad < Labyrint.antallRader - 1 && posKolonne > 0 && posKolonne < Labyrint.antallKolonner - 1) {
            naboNord = lab.rutenett.get(posRad-1).get(posKolonne);
            naboOest = lab.rutenett.get(posRad).get(posKolonne+1);
            naboSoer = lab.rutenett.get(posRad+1).get(posKolonne);
            naboVest = lab.rutenett.get(posRad).get(posKolonne-1);
            naboListe.add(naboNord);
            naboListe.add(naboVest);
            naboListe.add(naboOest);
            naboListe.add(naboSoer);
        }
        // nedre kant
        else if(posRad == Labyrint.antallRader - 1 && posKolonne > 0 && posKolonne < Labyrint.antallKolonner - 1) {
            naboNord = lab.rutenett.get(posRad - 1).get(posKolonne);
            naboOest = lab.rutenett.get(posRad).get(posKolonne + 1);
            naboVest = lab.rutenett.get(posRad).get(posKolonne - 1);
            naboListe.add(naboNord);
            naboListe.add(naboVest);
            naboListe.add(naboOest);
        }
        // øvre kant
        else if(posRad == 0 && posKolonne > 0 && posKolonne < Labyrint.antallKolonner - 1) {
            naboOest = lab.rutenett.get(posRad).get(posKolonne + 1);
            naboSoer = lab.rutenett.get(posRad + 1).get(posKolonne);
            naboVest = lab.rutenett.get(posRad).get(posKolonne - 1);
            naboListe.add(naboVest);
            naboListe.add(naboOest);
            naboListe.add(naboSoer);
        }

        // høyre kant
        else if(posRad > 0 && posRad < Labyrint.antallRader - 1 && posKolonne == Labyrint.antallKolonner - 1) {
            naboNord = lab.rutenett.get(posRad - 1).get(posKolonne);
            naboSoer = lab.rutenett.get(posRad + 1).get(posKolonne);
            naboVest = lab.rutenett.get(posRad).get(posKolonne - 1);
            naboListe.add(naboNord);
            naboListe.add(naboVest);
            naboListe.add(naboSoer);
        }

        // venstre kant
        else if(posRad > 0 && posRad < Labyrint.antallRader - 1 && posKolonne == 0) {
            naboNord = lab.rutenett.get(posRad - 1).get(posKolonne);
            naboOest = lab.rutenett.get(posRad).get(posKolonne + 1);
            naboSoer = lab.rutenett.get(posRad + 1).get(posKolonne);
            naboListe.add(naboNord);
            naboListe.add(naboOest);
            naboListe.add(naboSoer);
        }

        // hjørne oppe venstre HEER
        else if(posRad == 0 && posKolonne == 0) {
            naboOest = lab.rutenett.get(posRad).get(posKolonne + 1);
            naboSoer = lab.rutenett.get(posRad + 1).get(posKolonne);
            naboListe.add(naboOest);
            naboListe.add(naboSoer);
        }
        //hjørne oppe høyre
        else if(posRad == 0 && posKolonne == Labyrint.antallKolonner - 1){
            naboSoer = lab.rutenett.get(posRad + 1).get(posKolonne);
            naboVest = lab.rutenett.get(posRad).get(posKolonne - 1);
            naboListe.add(naboVest);
            naboListe.add(naboSoer);
        }
        // hjørne nede venstre
        else if(posRad == Labyrint.antallRader - 1 && posKolonne == 0) {
            naboNord = lab.rutenett.get(posRad - 1).get(posKolonne);
            naboOest = lab.rutenett.get(posRad).get(posKolonne + 1);
            naboListe.add(naboNord);
            naboListe.add(naboOest);
        }
        // hjørne nede høyre
        else if(posRad == Labyrint.antallRader - 1 && posKolonne == Labyrint.antallKolonner - 1) {
            naboNord = lab.rutenett.get(posRad - 1).get(posKolonne);
            naboVest = lab.rutenett.get(posRad).get(posKolonne - 1);
            naboListe.add(naboVest);
            naboListe.add(naboNord);
        } 
    }

    public String toString() {
        return "Rute på rad: " + rad + " Kolonne: " + kolonne;
    }
    
    //public void gaa(String vei, Rute forrige, boolean lagStringVei, ArrayList<Tuppel> forelopig) {
    //    ArrayList<Tuppel> nySti = new ArrayList<>(forelopig);
    //    Rute siste = forrige;
    //    nySti.add(new Tuppel(this.rad, this.kolonne));
//
    //    if(lagStringVei) {
    //        vei += " --> " + "(" + this.rad + " , " + this.kolonne + ")";
    //    }
    //    // Nord er hvit
    //    if (this.naboNord != null && this.naboNord.hvit() && this.naboNord != siste) {
    //        naboNord.gaa(vei, this, lagStringVei, nySti);
    //    }
    //    // Øst er hvit
    //    if (this.naboOest != null && this.naboOest.hvit() && this.naboOest != siste) {
    //        naboOest.gaa(vei, this, lagStringVei, nySti);
    //    }
    //    // Vest er hvit
    //    if (this.naboVest != null && this.naboVest.hvit() && this.naboVest != siste) {
    //        naboVest.gaa(vei, this, lagStringVei, nySti);
    //    }
    //    // Sør er hvit
    //    if (this.naboSoer != null && this.naboSoer.hvit() && this.naboSoer != siste) {
    //        naboSoer.gaa(vei, this, lagStringVei, nySti);
    //    }
    //}

    public void finnUtvei(boolean medPrint) {
        //ArrayList<Tuppel> forelopig = new ArrayList<>();
        //lab.finnUtvei = new ArrayList<Tuppel>();
        //lab.veien.clear();
        //if(medPrint) {
        //    this.gaa("", this, true, forelopig);
        //    for (String s : lab.veien) {
        //        System.out.println(s);
        //    }
        //}
        //else {
        //
        //    this.gaa("", this, false, forelopig);
//
        //    //for (Tuppel r : lab.finnUtvei) {
        //    //    System.out.println(r);
        //    //}
        //}
        gaa("", this, medPrint, new ArrayList<Tuppel>());
        //for (String s : lab.veien) {
        //    System.out.println(s);
        //}
    }
    
    abstract char tilTegn();

    abstract boolean hvit();

    abstract boolean aapen();

    abstract void gaa(String vei, Rute forrige, boolean lagVei, ArrayList<Tuppel> forelopig);
}
