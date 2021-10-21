public class Spesialist extends Lege implements Godkjenningsfritak{

    private String navn; 
    private String kontrollID; 

    Spesialist(String navn, String kontrollID) {
        super(navn);
        this.kontrollID = kontrollID;
        this.navn = navn; 
    }

    public String hentKontrollID() {
        return kontrollID; 
    }

    public String toString() {
        return "Legens navn: " + navn + "\nKontrollID: " + kontrollID;
    }
    
}
