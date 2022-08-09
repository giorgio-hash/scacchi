
public class Caselle extends Scacchiera{

    private int pos;
    private boolean coloreCasella;
    private Stato stato;
    private Pezzo p;
   
    
    /**
     * Costruttore Caselle
     * @param white : boolean
     * 
     * 
     */
    public Caselle(boolean white, int pos) {
        this.coloreCasella=white;  //correzione: prima c'era coloreCasella
        this.pos = pos;
    }

    public void inserisciPedina(Pezzo p) {
        this.p=p;
    }

    public void togliPedina() {
        this.p=null;
    }

    public int getPos() {
        return pos;
    }
    /*public Caselle getCasella() {  //?? è null
    	return this.casella;
    }*/
    
    public boolean getColoreCasella() {
        return coloreCasella;
    }

    public Stato getStato() {
        return stato;
    }

    public Pezzo getPezzo() {
        return p;
    }

    public boolean getColorePedina() {
        return p.white;
    }

}
