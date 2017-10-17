/* 
	@copy Coded by Francesco Garofalo 2017
 */
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class MainTest {
	
	private static Logger logger; //Definisco il logger per stampare messaggi a sistema

	public static void main (String args []) {	
		
		logger = Logger.getLogger("com.nomeProgetto"); //Serve per stampare messaggi a sistema
		//UserInterface e scelta opzioni
		/*
		 * Prima scelta Get istanza
		 */
		String scelta1 = JOptionPane.showInputDialog("Definisci l'operazione che vuoi effettuare! 1.Usa un'istanza esistente| 2.Crea una nuova istanza");
		int s1 = Integer.parseInt(scelta1);
		if (s1 == 1) {
			
		} else if(s1 == 2) {
			String scelta2 = JOptionPane.showInputDialog("Definisci il numero di passeggeri");
			int n = Integer.parseInt(scelta2);
			String scelta3 = JOptionPane.showInputDialog("Definisci il numero di accompagnatori");
			int m = Integer.parseInt(scelta3);
			String l = JOptionPane.showInputDialog("Definisci la durata del turno di ogni accompagnatore");
			int L = Integer.parseInt(l);
			String criterio1 = JOptionPane.showInputDialog("Definisci il criterio per gli accompagnatori in servizio. 1.Cmin, 2.Cmax, 3.Random");
			int c1 = Integer.parseInt(criterio1);
			String criterio2 = JOptionPane.showInputDialog("Definisci il criterio per gli accompagnatori non in servizio. 1.Cmin, 2.Cmax, 3.Random");
			int c2 = Integer.parseInt(criterio2);
			String istanza = JOptionPane.showInputDialog("Definisci il nome dell'istanza:");
			Gestore gestore = new Gestore();
			gestore.aggiungiAccompagnatori(m, L, istanza);
			gestore.aggiungiPasseggeri(n, istanza);
			gestore.ordinaPasseggeriInArray();
			gestore.stampaArrayLavori();
			JOptionPane.showInputDialog("Ordino i passeggeri:");
			gestore.trovaAccompagnatore(c1, c2);
			System.out.println("Ho ordinato i passeggeri.");
			JOptionPane.showInputDialog("Stampa");
			gestore.stampaArrayLavoratori();
			gestore.stampaArrayLavori();
			
		} else {
			
		}
		
	
		System.out.println("Arrivederci!");
	}
	
	
}
