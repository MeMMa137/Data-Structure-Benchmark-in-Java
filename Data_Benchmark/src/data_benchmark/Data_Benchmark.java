
package data_benchmark;

import java.io.FileWriter;
import java.io.IOException;

public class Data_Benchmark {

     static void SOP(String s) {
        System.out.println(s);
    }
     
    public static void main(String[] args) {
        Benchmark[] struttureDati = { //crea un array di oggetti che implementano l'interfaccia

            new ArrayBenchmark(),
            new ArrayBenchmark(),
            new ArrayBenchmark(),
            new ListBenchmark(),
            new ListBenchmark(),
            new ListBenchmark(),
            new ListaMonoBenchmark(),
            new ListaMonoBenchmark(),
            new ListaMonoBenchmark(),
            new LinkedListBenchmark(),
            new LinkedListBenchmark(),
            new LinkedListBenchmark(),
            new ArrayListBenchmark(),
            new ArrayListBenchmark(),
            new ArrayListBenchmark()
        };
    }
    
}
