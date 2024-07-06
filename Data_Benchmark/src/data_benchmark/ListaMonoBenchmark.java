
package data_benchmark;

public class ListaMonoBenchmark extends Benchmark {

    private NodoMono h, t;
    int nElementi; 

    public ListaMonoBenchmark() {
    }

    @Override
    public long eseguiSomma() {
        long ti = System.currentTimeMillis();
        SOP("somma listaMono = " + somma());
        return System.currentTimeMillis() - ti;
    }

    @Override
    public long eseguiSommaIndietro() {
        long ti = System.currentTimeMillis();
        SOP("somma indietro listaMono = " + sommaIndietro());
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
            aggiungiCoda(v[i]);
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
        NodoMono p = h;
        while (p != null) {
            s = s + p.inf;
            p = p.next;
        }
        return s;
    }

    int sommaIndietro() {
        NodoMono copiaInvertita = inverti();
        int s = 0;
        while (copiaInvertita != null) {
            s += copiaInvertita.inf;
            copiaInvertita = copiaInvertita.next;
        }
        return s;
    }

    NodoMono inverti() {
        NodoMono inverti = null, a = h, p;
        while (a != null) {
            p = a.next;
            a.next = inverti;
            inverti = a;
            a = p;
        }
        return inverti;
    }

    void insInTesta(int val) {
        NodoMono n = new NodoMono(val);
        n.next = h; //il next del nuovo elemento punterà all'elemento che sta puntando la testa (non ad h stesso), essendo che n dovrà diventare il suo precendente
        if (t == null) //se non c'è una coda (ovvero non ci sono elementi)
        {
            t = n; //il nuovo elemento diventa la coda
        }
        h = n; //il nuovo elemento diventerà la testa 
    }
    
}
