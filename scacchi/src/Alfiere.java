
import java.util.ArrayList;

public class Alfiere extends Pezzo {
	private Alfiere p = new Alfiere(white); //perch� un'istanza di alfiere dentro alfiere stesso??
	
	
	
	
	
    public Alfiere (boolean white) {
        super(white);
    }

    @Override
    char mostraLettera () {
        if (white==true){ 
            return 'B';
        } else {
            return 'b';
       }
    }

    
    
    //MANCA ARROCCO E POSIZIONE TRA I PIEDI(SE DEVO ANDARE IN TARGET MA DI MEZZO C'E' UN PEZZO NON CI POSSO ANDARE!)
    
    @Override
    boolean spostamentoPotenziale (Stato s, int target){
    /*true: se il pezzo può muovere nello stato s dalla propria casa alla casa target 
    (che deve essere libera in s)
    da considerare l'arrocco ma non lo scacco*/
      	int from = p.getPos();
    	Scacchiera scacchiera = s.getScacchiera();
    	//allora la posizione è libera ci posso andare con l'alfiere    	
    	int giocatore = s.getGiocatore();
    		//movimenti a sinistra obl. , destra obl., andando avanti e indietro quindi non solo in AVANZAMENTO
    		if(scacchiera.ifOccupata(target) == false) {
    			//bisogno di un ciclo per valutare i movimenti target possibili 
    			for(int i = 1 ; i <= 7; i ++){
   				  		int n = 10;
   				  		if(target == (from - n) + i || target == (from + n) + i ){
   				 			return true;
   				 		}	
   				  		n = n + 10;
   				 }
    			for(int i = 1 ; i <= 7; i ++){
				  		int n = 10;
				  		if(target == (from - n) - i || target == (from + n) - i){
				 			return true;
				 		}	
				  		n = n + 10;
				 }
    			return false;
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
      	int giocatore = s.getGiocatore();
      	Pezzo pezzoTarget = c.getPezzo(target);
      	int from = p.getPos();
      	//se il giocatore è il bianco e il pezzo target è il nero
      	if(c.ifOccupata(target) == true) {
      		if((c.getColorePezzo(pezzoTarget) == true && giocatore == 2)) {
        			//bisogno di un ciclo per valutare i movimenti target possibili 
        			for(int i = 1 ; i <= 7; i ++){
       				  		int n = 10;
       				  		if(target == (from - n) + i || target == (from + n) + i ){
       				 			return true;
       				 		}	
       				  		n = n + 10;
       				 }
        			for(int i = 1 ; i <= 7; i ++){
    				  		int n = 10;
    				  		if(target == (from - n) - i || target == (from + n) - i){
    				 			return true;
    				 		}	
    				  		n = n + 10;
    				 }
      	} else if(c.ifOccupata(target) == true){
      		//se il giocatore è il nero e il pezzo target è il bianco
      		if((c.getColorePezzo(pezzoTarget) == false && giocatore == 1 )) {
      			for(int i = 1 ; i <= 7; i ++){
				  		int n = 10;
				  		if(target == (from - n) + i || target == (from + n) + i ){
				 			return true;
				 		}	
				  		n = n + 10;
				 }
      			for(int i = 1 ; i <= 7; i ++){
			  			int n = 10;
			  			if(target == (from - n) - i || target == (from + n) - i){
			  				return true;
			 		}	
			  			n = n + 10;
      				}
      			}
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
