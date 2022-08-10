
import java.util.ArrayList;

public class Cavallo extends Pezzo {
	//private Cavallo p = new Cavallo(white);
	
	
    public Cavallo (boolean white) {
        super(white,white?'N':'n');
    }
    
    

    //MANCA ARROCCO E POSIZIONE TRA I PIEDI(SE DEVO ANDARE IN TARGET MA DI MEZZO C'E' UN PEZZO NON CI POSSO ANDARE!)
    
    @Override
    boolean spostamentoPotenziale (Stato s, int target){
    /*/*true: se il pezzo puÃ² muovere nello stato s dalla propria casa alla casa target 
    (che deve essere libera in s)
    da considerare l'arrocco ma non lo scacco
    	int from = s.scacchiera.getPos(this);
    	Scacchiera scacchiera = s.getScacchiera();
    	//allora la posizione Ã¨ libera ci posso andare con il cavallo->MA DEVE RIENTRARE NELLE MOSSE POTENZIALI DEL CAVALLO
    	//AD L
    	int giocatore = s.getGiocatorePM();
    	//se il giocatore Ã¨ il bianco 
    	if(giocatore == 1) {
  
    		if(scacchiera.ifOccupata(target) == false && (target == (from - 10) + 2 || target == (from + 10) + 2
    				|| target == (from + 20) + 1) || target == (from - 20) + 1)
    		 	{
    					return true;
    		 	}
    	}else if(giocatore == 2) {	// se il giocatore Ã¨ il nero
    		if(scacchiera.ifOccupata(target) == false && (target == (from + 10) - 2 || target == (from - 10) - 2
    				|| target == (from + 20) - 1 || target == (from - 20) - 1 )){
    					return true;
    				}
    	}
    
        return false;*/
    	
    	return s.getScacchiera().ifOccupata(target)?false:listaSpostamentoPotenziale(s).contains(target);
    }

    
    
