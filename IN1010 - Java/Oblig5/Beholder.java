import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Beholder {
    public static int finnsIHM = 0;
    public static int finnsIkkeIHM = 0;
    private ArrayList<HashMap<String, SubSekvens>> beholder = new ArrayList<HashMap<String, SubSekvens>>();
    private int antall = 0;
    private static ReentrantLock lock = new ReentrantLock();
    
    static HashMap<String, SubSekvens> slaaSammenMaps(HashMap<String, SubSekvens> hm1, HashMap<String, SubSekvens> hm2) {
    
        HashMap<String, SubSekvens> nyHashMap= new HashMap<String, SubSekvens>();
        SubSekvens hentaSub;

        for(SubSekvens sub1 : hm1.values()) {
            hentaSub = hm2.remove(sub1.hentSubSekvens());
            //Finnes ikke i hm2
            if(hentaSub == null) {
                nyHashMap.put(sub1.hentSubSekvens(), sub1);
                finnsIkkeIHM++;
            }
            // finnes i hm2, må plusses
            else{
                int ant = hentaSub.hentAntallForekomster();
                SubSekvens subben = new SubSekvens(sub1.hentSubSekvens());
                subben.settAntallForekomster(sub1.hentAntallForekomster());
                subben.leggTil(ant);
                nyHashMap.put(sub1.hentSubSekvens(), subben);
                finnsIHM++;
            }
        } 
        for(SubSekvens sub2 : hm2.values()) {
            nyHashMap.put(sub2.hentSubSekvens(), sub2);
            }
        
        return nyHashMap;  
    }
                     
    public HashMap<String, SubSekvens> hentHashMap(int pos) {
        return beholder.get(pos);
    }

    public void settInnHashMap(HashMap<String, SubSekvens> hashMap) {
        lock.lock();
        try {
            beholder.add(hashMap);
        }
        finally{
            lock.unlock();
        }
    }

    public int antallHashMaps() {
        return beholder.size();
    }
    
    public int antall() {return antall;}

    public HashMap<String, SubSekvens> hentEn() {
        lock.lock();
        try {
            antall--;
            return beholder.remove(0);
            }
        finally{
            lock.unlock();
        }
    }
}   


