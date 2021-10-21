import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Dataklynge {
    // Deklarerer to instansvariabler.
    private ArrayList<Rack> racks;
    private int noderPerRack;

    // Konstruktøren tar inn filnavn som parameter. Konstruktøren oppretter noder
    // basert på tekstfilen som blir sendt inn. 
    public Dataklynge(String filnavn) throws Exception{
        Scanner fil = new Scanner(new File(filnavn));
        racks = new ArrayList<Rack>();

        // Her lagrer jeg første linjen som noderPerRack. Dette tallet skal ikke brukes
        // til å opprette noder. Denne blir heller lagt til i metoden lengre ned; leggTilNode.
        String forsteLinje = fil.nextLine();
        noderPerRack = Integer.parseInt(forsteLinje);

        // While løkken brukes for å gå gjennom filen. Ettersom første linje er hentet ut kan
        // vi fra dette punktet definere dataen og opprette nodeobjekter. Dataen blir først gitt
        // til variabelen linje. Deretter vil variabelen alleData splitte linjen ved mellomrom og
        // returnere en liste. Deretter gir jeg antallNoder, GB og antPros sine verdier og gjør de
        // samtidig om fra string til int. 
        while (fil.hasNextLine()) {
            String linje = fil.nextLine();
            String[] alleData = linje.split(" ");

            int antallNoder = Integer.parseInt(alleData[0]);
            int GB = Integer.parseInt(alleData[1]);
            int antPros = Integer.parseInt(alleData[2]);
            
            // Denne for løkken oppretter nodeobjektene. Her bruker jeg dataen jeg samlet inn fra
            // tekstfilen. 
            for (int i = 0; i < antallNoder; i++) {
                leggTilNode(new Node(GB, antPros));
            }
        }

    }

    // Metode for å legge til node. Her blir første linje fra tekstfilen brukt.
    public void leggTilNode(Node node) {
        for (Rack r : racks) {
            if (r.hentAntallNoder() < noderPerRack) {
                r.leggTil(node);
                return;
            }        
        } 

        // Metoden når ikke dette punktet med mindre alle racksene er fulle. Koden under her lager
        // en ny rack og legger noden til i dette nye racket. 
        Rack nyRack = new Rack();
        racks.add(nyRack);
        nyRack.leggTil(node);
  
    }

    // Metode for å returnere det totale antallet prosessorer i dataklyngen. Denne tar i bruk
    // metoden fra rack som igjen tar i bruk metoden fra node. Teller blir returnert.
    public int antProsessorer(){
        int teller = 0;

        for (Rack r : racks) {       
            teller = teller + r.antProsessorer();
        }
        return teller;
    }

    // Metode for å sjekke hvor mange noder som har mer minne enn det som blir sendt inn som 
    // paakrevdMinne. Metoden kaller så på rack sin metoden hvor den sender paakrevdMinne videre.
    // Det er så metoden i rack som har ansvar for å sjekke om noder.minne returnerer et høyere tall 
    // enn det som er påkrevd minne. Teller blir returnert med et antall noder. 
    public int noderMedNokMinne(int paakrevdMinne) {
        int teller = 0;

        for (Rack r : racks) {
            
            teller = teller + r.noderMedNokMinne(paakrevdMinne);   
        }     
        return teller;
    }

    // Metode som returnerer antall racks i dataklynge. Denne sjekker bare størrelsen på 
    // arraylisten og returnerer dette som et heltall.
    public int antRacks(){
        return racks.size();

    }

    
}

