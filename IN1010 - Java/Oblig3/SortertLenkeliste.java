public class SortertLenkeliste<T extends Comparable<T>> extends Lenkeliste<T>{

    @Override
    public void leggTil(T x) {
        Node ny = new Node(x);

        if (start == null) {
            start = ny;
            siste = ny;
        }
        else {
            // Hvis x er midre enn start.data eller lik som start data. Settes til start.
            if(x.compareTo(start.data) < 0 || x.compareTo(start.data) == 0) {
                Node res = start;
                start = ny;
                start.neste = res;
            }
            // Hvis x er større enn siste.data eller lik som siste.data. Settes til siste.
            else if(x.compareTo(siste.data) > 0 || x.compareTo(siste.data) == 0) {
                siste.neste = ny;
                siste = ny;
            }
            // Hvis x er større enn start.data og mindre enn siste.data.
            else { 
                // teller meg frem til hvor x er mindre enn node.data
                Node pos = start;
                while(x.compareTo(pos.neste.data) > 0) {
                    pos = pos.neste;
                }
            
                // hopper over duplikat
                while(pos.data.compareTo(pos.neste.data) == 0) {
                    pos = pos.neste;
                }
                Node res = pos.neste;
                pos.neste = ny;
                ny.neste = res;

            }
        }

    }
    @Override
    public T fjern() throws UgyldigListeIndeks {
        Node p;
        if (start == null) {
            throw new UgyldigListeIndeks(0);
        }

        else {
            T f = siste.data;
            if (start != siste) {
                p = start;
                while (p.neste != siste) {
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

    @Override
    public void sett(int pos, T x) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void leggTil(int pos, T x) throws UnsupportedOperationException{
        throw new UnsupportedOperationException(); 
    }
    
}
