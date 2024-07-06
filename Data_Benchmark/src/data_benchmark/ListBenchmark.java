
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
    
     @Override
    public long eseguiInsTesta(int[] v) {
        long ti = System.currentTimeMillis();
        for (int i = 0; i < v.length; i++) {
            insInTesta(v[i]);
        }
        return System.currentTimeMillis() - ti;
    }

    @Override
    public long eseguiInsCoda(int[] v) {
        long ti = System.currentTimeMillis();
        for (int i = 0; i < v.length; i++) {
            insInCoda(v[i]);
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
            cancellaInPos(p[i]);
        }
        return System.currentTimeMillis() - ti;
    }
    
    //FUNZIONI SINGOLE
    
    int somma() {
        int s = 0;
        NodoBi p = h;
        while (p != null) {
            s = s + p.inf;
            p = p.next;
        }
        return s;
    }

    int sommaIndietro() {
        int s = 0;
        NodoBi p = t;
        while (p != null) {
            s = s + p.inf;
            p = p.prev;
        }
        return s;
    }

    void insInTesta(int valore) {
        NodoBi n = new NodoBi(valore);
        n.next = h; //il next del nuovo elemento punterà all'elemento che sta puntando la testa (non ad h stesso), essendo che n dovrà diventare il suo precendente
        if (t == null) //se non c'è una coda (ovvero non ci sono elementi)
        {
            t = n; //il nuovo elemento diventa la coda
        }
        if (h != null) //se ci sono elementi nella lista
        {
            h.prev = n; //il prev dell'elemento a cui sta puntando la testa(non ad h stesso) sarà il nuovo elemento, essendo che n dovrà diventare il suo precendente
        }
        h = n; //il nuovo elemento diventerà la testa
        this.nElementi++;
    }

    void insInCoda(int valore) {
        NodoBi n = new NodoBi(valore);
        if (t != null) //se la coda punta già ad un elemento presente nella lista
        {
            t.next = n; //essendo che vogliamo inserirne uno nuovo per ultimo, il next dell'elemento a cui sta puntando la coda diventerà il nuovo elemento
        }
        n.prev = t; //l'elemento nuovo punterà all'elemento a cui sta puntando t (non t stesso), essendo che quello dovrà diventare il suo precendente
        t = n; //la coda punterà al nuovo elemento
        if (h == null) //se non ci sono elementi nella lista
        {
            h = n; //il nuovo elemento diventa la testa
        }
    }
    
}
