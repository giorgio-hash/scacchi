import java.util.ArrayList;

public class Scacchiera {
    
    private final int dimensione = 8;
    private Caselle [][] scacchiera = new Caselle[dimensione][dimensione]; 

    /*protected int pos;
    protected int riga=pos%10;
    protected int colonna=pos/10;
    *
    *servono a getPezzo??
    **/
    
    protected Stato c;
    private boolean coloreCasella1=true; //sono entrambe dello stesso colore!
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
                scacchiera[i][j] = new Caselle(coloreCasella1);
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
        scacchiera[2][1] = scacchiera[2][1].inserisciPedina(new Pedone(true), 12);
        scacchiera[2][2] = scacchiera[2][2].inserisciPedina(new Pedone(true), 22);
        scacchiera[2][3] = scacchiera[2][3].inserisciPedina(new Pedone(true), 32);
        scacchiera[2][4] = scacchiera[2][4].inserisciPedina(new Pedone(true), 42);
        scacchiera[2][5] = scacchiera[2][5].inserisciPedina(new Pedone(true), 52);
        scacchiera[2][6] = scacchiera[2][6].inserisciPedina(new Pedone(true), 62);
        scacchiera[2][7] = scacchiera[2][7].inserisciPedina(new Pedone(true), 72);
        scacchiera[2][8] = scacchiera[2][8].inserisciPedina(new Pedone(true), 82);
        scacchiera[1][1] = scacchiera[1][1].inserisciPedina(new Torre(true), 11);
        scacchiera[1][2] = scacchiera[1][2].inserisciPedina(new Cavallo(true), 21);
        scacchiera[1][3] = scacchiera[1][3].inserisciPedina(new Alfiere(true), 31);
        scacchiera[1][4] = scacchiera[1][4].inserisciPedina(new Regina(true), 41);
        scacchiera[1][5] = scacchiera[1][5].inserisciPedina(new Re(true), 51);
        scacchiera[1][6] = scacchiera[1][6].inserisciPedina(new Alfiere(true), 61);
        scacchiera[1][7] = scacchiera[1][7].inserisciPedina(new Cavallo(true), 71);
        scacchiera[1][8] = scacchiera[1][8].inserisciPedina(new Torre(true), 81);
    }

    private void inserisciNeri(){
        scacchiera[8][1] = scacchiera[8][1].inserisciPedina(new Pedone(false), 18);
        scacchiera[8][2] = scacchiera[8][2].inserisciPedina(new Pedone(false), 28);
        scacchiera[8][3] = scacchiera[8][3].inserisciPedina(new Pedone(false), 38);
        scacchiera[8][4] = scacchiera[8][4].inserisciPedina(new Pedone(false), 48);
        scacchiera[8][5] = scacchiera[8][5].inserisciPedina(new Pedone(false), 58);
        scacchiera[8][6] = scacchiera[8][6].inserisciPedina(new Pedone(false), 68);
        scacchiera[8][7] = scacchiera[8][7].inserisciPedina(new Pedone(false), 78);
        scacchiera[8][8] = scacchiera[8][8].inserisciPedina(new Pedone(false), 88);
        scacchiera[8][1] = scacchiera[8][1].inserisciPedina(new Torre(false), 17);
        scacchiera[8][2] = scacchiera[8][2].inserisciPedina(new Cavallo(false), 27);
        scacchiera[8][3] = scacchiera[8][3].inserisciPedina(new Alfiere(false), 37);
        scacchiera[8][4] = scacchiera[8][4].inserisciPedina(new Regina(false), 47);
        scacchiera[8][5] = scacchiera[8][5].inserisciPedina(new Re(false), 57);
        scacchiera[8][6] = scacchiera[8][6].inserisciPedina(new Alfiere(false), 67);
        scacchiera[8][7] = scacchiera[8][7].inserisciPedina(new Cavallo(false), 77);
        scacchiera[8][8] = scacchiera[8][8].inserisciPedina(new Torre(false), 87);
    }
    
    public Pezzo getPezzo (int pos) {
    // restituisce il pezzo in posizione pos, null se tale posizione è libera
    	int rigaf = pos%10;
    	int colonnaf = pos/10;
        if (scacchiera[rigaf][colonnaf] == null) {
            return null;
        } else {
            return scacchiera[rigaf][colonnaf].getPezzo();
        }
    }

    public int getPos (Pezzo p) {
    //posizione del pezzo. 0 se il pezzo non c'è
    	
    	/*
    	int rigaf = pos%10;
    	int colonnaf = pos/10;
        if (scacchiera[rigaf][colonnaf] == null) {
            return 0;
        } else {
            return (scacchiera[rigaf][colonnaf].getPos());
        }
        */
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
        for (int i=dimensione; i>0; i--) {
            for (int j=1; j<=dimensione; j++) {
                s = s + (scacchiera[i][j]).getPezzo().mostraLettera();
            }
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
   
}
