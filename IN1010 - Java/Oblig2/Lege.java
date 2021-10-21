public class Lege {

    protected String navn; 

    Lege(String navn) {
        this.navn = navn;
    }

    public String hentNavn() {
        return navn; 
    }

    public String toString() {
        return "Legens navn: " + navn; 
    }    
}
