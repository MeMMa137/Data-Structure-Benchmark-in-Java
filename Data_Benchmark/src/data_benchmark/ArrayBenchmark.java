package data_benchmark;

import static data_benckmark.Data_Benchmark.SOP;

class ArrayBenchmark implements Data_Benchmark {

    private int v[]; //array di partenza per mettere tutte le implmentazioni sullo stesso piano

    ArrayBenchmark() {
        v = new int[0]; //inizializza vuoto
    }
    @Override
    public long eseguiSomma() {
        long ti = System.currentTimeMillis();
        SOP("VALORE somma = " + somma());
        return System.currentTimeMillis() - ti;
    }

    @Override
    public long eseguiSommaIndietro() {
        long ti = System.currentTimeMillis();
        SOP("VALORE somma = " + sommaIndietro());
        return System.currentTimeMillis() - ti;
    }

    @Override
    public long eseguiInsTesta(int[] v) {
        long ti = System.currentTimeMillis();
        for (int i = 0; i < v.length; i++) {
            insTesta(v[i]);
        }
        return System.currentTimeMillis() - ti;
    }

    @Override
    public long eseguiInsCoda(int[] v) {
        long ti = System.currentTimeMillis();
        for (int i = 0; i < v.length; i++) {
            insCoda(v[i]);
        }
        return System.currentTimeMillis() - ti;
    }

    @Override
    public long eseguiInsInPos(int[] v, int[] p) {
        long ti = System.currentTimeMillis();
        for (int i = 0; i < v.length; i++) {
            insInPos(v[i], p[i]);
        }
        return System.currentTimeMillis() - ti;
    }

    @Override
    public long eseguiCancInPos(int[] p) {
        long ti = System.currentTimeMillis();
        for (int i = 0; i < p.length; i++) {
            cancInPos(p[i]);
        }
        return System.currentTimeMillis() - ti;
    }
    
    //FUNZIONI SINGOLE
    int somma() {
        int s = 0;
        for (int i = 0; i < v.length; i++) {
            s += v[i];
        }
        return s;
    }

    int sommaIndietro() {
        int s = 0;
        for (int i = v.length - 1; i >= 0; i--) {
            s += v[i];
        }
        return s;
    }

    void insTesta(int val) {
        int[] nv = new int[v.length + 1];
        nv[0] = val;
        for (int i = 0; i < v.length; i++) {
            nv[i + 1] = v[i];
        }
        v = nv;
    }

    void insCoda(int val) {
        int[] nv = new int[v.length + 1];
        nv[v.length] = val;
        for (int i = 0; i < v.length; i++) {
            nv[i] = v[i];
        }
        v = nv;
    }
    
     void insInPos(int val, int p) {
        int[] nv = new int[v.length + 1];
        nv[p] = val;
        for (int i = 0; i < p; i++) {
            nv[i] = v[i];
        }
        for (int i = p + 1; i < v.length; i++) {
            nv[i + 1] = v[i];
        }
        v = nv;
    }

    boolean cancInPos(int p) {
        if (v.length == 0) {
            return false;
        }
        if (p <= 0 || p >= v.length) {
            return false;
        }
        int[] nv = new int[v.length - 1];
        for (int i = 0; i < p; i++) {
            nv[i] = v[i];
        }
        for (int i = p + 1; i < v.length; i++) {
            nv[i - 1] = v[i];
        }
        v = nv;
        return true;
    }
    
}
