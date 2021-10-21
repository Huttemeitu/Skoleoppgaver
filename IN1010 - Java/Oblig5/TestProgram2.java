import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.io.FileNotFoundException;



public class TestProgram2 {

    static int subStoerrelse = 3;
    static Beholder smittetBeholder;
    static Beholder usmittetBeholder;
    static CountDownLatch minB;
    static CountDownLatch fletteBar;
    static int antallTraader;
    static int antallFiler = 0;
    //Feil
    static int antallFilerLest = 0;
    static int feilFilLesing = 0;
    static int antallDomSS = 0;
    static int fantIkkeNokkel = 0;
    static int hmForFlettingS = 0;
    static int hmForFlettingU = 0;
    static int elemForFS = 0;
    static int elemForFU = 0;
    static int antallTraaderTerm = 0;
 
    

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        antallTraader = Integer.parseInt(args[0]);

        smittetBeholder = new Beholder();
        usmittetBeholder = new Beholder();
        settAntallFiler("metadata.csv");
        minB = new CountDownLatch(antallFiler);
        lesMetaFil("metadata.csv", smittetBeholder, usmittetBeholder, minB);
        try {
            System.out.println("Filene leses inn...");
            System.out.println(" ");

            
            minB.await();
            System.out.println("Alle tråder er fullført");    
        }
        catch(InterruptedException i) {
            System.out.println("feil");
        }
        hmForFlettingS = smittetBeholder.antallHashMaps();
        hmForFlettingU = usmittetBeholder.antallHashMaps();
    
        System.out.println("Fletting starter...");

        for(int i = 0; i < smittetBeholder.antallHashMaps(); i++) {
            for(SubSekvens s : smittetBeholder.hentHashMap(i).values()) {
                elemForFS++;
            }
        }
        for(int i = 0; i < usmittetBeholder.antallHashMaps(); i++) {
            for(SubSekvens s : usmittetBeholder.hentHashMap(i).values()) {
                elemForFU++;
            }
        }
        // Fletting
        CountDownLatch fletteBar = new CountDownLatch(antallTraader);
        if (antallTraader % 2 != 0) {
            Thread nySmittetTraad = new Thread(new FletteTraad(smittetBeholder, fletteBar));
            nySmittetTraad.start();
        }
        for(int i = 0; i < antallTraader/2; i++) {
            Thread nySmittetTraad = new Thread(new FletteTraad(smittetBeholder, fletteBar));
            nySmittetTraad.start();
        }
        for (int i = 0; i < antallTraader/2; i++) {
            Thread nyUSmittetTraad = new Thread(new FletteTraad(usmittetBeholder, fletteBar));
            nyUSmittetTraad.start();
        }
        try {
            fletteBar.await();
        }
        catch (InterruptedException i) {
            System.out.println("feil fletting");
        }
        System.out.println("Antall HashMaps i smittet beholder: " + smittetBeholder.hentHashMap(0).size());
        System.out.println("Antall HashMaps i usmittet beholder: " + usmittetBeholder.hentHashMap(0).size());
        System.out.println("Enkel statistisk test");
        enkelStatistiskTest();
        System.out.println("----------------------------------------");
        diagnotisering();
        
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed/1000 + "s");

    }


    
    static void lesMetaFil(String filnavn, Beholder smittet, Beholder usmittet, CountDownLatch latch) {
    //CountDownLatch midlL = new CountDownLatch(1);
    CountDownLatch minB2 = latch;
        try {
            File fil = new File(filnavn);
            Scanner scanner = new Scanner(fil);

            while (scanner.hasNextLine()) {
                String linje = scanner.nextLine();
                String[] data = linje.split(",");
                if (linje.startsWith("testfiler")) {
                    minB2.countDown();
                }
                else if (data[1].equals("True")) {
                    //lesFil(data[0], smittet);
                    Thread nyTraad = new Thread(new FilTraad(data[0], smittet, minB2));
                    nyTraad.start();
                    //System.out.println("Ny smittet tråd starter...");
                } 
                else if (data[1].equals("False")) {
                    //lesFil(data[0], usmittet);
                    Thread nyTraad = new Thread(new FilTraad(data[0], usmittet, minB2));
                    nyTraad.start();
                    //System.out.println("Ny usmittet tråd starter...");
                } 
                else {
                    System.out.println("Klarte ikke å lese.");
                    minB2.countDown();
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Can´t find file");
        }
    }

    static void leggTilSmittet(HashMap<String, SubSekvens> hm) {
        smittetBeholder.settInnHashMap(hm);
    }

    static void leggTilUsmittet(HashMap<String, SubSekvens> hm) {
        usmittetBeholder.settInnHashMap(hm);
    }

    static void enkelStatistiskTest() {
        
        for (SubSekvens Ss : smittetBeholder.hentHashMap(0).values()) {
            if (usmittetBeholder.hentHashMap(0).containsKey(Ss.hentSubSekvens())) {    
                if ((Ss.hentAntallForekomster() - usmittetBeholder.hentHashMap(0).get(Ss.hentSubSekvens()).hentAntallForekomster()) >= 5) {
                    
                    System.out.println(" ");
                    System.out.println("Subsekvensen: " + Ss.hentSubSekvens() + " ble funnet i: ");
                    System.out.println(Ss.hentAntallForekomster() + " personer med paavist virus.");
                    System.out.println(usmittetBeholder.hentHashMap(0).get(Ss.hentSubSekvens()).hentAntallForekomster()
                            + " personer uten paavist virus.");
                    System.out.println("Differanse: " + (Ss.hentAntallForekomster() - (usmittetBeholder.hentHashMap(0).get(Ss.hentSubSekvens()).hentAntallForekomster())));
                    System.out.println(" ");
                    antallDomSS++;
                }
            } 
            else {
                fantIkkeNokkel++;
            }
        }
    }

    static void settAntallFiler(String filnavn) {
        try {
            Scanner sc = new Scanner(new File(filnavn));
            while (sc.hasNextLine()) {
                antallFiler++;
                sc.nextLine();
            }
            sc.close();
        }
        catch (FileNotFoundException fnf) {
            System.out.println("feil");
        }
        System.out.println(antallFiler + " filer");
    }

    static void diagnotisering() {
        System.out.println("Antall filer lest: " + antallFilerLest);
        System.out.println("Antall feil i filinnlesing: " + feilFilLesing);
        System.out.println("Antall dominante subsekvenser: " + antallDomSS);
        System.out.println("Antall HM før fletting smittet: " + hmForFlettingS);
        System.out.println("Antall HM før fletting usmittet: " + hmForFlettingU);
        System.out.println("Antall HM etter fletting smittet: " + smittetBeholder.antallHashMaps());
        System.out.println("Antall HM etter fletting usmittet: " + usmittetBeholder.antallHashMaps());
        System.out.println("Totalt antall elementer før fletting smittet: " + elemForFS);
        System.out.println("Totalt antall elementer før fletting usmittet: " + elemForFU);
        System.out.println("Antall elementer i HM i smittet beholder etter fletting: " + smittetBeholder.hentHashMap(0).size());
        System.out.println("Antall elementer i HM i usmittet beholder etter fletting: " + usmittetBeholder.hentHashMap(0).size());
        System.out.println("Antall opprettede tråder: " + antallTraader);
        System.out.println("Antall terminerte traader: " + antallTraaderTerm);
    }
}

