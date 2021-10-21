import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.io.FileNotFoundException;

public class FilTraad implements Runnable{
    private String filnavn = "";
    private Beholder beholder = null;
    private int subStoerrelse = 3;
    private CountDownLatch minB3;
    private HashMap<String, SubSekvens> nyHM;
    private Scanner scanner;
    private File fil;
    public static int traadTeller = 0;
    private static ReentrantLock lock = new ReentrantLock();


    public FilTraad(String fn, Beholder b, CountDownLatch cdl) {
        filnavn = fn;
        beholder = b;
        minB3 = cdl;
        fil = new File(filnavn);
        try { 
            scanner = new Scanner(fil);    
        } 
        catch (FileNotFoundException i) {
            System.out.println("feil filtraad");
        }
    }


    public void run() {

        nyHM = new HashMap<String, SubSekvens>();
        while (scanner.hasNextLine()) {
            String linje = scanner.nextLine().trim();
            if (linje.startsWith("amino_acid ")) {
                scanner.nextLine();
            }
            for (int i = 0; i + subStoerrelse - 1 < (linje.length()); i++) {
                String sub = linje.substring(i, i + subStoerrelse);
                nyHM.putIfAbsent(sub, new SubSekvens(sub));     
            }  
        }
        scanner.close();
        System.out.println("FERDIG: " + traadTeller + "/" + TestProgram2.antallFiler);
        beholder.settInnHashMap(nyHM);
        oekTeller();
        minB3.countDown();   
    }
    static void oekTeller() {
        lock.lock();
        traadTeller++;
        lock.unlock();
    }
}
