package benckmark;

import static benckmark.BenckmarkMain.SOP;

public class ListBenchmark implements Benchmark {

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

    void cancellaInPos(int pos) {
        NodoBi p = h; //parte dalla testa
        for (int i = 0; i < pos; i++) {
            p = p.next; //il puntatore scorre
        }
        if (p.prev == null) { //se è il primo basterà far puntare la testa a quello successivo
            h = p.next;
        } else {
            p.prev.next = p.next; //il precedente di quello da cancellare punta al successivo di quello da cancellare
        }
        if (p.next == null) { //se è l'ultimo basterà far puntare la coda a quello precedente
            t = p.prev;
        } else {
            p.next.prev = p.prev; //il successivo di quello da cancellare punta al precedente di quello da cancellare
        }
    }

    boolean insInPos(int valore, int pos) {
        if (pos < 0 || pos > nElementi) //se la posizione da input è fuori dalla lista, non si mette
        {
            return false;
        }
        if (nElementi == 0 || pos == 0) { //se gli elementi non ci sono o si inseriscono in posizione 0, si mettono in testa
            insInTesta(valore);
            return true;
        }
        if (pos == nElementi) { //se la posizione è alla fine, si inserisce in coda           
            insInCoda(valore);
            return true;
        }

        NodoBi p; //si crea puntatore a elemento DOPO punto di inserimento

        if (pos > nElementi / 2) { //se conviene(posizione supera la metà degli elementi) si parte dal fondo (cosa) a cercare il punto
            p = t;
            for (int i = nElementi - 1; i >= pos; i--) //si scorre decrementando, essendo partiti dal fondo (coda)
            {
                p = p.prev; //anche il puntatore scorre passando all'elemento prima di se stesso
            }
        } else { //se conviene(posizione è sotto la metà degli elementi) si parte dall'inizio (testa) a cercare il punto
            p = h;
            for (int i = 0; i < pos; i++)//si scorre incrementando, essendo partiti dall'inizio (testa)
            {
                p = p.next;
            }
        }

        //INIZIO INSERIMENTO
        NodoBi n = new NodoBi(valore); //si crea il nuovo elemento da inserire
        p.prev.next = n; //quello prima, punta a quello nuovo
        n.prev = p.prev; //quello nuovo punta a quello prima
        p.prev = n; //quello dopo punta a quello nuovo
        n.next = p; //quello nuovo punta a quello dopo
        this.nElementi++; //si aggiunge 1 al contatore di elementi nella lista
        return true;

    }

}
