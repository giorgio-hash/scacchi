
import java.util.ArrayList;

public class Re extends Pezzo {

    public Re (boolean white) {
        super(white,white?'R':'r');
    }

    
    
    @Override
    boolean spostamentoPotenziale (Stato s, int target){
    /*true: se il pezzo può muovere nello stato s dalla propria casa alla casa target 
    (che deve essere libera in s)
    da considerare l'arrocco ma non lo scacco*/
    	
    	
        return s.getScacchiera().ifOccupata(target)?false:listaSpostamentoPotenziale(s).contains(target);
    }

    
    
    @Override
    public ArrayList<Integer> listaSpostamentoPotenziale (Stato s) {
    /*restituisce un arraylist contenente tutte e sole le posizioni della scacchiera 
    verso le quali il pezzo puÃ² muovere a partire dallo stato s.
    da considerare l'arrocco ma non lo scacco*/
    
    	
    	int posizione = s.getScacchiera().getPos(this);
        
    	ArrayList<Integer> lista = new ArrayList<Integer>();
    	
    	
    	/*
    	o -10
    	e +10
    	n +1
    	s -1
    	
    	diagonali:
    	no -9
    	ne +11
    	so -11
    	se +9
    	
    	le caselle vanno da 11 a 88
    	*/
    	
    	int[] offsets = {-10,10,1,-1,-9,11,-11,9};
    	
    	for(int i=0; i<offsets.length;i++)
    		if( (posizione + offsets[i]) >10 && (posizione + offsets[i]) <89 && (posizione + offsets[i])%10 != 0) {
    			if(!s.getScacchiera().ifOccupata((posizione + offsets[i])))
    				lista.add((posizione + offsets[i]));	
    			}
    		
    
    	if((white?s.getArroccoBC():s.getArroccoNC()) && super.getNumMosse() == 0)//verifica l'arrocco corto
    		if(!s.getScacchiera().ifOccupata((posizione+10)) && !s.getScacchiera().ifOccupata((posizione+20)))//se le due caselle a est son libere
    			if(!s.sottoAttacco((posizione+10), white? false:true) && !s.sottoAttacco((posizione+20), white? false:true))//se le due caselle a est non sono potenzialmente sotto attacco(secondo wikipedia e wikihow)
    			if(s.getScacchiera().getPezzo(posizione+30).mostraLettera()==(white?'R':'r'))//se la terza casella a est è una torre
    				lista.add((posizione + 20)); //aggiungi la posizione dell'arrocco corto
    	
    	if((white?s.getArroccoBL():s.getArroccoNL()) && super.getNumMosse() == 0)//verifica l'arrocco lungo
    		if(!s.getScacchiera().ifOccupata((posizione-10)) && !s.getScacchiera().ifOccupata((posizione-20)))//se le due caselle a ovest son libere
    			if(!s.sottoAttacco((posizione-10), white? false:true) && !s.sottoAttacco((posizione-20), white? false:true))//se le due caselle a ovest non sono potenzialmente sotto attacco(secondo wikipedia e wikihow)
    			if(s.getScacchiera().getPezzo(posizione-40).mostraLettera()==(white?'R':'r'))//se la quarta casella a ovest è una torre
    				lista.add((posizione - 20)); //aggiungi la posizione dell'arrocco lungo
    	
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

    	int posizione = s.getScacchiera().getPos(this);
        
    	ArrayList<Integer> lista = new ArrayList<Integer>();
    	
    	
    	/*
    	o -10
    	e +10
    	n +1
    	s -1
    	
    	diagonali:
    	no -9
    	ne +11
    	so -11
    	se +9
    	
    	le caselle vanno da 11 a 88
    	*/
    	
    	int[] offsets = {-10,10,1,-1,-9,11,-11,9};
    	
    	for(int i=0; i<offsets.length;i++)
    		if( (posizione + offsets[i]) >10 && (posizione + offsets[i]) <89 && (posizione + offsets[i])%10 != 0) {
    			if(!s.getScacchiera().ifOccupata((posizione + offsets[i])) || s.sottoAttacco(posizione + offsets[i], white))  //se libera oppure occupata da pezzo avversario
    				lista.add((posizione + offsets[i]));	
    			}
    		
    
        return lista;
    }
    
}
