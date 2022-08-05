
import java.util.ArrayList;

public class Cavallo extends Pezzo {
	//private Cavallo p = new Cavallo(white);
	
	
    public Cavallo (boolean white) {
        super(white,white?'N':'n');
    }
    
    

    //MANCA ARROCCO E POSIZIONE TRA I PIEDI(SE DEVO ANDARE IN TARGET MA DI MEZZO C'E' UN PEZZO NON CI POSSO ANDARE!)
    
    @Override
    boolean spostamentoPotenziale (Stato s, int target){
    /*true: se il pezzo può muovere nello stato s dalla propria casa alla casa target 
    (che deve essere libera in s)
    da considerare l'arrocco ma non lo scacco*/
    	int from = s.scacchiera.getPos(p);
    	Scacchiera scacchiera = s.getScacchiera();
    	//allora la posizione è libera ci posso andare con il cavallo->MA DEVE RIENTRARE NELLE MOSSE POTENZIALI DEL CAVALLO
    	//AD L
    	int giocatore = s.getGiocatorePM();
    	//se il giocatore è il bianco 
    	if(giocatore == 1) {
  
    		if(scacchiera.ifOccupata(target) == false && (target == (from - 10) + 2 || target == (from + 10) + 2
    				|| target == (from + 20) + 1) || target == (from - 20) + 1)
    		 	{
    					return true;
    		 	}
    	}else if(giocatore == 2) {	// se il giocatore è il nero
    		if(scacchiera.ifOccupata(target) == false && (target == (from + 10) - 2 || target == (from - 10) - 2
    				|| target == (from + 20) - 1 || target == (from - 20) - 1 )){
    					return true;
    				}
    	}
    
        return false;
    }

    @Override
    ArrayList<Integer> listaSpostamentoPotenziale (Stato s) {
    /*restituisce un arraylist contenente tutte e sole le posizioni della scacchiera 
    verso le quali il pezzo può muovere a partire dallo stato s.
    da considerare l'arrocco ma non lo scacco*/
    
    return null;
    };

    @Override
    boolean attacco (Stato s, int target){
    /*true se e solo se nello stato s il pezzo pone sotto attacco la casa target
    target deve essere libero oppure occupato da un pezzo avversario. 
    non considera lo scacco*/
    	 	Scacchiera c = s.getScacchiera();
         	int giocatore = s.getGiocatorePM();
         	Pezzo pezzoTarget = c.getPezzo(target);
         	int from = s.scacchiera.getPos(p);
         	//se il giocatore è il bianco e il pezzo target è il nero
         	if(c.ifOccupata(target) == true) {
         		if((c.getColorePezzo(pezzoTarget) == true && giocatore == 2)
         				&& (target == (from - 10) + 2 || target == (from + 10) + 2
        				|| target == (from + 20) + 1 || target == (from - 20) + 1)) {
        					
     						return true;
         			}
         	}else if(c.ifOccupata(target) == true){
         		//se il giocatore è il nero e il pezzo target è il bianco
         		if((c.getColorePezzo(pezzoTarget) == false && giocatore == 1 ) 
         				&& (target == (from + 10) - 2 || target == (from - 10) - 2
        				|| target == (from + 20) - 1 || target == (from - 20) - 1 )) {
             				return true;
         		}
         	}
         return false;
    }

    @Override
    ArrayList<Integer> listaAttacco (Stato s) {
    /*restituisce un arraylist contenente tutte e sole le posizioni della scacchiera che
    sono sotto attacco da parte del pezzo nello stato s. 
    le posizioni restituite devono corrispondere a una casa libera oppure occupata da un pezzo avversario. 
    sovrascriverlo nelle sottoclassi*/

    return null;
    }
	
    
}
