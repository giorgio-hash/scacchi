
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
     * n.b. per come � strutturato, il primo if potrebbe dare errori
     * 
     * @param pos : posizione in esame
     * @param white : colore dell'attaccante
     * @return True se la casella � del colore opposto risp. all'attaccante o se � vuota
     */
    public boolean sottoAttacco (int pos, boolean white) {
    /*true se la casa pos è sotto attacco da parte di white=true o nero(white=false)
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
    		
    		//non � occupata oppure il pezzo che la occupa � di colore opposto risp. all'attaccante
    		return true;
    		
    	}
    	
    	
		 //caso rimanente: � occupata ma dallo stesso colore dell'attaccante
		 return false;
    	
    }
    
    
    

    public boolean scacco() {
    //true se il re del giocatore prima mossa si trova in una casa sotto attacco
        if(giocatorePM==1) {
        	//re bianco
            return sottoAttacco(scacchiera.getPos(new Re(true)), false);
            
        } 
            
        //re nero
        return sottoAttacco(scacchiera.getPos(new Re(false)), true);
        
    }

    boolean scaccoMatto() {
    //true se il re del giocatore prima mossa si trova sotto scacco e l'altro giocatore non ha mosse valide
        //for(int i=0; i<)
    };

    boolean stallo () {
    //true se il giocatore prima mossa non ha mosse valide e non ha il re sotto scacco    
        
    /*
     * da rifare
     * 
     * if (giocatore.getRe().mostraLettera() == 'R' || giocatore.getRe().mostraLettera() == 'r' ) {
            try {
                if (giocatorePM == giocatore.getGiocatorePM() && !(sottoAttacco(giocatore.getPos(), true) || !sottoAttacco(giocatore.getPos(), false))) {
                    if (mossaValida(from, to, promozione) == false) {
                    esito = true;
                } else {
                	esito = false;
                }
            } else {
            	esito = false;
            }
        } catch (Exception e) {
            s = "Mossa non effettuabile: ...";
        }
    } else {
    	esito = false;
    }
    return esito;
    */
    	
    }
    	

    Stato simulaSpostamentoOCattura (int from, int to, int promozione) {
    /*che restituisce un nuovo stato risultante dalla mossa del giocatore di turno dalla casa from alla casa to, se
    ▪ nella casa from è presente un pezzo del giocatore individuato dal parametro white
    ▪ tale mossa rientra tra gli spostamenti potenziali del pezzo in questione, oppure è diretta verso una casa, sotto attacco dal pezzo in questione, che contiene un pezzo del giocatore avversario.
    Altrimenti restituisce null.
    Il parametro promozione è usato unicamente nel caso in cui si tratti di uno
    spostamento del pedone che raggiunge la traversa più lontana dalla sua posizione
    inziale e indica il pezzo di promozione del pedone: (0=regina, 1=cavallo, 2=alfiere,
    3=torre). */
    	int rigaf = from%10;
    	int colonnaf = from/10;
        if (Scacchiera.scacchiera[rigaf][colonnaf].getPezzo().white==true) { //allora è il giocatore identificato da white
        	
        	//prendo il pezzo
        	Pezzo pezzoGiocatore = Scacchiera.scacchiera[rigaf][colonnaf].getPezzo();
        	
        	
        	
        	if(pezzoGiocatore.mostraLettera() == 'P' ) {
        		if(pezzoGiocatore.spostamentoPotenziale(c, to) == true || pezzoGiocatore.attacco(c, to) == true) {
        				//fai la mossa, come?
        			 if(scacchiera.mossaPedone(from,to,pezzoGiocatore) == "Mossa avvenuta con successo") {
        				 c = new Stato(scacchiera, giocatore, arroccoB, arroccoN, enPassantB, enPassantN);		// fa la mossa e sistema i pezzi a seconda di ciò
        			 }
        		}
        		return c;
        	}
        	if(pezzoGiocatore.mostraLettera() == 'N' ) {
    			
        		if(pezzoGiocatore.spostamentoPotenziale(c, to) == true || pezzoGiocatore.attacco(c, to) == true) {
    				//fai la mossa, come?
        			if(scacchiera.mossaCavallo(from,to,pezzoGiocatore) == "Mossa avvenuta con successo") {
       				 c = new Stato(scacchiera, giocatore, arroccoB, arroccoN, enPassantB, enPassantN);		// fa la mossa e sistema i pezzi a seconda di ciò
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
        }
    };    

    
    
    
    
    
    
    Stato simulaSpostamentoOCattura (int from, int to) {
    //richiama simulaSpostamentoOCattura (from, to, 0)
        return simulaSpostamentoOCattura (from, to, 0);
    }

    boolean mossaValida (int from, int to, int promozione) {
    /*simula mossa giocatore di turno dalla casa from alla casa to - true se e solo se tale mossa è valida.
    Per essere valida, devono valere entrambe le seguenti condizioni:
    simulaSpostamentoOCattura (from, to, promozione) non deve restituire null;
    lo Stato restituito da simulaSpostamentoOCattura (from, to, promozione) non deve essere tale che il proprio 
    re si trovi in una situazione di scacco (ovvero si trovi in una casa sotto attacco da parte di un pezzo del
    giocatore avversario).*/
        if (simulaSpostamentoOCattura (from, to, promozione) != null) {
        	Stato ris = simulaSpostamentoOCattura (from, to, promozione);
        		if(ris.scacco() != false) {
        		esito = true;
        			}
        } else {
        		esito = false;
        }
        	return esito;
    }

    boolean mossaValida (int from, int to) {
    // richiama e restituisce mossaValida (from, to, 0)
        return mossaValida (from, to, 0);
    };

    boolean eseguiMossa (int from, int to, int promozione) {
    /*modifica lo stato in modo da eseguire la mossa del giocatore di turno dalla casa from alla casa to, 
    e restituisce true, se tale mossa è valida; altrimenti lascia invariato lo stato e restituisce false.*/
    	
    	//modificare lo stato
    	
    	
        if (mossaValida(from, to) == true) {
        	esito = true;
        } else {
        	esito = false;
        }
        return esito;
    }

    boolean eseguiMossa (int from, int to){
    //richiama e restituisce eseguiMossa (from, to, 0)
        return eseguiMossa (from, to, 0);
    };

    } 
  
