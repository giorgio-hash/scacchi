
import java.util.ArrayList;

public class Partita {
//memorizza lo stato del gioco, le mosse e l'eventuale esito
    private Stato s;
	private ArrayList<Mossa> mosse;
	private String esito;
	private Giocatore giocatore;
	
    public Partita () { 
    //costruttore che crea la Partita senza mosse
       s = new Stato(new Scacchiera(),1,false,false,false,false,false,false);
       this.mosse = new ArrayList<Mossa>();
       this.esito = "in corso";
       
    }


   
    /** se la Partita è in corso, modifica lo stato in modo da eseguire la mossa da casa from a casa to, e memorizzarla - diversamente solleva un'eccezione
    <li>arrocco --> from e to si riferiscono al re</li>
    <li>stallo --> esito: patta</li>
    <li>scacco matto --> esito: vittoria (bianchi / neri)</li>
    <br>parametro promozione: spostamento del pedone su 0=regina, 1=cavallo, 2=alfiere, 3=torre */
    public void eseguiMossa (int from, int to, int promozione) throws EccezioneMossa {
    /* se la Partita Ã¨ in corso, modifica lo stato in modo da eseguire la mossa da casa from a casa to, e memorizzarla - diversamente solleva un'eccezione
    arrocco --> from e to si riferiscono al re
    stallo --> esito: patta
    scacco matto --> esito: vittoria (bianchi / neri)
    parametro promozione: spostamento del pedone su 0=regina, 1=cavallo, 2=alfiere, 3=torre */
    	
    	//se sei in scacco, non puoi decidere di muovere altro
    	if(s.scacco() && s.getScacchiera().locateRe(s.getGiocatorePM()==1?true:false) != from)
    		throw new EccezioneMossa("sei in scacco! muovi solo il re");
    	
    	//MANCANO STALLO E SCACCO MATTO
    	if(esito.equals("in corso")) {
    		
    		if(s.eseguiMossa(from, to, promozione)) {
    		
    			mosse.add(new Mossa(from,to));
    			
    			if( s.isArrocco(from, to)) {
        			
        			if(to < from) {
        				//arrocco a sinistra
        				
        				//prendi scacchiera e pezzo
        				Scacchiera scacchiera = s.getScacchiera();
        				Pezzo torre = scacchiera.getPezzo(to-20);
        				
        				//prendi la casella di partenza e togli torre
        				Caselle casella = scacchiera.getCasella(to-20);
        				casella.togliPedina();
        				scacchiera.setCasella(casella);
        				
        				//inserisci la torre nella casella di destinazione
        				casella = scacchiera.getCasella(to+10);
        				casella.inserisciPedina(torre);
        				scacchiera.setCasella(casella);
        				
        				if(s.getGiocatorePM()==1)
        					s.setArroccoBL(false);
        					else
        						s.setArroccoNL(false);//hai usato arrocco lungo
        				
        				
        			}else {
        				//arrocco a destra
        				
        				//prendi scacchiera e pezzo
        				Scacchiera scacchiera = s.getScacchiera();
        				Pezzo torre = scacchiera.getPezzo(to+10);
        				
        				//prendi la casella di partenza e togli torre
        				Caselle casella = scacchiera.getCasella(to+10);
        				casella.togliPedina();
        				scacchiera.setCasella(casella);
        				
        				//inserisci la torre nella casella di destinazione
        				casella = scacchiera.getCasella(to-10);
        				casella.inserisciPedina(torre);
        				scacchiera.setCasella(casella);
        					
        				if(s.getGiocatorePM()==1) 
        					s.setArroccoBC(false);
        				else
        					s.setArroccoNC(false);//hai usato arrocco corto
        				
        			}
        			
        			mosse.add(new Mossa(from,to,"arrocco"));
        			
        		}
    			
    			//passa il turno al prossimo giocatore
    			s.setGiocatorePM(s.getGiocatorePM()==1?2:1);
    		
    			if(s.scaccoMatto()) {//se il successivo giocatore è scacco matto, allora il primo giocatore ha vinto
    				esito = "vittoria " + (s.getGiocatorePM()==1?"neri!":"bianchi!");
    			}
    			else {
    			
    				if(s.stallo())//valuta se il giocatore successivo è in stallo
        			{
        				esito = "patta";
        			}
    				
    			}
    	
    		
    		}else {
    			throw new EccezioneMossa("Mossa non valida");
    		}
    		
    		
    	}else {
    		
    		throw new EccezioneMossa("Mossa illegale! La Partita è già conclusa");
    		
    	}
    	
    	
    }

    public void eseguiMossa (int from, int to) throws EccezioneMossa {
    //richiama eseguiMossa (int from, int to, int promozione)

        eseguiMossa(from, to, 0);
    }

    public void abbandona () {
    //esito: vittoria casa che non ha abbandonato
    	esito = "vittoria " + (s.getGiocatorePM()==1?"neri!":"bianchi!");
    }

    public boolean inCorso () {
    //true se stato Ã¨ in corso

        return esito.equals("in corso");
    }

    public boolean vittoriaBianco () {
    //true se esito: vittoria bianchi

        return esito.equals("vittoria bianchi!");
    }

    public boolean vittoriaNero () {
    //true se esito: vittoria neri

        return esito.equals("vittoria neri!");
    }

    public boolean patta () {
    //true se esito: patta

        return esito.equals("patta");
    }
    
    
    public String getEsito() {
    	return esito;
    }
    
    public Stato getStato() {
    	return s;
    }
    
    public void setStato(Stato s) {
    	this.s = s;
    }
    
    public ArrayList<Mossa> getMosse() {
    	return mosse;
    }
    
    public Giocatore getGiocatore() {
    	return giocatore;
    }
    
    
}