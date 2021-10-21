import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

class Oblig6 {
    // 2021  Versjon 1.0
    public static void main(String[] args) {
        String filnavn = null;
        if (args.length > 0) {
            filnavn = args[0];
        } else {
            System.out.println("FEIL! Riktig bruk av programmet: "
                               +"java Oblig6 <labyrintfil>");
            return;
        }
        //File fil = new File(filnavn);
        Labyrint l = null;
        try {
            l = new Labyrint(filnavn);
        } catch (FileNotFoundException e) {
            System.out.printf("FEIL: Kunne ikke lese fra '%s'\n", filnavn);
            System.exit(1);
        }
        System.out.println(l);
        // les start-koordinater fra standard input
        Scanner inn = new Scanner(System.in);
        System.out.println("Skriv inn koordinater <kolonne> <rad>('a' for aa avslutte)");
        System.out.println("Skriv inn en ekstra bokstav/tall etter koordinatene for å se veien ut");
        String[] ord = inn.nextLine().split(" ");
        while (!ord[0].equals("a")) {
            int antallUtveier = 0;
            try {
                if(ord.length == 3) {
                    
                    int startRad = Integer.parseInt(ord[0]);
                    int startKol = Integer.parseInt(ord[1]);
                    System.out.println("Utveier:");
                    ArrayList<ArrayList<Tuppel>> utveier = l.finnUtveiFra(startRad, startKol, true);
                    for (ArrayList<Tuppel> lis: utveier) {
                        for(Tuppel t: lis)
                            System.out.println(t);
                            
                            
                        
                        antallUtveier++;
                        System.out.println();
                    }
                    System.out.println();
                    System.out.println("Antall utveier fra valgt rute: " + antallUtveier);
                    antallUtveier = 0;
                }
                else {
                    
                    int startRad = Integer.parseInt(ord[0]);
                    int startKol = Integer.parseInt(ord[1]);
                    System.out.println("Utveier:");
                    ArrayList<ArrayList<Tuppel>> utveier = l.finnUtveiFra(startRad, startKol, false);
                    for (ArrayList<Tuppel> lis : utveier) {
                        for (Tuppel t : lis){
                            System.out.println(t);
                            
                        }

                       
                        antallUtveier++;
                        System.out.println();
                    }
                    System.out.println();
                    System.out.println("Antall utveier fra valgt rute: " + antallUtveier);
                    antallUtveier = 0;
                }
                System.out.println();
            } catch (NumberFormatException e) {
                System.out.println("Ugyldig input!");
            }         
            System.out.println("Skriv inn nye koordinater ('a' for aa avslutte)");
            ord = inn.nextLine().split(" ");
        }
    }
}