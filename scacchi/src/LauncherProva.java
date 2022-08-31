import java.util.ArrayList;

public class LauncherProva {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Partita p = new Partita();
		
		System.out.println(p.getStato().getScacchiera().toString());
		
		Pezzo selezionato = p.getStato().getScacchiera().getPezzo(62);

		System.out.println("\n\nturno di: "+p.getStato().getGiocatorePM());
		System.out.println("\n\npezzo selezionato: " + selezionato);
		
		System.out.println("mosse a disposizione: ");
		
		System.out.println(selezionato.listaSpostamentoPotenziale(p.getStato()));
		
		
		try {
			p.eseguiMossa(62, 65);
		} catch (EccezioneMossa e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//reset
		
		System.out.println(p.getStato().getScacchiera().toString());
		
		System.out.println("\nora è il turno di: " + p.getStato().getGiocatorePM());
	}

}
