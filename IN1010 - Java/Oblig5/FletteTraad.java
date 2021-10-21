import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class FletteTraad implements Runnable {
    HashMap<String, SubSekvens> hashMap1 = null;
    HashMap<String, SubSekvens> hashMap2 = null;
    Beholder minb;
    int antallTraader = 0;
    boolean smittet;
    CountDownLatch minCdl;
    static int fletteTraadTeller = 0;
    private static ReentrantLock lock = new ReentrantLock();

    
    public FletteTraad(Beholder b1, CountDownLatch cdl){ 
        minCdl = cdl;
        minb = b1;
    }

    public void run() {
        while(minb.antallHashMaps() > 1) {
            HashMap<String, SubSekvens> res = Beholder.slaaSammenMaps(minb.hentEn(), minb.hentEn());
            minb.settInnHashMap(res);
        }
        oekTeller();
        oekTermTeller();
        minCdl.countDown();
    }
    
    static void oekTeller() {
        lock.lock();
        try {
            fletteTraadTeller++;
        }
        finally {
            lock.unlock();
        }
    }

    static void oekTermTeller() {
        lock.lock();
        try {
            TestProgram2.antallTraaderTerm++;
        }
        finally {
            lock.unlock();
        }
    }
    
}
