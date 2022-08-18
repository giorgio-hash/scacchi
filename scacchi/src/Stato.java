
import java.util.ArrayList;



public class Stato {
/*stato del gioco: scacchiera - giocatore che deve fare la prima mossa - arrocco bianco - arrocco nero
- cattura en passant bianco - cattura en passant nero*/
	
    private Scacchiera scacchiera;
    private int giocatorePM; //cambiato giocatorePM in int
    private boolean arroccoBL;
    private boolean arroccoBC;
    private boolean arroccoNL;
    private boolean arroccoNC;
    private boolean enPassantB;
    private boolean enPassantN;
	
    public Stato (Scacchiera scacchiera, int giocatorePM, boolean arroccoBL, boolean arroccoBC, boolean arroccoNL, boolean arroccoNC, boolean enPassantB, boolean enPassantN) {
    	this.scacchiera=scacchiera;
        this.giocatorePM=giocatorePM;
        this.arroccoBL=arroccoBL;
        this.arroccoBC=arroccoBC;
        this.arroccoNL=arroccoNL;
        this.arroccoNC=arroccoNC;
        this.enPassantB=enPassantB;
        this.enPassantN=enPassantN;
    }

    public Scacchiera getScacchiera() {
        return scacchiera;
    }
    
    public void setScacchiera(Scacchiera scacchiera) {
    	this.scacchiera = scacchiera;
    }

    public void setGiocatorePM(int giocatorePM) {
        this.giocatorePM=giocatorePM;
    }

    public int getGiocatorePM() {
        return giocatorePM;
    }

    public void setArroccoBL(boolean arroccoBL) {
        this.arroccoBL=arroccoBL;
    }

    public boolean getArroccoBL() {
        return arroccoBL;
    }

    public void setArroccoBC(boolean arroccoBC) {
        this.arroccoBC=arroccoBC;
    }

    public boolean getArroccoBC() {
        return arroccoBC;
    }

    public void setArroccoNL(boolean arroccoNL) {
        this.arroccoNL=arroccoNL;
    }

    public boolean getArroccoNL() {
        return arroccoNL;
    }

    public void setArroccoNC(boolean arroccoNC) {
        this.arroccoNC=arroccoNC;
    }

    public boolean getArroccoNC() {
        return arroccoNC;
    }

    public void setEnPassantB(boolean enPassantB) {
        this.enPassantB=enPassantB;
    }

    public boolean getEnPassantB() {
        return enPassantB;
    }

    public void setEnPassantN(boolean enPassantN) {
        this.enPassantN=enPassantN;
    } 

    public boolean getEnPassantN() {
        return enPassantN;
    }

    public Stato (Stato stato) {
        this.scacchiera=stato.getScacchiera();
        this.giocatorePM=stato.getGiocatorePM();
        this.arroccoBL=stato.getArroccoBL();
        this.arroccoBC=stato.getArroccoBC();
        this.arroccoNL=stato.getArroccoNL();
        this.arroccoNC=stato.getArroccoNC();
        this.enPassantB=stato.getEnPassantB();
        this.enPassantN=stato.getEnPassantN();
    }

