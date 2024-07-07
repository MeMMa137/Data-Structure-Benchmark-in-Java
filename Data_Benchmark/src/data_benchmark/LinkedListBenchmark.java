
package data_benchmark;

import static benckmark.data_benckmark.SOP;
import java.util.LinkedList;

public class LinkedListBenchmark extends Benchmark {

     LinkedList<Integer> lista;
     
    public LinkedListBenchmark() {
        lista = new LinkedList<>();
    }
    
    @Override
    public long eseguiSomma() {
        long ti = System.currentTimeMillis();
        SOP("somma linkedList = " + somma());
        return System.currentTimeMillis() - ti;
    }

    @Override
    public long eseguiSommaIndietro() {
        long ti = System.currentTimeMillis();
        SOP("somma indietro linkedList = " + sommaIndietro());
        return System.currentTimeMillis() - ti;
    }

    @Override
    public long eseguiInsTesta(int[] v) {
        long ti = System.currentTimeMillis();
        for (int i = 0; i < v.length; i++) {
            lista.addFirst(v[i]);
        }
        return System.currentTimeMillis() - ti;
    }

    @Override
    public long eseguiInsCoda(int[] v) {
        long ti = System.currentTimeMillis();
        for (int i = 0; i < v.length; i++) {
            lista.addLast(v[i]);
        }
        return System.currentTimeMillis() - ti;
    }
    
}
