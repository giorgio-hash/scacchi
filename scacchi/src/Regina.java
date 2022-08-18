
import java.util.ArrayList;

public class Regina extends Pezzo {

    public Regina (boolean white) {
        super(white,white?'Q':'q');
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
    	
		// up
		for(int i = 1; i < 8; i++) {
			if( !(x < 1 || x > 8 || y+i < 1 || y+i > 8) )
					if(!s.getScacchiera().ifOccupata((y+i)*10+x))
						lista.add( ((y+i)*10+x) );		
				}
		
		
		// down
		for(int i = 1; i < 8; i++) {
			if( !(x < 1 || x > 8 || y-i < 1 || y-i > 8) )
				if(!s.getScacchiera().ifOccupata((y-i)*10+x))
						lista.add( ((y-i)*10+x) );	
				}
		
		
		// left
		for(int i = 1; i < 8; i++) {
			if( !(x-i < 1 || x-i > 8 || y < 1 || y > 8) ) {
				if(!s.getScacchiera().ifOccupata(y*10+x-i))
					lista.add( (y*10+x-i) );	
			}
		}
		
		// right
		for(int i = 1; i < 8; i++) {
			if( !(x+i < 1 || x+i > 8 || y < 1 || y > 8) ) {
				if(!s.getScacchiera().ifOccupata(y*10+x+i))
					lista.add( (y*10+x+i) );	
			}
		}
		
		// NE
		for(int i = 1; i < 8; i++) {
			if( !(x+i < 1 || x+i > 8 || y+i < 1 || y+i > 8) ) {
				if(!s.getScacchiera().ifOccupata((y+i)*10+x+i))
					lista.add( ((y+i)*10+x+i) );	
			}
		}
		
		// NW
		for(int i = 1; i < 8; i++) {
			if( !(x-i < 1 || x-i > 8 || y+i < 1 || y+i > 8) ) {
				if(!s.getScacchiera().ifOccupata((y+i)*10+x-i))
					lista.add( ((y+i)*10+x-i) );	
			}
		}
		
		// SE
		for(int i = 1; i < 8; i++) {
			if( !(x+i < 1 || x+i > 8 || y-i < 1 || y-i > 8) ) {
				if(!s.getScacchiera().ifOccupata((y-i)*10+x+i)) 
					lista.add( ((y-i)*10+x+i) );	
			}
		}
		
		// SW
		for(int i = 1; i < 8; i++) {
			if( !(x-i < 1 || x-i > 8 || y-i < 1 || y-i > 8) ) {
				if(!s.getScacchiera().ifOccupata((y-i)*10+x-i))
					lista.add( ((y-i)*10+x-i) );	
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
    	
		// up
		for(int i = 1; i < 8; i++) {
			if( !(x < 1 || x > 8 || y+i < 1 || y+i > 8) )
					if(s.getScacchiera().ifOccupata((y+i)*10+x)) {
						if(s.getScacchiera().getScacchiera()[x-1][y+i-1].getPezzo().white != white)
							lista.add( ((y+i)*10+x) );	
						
						break;
					}
					
				}
		
		
		// down
		for(int i = 1; i < 8; i++) {
			if( !(x < 1 || x > 8 || y-i < 1 || y-i > 8) )
				if(s.getScacchiera().ifOccupata((y-i)*10+x)) {
						if(s.getScacchiera().getScacchiera()[x-1][y-i-1].getPezzo().white != white)
							lista.add( ((y-i)*10+x) );	
						
						break;
					}
					
				}
		
		
		// left
		for(int i = 1; i < 8; i++) {
			if( !(x-i < 1 || x-i > 8 || y < 1 || y > 8) ) {
				if(s.getScacchiera().ifOccupata(y*10+x-i)) {
					if(s.getScacchiera().getScacchiera()[x-i-1][y-1].getPezzo().white != white)
						lista.add( (y*10+x-i) );	
					
					break;
				}	
			}
		}
		
		// right
		for(int i = 1; i < 8; i++) {
			if( !(x+i < 1 || x+i > 8 || y < 1 || y > 8) ) {
				if(s.getScacchiera().ifOccupata(y*10+x+i)) {
					if(s.getScacchiera().getScacchiera()[x+i-1][y-1].getPezzo().white != white)
						lista.add( (y*10+x+i) );	
					
					break;
				}	
			}
		}
		
		// NE
		for(int i = 1; i < 8; i++) {
			if( !(x+i < 1 || x+i > 8 || y+i < 1 || y+i > 8) ) {
				if(s.getScacchiera().ifOccupata((y+i)*10+x+i)) {
					if(s.getScacchiera().getScacchiera()[x+i-1][y+i-1].getPezzo().white != white)
						lista.add( ((y+i)*10+x+i) );	
					
					break;
				}	
			}
		}
		
		// NW
		for(int i = 1; i < 8; i++) {
			if( !(x-i < 1 || x-i > 8 || y+i < 1 || y+i > 8) ) {
				if(s.getScacchiera().ifOccupata((y+i)*10+x-i)) {
					if(s.getScacchiera().getScacchiera()[x-i-1][y+i-1].getPezzo().white != white)
						lista.add( ((y+i)*10+x-i) );	
					
					break;
				}	
			}
		}
		
		// SE
		for(int i = 1; i < 8; i++) {
			if( !(x+i < 1 || x+i > 8 || y-i < 1 || y-i > 8) ) {
				if(s.getScacchiera().ifOccupata((y-i)*10+x+i)) {
					if(s.getScacchiera().getScacchiera()[x+i-1][y-i-1].getPezzo().white != white)
						lista.add( ((y-i)*10+x+i) );	
					
					break;
				}	
			}
		}
		
		// SW
		for(int i = 1; i < 8; i++) {
			if( !(x-i < 1 || x-i > 8 || y-i < 1 || y-i > 8) ) {
				if(s.getScacchiera().ifOccupata((y-i)*10+x-i)) {
					if(s.getScacchiera().getScacchiera()[x-i-1][y-i-1].getPezzo().white != white)
						lista.add( ((y-i)*10+x-i) );	
					
					break;
				}
			}
		}
		
		return lista;
    }

}
