
import java.util.ArrayList;

public class Alfiere extends Pezzo {
	//private Alfiere p = new Alfiere(white); //perch� un'istanza di alfiere dentro alfiere stesso??
	
	
	
	
	
    public Alfiere (boolean white) {
        super(white,white?'A':'a');
        
    }

    
    
    //MANCA ARROCCO E POSIZIONE TRA I PIEDI(SE DEVO ANDARE IN TARGET MA DI MEZZO C'E' UN PEZZO NON CI POSSO ANDARE!)
    
    public Alfiere(Pezzo p) {
		// TODO Auto-generated constructor stub
    	super(p.white,p.mostraLettera());
	}



	@Override
    boolean spostamentoPotenziale (Stato s, int target){
    /*true: se il pezzo può muovere nello stato s dalla propria casa alla casa target 
    (che deve essere libera in s)
    da considerare l'arrocco ma non lo scacco*/
      	
    	
        return s.getScacchiera().ifOccupata(target)?false:listaSpostamentoPotenziale(s).contains(target);
}

    @Override
    ArrayList<Integer> listaSpostamentoPotenziale (Stato s) {
    /*restituisce un arraylist contenente tutte e sole le posizioni della scacchiera 
    verso le quali il pezzo può muovere a partire dallo stato s.
    da considerare l'arrocco ma non lo scacco*/
    
    	ArrayList<Integer> lista = new ArrayList<Integer>();
		
    	int posizione = s.getScacchiera().getPos(this);
    	int x = posizione%10;
    	int y = posizione/10;
    	
		
		// NE
		for(int i = 1; i < 8; i++) 
			if( !(x+i < 1 || x+i > 8 || y+i < 1 || y+i > 8) ){
				if(!s.getScacchiera().ifOccupata((y+i)*10+x+i))
					lista.add((y+i)*10+x+i);	
			
		}
		
		// NW
		for(int i = 1; i < 8; i++) 
			if( !(x-i < 1 || x-i > 8 || y+i < 1 || y+i > 8) ){
				if(!s.getScacchiera().ifOccupata((y+i)*10+x-i)) 
					lista.add((y+i)*10+x-i);	
			
		}
		
		// SE
		for(int i = 1; i < 8; i++) {
			if( !(x+i < 1 || x+i > 8 || y-i < 1 || y-i > 8) ){
				if(!s.getScacchiera().ifOccupata((y-i)*10+x+i)) 
					lista.add((y-i)*10+x+i);	
			}
		}
		
		// SW
		for(int i = 1; i < 8; i++) {
			if( !(x-i < 1 || x-i > 8 || y-i < 1 || y-i > 8) ){
				if(!s.getScacchiera().ifOccupata((y-i)*10+x-i)) 
					lista.add((y-i)*10+x-i);
			}
		}
		
		return lista;
    
    };

    @Override
    boolean attacco (Stato s, int target){
    /*true se e solo se nello stato s il pezzo pone sotto attacco la casa target
    target deve essere libero oppure occupato da un pezzo avversario. 
    non considera lo scacco*/
	    	 
      		return listaAttacco(s).contains(target);
    }

    @Override
    ArrayList<Integer> listaAttacco (Stato s) {
    /*restituisce un arraylist contenente tutte e sole le posizioni della scacchiera che
    sono sotto attacco da parte del pezzo nello stato s. 
    le posizioni restituite devono corrispondere a una casa libera oppure occupata da un pezzo avversario. 
    sovrascriverlo nelle sottoclassi*/

    	ArrayList<Integer> lista = new ArrayList<Integer>();
		
    	int posizione = s.getScacchiera().getPos(this);
    	int x = posizione%10;
    	int y = posizione/10;
    	
    	
    	// NE
    	for(int i = 1; i < 8; i++) {
			if( !(x+i < 1 || x+i > 8 || y+i < 1 || y+i > 8) ){
				if(s.getScacchiera().ifOccupata((y+i)*10+x+i)) { 
						if(s.getScacchiera().getScacchiera()[x+i-1][y+i-1].getPezzo().white != white)
							lista.add( ((y+i)*10+x+i) );	
						
						break;
					}
			
				}
			}
    			
    		// NW
	    	for(int i = 1; i < 8; i++) {
				if( !(x+i < 1 || x+i > 8 || y-i < 1 || y-i > 8) ){
					if(s.getScacchiera().ifOccupata((y-i)*10+x+i)) { 
						if(s.getScacchiera().ifOccupata((y-i)*10+x+i)) {
							if(s.getScacchiera().getScacchiera()[x+i-1][y-i-1].getPezzo().white != white)
								lista.add( ((y-i)*10+x+i) );	
							
							break;
						}
				}
			}
			}
    			
    			// SE
	    	for(int i = 1; i < 8; i++) {
				if( !(x-i < 1 || x-i > 8 || y+i < 1 || y+i > 8) ){
					if(s.getScacchiera().ifOccupata((y+i)*10+x-i)) { 
						if(s.getScacchiera().ifOccupata((y+i)*10+x-i)) {
							if(s.getScacchiera().getScacchiera()[x-i-1][y+i-1].getPezzo().white != white)
								lista.add( ((y+i)*10+x-i) );	
							
							break;
						}
					}
				}
			}
    			
    			// SW
    			for(int i = 1; i < 8; i++) {
    				if( !(x-i < 1 || x-i > 8 || y-i < 1 || y-i > 8) ){
    					if(s.getScacchiera().ifOccupata((y-i)*10+x-i)) { 
    						if(s.getScacchiera().ifOccupata((y-i)*10+x-i)) {
    							if(s.getScacchiera().getScacchiera()[x-i-1][y-i-1].getPezzo().white != white)
    								lista.add( ((y-i)*10+x-i) );	
    							
    							break;
    						}
    				}
    			}
    			}
    return lista;
    }

    }
