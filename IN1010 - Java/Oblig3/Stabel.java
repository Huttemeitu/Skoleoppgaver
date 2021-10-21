public class Stabel<T> extends Lenkeliste<T> {

    public void leggPaa(T x) {
        Node ny = new Node(x);
        if(siste == null) {
            start = ny;
            siste = ny;
        }
        else {
        siste.neste = ny;
        siste = ny;
        }
    }

    public T taAv() throws UgyldigListeIndeks {
        Node p;
        if(start == null) {
            throw new UgyldigListeIndeks(0);
        }
        
        else {        
            T f = siste.data;
            if(start != siste) {
                p = start; 
                while(p.neste != siste) {
                p = p.neste;
                }

            siste = p;
            siste.neste = null;
        
            return f;
            }
            else {
                f = start.data;
                start = siste = null;
                return f;
            }
        }
    }
}