    /**
     * n.b. per come è strutturato, il primo if potrebbe dare errori
     * 
     * @param pos : posizione in esame
     * @param white : colore dell'attaccante
     * @return True se la casella è del colore opposto risp. all'attaccante o se è vuota
     */
    public boolean sottoAttacco (int pos, boolean white) {
    /*true se la casa pos Ã¨ sotto attacco da parte di white=true o nero(white=false)
    pos deve essere una casa vuota o contenente un pezzo di colore diverso dal colore che pone sotto attacco.*/
        
    	
    /*if((scacchiera.ifOccupata(pos)==true) || (scacchiera.getColorePezzo(scacchiera.getPezzo(pos))!=white)){
            return false;
        } else if (white==true) {
            if((scacchiera.ifOccupata(pos)==false) && (scacchiera.getColorePezzo(scacchiera.getPezzo(pos))==white)){
                for(int i=0; i<dimensione; i++) {
                    for (int j=0; j<dimensione; j++) {
                        ArrayList<Integer> listaDiAttacco=scacchiera.getScacchiera()[i][j].getPezzo().listaDiAttacco(this);
                    }
                    for(int y=0; y<listaDiAttacco.size(); y++) {
                        if (pos==listaDiAttacco.getPos(y)) return true;
                    }
                }
            } else return false;
        } else if (white==false) {
            if((scacchiera.ifOccupata(pos)==false) && (scacchiera.getColorePezzo(scacchiera.getPezzo(pos))==white)){
                for(int i=0; i<dimensione; i++) {
                    for (int j=0; j<dimensione; j++) {
                        ArrayList<Integer> listaDiAttacco=scacchiera.getScacchiera()[i][j].getPezzo().listaDiAttacco(this);
                    }
                    for(int y=0; y<listaDiAttacco.size(); y++) {
                        if (pos==listaDiAttacco.getPos(y)) return true;
                    }
                }
            } else return false;
        }*/
    	
    	if(!scacchiera.ifOccupata(pos) || scacchiera.getColorePezzo(scacchiera.getPezzo(pos)) != white) {
    		
    		//non è occupata oppure il pezzo che la occupa è di colore opposto risp. all'attaccante
    		return true;
    		
    	}
    	
    	
		 //caso rimanente: è occupata ma dallo stesso colore dell'attaccante
		 return false;
    	
    }
    
    
    

    public boolean scacco() {
    //true se il re del giocatore prima mossa si trova in una casa sotto attacco
        if(giocatorePM==1) {
        	//re bianco
            return sottoAttacco(scacchiera.locateRe(true), false);
            
        } 
            
        //re nero
        return sottoAttacco(scacchiera.locateRe(false), true);
        
    }

    boolean scaccoMatto() {
    //true se il re del giocatore prima mossa si trova sotto scacco e l'altro giocatore non ha mosse valide
        
    	
    	//0. valuta intanto se il re è in scacco
    	if(scacco()) {
    		
    		int posizione = scacchiera.locateRe(giocatorePM==1?true:false);
        	Pezzo re = scacchiera.getPezzo(posizione);
        	
        	//1. prendi ogni spostamento o cattura potenziale
        	ArrayList<Integer> mosse = re.listaSpostamentoPotenziale(this);
        	mosse.addAll(re.listaAttacco(this));
        	
        	
        	//2. simula ciascuna mossa e valuta se, dopo, è scacco
        	Stato simulazione;
        	int scacco = 0;
        	for(int i=0; i<mosse.size();i++) {
        		
        		simulazione = this.simulaSpostamentoOCattura(posizione, mosse.get(i));
        		if(simulazione.scacco())
        			scacco++;
        		
        	}
        	
        	//3. se ogni simulazione ha dato scacco, allora è scacco matto
        	if(scacco == mosse.size())
        		return true;
    		
    	}
    	
    	return false;
    	
    };

    boolean stallo () {
    //true se il giocatore prima mossa non ha mosse valide e non ha il re sotto scacco    
        
    	ArrayList<Pezzo> pezzi = new ArrayList<Pezzo>();
    	Pezzo pezzo;
    	boolean giocatore = giocatorePM==1?true:false;
    	int bloccati = 0;
    	
    	//1. prendi ogni pezzo del colore interessato
    	for(int i=0; i<8; i++)
    		for(int j=0; j<8; j++) {
    			
    			pezzo = scacchiera.getScacchiera()[i][j].getPezzo();
    			if(pezzo.white == giocatore) {
    				
    				pezzi.add(pezzo);
    				
    				//2. valuta se ogni pezzo non ha mosse disponibili
    				if(pezzo.listaAttacco(this).size() == 0 && pezzo.listaSpostamentoPotenziale(this).size() == 0)
    					bloccati++;
    			}
    			
    		}
    	
    	//3. se tutti i pezzi non hanno possibilità di movimento, è stallo
    	if(bloccati == pezzi.size())
    		return true;
    	
    	return false;
    	
    }
    	
