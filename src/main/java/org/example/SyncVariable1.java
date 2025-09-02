package org.example;
import java.math.BigInteger;

//@ThreadSafe
public class SyncVariable1 {
    private BigInteger lastNumber;
    private BigInteger[] lastFactors;
    private long hits;
    private long cashedHits;

    public synchronized long getHits(){return hits;}
    public synchronized double getCashedHits(){
        return (double) cashedHits / (double) hits;
    }

//    public void service(ServletRequest req, ServletResponse resp){
//        BigInteger i = extractFromRequest(req);
//
//    }
}
