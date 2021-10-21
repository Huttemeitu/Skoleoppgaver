public class Hovedprogram {
    public static void main(String[] args) {
        // Oppretter et objekt av hver av legemiddel sine subklasser
        Vanlig ibux = new Vanlig("Ibux", 150, 1.3);
        Vanedannende otrivin = new Vanedannende("Otrivin", 89, 2.3, 8);
        Narkotisk heroin = new Narkotisk("Heroin", 500, 5.8, 15);
        // Oppretter en lege og en spesialist
        Lege geir = new Lege("Geir");
        Spesialist jonas = new Spesialist("Jonas", "43");
        // Oppretter en resept av hver type. Jeg oppretter ikke en hvit resept ettersom
        // hvit resept sine egenskaper blir testet tilstrekkelig ved å teste p- og militærresept.
        MilitaerResept mRes = new MilitaerResept(otrivin, geir, 15, 4);
        PResepter pRes = new PResepter(ibux, geir, 13);
        BlaaResept bRes = new BlaaResept(heroin, jonas, 3, 1);

        // printer ut alle objektene. 
        System.out.println("");
        System.out.println(ibux);
        System.out.println("");
        System.out.println(otrivin);
        System.out.println("");
        System.out.println(heroin);
        System.out.println("");
        System.out.println(geir);
        System.out.println("");
        System.out.println(jonas);
        System.out.println("");
        System.out.println(mRes);
        System.out.println("");
        System.out.println(pRes);
        System.out.println("");
        System.out.println(bRes);
    }
}

