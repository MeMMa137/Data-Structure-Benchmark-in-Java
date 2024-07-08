
package benckmark;

public class EspTempoCSV {
int valTempo;
 String s;
    public EspTempoCSV(int valTempo, String stringa) {
        this.valTempo=valTempo;
        this.s=stringa;
    }
    
    int getTempo(){
        return valTempo;
    }
    
    String getString(){
        return s;
    } 
    
}