    /**
     * Restituisce un nuovo stato risultante dalla mossa del giocatore di turno dalla casa from alla casa to, se
     <ul>
     <li>nella casa from è presente un pezzo del giocatore individuato dal parametro white</li>
    <li>tale mossa rientra tra gli spostamenti potenziali del pezzo in questione, oppure è diretta verso una casa, sotto attacco dal pezzo in questione, che contiene un pezzo del giocatore avversario.<br>
    Altrimenti restituisce null.</li>
    </ul>
    <p>Il parametro promozione è usato unicamente nel caso in cui si tratti di uno
    spostamento del pedone che raggiunge la traversa più lontana dalla sua posizione
    inziale e indica il pezzo di promozione del pedone: <br>(0=regina, 1=cavallo, 2=alfiere,
    3=torre)</p>
     * 
     * @param from : <i>int</i> posizione iniziale
     * @param to : <i>int</i> posizione target
     * @param promozione  : <i>int</i> promozione pedina: 0=regina, 1=cavallo, 2=alfiere,
    3=torre
     * @return <i>Stato</i> se i parametri sono corretti
     * <br> <i>null</i> se ci sono errori nei parametri
     */
    Stato simulaSpostamentoOCattura (int from, int to, int promozione) {
    	/*che restituisce un nuovo stato risultante dalla mossa del giocatore di turno dalla casa from alla casa to, se
        --> nella casa from è presente un pezzo del giocatore individuato dal parametro white
        --> tale mossa rientra tra gli spostamenti potenziali del pezzo in questione, oppure è diretta verso una casa, sotto attacco dal pezzo in questione, che contiene un pezzo del giocatore avversario.
        Altrimenti restituisce null.
        Il parametro promozione è usato unicamente nel caso in cui si tratti di uno
        spostamento del pedone che raggiunge la traversa più lontana dalla sua posizione
        inziale e indica il pezzo di promozione del pedone: (0=regina, 1=cavallo, 2=alfiere,
        3=torre). */
    	
    	/*
    	int rigaf = from%10;
    	int colonnaf = from/10;
        if (Scacchiera.scacchiera[rigaf][colonnaf].getPezzo().white==true) { //allora Ã¨ il giocatore identificato da white
        	
        	//prendo il pezzo
        	Pezzo pezzoGiocatore = Scacchiera.scacchiera[rigaf][colonnaf].getPezzo();
        	
        	
        	
        	if(pezzoGiocatore.mostraLettera() == 'P' ) {
        		if(pezzoGiocatore.spostamentoPotenziale(c, to) == true || pezzoGiocatore.attacco(c, to) == true) {
        				//fai la mossa, come?
        			 if(scacchiera.mossaPedone(from,to,pezzoGiocatore) == "Mossa avvenuta con successo") {
        				 c = new Stato(scacchiera, giocatore, arroccoB, arroccoN, enPassantB, enPassantN);		// fa la mossa e sistema i pezzi a seconda di ciÃ²
        			 }
        		}
        		return c;
        	}
        	if(pezzoGiocatore.mostraLettera() == 'N' ) {
    			
        		if(pezzoGiocatore.spostamentoPotenziale(c, to) == true || pezzoGiocatore.attacco(c, to) == true) {
    				//fai la mossa, come?
        			if(scacchiera.mossaCavallo(from,to,pezzoGiocatore) == "Mossa avvenuta con successo") {
       				 c = new Stato(scacchiera, giocatore, arroccoB, arroccoN, enPassantB, enPassantN);		// fa la mossa e sistema i pezzi a seconda di ciÃ²
       			 }
       		}
        			return c;
        		
        	}
        	if(pezzoGiocatore.mostraLettera() == 'T' ) {
    			
        		if(pezzoGiocatore.spostamentoPotenziale(c, to) == true || pezzoGiocatore.attacco(c, to) == true) {
    				//fai la mossa, come?
    			
        		}
        		
        		return new Stato(scacchiera, giocatore, arroccoB, arroccoN, enPassantB, enPassantN);
        	}
        	if(pezzoGiocatore.mostraLettera() == 'Q' ) {
        		if(pezzoGiocatore.spostamentoPotenziale(c, to) == true || pezzoGiocatore.attacco(c, to) == true) {
    				//fai la mossa, come?
    			
        		}
        		
        		return new Stato(scacchiera, giocatore, arroccoB, arroccoN, enPassantB, enPassantN);
        	}
        	if(pezzoGiocatore.mostraLettera() == 'R' ) {
        		if(pezzoGiocatore.spostamentoPotenziale(c, to) == true || pezzoGiocatore.attacco(c, to) == true) {
    				//fai la mossa, come?
    			
        		}
        		
        		
        		return new Stato(scacchiera, giocatore, arroccoB, arroccoN, enPassantB, enPassantN); 
        	}
        	return new Stato(scacchiera, giocatore, arroccoB, arroccoN, enPassantB, enPassantN);
        } else {
        	return null;
        }*/
    	
    	int rigaf = from%10;
    	int colonnaf = from/10;
    	int rigat = to%10;
    	int colonnat = to/10;
    	
    	Pezzo pezzo = scacchiera.getScacchiera()[rigaf-1][colonnaf-1].getPezzo();
    	
    	if(pezzo == null || scacchiera.getScacchiera()[rigaf-1][colonnaf-1].getColorePedina() != (giocatorePM==1?true:false))
    		return null; //se la casella from non ha pezzo o non ha un pezzo del giocatore selezionato
    	
    	
    	if(pezzo.spostamentoPotenziale(this, to) || pezzo.attacco(this, to)) {
    		
    		Stato simulato = new Stato(this); //stiamo simulando! creo una copia dello stato attuale
    		
    		simulato.getScacchiera().getScacchiera()[rigaf-1][colonnaf-1].togliPedina(); //rimuovo dal from
    		simulato.getScacchiera().getScacchiera()[rigat-1][colonnat-1].inserisciPedina(pezzo); //aggiungo al to
    		
    		if(pezzo.mostraLettera() == 'P' || pezzo.mostraLettera() == 'p') {
    			if(rigat == simulato.getScacchiera().getTraversa(giocatorePM))
    				switch(promozione) {
    				
    					case 0://regina
    						simulato.getScacchiera().getScacchiera()[rigat-1][colonnat-1].inserisciPedina(new Regina(giocatorePM==1?true:false));
    						break;
    						
    					case 1://cavallo
    						simulato.getScacchiera().getScacchiera()[rigat-1][colonnat-1].inserisciPedina(new Cavallo(giocatorePM==1?true:false));
    						break;
    						
    					case 2://alfiere
    						simulato.getScacchiera().getScacchiera()[rigat-1][colonnat-1].inserisciPedina(new Alfiere(giocatorePM==1?true:false));
    						break;
    						
    					case 3://torre
    						simulato.getScacchiera().getScacchiera()[rigat-1][colonnat-1].inserisciPedina(new Torre(giocatorePM==1?true:false));
    						break;
    				}
    		}
    		
    		
    		return simulato;
    	}
    	
    	return null;
    };    

    
    
    
    
    
    
