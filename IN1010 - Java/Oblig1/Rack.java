import java.util.ArrayList;

public class Rack {
    // Deklarerer en arraylist som skal holde styr på nodeobjektene.
    private ArrayList<Node> noder;

    public Rack() {
        // Oppretter en tom arraylist som senere skal inneholde Nodeobjekter.
        noder = new ArrayList<Node>();       
        
    }
    // Metode for å legge til en node i et rack. 
    public void leggTil(Node node) {
        noder.add(node);
    }

    // Metode som går igjennom alle nodeobjekter i et rack og kaller på metoden 
    // fra nodeklassen som returnerer antall prosessorer per node. Teller holder
    // styr på antall prosessorer totalt i racket. Denne blir så returnert.
    public int antProsessorer(){
        int teller = 0;

        for (Node n : noder)  {
            teller = teller + n.antProsessorer();
        }
        return teller;

    }

    // Metode for å sjekke antall noder med minne over grensen som er sendt inn som
    // argument i denne metoden. If-sjekken sjekker om minne-metoden fra nodeklassen
    // returnerer et tall som er høyere enn paramteret paakrevdMinne. Isåfall økes
    // teller med 1 og blir til slutt returnert med totalen av antall noder med nok 
    // minne.
    public int noderMedNokMinne(int paakrevdMinne) {
        int teller = 0;
        
        for (Node n : noder) {
            if (n.minne() >= paakrevdMinne) {
                teller++;
            }    
        }
        
        return teller;
    }

    // Denne metoden returner antall noder som ligger inne i et rack. Her blir
    // lengden på arraylisten node returnert. 
    public int hentAntallNoder() {
        return noder.size();
    }
    
}
