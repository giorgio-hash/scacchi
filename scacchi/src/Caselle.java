package cleii.scacchi;

public class Caselle extends Scacchiera{

    private Caselle casella;
    private int pos;
    private boolean coloreCasella;
    private Stato stato;
    private Pezzo p;
   
    public Caselle(boolean white) {
        this.coloreCasella=coloreCasella;
    }

    public Caselle inserisciPedina(Pezzo p, int pos) {
        this.p=p;
        this.pos=pos;
        return casella;
    }

    public Caselle togliPedina(Pezzo p, int pos) {
        this.p=null;
        this.pos=pos;
        return casella;
    }

    public int getPos() {
        return pos;
    }
    public Caselle getCasella() {
    	return this.casella;
    }
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
