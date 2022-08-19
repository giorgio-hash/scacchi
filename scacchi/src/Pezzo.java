
import java.util.ArrayList;

public abstract class Pezzo implements Cloneable{
//rappresenta i pezzi posizionabili sulla scacchiera
    
    protected boolean white;
   
    private char lettera;
    private int numMosse;
    private int id;
    
    private static int idgen = 0;
    
    

    public Pezzo (boolean white,char lettera) {
        this.white=white;
        this.lettera = lettera;
        numMosse = 0;
        id = idgen++;
    }

    

    /**
     * 
     * true: se il pezzo può muovere nello stato s dalla propria casa alla casa target 
    (che deve essere libera in s)
    da considerare l'arrocco ma non lo scacco
     * 
     */
    abstract boolean spostamentoPotenziale (Stato s, int target);
    /*true: se il pezzo puÃ² muovere nello stato s dalla propria casa alla casa target 
    (che deve essere libera in s)
    da considerare l'arrocco ma non lo scacco*/

    /**
     * restituisce un arraylist contenente tutte e sole le posizioni della scacchiera 
     * verso le quali il pezzo può muovere a partire dallo stato s.<br>
     * da considerare l'arrocco ma non lo scacco
     * 
     * @param s : Stato
     */
    abstract ArrayList<Integer> listaSpostamentoPotenziale (Stato s);
    /*restituisce un arraylist contenente tutte e sole le posizioni della scacchiera 
    verso le quali il pezzo puÃ² muovere a partire dallo stato s.
    da considerare l'arrocco ma non lo scacco*/

    
    /**
     * 
     * 
     * @param s : <i>Stato</i> stato
     * @param target : <i>int</i> target 
     * @return <i>boolean</i>
     */
    abstract boolean attacco (Stato s, int target);
    /*true se e solo se nello stato s il pezzo pone sotto attacco la casa target
    target deve essere libero oppure occupato da un pezzo avversario. 
    non considera lo scacco*/

    
    /**
     * restituisce un arraylist contenente tutte e sole le posizioni della scacchiera che
    sono sotto attacco da parte del pezzo nello stato s. 
    <br>le posizioni restituite devono corrispondere a una casa libera oppure occupata da un pezzo avversario. 
     * 
     * 
     * 
     */
    ArrayList<Integer> listaAttacco (Stato s) {
    /*restituisce un arraylist contenente tutte e sole le posizioni della scacchiera che
    sono sotto attacco da parte del pezzo nello stato s. 
    le posizioni restituite devono corrispondere a una casa libera oppure occupata da un pezzo avversario. 
    sovrascriverlo nelle sottoclassi*/

        return null;
    }
    
    
    
  
    
    public char mostraLettera() {
    	return lettera;
    }
    
    public int getId() {
    	
    	return id;
    	
    }
    
    public void registraMossa() {
    	
    	numMosse++;
    	
    }
    
    /**
     * quante volte il pezzo è stato mosso
     * @return numero mosse
     */
    public int getNumMosse() {
    	return numMosse;
    }

    public String toString() {
    	return id+":"+lettera;
    }
    
    
}
