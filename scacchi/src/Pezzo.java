
import java.util.ArrayList;

public abstract class Pezzo {
//rappresenta i pezzi posizionabili sulla scacchiera
    
    protected boolean white;
    protected int pos;

    public Pezzo (boolean white) {
        this.white=white;
    }

    abstract char mostraLettera();

    abstract boolean spostamentoPotenziale (Stato s, int target);
    /*true: se il pezzo può muovere nello stato s dalla propria casa alla casa target 
    (che deve essere libera in s)
    da considerare l'arrocco ma non lo scacco*/

    ArrayList<Integer> listaSpostamentoPotenziale (Stato s);
    /*restituisce un arraylist contenente tutte e sole le posizioni della scacchiera 
    verso le quali il pezzo può muovere a partire dallo stato s.
    da considerare l'arrocco ma non lo scacco*/

    abstract boolean attacco (Stato s, int target);
    /*true se e solo se nello stato s il pezzo pone sotto attacco la casa target
    target deve essere libero oppure occupato da un pezzo avversario. 
    non considera lo scacco*/

    ArrayList<Integer> listaAttacco (Stato s) {
    /*restituisce un arraylist contenente tutte e sole le posizioni della scacchiera che
    sono sotto attacco da parte del pezzo nello stato s. 
    le posizioni restituite devono corrispondere a una casa libera oppure occupata da un pezzo avversario. 
    sovrascriverlo nelle sottoclassi*/

        return null;
    }
    
    
    
    public int getPos() {
    	return this.pos;
    }

}
