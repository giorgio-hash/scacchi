
/**
 * classe inutile, da eliminare
 * 
 * @author gchir
 *
 */
public class Mossa {
	private int x1, y1, x2, y2,id;
    private String descr = "";
	

    /**
     * le mosse sono rappresentate da un id.<br>
     * id dispari per il giocatore 1<br>
     * id pari per il giocatore 2
     */
    private static int idmossa = 0;
    
	
    
    public Mossa(int from, int to,String descr) {
		this.x1 = x1%10;
		this.y1 = y1/10;
		this.x2 = x2%10;
		this.y2 = y2/10;
		this.id = idmossa++;
		this.descr = descr;
	}
    
    public Mossa(int from, int to) {
		this.x1 = x1%10;
		this.y1 = y1/10;
		this.x2 = x2%10;
		this.y2 = y2/10;
		this.id = idmossa++;
	}

	public int getX1() {
		return x1;
	}

	public int getX2() {
		return x2;
	}

	public int getY1() {
		return y1;
	}


	public int getY2() {
		return y2;
	}
	
	public int getIdMossa() {
		return id;
	}
	

	
	
	public String toString(){ 
		return (x1) + "" + (y1) + " -> " + (x2) + "" + (y2) + descr;
	}
}
