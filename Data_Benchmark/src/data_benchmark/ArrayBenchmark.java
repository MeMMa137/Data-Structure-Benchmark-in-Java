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
    
}
