import java.util.ArrayList;

public class Scacchiera {
    
    private final int dimensione = 8;
    private Caselle [][] scacchiera = new Caselle[dimensione][dimensione];//le caselle vanno da [0][0] a [7][7]

    /*protected int pos;
    protected int riga=pos%10;
    protected int colonna=pos/10;
    *
    *servono a getPezzo??
    **/
    
    protected Stato c;
    private boolean coloreCasella1=true; //servono nella creazione della scacchiera
    private boolean coloreCasella2=true;

    public Scacchiera () {
    //costruttore che crea la scacchiera, ogni casella un pezzo  
        creaScacchiera();
        inserisciBianchi();
        inserisciNeri();
    }

    
    private void creaScacchiera(){
        for (int i=0; i<dimensione; i++) {
            for (int j=0; j<dimensione; j++) {
                scacchiera[i][j] = new Caselle(coloreCasella1,((j+1)*10)+(i+1));
                if(coloreCasella1==true){
                    coloreCasella1=false;
                } else {
                    coloreCasella1=true;
                }
            }
            if (coloreCasella2==true) {
                coloreCasella2=false;
                coloreCasella1=coloreCasella2;
            } else {
                coloreCasella2=true;
                coloreCasella1=coloreCasella2;
            }
        }   
    }

    
    private void inserisciBianchi(){
        //VERIFICARE SE POSSIBILE INSERIRE [riga][colonna] dato (...pos)
    	
    	
    	for(int i=0; i<8; i++)
    		scacchiera[1][i].inserisciPedina(new Pedone(true));
    	
        scacchiera[0][0].inserisciPedina(new Torre(true));
        scacchiera[0][1].inserisciPedina(new Cavallo(true));
        scacchiera[0][2].inserisciPedina(new Alfiere(true));
        scacchiera[0][3].inserisciPedina(new Regina(true));
        scacchiera[0][4].inserisciPedina(new Re(true));
        scacchiera[0][5].inserisciPedina(new Alfiere(true));
        scacchiera[0][6].inserisciPedina(new Cavallo(true));
        scacchiera[0][7].inserisciPedina(new Torre(true));
    }

    private void inserisciNeri(){
    	
    	for(int i=0; i<8; i++)
    		scacchiera[7][i].inserisciPedina(new Pedone(false));
       
    	scacchiera[7][0].inserisciPedina(new Torre(false));
        scacchiera[7][1].inserisciPedina(new Cavallo(false));
        scacchiera[7][2].inserisciPedina(new Alfiere(false));
        scacchiera[7][3].inserisciPedina(new Regina(false));
        scacchiera[7][4].inserisciPedina(new Re(false));
        scacchiera[7][5].inserisciPedina(new Alfiere(false));
        scacchiera[7][6].inserisciPedina(new Cavallo(false));
        scacchiera[7][7].inserisciPedina(new Torre(false));
    }
    
    public Pezzo getPezzo (int pos) {
    // restituisce il pezzo in posizione pos, null se tale posizione è libera
    	int rigaf = pos%10;
    	int colonnaf = pos/10;
        
    	return scacchiera[rigaf-1][colonnaf-1].getPezzo();
    }

    public int getPos (Pezzo p) {
    //posizione del pezzo. 0 se il pezzo non c'è
    	
    	for(int i=0;i<8;i++)
    		for(int j=0; j<8;j++)
    			if(scacchiera[i][j].getPezzo().mostraLettera() == p.mostraLettera() )
    				return scacchiera[i][j].getPos();
    	return 0;
    }
    

    public Stato getStato (int pos) {
    //stato di una casella
    	int rigaf = pos%10;
    	int colonnaf = pos/10;
        if(scacchiera[rigaf][colonnaf] == null) {
            return null;
        } else {
            return scacchiera[rigaf][colonnaf].getStato();
        }
    }

    public String toString() {
    //stampa bianchi con maiuscole, neri con minuscole e . celle vuote
        String s = "";
        for (int i=dimensione-1; i>=0; i--) {
            for (int j=0; j<dimensione; j++) {
                s = s + (scacchiera[i][j]).getPezzo().mostraLettera();
            }
            s += '\n'; //va a capo per scrivere nuova riga
        }
        return s;  
    }
    public boolean ifOccupata(int pos) {
    	int rigac = pos%10;
    	int colonnac = pos/10;
    	if(this.scacchiera[rigac][colonnac] == null) {
    		return false;
    	}else {
    		return true;
    	}
    }
    public Boolean getColorePezzo(Pezzo p) {
    	return p.white;
    }

    protected Caselle [][] getScacchiera() {
        return scacchiera;
    }
    
    /**
     * restituisce la traversa del giocatore (dove le pedine hanno una promozione)
     * 
     * @param giocatorePM : 1=bianco, 2=nero
     * @return
     * <i>8</i> se il giocatore parte da su
     * <br><i>1</i> altrimenti
     */
    public int getTraversa(int giocatorePM) {
    	
    	return giocatorePM==1?8:1;
    }
   
}
