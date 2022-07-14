package cleii.scacchi;


public class Mosse extends Scacchiera {
	private String f;
    private int from;
    private int to;
    

    public String mossaPedone (int from, int to, Pezzo p) {
        //ipotesi base spostamento in avanti di una casella se libera
    	  int rigaf=from%10;
    	  int colonnaf=from/10;
    	  int rigat=to%10;
    	  int colonnat=to/10;
    	  String s;
    	     try {
        if (p.spostamentoPotenziale(c, to) == true || p.attacco(c, to) == true) {
                    scacchiera[rigat][colonnaf].inserisciPedina(scacchiera[rigaf][colonnaf].getPezzo(), scacchiera[rigat][colonnat].getPos());
                    scacchiera[rigaf][colonnaf].togliPedina(p, pos);
                    s = "Mossa avvenuta con successo";
                        } else {
                            s = "Mossa non effettuabile: casella to occupata";
                        }
                  } catch (Exception e) {
                        s = "Mossa non effettuabile: casella from o to non esistenti";
                  }
                return s;
    }
         
    	//movimenti torre--> solo movimenti come avanti, dietro, destra, sinistra.
    	//senza limiti di posizioni
    public String mossaTorre (int from, int to, Pezzo p) {
    	//riga e colonna della posizione da dove parte il pezzo
    	int rigaf = from%10;
    	int colonnaf = from/10;
    	//riga e colonna della posizione della direzione del pezzo
    	int rigat = to%10;
    	int colonnat = to/10;
    	
    	String s = "";
  
    	
    	return s;
    	
    }

    public String muoviCavallo (int pos, Pezzo p) {
     
    	
    	String s = "";
    	
    	
    	return s;
    	
    }

    public void muoviAlfiere (int pos, Pezzo p) {
      
    }

    public void muoviRegina (int pos, Pezzo p) {
        
    }

    public void muoviRe (int pos, Pezzo p) {
        
    }

    public String arrocoB () {
       return f;
    }

    public String arroccoN () {
        return f;
    }

    public String enPassantB () {
        return f;
    }

    public String enPassantN () {
        return f;
    }

}
