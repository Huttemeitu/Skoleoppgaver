public class TestLegemiddel {
    public static void main(String[] args) {
        
        Narkotisk narko = new Narkotisk("Heroin", 500, 3.5, 10);
        Vanedannende nesespray = new Vanedannende("Otrivin", 68, 2.6, 3);
        Vanlig hodepinetabelett = new Vanlig("Paracet", 80, 1.3);

        //Tester hentNavn()
        if (hodepinetabelett.hentNavn() == "Paracet") {
            System.out.println("hentNavn() funker");
        }
        else {
            System.out.println("hentNavn() funker ikke");
        }
        // Tester hentPris()
        if (hodepinetabelett.hentPris() == 80) {
            System.out.println("hentPris() funker");
        } else {
            System.out.println("hentPris() funker ikke");
        }
        // Tester hentVirkestoff()
        if (hodepinetabelett.hentVirkestoff() == 1.3) {
            System.out.println("hentVirkestoff() funker");
        } else {
            System.out.println("hentVirkestoff() funker ikke");
        }
        // Tester settNyPris()
        hodepinetabelett.settNyPris(100);
        if (hodepinetabelett.hentPris() == 100) {
            System.out.println("settNyPris() funker");
        } else {
            System.out.println("settNyPris() funker ikke");
        }
        // Tester hentId()
        if (narko.hentId() == 1 && nesespray.hentId() == 2 && hodepinetabelett.hentId() == 3) {
            System.out.println("hentId() funker");
        } else {
            System.out.println("hentId() funker ikke");
        }
        // Tester hentnNarkotiskStyrke()
        if (narko.hentNarkotiskStyrke() == 10) {
            System.out.println("hentNarkotiskStyrke() funker");
        } else {
            System.out.println("hentNarkotiskStyrke() funker ikke");
        }
        // Tester hentVanedannendeStyrke()
        if (nesespray.hentVanedannendeStyrke() == 3) {
            System.out.println("hentVanedannendeStyrke() funker");
        } else {
            System.out.println("hentVanedannendeStyrke() funker ikke");
        }
        // Viser toString-metoden
        System.out.println("");
        System.out.println(narko);
        System.out.println("");
        System.out.println(nesespray);
        System.out.println("");
        System.out.println(hodepinetabelett); 
    }  
}