    @Override
    ArrayList<Integer> listaSpostamentoPotenziale (Stato s) {
    /*restituisce un arraylist contenente tutte e sole le posizioni della scacchiera 
    verso le quali il pezzo puÃ² muovere a partire dallo stato s.
    da considerare l'arrocco ma non lo scacco*/
    
    	int posizione = s.getScacchiera().getPos(this);
        
    	ArrayList<Integer> lista = new ArrayList<Integer>();
    	
    	
    	/*
    	da 55 può andare a 

		ovest
		34		34-55 =-21	so
		36		36-55 = -19	no
		
		sud
		43		43-55 = -12 so
		63		63-55 = 8 se
		
		est
		74		74-55 = 19 se
		76		76-55 = 21 ne
		
		nord
		67		67-55 = 12 se
		47		47-55 = -8 no
    	
    	le caselle vanno da 11 a 88
    	*/
    	
    	//				 so	 no	 so	 se se ne se no
    	int[] offsets = {-21,-19,-12,8,19,21,12,-8};
    	
    	for(int i=0; i<offsets.length;i++)
    		if( (posizione + offsets[i]) >10 && (posizione + offsets[i]) <89 && (posizione + offsets[i])%10 != 0) {
    			if(!s.getScacchiera().ifOccupata((posizione + offsets[i])))
    				lista.add((posizione + offsets[i]));	
    			}
    		
    	
    	int c_from = posizione / 10;
    	int r_from = posizione % 10;
    	int target = 0;
    	int c_to = 0;
    	int r_to = 0;
    	
    	for(int i=0; i<offsets.length; i++) {
    		
    		target = lista.get(i);
    		c_to = target / 10;
    		r_to = target % 10;
    		
    		switch(r_to - r_from) {
    		
    				case 2: //nord
    					if(!s.getScacchiera().ifOccupata(target-1) && !s.getScacchiera().ifOccupata(target-2))
    							break;//se le due caselle sotto alla casella target sono libere, la mossa è legale
    						
    						if(!s.getScacchiera().ifOccupata(posizione+1) && !s.getScacchiera().ifOccupata(posizione+2))
    							break;//se le due caselle sopra la posizione iniziale sono libere, la mossa è legale
    						
    						//altrimenti la mossa non è legale: elimina il target
    						lista.remove(i);
    					break;
    		
    				case -2: //sud
	    					if(!s.getScacchiera().ifOccupata(target+1) && !s.getScacchiera().ifOccupata(target+2))
								break;//se le due caselle sopra alla casella target sono libere, la mossa è legale
							
							if(!s.getScacchiera().ifOccupata(posizione-1) && !s.getScacchiera().ifOccupata(posizione-2))
								break;//se le due caselle sotto la posizione iniziale sono libere, la mossa è legale
							
							//altrimenti la mossa non è legale: elimina il target
							lista.remove(i);
						break;
    					
						
    				default:
    					switch(c_to - c_from) {
    					
    						case 2: //est
    							if(!s.getScacchiera().ifOccupata(target-10) && !s.getScacchiera().ifOccupata(target-20))
        							break;//se le due caselle a sx della casella target sono libere, la mossa è legale
        						
        						if(!s.getScacchiera().ifOccupata(posizione+10) && !s.getScacchiera().ifOccupata(posizione+20))
        							break;//se le due caselle a dx della posizione iniziale sono libere, la mossa è legale
        						
        						//altrimenti la mossa non è legale: elimina il target
        						lista.remove(i);
        					break;
        					
    						case -2: //ovest
    							if(!s.getScacchiera().ifOccupata(target+10) && !s.getScacchiera().ifOccupata(target+20))
        							break;//se le due caselle a dx della casella target sono libere, la mossa è legale
        						
        						if(!s.getScacchiera().ifOccupata(posizione-10) && !s.getScacchiera().ifOccupata(posizione-20))
        							break;//se le due caselle a sx della posizione iniziale sono libere, la mossa è legale
        						
        						//altrimenti la mossa non è legale: elimina il target
        						lista.remove(i);
        					break;
    					
        					default:
    					}
    		}
    		
    	}
    
    	
        return lista;
    
    };

    
    
    @Override
    boolean attacco (Stato s, int target){
    /*true se e solo se nello stato s il pezzo pone sotto attacco la casa target
    target deve essere libero oppure occupato da un pezzo avversario. 
    non considera lo scacco*/
    	 	/*Scacchiera c = s.getScacchiera();
         	int giocatore = s.getGiocatorePM();
         	Pezzo pezzoTarget = c.getPezzo(target);
         	int from = s.getScacchiera().getPos(p);
         	//se il giocatore Ã¨ il bianco e il pezzo target Ã¨ il nero
         	if(c.ifOccupata(target) == true) {
         		if((c.getColorePezzo(pezzoTarget) == true && giocatore == 2)
         				&& (target == (from - 10) + 2 || target == (from + 10) + 2
        				|| target == (from + 20) + 1 || target == (from - 20) + 1)) {
        					
     						return true;
         			}
         	}else if(c.ifOccupata(target) == true){
         		//se il giocatore Ã¨ il nero e il pezzo target Ã¨ il bianco
         		if((c.getColorePezzo(pezzoTarget) == false && giocatore == 1 ) 
         				&& (target == (from + 10) - 2 || target == (from - 10) - 2
        				|| target == (from + 20) - 1 || target == (from - 20) - 1 )) {
             				return true;
         		}
         	}
         return false;*/
    	
    	return listaAttacco(s).contains(target);
    }

