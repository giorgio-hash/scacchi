
import java.util.ArrayList;

public class Pedone extends Pezzo {
	//private Pedone p = new Pedone(white);
	
    public Pedone (boolean white) {
        super(white,white?'P':'p');
    }

  

    public Pedone(Pezzo p) {
		// TODO Auto-generated constructor stub
    	super(p.white,p.mostraLettera());
	}



	//MANCA ARROCCO E POSIZIONE TRA I PIEDI(SE DEVO ANDARE IN TARGET MA DI MEZZO C'E' UN PEZZO NON CI POSSO ANDARE!)
    //MANCA PRIMA MOSSA--> PUO' FARE DUE PASSI IN AVANTI IL PEDONE
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
    	
    	if(white) {
			// forward
    		if( !(x+1 < 1 || x+1 > 8 || y < 1 || y > 8) )
    			if(!s.getScacchiera().ifOccupata((y)*10+x+1))
    				lista.add(((y)*10+x+1) );
    		
    		if(s.getEnPassantB() && this.getNumMosse() == 0)
    			lista.add(((y)*10+x+2) );
			
		}
		else {
			// forward
			if( !(x-1 < 1 || x-1 > 8 || y < 1 || y > 8) )
    			if(!s.getScacchiera().ifOccupata((y)*10+x-1))
    				lista.add(((y)*10+x-1) );
			
			if(s.getEnPassantN() && this.getNumMosse() == 0)
				lista.add(((y)*10+x-2) );
			
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
    	
    	if(white) {
			
			
    		if( !(x+1 < 1 || x+1 > 8 || y+1 < 1 || y+1 > 8) ) 
				if(s.getScacchiera().ifOccupata((y+1)*10+x+1)) 
					if(s.getScacchiera().getScacchiera()[x+1-1][y+1-1].getPezzo().white != white)
						lista.add( ((y+1)*10+x+1) );	
			
			
					if( !(x+1 < 1 || x+1 > 8 || y-1 < 1 || y-1 > 8) ) 
						if(s.getScacchiera().ifOccupata((y-1)*10+x+1)) 
							if(s.getScacchiera().getScacchiera()[x+1-1][y-1-1].getPezzo().white != white)
								lista.add( ((y-1)*10+x+1) );	
		}
		else {
			
			if( !(x-1 < 1 || x-1 > 8 || y+1 < 1 || y+1 > 8) ) 
				if(s.getScacchiera().ifOccupata((y+1)*10+x-1)) 
					if(s.getScacchiera().getScacchiera()[x-1-1][y+1-1].getPezzo().white != white)
						lista.add( ((y+1)*10+x-1) );	
			
			
					if( !(x-1 < 1 || x-1 > 8 || y-1 < 1 || y-1 > 8) ) 
						if(s.getScacchiera().ifOccupata((y-1)*10+x-1)) 
							if(s.getScacchiera().getScacchiera()[x-1-1][y-1-1].getPezzo().white != white)
								lista.add( ((y-1)*10+x-1) );
			
				
		}
    	
    	
    	return lista;
    }

	
    	
   
				
}
