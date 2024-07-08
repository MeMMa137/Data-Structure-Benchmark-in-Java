package benckmark;

public interface Benchmark {
    long eseguiSomma();
    long eseguiSommaIndietro();
    long eseguiInsTesta(int[] v);
    long eseguiInsCoda(int[] v);
    long eseguiInsInPos(int[] v,int[] p);
    long eseguiCancInPos(int[] p);
}
//serve ad importare tutto insieme le funzioni (+ veloce)