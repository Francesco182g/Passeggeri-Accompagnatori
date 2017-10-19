/* 
	@copy Coded by Francesco Garofalo 2017
 */
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class MainTest {

	private static Logger logger; //Definisco il logger per stampare messaggi a sistema

	public static void main (String args []) {	

		logger = Logger.getLogger("com.nomeProgetto"); //Serve per stampare messaggi a sistema
		Gestore gestore = new Gestore();
		//UserInterface e scelta opzioni
		/*
		 * Prima scelta Get istanza
		 */
		String scelta1 = JOptionPane.showInputDialog("Definisci l'operazione che vuoi effettuare! 1.Usa un'istanza esistente| 2.Crea una nuova istanza");
		int s1 = Integer.parseInt(scelta1);
		
		if (s1 == 1) {
			String istanza = JOptionPane.showInputDialog("Definisci il nome dell'istanza:");
			try {
				gestore.getLavoratoriDB(istanza);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				gestore.getLavoriDB(istanza);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*
			 * Inserisci criteri 1 e 2
			 */
			String criterio1 = JOptionPane.showInputDialog("Definisci il criterio per gli accompagnatori in servizio. 1.Cmin, 2.Cmax, 3.Random");
			int c1 = Integer.parseInt(criterio1);
			String criterio2 = JOptionPane.showInputDialog("Definisci il criterio per gli accompagnatori non in servizio. 1.Cmin, 2.Cmax, 3.Random");
			int c2 = Integer.parseInt(criterio2);
			
			
			gestore.ordinaPasseggeriInArray();
			gestore.trovaAccompagnatore(c1, c2);
			JOptionPane.showInputDialog("Stampa");
			gestore.stampaArrayLavoratori();
			gestore.stampaArrayLavori();
			/*
			 * Seconda scelta Crea istanza
			 */
		} else if(s1 == 2) {
			/*
			 * Inizializzazione con n,m,L
			 */
			String scelta2 = JOptionPane.showInputDialog("Definisci il numero di passeggeri");
			int n = Integer.parseInt(scelta2);
			
			String scelta3 = JOptionPane.showInputDialog("Definisci il numero di accompagnatori");
			int m = Integer.parseInt(scelta3);
			
			String l = JOptionPane.showInputDialog("Definisci la durata del turno di ogni accompagnatore");
			int L = Integer.parseInt(l);
			/*
			 * Inserisci criteri 1 e 2
			 */
			String criterio1 = JOptionPane.showInputDialog("Definisci il criterio per gli accompagnatori in servizio. 1.Cmin, 2.Cmax, 3.Random");
			int c1 = Integer.parseInt(criterio1);
			String criterio2 = JOptionPane.showInputDialog("Definisci il criterio per gli accompagnatori non in servizio. 1.Cmin, 2.Cmax, 3.Random");
			int c2 = Integer.parseInt(criterio2);
			/*
			 * Definisco il nome dell'istanza, creo accompagnatori, passeggeri e ordino i passeggeri
			 */
			String istanza = JOptionPane.showInputDialog("Definisci il nome dell'istanza:");
			gestore.aggiungiAccompagnatori(m, L, istanza);
			gestore.aggiungiPasseggeri(n, istanza);
			gestore.ordinaPasseggeriInArray();
			//Chiedo all'utente se vuole rendere persistente l'istanza
			String perstok = JOptionPane.showInputDialog("Vuoi rendere persistente l'istanza? 1.Si 2.NO");
			int scelta = Integer.parseInt(perstok);
			if(scelta == 1) {
				try {
					gestore.popolaLavoratoriDB(istanza, m, L);
				} catch (SQLException e) {
					logger.severe("PERSISTENZA NON RIUSCITA!");
					e.printStackTrace();
				}
				try {
					gestore.popolaLavoriDB();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					logger.severe("PERSISTENZA NON RIUSCITA!");
				}
			}
			
			else {
				logger.info("L'istanza " + istanza + "non sarà resa persistente!");
			}
			gestore.trovaAccompagnatore(c1, c2);
			System.out.println("Ho ordinato i passeggeri.");
			JOptionPane.showInputDialog("Stampa");
			gestore.stampaArrayLavoratori();
			gestore.stampaArrayLavori();

		} 
		System.out.println("Arrivederci!");
	}



}


