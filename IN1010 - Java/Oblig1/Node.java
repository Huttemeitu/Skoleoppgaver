public class Node {
    // Deklarerer instansvariablene til  Node
    private int minneStr;
    private int antallPros;
    // Konstruktør, lagrer parameterne i variablene minneStr og antallPros.
    public Node(int mS, int aP) {
        minneStr = mS;
        antallPros = aP; 
        
    }
    // Metode for å returnere antall prosessorer per node
    public int antProsessorer() {
        return antallPros;

    }
    // Metode for å returnere størrelsen på minne per node
    public int minne() {
        return minneStr;



    }
    
}