    Stato simulaSpostamentoOCattura (int from, int to) {
    //richiama simulaSpostamentoOCattura (from, to, 0)
        return simulaSpostamentoOCattura (from, to, 0);
    }

    boolean mossaValida (int from, int to, int promozione) {
    /*simula mossa giocatore di turno dalla casa from alla casa to - true se e solo se tale mossa Ã¨ valida.
    Per essere valida, devono valere entrambe le seguenti condizioni:
    simulaSpostamentoOCattura (from, to, promozione) non deve restituire null;
    lo Stato restituito da simulaSpostamentoOCattura (from, to, promozione) non deve essere tale che il proprio 
    re si trovi in una situazione di scacco (ovvero si trovi in una casa sotto attacco da parte di un pezzo del
    giocatore avversario).*/
    	
    	boolean esito = false;
    	
        if (simulaSpostamentoOCattura (from, to, promozione) != null) {
        	Stato ris = simulaSpostamentoOCattura (from, to, promozione);
        		if(ris.scacco() != false) 
        			esito = true;
        }
        		
        		
        	return esito;
    }

    boolean mossaValida (int from, int to) {
    // richiama e restituisce mossaValida (from, to, 0)
        return mossaValida (from, to, 0);
    };

    /**
     * modifica lo stato in modo da eseguire la mossa del giocatore di turno dalla casa from alla casa to, 
    e restituisce true, se tale mossa è valida; altrimenti lascia invariato lo stato e restituisce false.*/
    
