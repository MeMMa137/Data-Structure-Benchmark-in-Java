
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
    
    @Override
    public long eseguiInsInPos(int[] v, int[] p) {
        long ti = System.currentTimeMillis();
        for (int i = 0; i < v.length; i++) {
            lista.add(p[i], v[i]); //pos, val
        }
        return System.currentTimeMillis() - ti;
    }

    @Override
    public long eseguiCancInPos(int[] p) {
        long ti = System.currentTimeMillis();
        for (int i = 0; i < p.length; i++) {
            lista.remove(p[i]);
        }
        return System.currentTimeMillis() - ti;
    }
    
    //FUNZIONI SINGOLE

    int somma() {
        int s = 0;
        for (int i = 0; i < lista.size(); i++) {
            s += lista.get(i);
        }
        return s;
    }

    int sommaIndietro() {
        int s = 0;
        for (int i = lista.size() - 1; i >= 0; i--) {
            s += lista.get(i);
        }
        return s;
    }
    
}