    @Override
    ArrayList<Integer> listaAttacco (Stato s) {
    /*restituisce un arraylist contenente tutte e sole le posizioni della scacchiera che
    sono sotto attacco da parte del pezzo nello stato s. 
    le posizioni restituite devono corrispondere a una casa libera oppure occupata da un pezzo avversario. 
    sovrascriverlo nelle sottoclassi*/
    	
    	int posizione = s.getScacchiera().getPos(this);
        
    	ArrayList<Integer> lista = new ArrayList<Integer>();
    	
    	
    	/*
    	da 55 può andare a 

		ovest
		34		34-55 =-21	so
		36		36-55 = -19	no
		
		sud
		43		43-55 = -12 so
		63		63-55 = 8 se
		
		est
		74		74-55 = 19 se
		76		76-55 = 21 ne
		
		nord
		67		67-55 = 12 se
		47		47-55 = -8 no
    	
    	le caselle vanno da 11 a 88
    	*/
    	
    	//				 so	 no	 so	 se se ne se no
    	int[] offsets = {-21,-19,-12,8,19,21,12,-8};
    	
    	for(int i=0; i<offsets.length;i++)
    		if( (posizione + offsets[i]) >10 && (posizione + offsets[i]) <89 && (posizione + offsets[i])%10 != 0 ) {
    			if(!s.getScacchiera().ifOccupata((posizione + offsets[i])) || s.sottoAttacco(posizione + offsets[i], white))
    				lista.add((posizione + offsets[i]));	
    			}
    		
    	
    	int c_from = posizione / 10;
    	int r_from = posizione % 10;
    	int target = 0;
    	int c_to = 0;
    	int r_to = 0;
    	
    	for(int i=0; i<offsets.length; i++) {
    		
    		target = lista.get(i);
    		c_to = target / 10;
    		r_to = target % 10;
    		
    		switch(r_to - r_from) {
    		
    				case 2: //nord
    					if(!s.getScacchiera().ifOccupata(target-1) && !s.getScacchiera().ifOccupata(target-2))
    							break;//se le due caselle sotto alla casella target sono libere, la mossa è legale
    						
    						if(!s.getScacchiera().ifOccupata(posizione+1) && !s.getScacchiera().ifOccupata(posizione+2))
    							break;//se le due caselle sopra la posizione iniziale sono libere, la mossa è legale
    						
    						//altrimenti la mossa non è legale: elimina il target
    						lista.remove(i);
    					break;
    		
    				case -2: //sud
	    					if(!s.getScacchiera().ifOccupata(target+1) && !s.getScacchiera().ifOccupata(target+2))
								break;//se le due caselle sopra alla casella target sono libere, la mossa è legale
							
							if(!s.getScacchiera().ifOccupata(posizione-1) && !s.getScacchiera().ifOccupata(posizione-2))
								break;//se le due caselle sotto la posizione iniziale sono libere, la mossa è legale
							
							//altrimenti la mossa non è legale: elimina il target
							lista.remove(i);
						break;
    					
						
    				default:
    					switch(c_to - c_from) {
    					
    						case 2: //est
    							if(!s.getScacchiera().ifOccupata(target-10) && !s.getScacchiera().ifOccupata(target-20))
        							break;//se le due caselle a sx della casella target sono libere, la mossa è legale
        						
        						if(!s.getScacchiera().ifOccupata(posizione+10) && !s.getScacchiera().ifOccupata(posizione+20))
        							break;//se le due caselle a dx della posizione iniziale sono libere, la mossa è legale
        						
        						//altrimenti la mossa non è legale: elimina il target
        						lista.remove(i);
        					break;
        					
    						case -2: //ovest
    							if(!s.getScacchiera().ifOccupata(target+10) && !s.getScacchiera().ifOccupata(target+20))
        							break;//se le due caselle a dx della casella target sono libere, la mossa è legale
        						
        						if(!s.getScacchiera().ifOccupata(posizione-10) && !s.getScacchiera().ifOccupata(posizione-20))
        							break;//se le due caselle a sx della posizione iniziale sono libere, la mossa è legale
        						
        						//altrimenti la mossa non è legale: elimina il target
        						lista.remove(i);
        					break;
    					
        					default:
    					}
    		}
    		
    	}
    
    	
        return lista;
    }
	
    
}
