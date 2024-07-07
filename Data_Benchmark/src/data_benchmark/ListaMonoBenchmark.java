
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
    
    boolean insInPos(int valore, int pos) {

        if (pos == 0) { //se gli elementi non ci sono o si inseriscono in posizione 0, si mettono in testa
            insInTesta(valore);
            return true;
        }

        NodoMono p; //si crea puntatore a elemento DOPO punto di inserimento

        p = h;
        for (int i = 0; i < pos - 1; i++)//si scorre incrementando, essendo partiti dall'inizio (testa)
        {
            p = p.next;
        }
        //inzio inserimento
        NodoMono n = new NodoMono(valore); //si crea il nuovo elemento da inserire
        n.next = p.next; //quello nuovo punta a quello dopo
        p.next = n;
        this.nElementi++; //si aggiunge 1 al contatore di elementi nella lista
        return true;
    }

    boolean cancellaInPos(int pos) {
        if (pos < 0 || pos >= this.nElementi) {
            // Posizione non valida
            return false;
        }

        if (pos == 0) {
            // Se la posizione è 0, cancella la testa se esiste
            if (this.h != null) {
                this.h = this.h.next;
            }
        } else {
            NodoMono p = this.h;
            for (int i = 0; i < pos - 1; i++) {
                if (p == null) {
                    // Posizione non valida
                    return false;
                }
                p = p.next;
            }

            // Verifica se p o p.next sono null prima di accedere a p.next.next
            if (p != null && p.next != null) {
                p.next = p.next.next;
            } else if (p != null) {
                // Gestisci la rimozione dell'ultimo elemento
                p.next = null;
            } else {
                return false; // Posizione non valida
            }
        }

        this.nElementi--;
        return true;
    }
    
}
