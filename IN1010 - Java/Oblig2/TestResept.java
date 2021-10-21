public class TestResept {

    public static void main(String[] args) {
        
        MilitaerResept mRes = new MilitaerResept(new Vanlig("Ibux", 67, 1.2), new Lege("Geir"),34, 2);
        PResepter pRes = new PResepter(new Vanedannende("Nesespray", 187, 1.6, 10), new Lege("Siri"), 24);
        BlaaResept bRes = new BlaaResept(new Narkotisk("Kokain", 500, 6.5, 9000), new Lege("Kai Arne"), 54, 1);

        // Tester hentId()
        if (mRes.hentId() == 1 && pRes.hentId() == 2 && bRes.hentId() == 3) {
            System.out.println("hentId() funker");
        }
        else {
            System.out.println("hentId() funker ikke");
        }
        // Tester hentLegemiddel()
        if (mRes.hentLegemiddel() instanceof Vanlig) {
            System.out.println("hentLegemiddel() funker");
        }
        else {
            System.out.println("hentLegemiddel() funker ikke");
        }
        // Tester hentLege()
        if (mRes.hentLege() instanceof Lege) {
            System.out.println("hentLege() funker");
        }
        else {
            System.out.println("hentLege() funker ikke");
        }
        // Tester hentPasientId()
        if (mRes.hentPasientId() == 34) {
            System.out.println("hentPasientId() funker");
        }
        else {
            System.out.println("hentPasientId() funker ikke");
        }
        // Tester hentReit()
        if (mRes.hentReit() == 2) {
            System.out.println("hentReit() funker");
        }
        else {
            System.out.println("hentReit() funker ikke");
        }
        // Tester bruk()
        if (bRes.bruk()) {
            if (bRes.bruk() == false) {
                System.out.println("bruk() funker");
            }
            else {
                System.out.println("bruk() funker ikke");
            }
        }
        else {
            System.out.println("bruk() funker ikke");
        }
        // Tester prisAaBetale() for de forskjellige subklassene
        if(mRes.prisAaBetale() == 0) {
            System.out.println("prisAaBetale() funker");
        }
        else {
            System.out.println("prisAaBetale() funker ikke");
        }

        if (pRes.prisAaBetale() == 79) {
            System.out.println("prisAaBetale() funker");
        }
        else {
            System.out.println("prisAaBetale() funker ikke");
        }

        if (bRes.prisAaBetale() == 125) {
            System.out.println("prisAaBetale() funker");
        }
        else {
            System.out.println("prisAaBetale() funker");
        }
        // Tester farge()
        if (bRes.farge() == "Blaa" && mRes.farge() == "Hvit") {
            System.out.println("farge() funker");
        }
        else {
            System.out.println("farge() funker ikke");
        }
        // Tester toString-metoden
        System.out.println("");
        System.out.println(mRes); 
    } 
}
