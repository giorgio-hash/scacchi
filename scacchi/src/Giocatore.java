

public class Giocatore extends partita {

    private int giocatorePM;
    private int giocatore1=1; //pezzi bianche
    private int giocatore2=2; //pezzi neri
    private int contatoreMosse;
    
    /*private int pos;
    private Pezzo p;*/

    public Giocatore (int giocatorePM) {
        this.giocatorePM=giocatorePM;
    }

    public int giocatorePM () {
        if (contatoreMosse==0) {
            giocatorePM=giocatore1;
        } else {
            if (giocatorePM==giocatore1) {
                giocatorePM=giocatore2;
            } else {
                giocatorePM=giocatore1;
            }
        }
        return giocatorePM;
    }

    public int getGiocatorePM() {
        return giocatorePM;
    } 

    /*utile?
     * 
     * public Pezzo getRe() {
        return p;
    }

    public int getPos() {
        return p.pos;
    }
  	*/
}
