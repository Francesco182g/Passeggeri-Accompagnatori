
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
			
		} else {
			
		}
		
		
		String scelta2 = JOptionPane.showInputDialog(":");
	
		
	}
	
	
}
