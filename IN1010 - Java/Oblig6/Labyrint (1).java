import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

class Labyrint {
    public static int antallRader;
    public static int antallKolonner;
    public ArrayList<ArrayList<Rute>> rutenett;
    public ArrayList<String> veien;
    public ArrayList<ArrayList<Tuppel>> utveiTuppel; // denne!
    public int antallAapninger = 0;
    public ArrayList<Tuppel> finnUtvei;


    public Labyrint(String filnavn) throws FileNotFoundException{
        rutenett = new ArrayList<ArrayList<Rute>>();
        veien = new ArrayList<String>();
        utveiTuppel = new ArrayList<ArrayList<Tuppel>>();
        Scanner sc = new Scanner(new File(filnavn));
        String[] forsteLinje = sc.nextLine().split(" ");
        antallRader = Integer.parseInt(forsteLinje[0]);
        antallKolonner = Integer.parseInt(forsteLinje[1]);
        for(int i = 0; i < antallRader; i++) {
            rutenett.add(new ArrayList<Rute>());
        }
        int indexRad = 0;
        while(sc.hasNextLine()){
            int indexKolonne = 0;
            char[] linje = sc.nextLine().toCharArray();
        
            for(char c : linje) {
                if(c == '.') {
                    if(indexRad == 0 || indexRad == antallRader - 1 || indexKolonne == 0 || indexKolonne == antallKolonner - 1) {
                        rutenett.get(indexRad).add(new Aapning(this, indexRad, indexKolonne));
                        antallAapninger++;
                    }
                    else {
                        rutenett.get(indexRad).add(new HvitRute(this, indexRad, indexKolonne));
                    }
                }
                else if(c == '#') {
                    rutenett.get(indexRad).add(new SortRute(this, indexRad, indexKolonne));
                }
                
                else {
                    System.out.println("klarte ikke lese char");
                }
                indexKolonne++;
            }
            indexRad++;
        }
        
        for(ArrayList<Rute> list : rutenett) {
            for(Rute r : list) {
                r.finnNaboer(r.rad, r.kolonne);
            }
        }
    }
    
    public String toString() {
        String result = "";
        for(int i = 0; i < rutenett.size(); i++) {
            for(int j = 0; j < rutenett.get(i).size(); j++) {
                result += rutenett.get(i).get(j).tilTegn();    
            }
            result += "\n";
        }
        return result;
    }

    public void leggTilIListe(String vei) {
        veien.add(vei);
    }

    public ArrayList<ArrayList<Tuppel>> finnUtveiFra(int rad, int kol, boolean medPrint) {
        utveiTuppel.clear();
        rutenett.get(rad).get(kol).finnUtvei(medPrint);
        return utveiTuppel;
    }

}
