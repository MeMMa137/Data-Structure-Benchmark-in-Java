
package data_benchmark;

import static benckmark.BenckmarkMain.SOP;
import java.util.ArrayList;

public class ArrayListBenchmark extends Benchmark {

   ArrayList<Integer> arrayList;

    public ArrayListBenchmark() {
        arrayList = new ArrayList<>();
    }

    @Override
    public long eseguiSomma() {
        long ti = System.currentTimeMillis();
        SOP("somma arrayList = " + somma());
        return System.currentTimeMillis() - ti;
    }

    @Override
    public long eseguiSommaIndietro() {
        long ti = System.currentTimeMillis();
        SOP("somma indietro arrayList = " + sommaIndietro());
        return System.currentTimeMillis() - ti;
    }

    @Override
    public long eseguiInsTesta(int[] v) {
        long ti = System.currentTimeMillis();
        for (int i = 0; i < v.length; i++) {
            arrayList.add(0, v[i]);
        }
        return System.currentTimeMillis() - ti;
    }

    @Override
    public long eseguiInsCoda(int[] v) {
        long ti = System.currentTimeMillis();
        for (int i = 0; i < v.length; i++) {
            arrayList.add(v[i]);
        }
        return System.currentTimeMillis() - ti;
    }
    
}
