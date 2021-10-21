import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileNotFoundException;

public class Legesystem {
    protected Lenkeliste<Pasient> pasienter = new Lenkeliste<Pasient>();
    protected Lenkeliste<Legemiddel> legemidler = new Lenkeliste<Legemiddel>();
    protected Lenkeliste<Resept> reseptListe = new Lenkeliste<Resept>();
    protected SortertLenkeliste<Lege> leger = new SortertLenkeliste<Lege>();
    
 

    public void lesFraFil(String filnavn) throws FileNotFoundException {
        int pasientFeil = 0;
        int legemiddelFeil = 0;
        int legeFeil = 0;
        int reseptFeil = 0;
        int falltIkkeInnenforNoe = 0;
        try {
            File fil = new File(filnavn);
            Scanner scanner = new Scanner(fil);
            while (scanner.hasNextLine()) {  
                ArrayList<String> linjen = new ArrayList<>();  
                String linje = scanner.nextLine();
                String[] data = linje.split(",");
                for(String s : data) {
                    linjen.add(s);
                }
                if(linje.startsWith("#")) {
                    continue;
                }
                // pasient
                if (linjen.size() == 2 && linjen.get(1).length() == 11) {
                    Pasient nyPasient = new Pasient(linjen.get(0), linjen.get(1));
                    pasienter.leggTil(nyPasient);
                }
                // narkotisk
                else if (linjen.get(1).equals("narkotisk")) {
                    Narkotisk nyNarkotisk = new Narkotisk(linjen.get(0), 
                            (int)Double.parseDouble(linjen.get(2)),
                            Double.parseDouble(linjen.get(3)), (int)Double.parseDouble(linjen.get(4)));
                    legemidler.leggTil(nyNarkotisk);
                }
                // vanedannende
                else if (linjen.get(1).equals("vanedannende")) {
                    Vanedannende nyVanedannende = new Vanedannende(linjen.get(0), 
                            (int)Double.parseDouble(linjen.get(2)),
                            (int)Double.parseDouble(linjen.get(3)), (int)Double.parseDouble(linjen.get(4)));
                    legemidler.leggTil(nyVanedannende);
                }
                // vanlig
                else if (linjen.get(1).equals("vanlig")) {
                    Vanlig nyVanlig = new Vanlig(linjen.get(0), 
                            (int)Double.parseDouble(linjen.get(2)),
                            Double.parseDouble(linjen.get(3)));
                    legemidler.leggTil(nyVanlig);
                }
                // Lege
                else if(linjen.size() == 2 && linjen.get(1).length() != 11)  {
                    // vanlig lege
                    if(linjen.get(1).trim().length() == 1) {
                        Lege nyLege = new Lege(linjen.get(0));
                        leger.leggTil(nyLege);
                    }
                    // spesialist
                    else {
                        Spesialist nySpesialist = new Spesialist(linjen.get(0), linjen.get(1));
                        leger.leggTil(nySpesialist);
                    }
                }
                // hvit resept
                else if(linjen.get(3).equals("hvit")) {
                    if(finnLegemiddelMedNummer(Integer.parseInt(linjen.get(0))) != null && hentLegeObjektMedNavn(linjen.get(1)) != null && finnPasientMedNummer(Integer.parseInt(linjen.get(2))) != null) {
                        HvitResept nyHvit = new HvitResept(finnLegemiddelMedNummer(Integer.parseInt(linjen.get(0))), hentLegeObjektMedNavn(linjen.get(1)), finnPasientMedNummer(Integer.parseInt(linjen.get(2))), Integer.parseInt(linjen.get(4)));
                        if(finnLegemiddelMedNummer(Integer.parseInt(linjen.get(0))) instanceof Narkotisk && hentLegeObjektMedNavn(linjen.get(1)) instanceof Spesialist == false) {
                            continue;
                        }
                        reseptListe.leggTil(nyHvit);
                        finnPasientMedNummer(Integer.parseInt(linjen.get(2))).resepter.leggPaa(nyHvit);
                    }
                    else {
                        reseptFeil++;
                        continue;
                    }
                }
                // blaa resept
                else if(linjen.get(3).equals("blaa")) {
                    if(finnLegemiddelMedNummer(Integer.parseInt(linjen.get(0))) != null && hentLegeObjektMedNavn(linjen.get(1)) != null && finnPasientMedNummer(Integer.parseInt(linjen.get(2))) != null) {
                        BlaaResept nyBlaa = new BlaaResept(finnLegemiddelMedNummer(Integer.parseInt(linjen.get(0))), hentLegeObjektMedNavn(linjen.get(1)), finnPasientMedNummer(Integer.parseInt(linjen.get(2))), Integer.parseInt(linjen.get(4)));
                        if (finnLegemiddelMedNummer(Integer.parseInt(linjen.get(0))) instanceof Narkotisk
                                && hentLegeObjektMedNavn(linjen.get(1)) instanceof Spesialist == false) {
                            continue;
                        }
                        reseptListe.leggTil(nyBlaa);
                        finnPasientMedNummer(Integer.parseInt(linjen.get(2))).resepter.leggPaa(nyBlaa);
                    }
                    else {
                        reseptFeil++;
                        continue;
                    }
                }
                // millitaer resept
                else if(linjen.get(3).equals("militaer")) {
                    if(finnLegemiddelMedNummer(Integer.parseInt(linjen.get(0))) != null && hentLegeObjektMedNavn(linjen.get(1)) != null && finnPasientMedNummer(Integer.parseInt(linjen.get(2))) != null) {
                        MilitaerResept nyMill = new MilitaerResept(finnLegemiddelMedNummer(Integer.parseInt(linjen.get(0))), hentLegeObjektMedNavn(linjen.get(1)), finnPasientMedNummer(Integer.parseInt(linjen.get(2))), Integer.parseInt(linjen.get(4)));
                        if (finnLegemiddelMedNummer(Integer.parseInt(linjen.get(0))) instanceof Narkotisk
                                && hentLegeObjektMedNavn(linjen.get(1)) instanceof Spesialist == false) {
                            continue;
                        }
                        reseptListe.leggTil(nyMill);
                        finnPasientMedNummer(Integer.parseInt(linjen.get(2))).resepter.leggPaa(nyMill);
                    }
                    else {
                        reseptFeil++;
                        continue;
                    }
                }
                // p resept
                else if(linjen.get(3).equals("p")) {
                    if(finnLegemiddelMedNummer(Integer.parseInt(linjen.get(0))) != null && hentLegeObjektMedNavn(linjen.get(1)) != null && finnPasientMedNummer(Integer.parseInt(linjen.get(2))) != null) {
                        PResepter nyP = new PResepter(finnLegemiddelMedNummer(Integer.parseInt(linjen.get(0))), hentLegeObjektMedNavn(linjen.get(1)), finnPasientMedNummer(Integer.parseInt(linjen.get(2))));
                        if (finnLegemiddelMedNummer(Integer.parseInt(linjen.get(0))) instanceof Narkotisk
                                && hentLegeObjektMedNavn(linjen.get(1)) instanceof Spesialist == false) {
                            continue;
                        }
                        reseptListe.leggTil(nyP);
                        finnPasientMedNummer(Integer.parseInt(linjen.get(2))).resepter.leggPaa(nyP);
                    }
                    else {
                        reseptFeil++;
                        continue;
                    }
                } 
                else {
                    falltIkkeInnenforNoe++;
                    //System.out.println(linje);
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Fant ikke fil.");
        }
        //System.out.println("Pasientfeil: " + pasientFeil);
        //System.out.println("Reseptfeil: " + reseptFeil);
        //System.out.println("Generelle feil: " + falltIkkeInnenforNoe);
        System.out.println(" ");
        
    }

    public Legemiddel finnLegemiddelMedNummer(int i) {
        for(Legemiddel l : legemidler) {
            if(i == l.hentId()) {
                return l;
            }
        }
        return null;
    }

    public Pasient finnPasientMedNummer(int i) {
        
        for(Pasient p : pasienter) {
            if(i == p.hentId()) {
                return p;
            }
        }
        return null;
    }

    public Lege hentLegeObjektMedNavn(String navn) {
        for(Lege l : leger) {
            if(navn.equals(l.hentNavn())) {
                return l;
            }
        }
        return null;
    }

    public void loekke() {
        Scanner in = new Scanner(System.in);
        System.out.println("Hei!\nVelg hva du vil gjøre:\nFor fullstendig oversikt over alle elementer, skriv 'u' \n"
                + "For å opprette og legge til et nytt element, skriv 'o'\nFor å bruke en resept, skriv 'r'\nFor å skrive ut statistikk, skriv 's'\n"
                + "For å skrive alle data til fil, skriv 'f'\nFor å avslutte/gå tilbake, skriv 'q'");

        String svar = in.nextLine();

        while(svar.equals("q") == false) {
            // Utskrift
            if(svar.equals("u")) {
                System.out.println("Pasientliste:");
                for(Pasient p : pasienter) {
                    System.out.println(p.navn + ", fnum: " + p.fNummer);
                }
                System.out.println("");
                System.out.println("Reseptliste");
                for(Resept r : reseptListe) {
                    System.out.println("Legemiddel: " + r.legemiddelet.navn + ", Skrevet ut av: " + r.legen.navn + " til pasient: " + r.pasient.navn);
                }
                System.out.println("");
                System.out.println("Legemiddelliste: ");
                ArrayList<Vanedannende> vanedannende = new ArrayList<>();
                ArrayList<Narkotisk> narkotisk = new ArrayList<>();
                for(Legemiddel l : legemidler) {
                    if(l instanceof Vanlig) {
                        System.out.println("Navn: " + l.navn + " Pris: " + l.pris + " Virkestoff: " + l.virkestoff);
                    }
                    else if(l instanceof Narkotisk){
                        narkotisk.add((Narkotisk)l);
                    }
                    else if(l instanceof Vanedannende) {
                        vanedannende.add((Vanedannende)l);
                    }
                }
                for(Vanedannende v : vanedannende) {
                    System.out.println("Navn: " + v.navn + " Pris: " + v.pris + " Virkestoff: " + v.virkestoff + " Styrke: " + v.hentVanedannendeStyrke());
                }
                for(Narkotisk n : narkotisk) {
                    System.out.println("Navn: " + n.navn + " Pris: " + n.pris + " Virkestoff: " + n.virkestoff + " Styrke: " + n.hentNarkotiskStyrke());
                }
                System.out.println("");
                System.out.println("Legeliste: ");
                ArrayList<Spesialist> spesialister = new ArrayList<>();
                for(Lege l : leger) {
                    System.out.println(l.toString());
                }
                
                System.out.println(" ");
                System.out.println("Velg ny Operasjon!");
            }
            // Opprett
            else if(svar.equals("o")) { 
                System.out.println("Velg hva du vil opprette:\nLege: 'l'\nPasient: 'p'\nLegemiddel: 'lm'\nResept: 'r'");

                String svar1 = in.nextLine();
                if (svar1.equals("q")) {
                    svar = "x";
                    continue;
                }
                // Oppretter lege
                if(svar1.equals("l")) {
                    System.out.println("Fyll inn: navn (,KontrollID)");
                    String svar2 = in.nextLine();
                    if (svar2.equals("q")) {
                        continue;
                    }
                    ArrayList<String> legeInfo = new ArrayList<>();
                    String[] data = svar2.split(", ");
                    for(String i : data) {
                        legeInfo.add(i);
                    }
                    if(legeInfo.size() == 1) {
                        Lege nyLege = new Lege(legeInfo.get(0));
                        leger.leggTil(nyLege);
                        System.out.println(" ");
                        System.out.println("Ny lege med navn: " + legeInfo.get(0) + " ble opprettet!\nVelg en ny operasjon.");
                        System.out.println(" ");
                    }
                    else {
                        Spesialist nySpes = new Spesialist(legeInfo.get(0), legeInfo.get(1));
                        leger.leggTil(nySpes);
                        System.out.println(" ");
                        System.out.println("Ny spesialist med navn: " + legeInfo.get(0) + " og kontrollID: " + legeInfo.get(1) + " ble opprettet!\nVelg en ny operasjon.");
                        System.out.println(" ");
                    }
                }
                // Oppretter pasient
                else if(svar1.equals("p")) {
                    System.out.println("Fyll inn: navn, foedselsnummer");
                    String svar2 = in.nextLine();
                    if (svar2.equals("q")) {
                        continue;
                    }
                    String data[] = svar2.split(", ");
                    Pasient nyPas = new Pasient(data[0], data[1]);
                    pasienter.leggTil(nyPas);
                    System.out.println(" ");
                    System.out.println("Ny pasient med navn: " + data[0] + " og fødselsnummer: " + data[1] + " ble opprettet.\nVelg en ny operasjon!");
                    System.out.println(" ");
                }
                // Oppretter legemiddel
                else if(svar1.equals("lm")){
                    System.out.println("Hvilke type legemiddel vil du opprette?");
                    System.out.println("Vanlig: 'v'\nVanedannende: 'd'\nNarkotisk: 'n'");
                    String svar2 = in.nextLine();
                    if (svar2.equals("q")) {
                        continue;
                    }
                    if(svar2.equals("v")) {
                        System.out.println("Fyll inn: navn, pris, virkestoff");
                        String svar3 = in.nextLine();
                        if (svar3.equals("q")) {
                        continue;
                    }
                        String[] data = svar3.split(", ");
                        Vanlig nyLm = new Vanlig(data[0], Integer.parseInt(data[1]), Double.parseDouble(data[2]));
                        legemidler.leggTil(nyLm);
                        System.out.println(" ");
                        System.out.println("Nytt vanlig legemiddel med navn: " + data[0] + " pris: " + data[1] + " og virkestoff: " + data[2] + " ble opprettet!\nVelg en ny operasjon!");
                        System.out.println(" ");
                    }
                    else if(svar2.equals("d")) {
                        System.out.println("Fyll inn: navn, pris, virkestoff, styrke");
                        String svar3 = in.nextLine();
                        if (svar3.equals("q")) {
                            continue;
                        }
                        String[] data = svar3.split(", ");
                        Vanedannende nyLm = new Vanedannende(data[0], Integer.parseInt(data[1]), Double.parseDouble(data[2]), Integer.parseInt(data[3]));
                        legemidler.leggTil(nyLm);
                        System.out.println(" ");
                        System.out.println("Nytt vanedannende legemiddel med navn: " + data[0] + " pris: " + data[1] + " virkestoff: " + data[2] + " og styrke: " + data[3] + " ble opprettet!\nVelg en ny operasjon!");
                        System.out.println(" ");
                    }
                    else if(svar2.equals("n")) {
                        System.out.println("Fyll inn: navn, pris, virkestoff, styrke");
                        String svar3 = in.nextLine();
                        if (svar3.equals("q")) {
                            continue;
                        }
                        String[] data = svar3.split(", ");
                        Narkotisk nyLm = new Narkotisk(data[0], Integer.parseInt(data[1]), Double.parseDouble(data[2]), Integer.parseInt(data[3]));
                        legemidler.leggTil(nyLm);
                        System.out.println(" ");
                        System.out.println("Nytt narkotisk legemiddel med navn: " + data[0] + " pris: " + data[1] + " virkestoff: " + data[2] + " og styrke: " + data[3] + " ble opprettet!\nVelg en ny operasjon!");
                        System.out.println(" ");
                    }
                else {
                    System.out.println("Ugyldig kommando.");
                }
                }
                // Oppretter resept
                else if(svar1.equals("r")) {
                    System.out.println("");
                    System.out.println("Velg hvilke lege du er: ");
                    int teller = 0;
                    
                    for (Lege l : leger) {       
                        System.out.println(teller + ": " + l.toString());
                        teller++;
                    }                   
                    String svar4 = in.nextLine();
                    if (svar4.equals("q")) {
                        continue;
                    }
                    Lege utskrivendeLege = leger.hent(Integer.parseInt(svar4));                    
                    
                    System.out.println("Hvilke type resept vil du opprette?");
                    System.out.println("Millitaer: 'm'\nP-Resept: 'p'\nBlaa resept: 'b'\nHvit resept: 'h'");
                    String svar2 = in.nextLine();

                    if(svar2.equals("m")) {
                        try{
                            System.out.println("Fyll inn: legemiddelnummer, pasientnummer, reit\n'q' for å gå tilbake");
                            String svar3 = in.nextLine(); 
                            if (svar3.equals("q")) {
                                continue;
                            }
                            String[] data = svar3.split(", ");
                            
                            Resept nyM = utskrivendeLege.skrivMillitaerResept(finnLegemiddelMedNummer(Integer.parseInt(data[0])), finnPasientMedNummer(Integer.parseInt(data[1])), Integer.parseInt(data[2]));
                            reseptListe.leggTil(nyM);
                            finnPasientMedNummer(Integer.parseInt(data[1])).resepter.leggTil(nyM);
                            System.out.println(" ");
                            System.out.println("Ny Militærresept ble opprettet med følgende spesifikasjoner:");
                            System.out.println("Legemiddel: " + finnLegemiddelMedNummer(Integer.parseInt(data[0])).navn);
                            System.out.println("Utskrevet av: " + utskrivendeLege.navn);
                            System.out.println("Til pasient:  " + finnPasientMedNummer(Integer.parseInt(data[1])).navn);
                            System.out.println("Reit: " + data[2]);
                            System.out.println(" ");
                            System.out.println("Velg ny operasjon!");
                        }
                        catch (UlovligUtskrift e) {
                            System.out.println(" ");
                            System.out.println(utskrivendeLege.hentNavn() + " har ikke lov til å skrive ut narkotiske legemidler");
                            System.out.println(" ");
                        }
                        

                    }
                    else if(svar2.equals("p")) {
                        try {
                            System.out.println("Fyll inn: legemiddelnummer, pasientnummer\n'q' for å gå tilbake");
                            String svar3 = in.nextLine(); 
                            if (svar3.equals("q")) {
                                continue;
                            }
                            String[] data = svar3.split(", ");
                            Resept nyP = utskrivendeLege.skrivPResept(finnLegemiddelMedNummer(Integer.parseInt(data[0])), finnPasientMedNummer(Integer.parseInt(data[1])));
                            reseptListe.leggTil(nyP);
                            finnPasientMedNummer(Integer.parseInt(data[1])).resepter.leggTil(nyP);
                            System.out.println(" ");
                            System.out.println("Ny P-resept ble opprettet med følgende spesifikasjoner:");
                            System.out.println("Legemiddel: " + finnLegemiddelMedNummer(Integer.parseInt(data[0])).navn);
                            System.out.println("Utskrevet av: " + utskrivendeLege.navn);
                            System.out.println("Til pasient:  " + finnPasientMedNummer(Integer.parseInt(data[1])).navn);
                            System.out.println(" ");
                            System.out.println("Velg ny operasjon!");
                        }
                        catch (UlovligUtskrift e) {
                            System.out.println(" ");
                            System.out.println(utskrivendeLege.hentNavn() + " har ikke lov til å skrive ut narkotiske legemidler");
                            System.out.println(" ");
                        }
                    }
                    else if(svar2.equals("b")) {
                        try {
                            System.out.println("Fyll inn: legemiddelnummer, pasientnummer, reit\n'q' for å gå tilbake");
                            String svar3 = in.nextLine(); 
                            if (svar3.equals("q")) {
                                continue;
                            }
                            String[] data = svar3.split(", ");
                            Resept nyB = utskrivendeLege.skrivBlaaResept(finnLegemiddelMedNummer(Integer.parseInt(data[0])), finnPasientMedNummer(Integer.parseInt(data[1])), Integer.parseInt(data[2]));
                            reseptListe.leggTil(nyB);
                            finnPasientMedNummer(Integer.parseInt(data[1])).resepter.leggTil(nyB);
                            System.out.println(" ");
                            System.out.println("Ny blå resept ble opprettet med følgende spesifikasjoner:");
                            System.out.println("Legemiddel: " + finnLegemiddelMedNummer(Integer.parseInt(data[0])).navn);
                            System.out.println("Utskrevet av: " + utskrivendeLege.navn);
                            System.out.println("Til pasient:  " + finnPasientMedNummer(Integer.parseInt(data[1])).navn);
                            System.out.println("Reit: " + data[2]);
                            System.out.println(" ");
                            System.out.println("Velg ny operasjon!");
                        }
                        catch (UlovligUtskrift e) {
                            System.out.println(" ");
                            System.out.println(utskrivendeLege.hentNavn() + " har ikke lov til å skrive ut narkotiske legemidler");
                            System.out.println(" ");

                        }
                    }
                    else if(svar2.equals("h")) {
                        try {
                            System.out.println("Fyll inn: legemiddelnummer, pasientnummer, reit\n'q' for å gå tilbake");
                            String svar3 = in.nextLine(); 
                            if(svar3.equals("q")) {
                                continue;
                            }
                            String[] data = svar3.split(", ");
                            Resept nyH = utskrivendeLege.skrivHvitResept(finnLegemiddelMedNummer(Integer.parseInt(data[0])), finnPasientMedNummer(Integer.parseInt(data[1])), Integer.parseInt(data[2]));
                            reseptListe.leggTil(nyH);
                            finnPasientMedNummer(Integer.parseInt(data[1])).resepter.leggTil(nyH);
                            System.out.println(" ");
                            System.out.println("Ny hvit resept ble opprettet med følgende spesifikasjoner:");
                            System.out.println("Legemiddel: " + finnLegemiddelMedNummer(Integer.parseInt(data[0])).navn);
                            System.out.println("Utskrevet av: " + utskrivendeLege.navn);
                            System.out.println("Til pasient:  " + finnPasientMedNummer(Integer.parseInt(data[1])).navn);
                            System.out.println("Reit: " + data[2]);
                            System.out.println(" ");
                            System.out.println("Velg ny operasjon!");
                        }
                        catch (UlovligUtskrift e){
                            System.out.println(" ");
                            System.out.println(utskrivendeLege.hentNavn() + " har ikke lov til å skrive ut narkotiske legemidler");
                            System.out.println(" ");
                        }
                    }
                    else {
                        System.out.println("Ugyldig kommando.");
                    }
                }
                else{
                    System.out.println("Ugyldig kommando.");
                }
            }
            // Bruker en resept
            else if(svar.equals("r")) {
                System.out.println("Hvilken pasient vil du se resepter for?\n");
                
                for(Pasient p : pasienter) {
                    System.out.println(p.id + ":" + p.navn + " (fnr " + p.fNummer + ")");
                }
                svar = in.nextLine();
                Pasient valgtP = null;
                for(Pasient p : pasienter) {
                    if(p.id == Integer.parseInt(svar)) {
                        valgtP = p;
                    }
                }
                System.out.println("Valgt pasient: " + valgtP.navn + " (fnr " + valgtP.fNummer + ")");
                if(valgtP.resepter.stoerrelse() == 0) {
                    System.out.println("Pasient har ingen resepter");
                    System.out.println(" ");
                    continue;
                }
                for (Resept r : valgtP.resepter){
                    System.out.println(r.id + ": " +  r.legemiddelet.navn + " " + "(" + r.reit + "reit)");
                }
                System.out.println("Hvilke resept vil du bruke?");
                svar = in.nextLine();
                Resept valgtR = null;
                for(Resept r : valgtP.resepter) {
                    if(r.id == Integer.parseInt(svar)) {
                        valgtR = r; 
                    }
                }
                if(valgtR.bruk()) {
                    System.out.println("Du har nå brukt resepten: " + valgtR.legemiddelet.navn);
                }
                else if(valgtR.bruk() == false) {
                    System.out.println("Kunne ikke bruke resept paa " + valgtR.pasient.navn + " (ingen gjenværende reit)");
                }

            }

            else if(svar.equals("s")) {
                System.out.println("Statistikk");
                System.out.println("Velg alternativ 1, 2 eller 3:");
                System.out.println("1: Totalt antall utskrevne resepter på vanedannende legemidler.");
                System.out.println("2: Totalt antall utskrevne resepter på narkotiske legemidler.");
                System.out.println("3: Statistikk om mulig misbruk av narkotika.");
                String svar2 = in.nextLine();
                if(svar2.equals("1")) {
                    int teller = 0;
                    for(Resept r : reseptListe) {
                        if(r.legemiddelet instanceof Vanedannende) {
                            teller++;
                        }
                    }
                    System.out.println(" ");
                    System.out.println("Totalt antall utskrevne resepter på vanedannende legemidler: " + teller);
                    System.out.println(" ");
                }
                else if(svar2.equals("2")) {
                    int teller = 0;
                    for(Resept r : reseptListe) {
                        if(r.legemiddelet instanceof Narkotisk) {
                            teller++;
                        }
                    }
                    System.out.println(" ");
                    System.out.println("Totalt antall utskrevne resepter på narkotiske legemidler: " + teller);
                    System.out.println(" ");

                }
                else if(svar2.equals("3")) {
                    HashMap<String, Integer> legeStats = new HashMap<String, Integer>();
                    System.out.println("Leger som har skrevet ut narkotiske resepter: ");
                    for(Resept r : reseptListe) {
                        if(r.legemiddelet instanceof Narkotisk) {
                            if(legeStats.containsKey(r.legen.navn)) {
                                legeStats.put(r.legen.navn, legeStats.get(r.legen.navn) + 1);
                            }
                            else {
                                legeStats.put(r.legen.navn, 1);
                            }
                        }
                    }
                    for(String i : legeStats.keySet()) {
                        System.out.println(i + " har skrevet ut " + legeStats.get(i) + " resepter på narkotiske legemidler." );
                    }
                    System.out.println(" ");
                    System.out.println("Pasienter med narkotiske resepter: ");
                    HashMap<String, Integer> pasientStats = new HashMap<String, Integer>();
                    for(Pasient p : pasienter) {
                        for(Resept r : p.resepter) {
                            if(r.legemiddelet instanceof Narkotisk) {
                                if(pasientStats.containsKey(p.navn)) {
                                    pasientStats.put(p.navn, pasientStats.get(p.navn) + 1);
                                }
                                else {
                                    pasientStats.put(p.navn, 1);
                                }  
                            } 
                        }
                    }
                    for(String i : pasientStats.keySet()) {
                        System.out.println(i + " har " + pasientStats.get(i) + " resepter på narkotiske legemidler." );
                    }
                    System.out.println(" ");
                    System.out.println("Velg ny operasjon!");
                    System.out.println(" ");

                }
                else {
                    System.out.println("Ugyldig kommando.");
                }
            }

            else if(svar.equals("f")) {
                System.out.println("Ikke laget enda.");            
            }

            else{
                System.out.println("Dette forsto jeg ikke. Prøv igjen!");
            }
        System.out.println("Velg hva du vil gjøre:\nFor fullstendig oversikt over alle elementer, skriv 'u' \n"
            + "For å opprette og legge til et nytt element, skriv 'o'\nFor å bruke en resept, skriv 'r'\nFor å skrive ut statistikk, skriv 's'\n"
            + "For å skrive alle data til fil, skriv 'f'\nFor å avslutte/gå tilbake, skriv 'q'");

        svar = in.nextLine();
        }
    }

    public void tellObjekter() {
        int pTeller = 0;
        int lTeller = 0;
        int lmTeller = 0;
        int rTeller = 0;
        for(Pasient p : pasienter) {
            pTeller++;
        }
        for(Lege l : leger) {
            lTeller++;
        }
        for(Legemiddel lm : legemidler) {
            lmTeller++;
        }
        for(Resept r : reseptListe) {
            rTeller++;
        }
        System.out.println("Pasienter: " + pTeller);
        System.out.println("Leger: " + lTeller);
        System.out.println("Legemidler: " + lmTeller);
        System.out.println("Resepter: " + rTeller);
    }
}