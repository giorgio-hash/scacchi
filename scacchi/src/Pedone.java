
import java.util.ArrayList;

public class Pedone extends Pezzo {
	//private Pedone p = new Pedone(white);
	
    public Pedone (boolean white) {
        super(white,white?'P':'p');
    }

  

    //MANCA ARROCCO E POSIZIONE TRA I PIEDI(SE DEVO ANDARE IN TARGET MA DI MEZZO C'E' UN PEZZO NON CI POSSO ANDARE!)
    //MANCA PRIMA MOSSA--> PUO' FARE DUE PASSI IN AVANTI IL PEDONE
    @Override
    boolean spostamentoPotenziale (Stato s, int target){
    /*true: se il pezzo può muovere nello stato s dalla propria casa alla casa target 
    (che deve essere libera in s)
    da considerare l'arrocco ma non lo scacco*/
  
    	//VALUTARE ANCHE SE E' LA PRIMA MOSSA--> PEDONE PU0' FARE DUE PASSI IN AVANTI INVECE DI UNO NELLA PRIMA MOSSA
    	int from = p.getPos();
    	Scacchiera scacchiera = s.getScacchiera();
    	//allora la posizione è libera ci posso andare con il pedone
    	//distinzione giocatore bianco o nero 
    	int giocatore = s.getGiocatore();
    	int contatore = s.getContatore();
    	//VALUTARE MOSSA NR.1--> due posizioni in avanti sono lo spostamento potenziale per un pedone
    	//giocatore bianco
    	if(giocatore == 1) {
    		if(scacchiera.ifOccupata(target) == false && target == from + 1) { 
    			return true;
    	}else if(giocatore == 2){ //giocatore neri
    		if(scacchiera.ifOccupata(target) == false && target == from - 1 ) { 
        		return true;
    	}}
    	}
    		return false;
    }

    @Override
    ArrayList<Integer> listaSpostamentoPotenziale (Stato s) {
    /*restituisce un arraylist contenente tutte e sole le posizioni della scacchiera 
    verso le quali il pezzo può muovere a partire dallo stato s.
    da considerare l'arrocco ma non lo scacco*/
    ArrayList<Integer> lista = new ArrayList<>();
    	//fare i controlli ed inserire nell'arrayList;
    	
    
    
    
    
    return lista;
    };

    @Override
    boolean attacco (Stato s, int target){
    /*true se e solo se nello stato s il pezzo pone sotto attacco la casa target
    target deve essere libero oppure occupato da un pezzo avversario. 
    non considera lo scacco*/
        Scacchiera c = s.getScacchiera();
        // il pedone pone in attacco solo se punta in avanti-obliquo
        int from = p.getPos();
        	int giocatore = s.getGiocatore();
        	//se sono bianco, quindi se giocatore == 1
        	Pezzo pezzoTarget = c.getPezzo(target);
        	if(c.getColorePezzo(pezzoTarget) == true && giocatore == 2) {
        		if((c.ifOccupata(target) == true)
        				&& (target == ((pos-10)-1) || target == ((from+10)-1))) {
    						return true;
        			}
        	}else if(c.getColorePezzo(pezzoTarget) == false && giocatore == 1){
        	//se sono nero
        		if((c.ifOccupata(target) == true && giocatore == 1) 
        				&& (target == ((from-10)+1) || target == ((from+10)+1))) {
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
    	ArrayList<Integer> lista = new ArrayList<>();
    	//fare i controlli ed inserire nell'arrayList;
    	
    	return lista;
    }

	
    	
   
    
}
