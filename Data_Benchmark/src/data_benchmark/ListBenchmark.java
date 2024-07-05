
package data_benchmark;

import static benckmark.BenckmarkMain.SOP;

public class ListBenchmark extends Benchmark {

     private NodoBi h, t; 
    int nElementi; 
    
    public ListBenchmark() {
        h = null;
        t = null;
        nElementi = 0;
    }
    
     @Override
    public long eseguiSomma() {
        long ti = System.currentTimeMillis();
        SOP("VALORE somma listaBi = " + somma());
        return System.currentTimeMillis() - ti;
    }

    @Override
    public long eseguiSommaIndietro() {
        long ti = System.currentTimeMillis();
        SOP("VALORE somma listaBi = " + sommaIndietro());
        return System.currentTimeMillis() - ti;
    }
    
}
