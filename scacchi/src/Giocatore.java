

public class Giocatore extends partita {

    private int giocatorePM;
    private final int giocatore1=1; //pezzi bianche
    private final int giocatore2=2; //pezzi neri
    private int contatoreMosseGiocatore;
    
    
    private static int contatoreMosse=0; //contatore globale delle mosse (inizializzato a inizio programma)
    
    /*private int pos;
    private Pezzo p;*/

    public Giocatore (int giocatorePM) {
        this.giocatorePM=giocatorePM;
        this.contatoreMosseGiocatore = 0;
    }
    

    /**
     * quando viene richiamata, passa il turno all'altro giocatore. 
     * <br>alla prima chiamata assegna il turno a giocatore1 ovvero bianchi
     * 
     */
    public void setGiocatorePM () {
        if (contatoreMosse==0) {
            giocatorePM=giocatore1;
        } else {
        	giocatorePM = giocatorePM==giocatore1? giocatore2 : giocatore1;	
        }
    }

    /**
     * mostra di chi è il turno
     * <ol>
     * <li>bianchi
     * <li>neri
     * </ol>
     * @return <i>int</i> giocatorePM
     */
    public int getGiocatorePM() {
        return giocatorePM;
    } 

    
    /*
     * non posso fare getRe se non ho una istanza della scacchiera...
     *  
   public Pezzo getRe() {
        return p;
    }

   
    public int getPos() {
        return p.pos;
    }
  	*/
}
