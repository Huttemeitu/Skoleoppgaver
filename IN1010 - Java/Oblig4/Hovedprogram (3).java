import java.io.FileNotFoundException;
public class Hovedprogram {

    public static void main(String[] args) throws Exception {
        Legesystem nyttLegeSystem = new Legesystem();

        nyttLegeSystem.lesFraFil("test2.txt");
        System.out.println("Ferdig med å lese inn");

        nyttLegeSystem.loekke();
        System.out.println("Avslutter program...");

        //nyttLegeSystem.tellObjekter();
    }
    
}
