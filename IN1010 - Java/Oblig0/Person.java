public class Person {
    private Bil3 personensBil;
    
    public Person(Bil3 bil){
        Bil3 personensBil = bil;


    }
    public void skrivUt4()
    {
        String hentetRegNr = personensBil.hentNummer();
        System.out.println("Bilens regnr: " + hentetRegNr);
        
    }
    
}
