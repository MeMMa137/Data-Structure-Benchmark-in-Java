package benckmark;

import static benckmark.BenckmarkMain.SOP;
import java.util.ArrayList;

class ArrayListBenchmark implements Benchmark {

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

    @Override
    public long eseguiInsInPos(int[] v, int[] p) {
        long ti = System.currentTimeMillis();
        for (int i = 0; i < v.length; i++) {
            arrayList.add(p[i], v[i]); //pos, val
        }
        return System.currentTimeMillis() - ti;
    }

    @Override
    public long eseguiCancInPos(int[] p) {
        long ti = System.currentTimeMillis();
        for (int i = 0; i < p.length; i++) {
            arrayList.remove(p[i]);
        }
        return System.currentTimeMillis() - ti;
    }
    
    //FUNZIONI SINGOLE

    int somma() {
        int s = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            s += arrayList.get(i);
        }
        return s;
    }

    int sommaIndietro() {
        int s = 0;
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            s += arrayList.get(i);
        }
        return s;
    }

}
