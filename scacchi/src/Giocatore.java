

public class Giocatore{

    private int giocatorePM;
    private final int giocatore1=1; //pezzi bianche
    private final int giocatore2=2; //pezzi neri
    
    
    /*private int pos;
    private Pezzo p;*/

    public Giocatore (int giocatorePM) {
        this.giocatorePM=giocatorePM;
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
