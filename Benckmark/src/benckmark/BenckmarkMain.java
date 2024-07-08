package benckmark;

import java.io.FileWriter;
import java.io.IOException;

public class BenckmarkMain {

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

        final int n = 10000; //valore dell'array (numero di elementi)
        EspTempoCSV[][] esportazione = new EspTempoCSV[15][6]; //matrice di dati x esportazione 

        int[] vi = new int[n]; //crea un array di n elementi con valri random
        for (int i = 0; i < vi.length; i++) {
            vi[i] = (int) (Math.random() * 1000);
        }

        int[] p = new int[n]; //posizione da inseririre, nuovo array con n posti
        for (int i = 0; i < p.length; i++) //inserisce numeri di posizioni random, all'interno della lunghezza dell'array
        {
            p[i] = (int) (Math.random() * p.length);
        }

        for (int i = 0; i < struttureDati.length; i++) { //esegue tutti i tipi di test, su ongi tipologia di implementazione (x3)
            Benchmark ab = struttureDati[i];
            SOP("ins testa di " + i + " = " + ab.eseguiInsTesta(vi) + " millisecondi");
            SOP("ins coda di " + i + " = " + ab.eseguiInsCoda(vi) + " millisecondi");
            SOP("ins pos di " + i + " = " + ab.eseguiInsInPos(vi, p) + " millisecondi");
            SOP("somma di " + i + " = " + ab.eseguiSomma() + " millisecondi");
            SOP("somma indietro di " + i + " = " + ab.eseguiSommaIndietro() + " millisecondi");
            SOP("canc pos di " + i + " = " + ab.eseguiCancInPos(p) + " millisecondi\n");
        }

        //STRUTTURA PER ESPORTAZIONE A CSV    
        for (int i = 0; i < struttureDati.length; i++) {
            Benchmark ab = struttureDati[i];
            //in base al numero del giro viene identificato come un certo tipo di implementazione, per esportarlo come stringa
            String s = "Array";
            if (i < 6 && i >= 3) {
                s = "Liste Bi";
            }
            if (i < 9 && i >= 6) {
                s = "Liste Mono";
            }
            if (i < 12 && i >= 9) {
                s = "Linked List";
            }
            if (i < 15 && i >= 12) {
                s = "Array List";
            }
            //si crea e si inizializza una matrice per i dati da esportare
            esportazione[i][0] = new EspTempoCSV((int) ab.eseguiInsTesta(vi), s);
            esportazione[i][1] = new EspTempoCSV((int) ab.eseguiInsCoda(vi), s);
            esportazione[i][2] = new EspTempoCSV((int) ab.eseguiInsInPos(vi, p), s);
            esportazione[i][3] = new EspTempoCSV((int) ab.eseguiSomma(), s);
            esportazione[i][4] = new EspTempoCSV((int) ab.eseguiSommaIndietro(), s);
            esportazione[i][5] = new EspTempoCSV((int) ab.eseguiCancInPos(p), s);

        }

        scriviCSV("dati.csv", esportazione);

    }
    //ESPORTAZIONE A CSV

    private static void scriviCSV(String nomeFile, EspTempoCSV[][] matrice) {
        try (FileWriter writer = new FileWriter(nomeFile)) {
            // Scrivi le intestazioni delle colonne
            writer.append("Implementazione,Inserimento in testa, Inserimento in coda, Inserimento in pos, somma, somma indietro, cancellazione in pos\n");

            // Scrivi i dati
            for (int i = 0; i < matrice.length; i++) {
                writer.append(String.format("%s, %d, %d, %d, %d, %d, %d\n",
                        matrice[i][0].getString(), matrice[i][0].getTempo(), matrice[i][1].getTempo(), matrice[i][2].getTempo(), matrice[i][3].getTempo(), matrice[i][4].getTempo(), matrice[i][0].getTempo()));
            }

            System.out.println("Dati scritti con successo nel file " + nomeFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
