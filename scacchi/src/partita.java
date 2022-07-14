package cleii.scacchi;
import java.util.ArrayList;

public class partita {
//memorizza lo stato del gioco, le mosse e l'eventuale esito
    private Stato s;
	private ArrayList<Mosse> mosse;
	private String esito;
	int contatoreMosse;
	
    public partita () { 
    //costruttore che crea la partita senza mosse
       this.s = s;
       this.mosse = new ArrayList<>();
       this.esito = esito;
    }

   

    public void eseguiMossa (int from, int to, int promozione) throws EccezioneMossa {
    /* se la partita è in corso, modifica lo stato in modo da eseguire la mossa da casa from a casa to, e memorizzarla - diversamente solleva un'eccezione
    arrocco --> from e to si riferiscono al re
    stallo --> esito: patta
    scacco matto --> esito: vittoria (bianchi / neri)
    parametro promozione: spostamento del pedone su 0=regina, 1=cavallo, 2=alfiere, 3=torre */
    	
    	
    	
    	
    	
    	
    	
    	
    }

    public void eseguiMossa (int from, int to) throws EccezioneMossa {
    //richiama eseguiMossa (int from, int to, int promozione)

        eseguiMossa(from, to, 0);
        contatoreMosse++;
    }

    public void abbandona () {
    //esito: vittoria casa che non ha abbandonato

    }

    public boolean inCorso () {
    //true se stato è in corso

        return true;
    }

    public boolean vittoriaBianco () {
    //true se esito: vittoria bianchi

        return true;
    }

    public boolean vittoriaNero () {
    //true se esito: vittoria neri

        return true;
    }

    public boolean patta () {
    //true se esito: patta

        return true;
    }
    
}
