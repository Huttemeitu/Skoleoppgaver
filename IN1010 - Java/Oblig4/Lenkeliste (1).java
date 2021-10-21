import java.util.Iterator;
public class Lenkeliste<T> implements Liste<T> {
    public class Node {
        Node neste = null; 
        T data; 

        Node (T x) {
            data = x; 
        }
    }
    
    protected Node start = null;
    protected Node siste = null;
    
    public class LenkelisteIterator implements Iterator<T> {
        private Lenkeliste<T> minLl;
        private int pos;

        public LenkelisteIterator(Lenkeliste<T> nyListe) {
            minLl = nyListe;
            pos = 0;
           
        }
        
        public T next() {
            return minLl.hent(pos++);
        }
        
        public boolean hasNext() {
            return (pos < minLl.stoerrelse());
        }
        
        
    }
    @Override
    public Iterator<T> iterator() {
        return new LenkelisteIterator(this);
    }

    
    @Override
    public void leggTil(T x) {
        Node ny = new Node(x);

        if (start == null) {
            start = ny;  
        }
        else {        
            siste.neste = ny;   
        }
        siste = ny;
    }

    
    @Override
    public T fjern() throws UgyldigListeIndeks{
        if(start == null) {
            throw new UgyldigListeIndeks(0);
        }
        else {
        Node n = start;
        start = start.neste;
        return n.data;
        }
    }


    @Override
    public int stoerrelse() {
        int teller = 0;
        Node peker = start; 
        while(peker != null) {
            teller++;
            peker = peker.neste;
        }
        return teller;
    }

    
    @Override
    public T hent(int pos) throws UgyldigListeIndeks {
        if(pos < 0 || pos > stoerrelse()-1) {
            throw new UgyldigListeIndeks(pos);
        }
        else if(pos == 0 && start == null) {
            throw new UgyldigListeIndeks(pos);
        }
        else{

            Node p = start; 
            for (int i = 0; i < pos; i++) {
                p = p.neste;
            }    
            return p.data;
        }
    }
    
    
    @Override
    public void sett(int pos, T x) throws UgyldigListeIndeks {
        if(pos < 0 || pos > stoerrelse()-1) {
            throw new UgyldigListeIndeks(pos);
        }
        else if(pos == 0 && start == null) {
            throw new UgyldigListeIndeks(pos);
        }
        Node peker = start;
        for(int i = 0; i<pos; i++) {
            peker = peker.neste;
        }
        peker.data = x;
    }

    
    @Override
    public void leggTil(int pos, T x) throws UgyldigListeIndeks {
        if(pos < 0 || pos > stoerrelse()) {
            throw new UgyldigListeIndeks(pos);
        }
        Node ny = new Node(x);
        Node peker = start;


        if (pos == 0 && start == null) {
            start = ny;
            siste = ny;
        }
        else if(pos == 0) {
            Node res = start;
            start = ny;
            ny.neste = res;   
        }
        
        else{
            for (int i = 0; i < pos - 1; i++) {
                peker = peker.neste;
            }
            Node res = peker.neste;
            peker.neste = ny;
            ny.neste = res;
        }
    }

    
    @Override
    public T fjern(int pos) throws UgyldigListeIndeks {
        T dataFjernet;
        Node p = start;
        if (pos < 0 || pos > stoerrelse()-1) {
            throw new UgyldigListeIndeks(pos);
        }

        else if(pos == 0 && start == null) {
            throw new UgyldigListeIndeks(pos);

        }

        else if(pos == 0) {
            dataFjernet = start.data;
            start = start.neste; 
        }

        else if (pos == stoerrelse()-1) {
            dataFjernet = siste.data;
            for (int i = 0; i < pos-1; i++) {
            p = p.neste;
            }
            p.neste = null;
            siste = p;
        }
            
        
        else {
        for (int i = 0; i < pos-1; i++) {
            p = p.neste;
        }
        dataFjernet = p.neste.data;
        p.neste = p.neste.neste;
        }

        return dataFjernet;
    }

    @Override
    public String toString() {
        String string = "";
        Node peker = start;
        while(peker != null) {
            string = string + peker.data;
            peker = peker.neste;
        }
        return string;
    }
    
}