    boolean eseguiMossa (int from, int to, int promozione) {
    /*modifica lo stato in modo da eseguire la mossa del giocatore di turno dalla casa from alla casa to, 
    e restituisce true, se tale mossa Ã¨ valida; altrimenti lascia invariato lo stato e restituisce false.*/
    	
    	//modificare lo stato
    	boolean esito = false;
    	
        if (mossaValida(from, to)) {
        	
        	int rigaf = from%10;
        	int colonnaf = from/10;
        	int rigat = to%10;
        	int colonnat = to/10;
        	
        	Pezzo pezzo = scacchiera.getScacchiera()[rigaf-1][colonnaf-1].getPezzo();
        	
        	pezzo.registraMossa();//aumenta di 1 il contatore delle mosse del pezzo
        	
        	this.getScacchiera().getScacchiera()[rigaf-1][colonnaf-1].togliPedina(); //rimuovo dal from
    		this.getScacchiera().getScacchiera()[rigat-1][colonnat-1].inserisciPedina(pezzo); //aggiungo al to
    		
    		esito = true;
    		
    		if(pezzo.mostraLettera() == 'P' || pezzo.mostraLettera() == 'p') {
    			if(rigat == this.getScacchiera().getTraversa(giocatorePM))
    				switch(promozione) {
    				
    					case 0://regina
    						this.getScacchiera().getScacchiera()[rigat-1][colonnat-1].inserisciPedina(new Regina(giocatorePM==1?true:false));
    						break;
    						
    					case 1://cavallo
    						this.getScacchiera().getScacchiera()[rigat-1][colonnat-1].inserisciPedina(new Cavallo(giocatorePM==1?true:false));
    						break;
    						
    					case 2://alfiere
    						this.getScacchiera().getScacchiera()[rigat-1][colonnat-1].inserisciPedina(new Alfiere(giocatorePM==1?true:false));
    						break;
    						
    					case 3://torre
    						this.getScacchiera().getScacchiera()[rigat-1][colonnat-1].inserisciPedina(new Torre(giocatorePM==1?true:false));
    						break;
    				}
    		}
        } 
        
        return esito;
    }

    boolean eseguiMossa (int from, int to){
    //richiama e restituisce eseguiMossa (from, to, 0)
        return eseguiMossa (from, to, 0);
    };
    
    /**
     * valuta se, dato un re in from, questo può effettuare un arrocco verso to
     * 
     * @param from
     * @param target
     * @return
     */
    public boolean isArrocco(int from, int target) {
    	
    	Pezzo pezzo = scacchiera.getPezzo(from);
    	
    	if(pezzo.mostraLettera() == 'K' || pezzo.mostraLettera() == 'k')
	    	switch(giocatorePM) {
	    	
	    		case 1:
	    			if( pezzo.white ) {
	            		if( arroccoBL && (from - 20) == target && pezzo.listaSpostamentoPotenziale(this).contains(target))
	            			return true;
	                	
	            		if( arroccoBC && (from + 20)==target && pezzo.listaSpostamentoPotenziale(this).contains(target))
	            			return true;
	            	}
	    			break;
	    		case 2:
	    			if( !pezzo.white ) {
	    				if( arroccoNL && (from - 20) == target && pezzo.listaSpostamentoPotenziale(this).contains(target))
	            			return true;
	                	
	            		if( arroccoNC	 && (from + 20)==target && pezzo.listaSpostamentoPotenziale(this).contains(target))
	            			return true;
	            	}
	    			break;
    	}
    		
    	return false;
    }

    } 
  
