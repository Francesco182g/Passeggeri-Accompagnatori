/* 
	@copy Coded by Francesco Garofalo 2017
 */

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;


public class Gestore {
	//private ArrayList lavoratori, Array che contiene tutti i lavoratori (NON UTILIZZATO)
	public ArrayList <Lavoratore> lavoratoriClasse1 = new ArrayList<>(); //Italiano
	public ArrayList <Lavoratore> lavoratoriClasse2 = new ArrayList<>(); //Italiano,Inglese
	public ArrayList <Lavoratore> lavoratoriClasse3 = new ArrayList<>();; //Italiano,Inglese,Francese
	public ArrayList <Lavoratore> lavoratoriClasse4 = new ArrayList<>(); //Italiano,Inglese,Spagnolo
	public ArrayList <Lavoratore> lavoratoriClasse5 = new ArrayList<>(); //Italiano, Inglese, Francese, Spagnolo
	public ArrayList <Lavoro> lavori = new ArrayList<>();
	//private ArrayList <Lavoro> lavoriSenzaAccompagnatori = new ArrayList<>();
	//private ArrayList <Lavoratore> lavoratori = new ArrayList<>(); //TUTTI DAL DATABASE

	private Lavoro lavoro;
	private Lavoratore lavoratore;

	private int divisioniLavori;
	private int divisioneClassi;
	
	private int n;
	private int m;

	private static Logger logger; //Definisco il logger per stampare messaggi a sistema


	public Gestore() 
	{
		super();		
		logger = Logger.getLogger("com.Michele"); //Serve per stampare messaggi a sistema
	}

	/*
	 * Aggiungi accompagnatori
	 */
	public synchronized void aggiungiAccompagnatori(int m, int L, String istanza) {
		this.m = m;
		divisioneClassi = m/5;
		int i = 1;
		System.out.println(m + " e "+ divisioneClassi);
		//Lavoratori Classe 1
		for(i=1; i<=divisioneClassi; i++) {
			lavoratore = new Lavoratore();			
			lavoratore.setIdentificatore(i);
			lavoratore.setOreTotaliServizio(L);
			lavoratore.setLingua("i");
			lavoratore.setOreRimaste(L);
			lavoratore.setOraFineServizio(0);
			lavoratore.setIstanza(istanza);
			lavoratoriClasse1.add(lavoratore);
			//System.out.println("Aggiungo lavoratore: "+lavoratore.toString());

		}

		//Lavoratori Classe 2
		for(i=divisioneClassi+1;i<=divisioneClassi *2 ;i++) {
			lavoratore = new Lavoratore();			

			lavoratore.setIdentificatore(i);
			lavoratore.setOreTotaliServizio(L);
			lavoratore.setLingua("ie");
			lavoratore.setOreRimaste(L);
			lavoratore.setOraFineServizio(0);
			lavoratore.setIstanza(istanza);
			lavoratoriClasse2.add(lavoratore);
			//System.out.println("Aggiungo lavoratore: "+lavoratore.toString());
		}

		//Lavoratori Classe 3
		for(i=divisioneClassi *2 +1;i<=divisioneClassi *3;i++) {
			lavoratore = new Lavoratore();			
			lavoratore.setIdentificatore(i);
			lavoratore.setOreTotaliServizio(L);
			lavoratore.setLingua("ief");
			lavoratore.setOreRimaste(L);
			lavoratore.setOraFineServizio(0);
			lavoratore.setIstanza(istanza);
			lavoratoriClasse3.add(lavoratore);
			//System.out.println("Aggiungo lavoratore: "+lavoratore.toString());

		}

		//Lavoratori Classe 4
		for(i=divisioneClassi *3 +1;i<=divisioneClassi *4;i++) {
			lavoratore = new Lavoratore();			
			lavoratore.setIdentificatore(i);
			lavoratore.setOreTotaliServizio(L);
			lavoratore.setLingua("ies");
			lavoratore.setOreRimaste(L);
			lavoratore.setOraFineServizio(0);
			lavoratore.setIstanza(istanza);
			lavoratoriClasse4.add(lavoratore);
			//System.out.println("Aggiungo lavoratore: "+lavoratore.toString());

		}

		//Lavoratori Classe 5
		for(i=divisioneClassi *4 + 1;i<=m;i++) {
			lavoratore = new Lavoratore();			
			lavoratore.setIdentificatore(i);
			lavoratore.setOreTotaliServizio(L);
			lavoratore.setLingua("iefs");
			lavoratore.setOreRimaste(L);
			lavoratore.setOraFineServizio(0);
			lavoratore.setIstanza(istanza);
			lavoratoriClasse5.add(lavoratore);
			//System.out.println("Aggiungo lavoratore: "+lavoratore.toString());
		}
	}

	/*
	 * Aggiunge i passeggeri
	 */
	public synchronized void aggiungiPasseggeri(int n, String istanza) {
		this.n = n;
		divisioniLavori = n/4;
		//ITA
		for(int i=0; i<divisioniLavori; i++) {
			lavoro = new Lavoro();
			lavoro.setCodicePasseggero(i);
			lavoro.setDurata(6);
			lavoro.setLingua("ita");
			Random random = new Random();
			lavoro.setOraInizio(random.nextInt(200));//Valore max 
			int durata = random.nextInt(10-5) + 5;
			lavoro.setDurata(durata);
			lavoro.setOraFine(lavoro.getOraInizio() + durata);
			lavoro.setLavoratoreAssegnato(0);
			lavoro.setIstanza(istanza);
			lavori.add(lavoro);
		}

		//ENG
		for(int i=divisioniLavori; i<divisioniLavori * 2; i++) {
			lavoro = new Lavoro();
			lavoro.setCodicePasseggero(i);
			lavoro.setDurata(6);
			lavoro.setLingua("eng");
			Random random = new Random();
			lavoro.setOraInizio(random.nextInt(200));//Valore max 
			int durata = random.nextInt(10-5) + 5;
			lavoro.setDurata(durata);
			lavoro.setOraFine(lavoro.getOraInizio() + durata);
			lavoro.setLavoratoreAssegnato(0);
			lavoro.setIstanza(istanza);
			lavori.add(lavoro);
		}

		//FRA	
		for(int i=divisioniLavori * 2; i<divisioniLavori * 3; i++) {
			lavoro = new Lavoro();
			lavoro.setCodicePasseggero(i);
			lavoro.setDurata(6);
			lavoro.setLingua("fra");
			Random random = new Random();
			lavoro.setOraInizio(random.nextInt(200));//Valore max 240
			int durata = random.nextInt(10-5) + 5;
			lavoro.setDurata(durata);
			lavoro.setOraFine(lavoro.getOraInizio() + durata);
			lavoro.setLavoratoreAssegnato(0);
			lavoro.setIstanza(istanza);
			lavori.add(lavoro);
		}

		//SPA	
		for(int i=divisioniLavori * 3; i<divisioniLavori * 4; i++) {
			lavoro = new Lavoro();
			lavoro.setCodicePasseggero(i);
			lavoro.setDurata(6);
			lavoro.setLingua("spa");
			Random random = new Random();
			lavoro.setOraInizio(random.nextInt(200));//Valore max 240
			int durata = random.nextInt(10-5) + 5;
			lavoro.setDurata(durata);
			lavoro.setOraFine(lavoro.getOraInizio() + durata);
			lavoro.setLavoratoreAssegnato(0);
			lavoro.setIstanza(istanza);
			lavori.add(lavoro);
		}
	}

	/*
	 * ALGORITMO ORDINAMENTO
	 * Si occupa di ordinare gli elementi dell'array di passeggeri (Selection Sort)
	 */
	public synchronized void ordinaPasseggeriInArray()  {
		for(int i=0; i<lavori.size(); i++) {
			for(int j=0; j<lavori.size(); j++) {
				if(lavori.get(i).getOraInizio() < lavori.get(j).getOraInizio()) {
					Lavoro lavoroi = new Lavoro();
					Lavoro lavoroj = new Lavoro();
					lavoroi = lavori.get(i);
					lavoroj = lavori.get(j);
					lavori.set(i, lavoroj);
					lavori.set(j, lavoroi);
					logger.info("Algoritmo ordinamento: sposto: " +i+ " a: " +j);
				}
			}
		}
		System.out.println("SELECTION SORT: Ordinamento brutale completato!");
	}

	/*
	 * Controllo per ogni passeggero se è presente un accompagnatore che possa servirlo
	 * @Param due criteri inseriti dall'utente 
	 */
	public synchronized void trovaAccompagnatore(int c1, int c2) {
		logger.info("ESEGUO TROVA ACCOMPAGNATORE");
		for(int i=0; i< lavori.size(); i++) {
			if(lavori.get(i).getLingua().equals("ita")) {
				logger.info("Istanza: " +lavori.get(i).toString());
				int id = trovaAccompagnatoreItaliano(lavori.get(i).getDurata(), lavori.get(i).getOraInizio(), lavori.get(i).getOraFine(), c1, c2);
				if(id != 0) {
					lavori.get(i).setLavoratoreAssegnato(id);
				} else {
					logger.info("Nessun accompagnatore trovato per: "+lavori.get(i).getCodicePasseggero());
				}
			} if(lavori.get(i).getLingua().equals("eng")) {
				int id = trovaAccompagnatoreInglese(lavori.get(i).getDurata(), lavori.get(i).getOraInizio(), lavori.get(i).getOraFine(), c1, c2);
				if(id != 0) {
					lavori.get(i).setLavoratoreAssegnato(id);
				} else {
					logger.info("Nessun accompagnatore trovato per: "+lavori.get(i).getCodicePasseggero());
				}
			} if(lavori.get(i).getLingua().equals("fra")) {
				int id = trovaAccompagnatoreFrancese(lavori.get(i).getDurata(), lavori.get(i).getOraInizio(), lavori.get(i).getOraFine(), c1, c2);
				if(id != 0) {
					lavori.get(i).setLavoratoreAssegnato(id);
				} else {
					logger.info("Nessun accompagnatore trovato per: "+lavori.get(i).getCodicePasseggero());
				}
			} if(lavori.get(i).getLingua().equals("spa")) {
				int id = trovaAccompagnatoreSpagnolo(lavori.get(i).getDurata(), lavori.get(i).getOraInizio(), lavori.get(i).getOraFine(), c1, c2);
				if(id != 0) {
					lavori.get(i).setLavoratoreAssegnato(id);
				} else {
					logger.info("Nessun accompagnatore trovato per: "+lavori.get(i).getCodicePasseggero());
				}
			}
		}
	}

	
	
	/*
	 * LINGUA ITALIANA
	 */
	/*
	 * Metodo per trovare accompagnatori Italiani
	 * Input: C1, C2, durata, orainzio, orafine
	 */
	public synchronized int trovaAccompagnatoreItaliano(int durata, int oraInizio, int oraFine, int c1, int c2) {
		int id = 0;
		if(c1 == 1 & c2 == 1) {
			id = trovaAccompagnatoreItalianoCminCmin(durata, oraInizio, oraFine);
		} if (c1 == 1 & c2 == 2) {
			id = trovaAccompagnatoreItalianoCminCmax(durata, oraInizio, oraFine);
		} if (c1 == 2 & c2 == 1) {
			id = trovaAccompagnatoreItalianoCmaxCmin(durata, oraInizio, oraFine);
		} if (c1 == 2 & c2 == 2) {
			id = trovaAccompagnatoreItalianoCmaxCmax(durata, oraInizio, oraFine);
		} if (c1 == 1 & c2 == 3) {
			id = trovaAccompagnatoreItalianoCminRand(durata, oraInizio, oraFine);
		} if (c1 == 2 & c2 == 3) {
			id = trovaAccompagnatoreItalianoCmaxRand(durata, oraInizio, oraFine);
		} if (c1 == 3 & c2 == 1) {
			id = trovaAccompagnatoreItalianoRandCmin(durata, oraInizio, oraFine);
		} if (c1 == 3 & c2 == 2) {
			id = trovaAccompagnatoreItalianoRandCmax(durata, oraInizio, oraFine);
		} if (c1 == 3 & c2 == 3) {
			id = trovaAccompagnatoreItalianoRandRand(durata, oraInizio, oraFine);
		} else {
			//logger.severe("CRITERI ERRATI");
		}
		return id;
	}

	/*
	 * TrovaAccompagnatoreItaliano
	 * Criteri: Cmin Cmin
	 */
	public synchronized int trovaAccompagnatoreItalianoCminCmin(int durata, int oraInizio, int oraFine) {
		int id = 0;
		id = cercaLavoratoreClasse1ISCmin(durata, oraInizio, oraFine);
		if(id == 0) {
			id = cercaLavoratoreClasse1NISCmin(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse2ISCmin(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse2NISCmin(durata, oraInizio, oraFine);
		} 
		Random rand = new Random();
		int r = rand.nextInt(2);
		if(r == 1) {
			if (id == 0) {
				id = cercaLavoratoreClasse3ISCmin(durata, oraInizio, oraFine);
			} if (id == 0) {
				id = cercaLavoratoreClasse3NISCmin(durata, oraInizio, oraFine);
			}
		} else {
			if (id == 0) {
				id = cercaLavoratoreClasse4ISCmin(durata, oraInizio, oraFine);
			} if (id == 0) {
				id = cercaLavoratoreClasse4NISCmin(durata, oraInizio, oraFine);
			} 
		}
		if (id == 0) {
			id = cercaLavoratoreClasse5ISCmin(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5NISCmin(durata, oraInizio, oraFine);
		} else {
			logger.severe("TrovaAccompagnatoreItalianoCminCmin: Non ho trovato Accompagnatori");
		}
		return id;
	}

	/*
	 * TrovaAccompagnatoreItaliano
	 * Criteri: Cmin Cmax
	 */
	public synchronized int trovaAccompagnatoreItalianoCminCmax(int durata, int oraInizio, int oraFine) {
		int id = 0;
		id = cercaLavoratoreClasse1ISCmin(durata, oraInizio, oraFine);
		if(id == 0) {
			id = cercaLavoratoreClasse1NISCmax(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse2ISCmin(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse2NISCmax(durata, oraInizio, oraFine);
		} 
		Random rand = new Random();
		int r = rand.nextInt(2);
		if(r == 1) {
			if (id == 0) {
				id = cercaLavoratoreClasse3ISCmin(durata, oraInizio, oraFine);
			} if (id == 0) {
				id = cercaLavoratoreClasse3NISCmax(durata, oraInizio, oraFine);
			}
		} else {
			if (id == 0) {
				id = cercaLavoratoreClasse4ISCmin(durata, oraInizio, oraFine);
			} if (id == 0) {
				id = cercaLavoratoreClasse4NISCmax(durata, oraInizio, oraFine);
			} 
		}
		if (id == 0) {
			id = cercaLavoratoreClasse5ISCmin(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5NISCmax(durata, oraInizio, oraFine);
		} else {
			logger.severe("TrovaAccompagnatoreItalianoCminCmax: Non ho trovato Accompagnatori");
		}
		return id;
	}

	/*
	 * TrovaAccompagnatoreItaliano
	 * Criteri: Cmax Cmin
	 */
	public synchronized int trovaAccompagnatoreItalianoCmaxCmin(int durata, int oraInizio, int oraFine) {
		int id = 0;
		id = cercaLavoratoreClasse1ISCmax(durata, oraInizio, oraFine);
		if(id == 0) {
			id = cercaLavoratoreClasse1NISCmin(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse2ISCmax(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse2NISCmin(durata, oraInizio, oraFine);
		} 
		Random rand = new Random();
		int r = rand.nextInt(2);
		if(r == 1) {
			if (id == 0) {
				id = cercaLavoratoreClasse3ISCmax(durata, oraInizio, oraFine);
			} if (id == 0) {
				id = cercaLavoratoreClasse3NISCmin(durata, oraInizio, oraFine);
			}
		} else {
			if (id == 0) {
				id = cercaLavoratoreClasse4ISCmax(durata, oraInizio, oraFine);
			} if (id == 0) {
				id = cercaLavoratoreClasse4NISCmin(durata, oraInizio, oraFine);
			} 
		}
		if (id == 0) {
			id = cercaLavoratoreClasse5ISCmax(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5NISCmin(durata, oraInizio, oraFine);
		} else {
			logger.severe("TrovaAccompagnatoreItalianoCmaxCmin: Non ho trovato Accompagnatori");
		}
		return id;
	}

	/*
	 * TrovaAccompagnatoreItaliano
	 * Criteri: Cmax Cmax
	 */
	public synchronized int trovaAccompagnatoreItalianoCmaxCmax(int durata, int oraInizio, int oraFine) {
		int id = 0;
		id = cercaLavoratoreClasse1ISCmax(durata, oraInizio, oraFine);
		if(id == 0) {
			id = cercaLavoratoreClasse1NISCmax(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse2ISCmax(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse2NISCmax(durata, oraInizio, oraFine);
		} 
		Random rand = new Random();
		int r = rand.nextInt(2);
		if(r == 1) {
			if (id == 0) {
				id = cercaLavoratoreClasse3ISCmax(durata, oraInizio, oraFine);
			} if (id == 0) {
				id = cercaLavoratoreClasse3NISCmax(durata, oraInizio, oraFine);
			}
		} else {
			if (id == 0) {
				id = cercaLavoratoreClasse4ISCmax(durata, oraInizio, oraFine);
			} if (id == 0) {
				id = cercaLavoratoreClasse4NISCmax(durata, oraInizio, oraFine);
			} 
		}
		if (id == 0) {
			id = cercaLavoratoreClasse5ISCmax(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5NISCmax(durata, oraInizio, oraFine);
		} else {
			logger.severe("TrovaAccompagnatoreItalianoCmaxCmax: Non ho trovato Accompagnatori");
		}
		return id;
	}

	/*
	 * TrovaAccompagnatoreItaliano
	 * Criteri: Cmin Rand
	 */
	public synchronized int trovaAccompagnatoreItalianoCminRand(int durata, int oraInizio, int oraFine) {
		int id = 0;
		id = cercaLavoratoreClasse1ISCmin(durata, oraInizio, oraFine);
		if(id == 0) {
			id = cercaLavoratoreClasse1NISRandom(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse2ISCmin(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse2NISRandom(durata, oraInizio, oraFine);
		} 
		Random rand = new Random();
		int r = rand.nextInt(2);
		if(r == 1) {
			if (id == 0) {
				id = cercaLavoratoreClasse3ISCmin(durata, oraInizio, oraFine);
			} if (id == 0) {
				id = cercaLavoratoreClasse3NISRandom(durata, oraInizio, oraFine);
			}
		} else {
			if (id == 0) {
				id = cercaLavoratoreClasse4ISCmin(durata, oraInizio, oraFine);
			} if (id == 0) {
				id = cercaLavoratoreClasse4NISRandom(durata, oraInizio, oraFine);
			} 
		}
		if (id == 0) {
			id = cercaLavoratoreClasse5ISCmin(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5NISRandom(durata, oraInizio, oraFine);
		} else {
			logger.severe("TrovaAccompagnatoreItalianoCminRandom: Non ho trovato Accompagnatori");
		}
		return id;
	}

	/*
	 * TrovaAccompagnatoreItaliano
	 * Criteri: Cmax Rand
	 */
	public synchronized int trovaAccompagnatoreItalianoCmaxRand(int durata, int oraInizio, int oraFine) {
		int id = 0;
		id = cercaLavoratoreClasse1ISCmax(durata, oraInizio, oraFine);
		if(id == 0) {
			id = cercaLavoratoreClasse1NISRandom(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse2ISCmax(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse2NISRandom(durata, oraInizio, oraFine);
		} 
		Random rand = new Random();
		int r = rand.nextInt(2);
		if(r == 1) {
			if (id == 0) {
				id = cercaLavoratoreClasse3ISCmax(durata, oraInizio, oraFine);
			} if (id == 0) {
				id = cercaLavoratoreClasse3NISRandom(durata, oraInizio, oraFine);
			}
		} else {
			if (id == 0) {
				id = cercaLavoratoreClasse4ISCmax(durata, oraInizio, oraFine);
			} if (id == 0) {
				id = cercaLavoratoreClasse4NISRandom(durata, oraInizio, oraFine);
			} 
		}
		if (id == 0) {
			id = cercaLavoratoreClasse5ISCmax(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5NISRandom(durata, oraInizio, oraFine);
		} else {
			logger.severe("TrovaAccompagnatoreItalianoCmaxRandom: Non ho trovato Accompagnatori");
		}
		return id;
	}

	/*
	 * TrovaAccompagnatoreItaliano
	 * Criteri: Rand Cmin
	 */
	public synchronized int trovaAccompagnatoreItalianoRandCmin(int durata, int oraInizio, int oraFine) {
		int id = 0;
		id = cercaLavoratoreClasse1ISRandom(durata, oraInizio, oraFine);
		if(id == 0) {
			id = cercaLavoratoreClasse1NISCmin(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse2ISRandom(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse2NISCmin(durata, oraInizio, oraFine);
		} 
		Random rand = new Random();
		int r = rand.nextInt(2);
		if(r == 1) {
			if (id == 0) {
				id = cercaLavoratoreClasse3ISRandom(durata, oraInizio, oraFine);
			} if (id == 0) {
				id = cercaLavoratoreClasse3NISCmin(durata, oraInizio, oraFine);
			}
		} else {
			if (id == 0) {
				id = cercaLavoratoreClasse4ISRandom(durata, oraInizio, oraFine);
			} if (id == 0) {
				id = cercaLavoratoreClasse4NISCmin(durata, oraInizio, oraFine);
			} 
		}
		if (id == 0) {
			id = cercaLavoratoreClasse5ISRandom(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5NISCmin(durata, oraInizio, oraFine);
		} else {
			logger.severe("TrovaAccompagnatoreItalianoRandomCmin: Non ho trovato Accompagnatori");
		}
		return id;
	}

	/*
	 * TrovaAccompagnatoreItaliano
	 * Criteri: Rand Cmax
	 */
	public synchronized int trovaAccompagnatoreItalianoRandCmax(int durata, int oraInizio, int oraFine) {
		int id = 0;
		id = cercaLavoratoreClasse1ISRandom(durata, oraInizio, oraFine);
		if(id == 0) {
			id = cercaLavoratoreClasse1NISCmax(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse2ISRandom(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse2NISCmax(durata, oraInizio, oraFine);
		} 
		Random rand = new Random();
		int r = rand.nextInt(2);
		if(r == 1) {
			if (id == 0) {
				id = cercaLavoratoreClasse3ISRandom(durata, oraInizio, oraFine);
			} if (id == 0) {
				id = cercaLavoratoreClasse3NISCmax(durata, oraInizio, oraFine);
			}
		} else {
			if (id == 0) {
				id = cercaLavoratoreClasse4ISRandom(durata, oraInizio, oraFine);
			} if (id == 0) {
				id = cercaLavoratoreClasse4NISCmax(durata, oraInizio, oraFine);
			} 
		}
		if (id == 0) {
			id = cercaLavoratoreClasse5ISRandom(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5NISCmax(durata, oraInizio, oraFine);
		} else {
			logger.severe("TrovaAccompagnatoreItalianoRandomCmax: Non ho trovato Accompagnatori");
		}
		return id;
	}

	/*
	 * TrovaAccompagnatoreItaliano
	 * Criteri: Rand Rand
	 */
	public synchronized int trovaAccompagnatoreItalianoRandRand(int durata, int oraInizio, int oraFine) {
		int id = 0;
		id = cercaLavoratoreClasse1ISRandom(durata, oraInizio, oraFine);
		if(id == 0) {
			id = cercaLavoratoreClasse1NISRandom(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse2ISRandom(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse2NISRandom(durata, oraInizio, oraFine);
		} 
		Random rand = new Random();
		int r = rand.nextInt(2);
		if(r == 1) {
			if (id == 0) {
				id = cercaLavoratoreClasse3ISRandom(durata, oraInizio, oraFine);
			} if (id == 0) {
				id = cercaLavoratoreClasse3NISRandom(durata, oraInizio, oraFine);
			}
		} else {
			if (id == 0) {
				id = cercaLavoratoreClasse4ISRandom(durata, oraInizio, oraFine);
			} if (id == 0) {
				id = cercaLavoratoreClasse4NISRandom(durata, oraInizio, oraFine);
			} 
		}
		if (id == 0) {
			id = cercaLavoratoreClasse5ISRandom(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5NISRandom(durata, oraInizio, oraFine);
		} else {
			logger.severe("TrovaAccompagnatoreItalianoRandomRandom: Non ho trovato Accompagnatori");
		}
		return id;
	}


	/*
	 * LINGUA INGLESE
	 */
	/*
	 * Metodo per trovare accompagnatori Inglesi
	 * Input: C1, C2, durata, orainzio, orafine
	 */
	public synchronized int trovaAccompagnatoreInglese(int durata, int oraInizio, int oraFine, int c1, int c2) {
		int id = 0;
		if(c1 == 1 & c2 == 1) {
			id = trovaAccompagnatoreIngleseCminCmin(durata, oraInizio, oraFine);
		} if (c1 == 1 & c2 == 2) {
			id = trovaAccompagnatoreIngleseCminCmax(durata, oraInizio, oraFine);
		} if (c1 == 2 & c2 == 1) {
			id = trovaAccompagnatoreIngleseCmaxCmin(durata, oraInizio, oraFine);
		} if (c1 == 2 & c2 == 2) {
			id = trovaAccompagnatoreIngleseCmaxCmax(durata, oraInizio, oraFine);
		} if (c1 == 1 & c2 == 3) {
			id = trovaAccompagnatoreIngleseCminRand(durata, oraInizio, oraFine);
		} if (c1 == 2 & c2 == 3) {
			id = trovaAccompagnatoreIngleseCmaxRand(durata, oraInizio, oraFine);
		} if (c1 == 3 & c2 == 1) {
			id = trovaAccompagnatoreIngleseRandCmin(durata, oraInizio, oraFine);
		} if (c1 == 3 & c2 == 2) {
			id = trovaAccompagnatoreIngleseRandCmax(durata, oraInizio, oraFine);
		} if (c1 == 3 & c2 == 3) {
			id = trovaAccompagnatoreIngleseRandRand(durata, oraInizio, oraFine);
		} else {
			//logger.severe("CRITERI ERRATI");
		}
		return id;
	}

	/*
	 * TrovaAccompagnatoreInglese
	 * Criteri: Cmin Cmin
	 */
	public synchronized int trovaAccompagnatoreIngleseCminCmin(int durata, int oraInizio, int oraFine) {
		int id = 0;
		id = cercaLavoratoreClasse2ISCmin(durata, oraInizio, oraFine);
		if (id == 0) {
			id = cercaLavoratoreClasse2NISCmin(durata, oraInizio, oraFine);
		} 
		Random rand = new Random();
		int r = rand.nextInt(2);
		if(r == 1) {
			if (id == 0) {
				id = cercaLavoratoreClasse3ISCmin(durata, oraInizio, oraFine);
			} if (id == 0) {
				id = cercaLavoratoreClasse3NISCmin(durata, oraInizio, oraFine);
			}
		} else {
			if (id == 0) {
				id = cercaLavoratoreClasse4ISCmin(durata, oraInizio, oraFine);
			} if (id == 0) {
				id = cercaLavoratoreClasse4NISCmin(durata, oraInizio, oraFine);
			} 
		}
		if (id == 0) {
			id = cercaLavoratoreClasse5ISCmin(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5NISCmin(durata, oraInizio, oraFine);
		} else {
			logger.severe("TrovaAccompagnatoreIngleseCminCmin: Non ho trovato Accompagnatori");
		}
		return id;
	}

	/*
	 * TrovaAccompagnatoreInglese
	 * Criteri: Cmin Cmax
	 */
	public synchronized int trovaAccompagnatoreIngleseCminCmax(int durata, int oraInizio, int oraFine) {
		int id = 0;
		id = cercaLavoratoreClasse2ISCmin(durata, oraInizio, oraFine);
		if (id == 0) {
			id = cercaLavoratoreClasse2NISCmax(durata, oraInizio, oraFine);
		} 
		Random rand = new Random();
		int r = rand.nextInt(2);
		if(r == 1) {
			if (id == 0) {
				id = cercaLavoratoreClasse3ISCmin(durata, oraInizio, oraFine);
			} if (id == 0) {
				id = cercaLavoratoreClasse3NISCmax(durata, oraInizio, oraFine);
			}
		} else {
			if (id == 0) {
				id = cercaLavoratoreClasse4ISCmin(durata, oraInizio, oraFine);
			} if (id == 0) {
				id = cercaLavoratoreClasse4NISCmax(durata, oraInizio, oraFine);
			} 
		}
		if (id == 0) {
			id = cercaLavoratoreClasse5ISCmin(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5NISCmax(durata, oraInizio, oraFine);
		} else {
			logger.severe("TrovaAccompagnatoreIngleseCminCmax: Non ho trovato Accompagnatori");
		}
		return id;
	}

	/*
	 * TrovaAccompagnatoreInglese
	 * Criteri: Cmax Cmin
	 */
	public synchronized int trovaAccompagnatoreIngleseCmaxCmin(int durata, int oraInizio, int oraFine) {
		int id = 0;
		id = cercaLavoratoreClasse2ISCmax(durata, oraInizio, oraFine);
		if (id == 0) {
			id = cercaLavoratoreClasse2NISCmin(durata, oraInizio, oraFine);
		} 
		Random rand = new Random();
		int r = rand.nextInt(2);
		if(r == 1) {
			if (id == 0) {
				id = cercaLavoratoreClasse3ISCmax(durata, oraInizio, oraFine);
			} if (id == 0) {
				id = cercaLavoratoreClasse3NISCmin(durata, oraInizio, oraFine);
			}
		} else {
			if (id == 0) {
				id = cercaLavoratoreClasse4ISCmax(durata, oraInizio, oraFine);
			} if (id == 0) {
				id = cercaLavoratoreClasse4NISCmin(durata, oraInizio, oraFine);
			} 
		}
		if (id == 0) {
			id = cercaLavoratoreClasse5ISCmax(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5NISCmin(durata, oraInizio, oraFine);
		} else {
			logger.severe("TrovaAccompagnatoreIngleseCmaxCmin: Non ho trovato Accompagnatori");
		}
		return id;
	}

	/*
	 * TrovaAccompagnatoreInglese
	 * Criteri: Cmax Cmax
	 */
	public synchronized int trovaAccompagnatoreIngleseCmaxCmax(int durata, int oraInizio, int oraFine) {
		int id = 0;
		id = cercaLavoratoreClasse2ISCmax(durata, oraInizio, oraFine);
		if (id == 0) {
			id = cercaLavoratoreClasse2NISCmax(durata, oraInizio, oraFine);
		} 
		Random rand = new Random();
		int r = rand.nextInt(2);
		if(r == 1) {
			if (id == 0) {
				id = cercaLavoratoreClasse3ISCmax(durata, oraInizio, oraFine);
			} if (id == 0) {
				id = cercaLavoratoreClasse3NISCmax(durata, oraInizio, oraFine);
			}
		} else {
			if (id == 0) {
				id = cercaLavoratoreClasse4ISCmax(durata, oraInizio, oraFine);
			} if (id == 0) {
				id = cercaLavoratoreClasse4NISCmax(durata, oraInizio, oraFine);
			} 
		}
		if (id == 0) {
			id = cercaLavoratoreClasse5ISCmax(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5NISCmax(durata, oraInizio, oraFine);
		} else {
			logger.severe("TrovaAccompagnatoreIngleseCmaxCmax: Non ho trovato Accompagnatori");
		}
		return id;
	}

	/*
	 * TrovaAccompagnatoreInglese
	 * Criteri: Cmin Rand
	 */
	public synchronized int trovaAccompagnatoreIngleseCminRand(int durata, int oraInizio, int oraFine) {
		int id = 0;
		id = cercaLavoratoreClasse2ISCmin(durata, oraInizio, oraFine);
		if (id == 0) {
			id = cercaLavoratoreClasse2NISRandom(durata, oraInizio, oraFine);
		} 
		Random rand = new Random();
		int r = rand.nextInt(2);
		if(r == 1) {
			if (id == 0) {
				id = cercaLavoratoreClasse3ISCmin(durata, oraInizio, oraFine);
			} if (id == 0) {
				id = cercaLavoratoreClasse3NISRandom(durata, oraInizio, oraFine);
			}
		} else {
			if (id == 0) {
				id = cercaLavoratoreClasse4ISCmin(durata, oraInizio, oraFine);
			} if (id == 0) {
				id = cercaLavoratoreClasse4NISRandom(durata, oraInizio, oraFine);
			} 
		}
		if (id == 0) {
			id = cercaLavoratoreClasse5ISCmin(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5NISRandom(durata, oraInizio, oraFine);
		} else {
			logger.severe("TrovaAccompagnatoreIngleseCminRandom: Non ho trovato Accompagnatori");
		}
		return id;
	}

	/*
	 * TrovaAccompagnatoreInglese
	 * Criteri: Cmax Rand
	 */
	public synchronized int trovaAccompagnatoreIngleseCmaxRand(int durata, int oraInizio, int oraFine) {
		int id = 0;
		id = cercaLavoratoreClasse2ISCmax(durata, oraInizio, oraFine);
		if (id == 0) {
			id = cercaLavoratoreClasse2NISRandom(durata, oraInizio, oraFine);
		} 
		Random rand = new Random();
		int r = rand.nextInt(2);
		if(r == 1) {
			if (id == 0) {
				id = cercaLavoratoreClasse3ISCmax(durata, oraInizio, oraFine);
			} if (id == 0) {
				id = cercaLavoratoreClasse3NISRandom(durata, oraInizio, oraFine);
			}
		} else {
			if (id == 0) {
				id = cercaLavoratoreClasse4ISCmax(durata, oraInizio, oraFine);
			} if (id == 0) {
				id = cercaLavoratoreClasse4NISRandom(durata, oraInizio, oraFine);
			} 
		}
		if (id == 0) {
			id = cercaLavoratoreClasse5ISCmax(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5NISRandom(durata, oraInizio, oraFine);
		} else {
			logger.severe("TrovaAccompagnatoreIngleseCmaxRandom: Non ho trovato Accompagnatori");
		}
		return id;
	}

	/*
	 * TrovaAccompagnatoreInglese
	 * Criteri: Rand Cmin
	 */
	public synchronized int trovaAccompagnatoreIngleseRandCmin(int durata, int oraInizio, int oraFine) {
		int id = 0;
		id = cercaLavoratoreClasse2ISRandom(durata, oraInizio, oraFine);
		if (id == 0) {
			id = cercaLavoratoreClasse2NISCmin(durata, oraInizio, oraFine);
		} 
		Random rand = new Random();
		int r = rand.nextInt(2);
		if(r == 1) {
			if (id == 0) {
				id = cercaLavoratoreClasse3ISRandom(durata, oraInizio, oraFine);
			} if (id == 0) {
				id = cercaLavoratoreClasse3NISCmin(durata, oraInizio, oraFine);
			}
		} else {
			if (id == 0) {
				id = cercaLavoratoreClasse4ISRandom(durata, oraInizio, oraFine);
			} if (id == 0) {
				id = cercaLavoratoreClasse4NISCmin(durata, oraInizio, oraFine);
			} 
		}
		if (id == 0) {
			id = cercaLavoratoreClasse5ISRandom(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5NISCmin(durata, oraInizio, oraFine);
		} else {
			logger.severe("TrovaAccompagnatoreIngleseRandomCmin: Non ho trovato Accompagnatori");
		}
		return id;
	}

	/*
	 * TrovaAccompagnatoreInglese
	 * Criteri: Rand Cmax
	 */
	public synchronized int trovaAccompagnatoreIngleseRandCmax(int durata, int oraInizio, int oraFine) {
		int id = 0;

		id = cercaLavoratoreClasse2ISRandom(durata, oraInizio, oraFine);
		if (id == 0) {
			id = cercaLavoratoreClasse2NISCmax(durata, oraInizio, oraFine);
		} 
		Random rand = new Random();
		int r = rand.nextInt(2);
		if(r == 1) {
			if (id == 0) {
				id = cercaLavoratoreClasse3ISRandom(durata, oraInizio, oraFine);
			} if (id == 0) {
				id = cercaLavoratoreClasse3NISCmax(durata, oraInizio, oraFine);
			}
		} else {
			if (id == 0) {
				id = cercaLavoratoreClasse4ISRandom(durata, oraInizio, oraFine);
			} if (id == 0) {
				id = cercaLavoratoreClasse4NISCmax(durata, oraInizio, oraFine);
			} 
		}
		if (id == 0) {
			id = cercaLavoratoreClasse5ISRandom(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5NISCmax(durata, oraInizio, oraFine);
		} else {
			logger.severe("TrovaAccompagnatoreIngleseRandomCmax: Non ho trovato Accompagnatori");
		}
		return id;
	}

	/*
	 * TrovaAccompagnatoreInglese
	 * Criteri: Rand Rand
	 */
	public synchronized int trovaAccompagnatoreIngleseRandRand(int durata, int oraInizio, int oraFine) {
		int id = 0;

		id = cercaLavoratoreClasse2ISRandom(durata, oraInizio, oraFine);
		if (id == 0) {
			id = cercaLavoratoreClasse2NISRandom(durata, oraInizio, oraFine);
		} 
		Random rand = new Random();
		int r = rand.nextInt(2);
		if(r == 1) {
			if (id == 0) {
				id = cercaLavoratoreClasse3ISRandom(durata, oraInizio, oraFine);
			} if (id == 0) {
				id = cercaLavoratoreClasse3NISRandom(durata, oraInizio, oraFine);
			}
		} else {
			if (id == 0) {
				id = cercaLavoratoreClasse4ISRandom(durata, oraInizio, oraFine);
			} if (id == 0) {
				id = cercaLavoratoreClasse4NISRandom(durata, oraInizio, oraFine);
			} 
		}
		if (id == 0) {
			id = cercaLavoratoreClasse5ISRandom(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5NISRandom(durata, oraInizio, oraFine);
		} else {
			logger.severe("TrovaAccompagnatoreItalianoRandomRandom: Non ho trovato Accompagnatori");
		}
		return id;
	}

	/*
	 * LINGUA FRANCESE
	 */
	/*
	 * Metodo per trovare accompagnatori Francesi
	 * Input: C1, C2, durata, orainzio, orafine
	 */
	public synchronized int trovaAccompagnatoreFrancese(int durata, int oraInizio, int oraFine, int c1, int c2) {
		int id = 0;
		if(c1 == 1 & c2 == 1) {
			id = trovaAccompagnatoreFranceseCminCmin(durata, oraInizio, oraFine);
		} if (c1 == 1 & c2 == 2) {
			id = trovaAccompagnatoreFranceseCminCmax(durata, oraInizio, oraFine);
		} if (c1 == 2 & c2 == 1) {
			id = trovaAccompagnatoreFranceseCmaxCmin(durata, oraInizio, oraFine);
		} if (c1 == 2 & c2 == 2) {
			id = trovaAccompagnatoreFranceseCmaxCmax(durata, oraInizio, oraFine);
		} if (c1 == 1 & c2 == 3) {
			id = trovaAccompagnatoreFranceseCminRand(durata, oraInizio, oraFine);
		} if (c1 == 2 & c2 == 3) {
			id = trovaAccompagnatoreFranceseCmaxRand(durata, oraInizio, oraFine);
		} if (c1 == 3 & c2 == 1) {
			id = trovaAccompagnatoreFranceseRandCmin(durata, oraInizio, oraFine);
		} if (c1 == 3 & c2 == 2) {
			id = trovaAccompagnatoreFranceseRandCmax(durata, oraInizio, oraFine);
		} if (c1 == 3 & c2 == 3) {
			id = trovaAccompagnatoreFranceseRandRand(durata, oraInizio, oraFine);
		} else {
			//logger.severe("CRITERI ERRATI");
		}
		return id;
	}

	/*
	 * TrovaAccompagnatoreFrancese
	 * Criteri: Cmin Cmin
	 */
	public synchronized int trovaAccompagnatoreFranceseCminCmin(int durata, int oraInizio, int oraFine) {
		int id = 0;
		id = cercaLavoratoreClasse3ISCmin(durata, oraInizio, oraFine);
		if (id == 0) {
			id = cercaLavoratoreClasse3NISCmin(durata, oraInizio, oraFine);
		} 
		if (id == 0) {
			id = cercaLavoratoreClasse5ISCmin(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5NISCmin(durata, oraInizio, oraFine);
		} else {
			logger.severe("TrovaAccompagnatoreFranceseCminCmin: Non ho trovato Accompagnatori");
		}
		return id;
	}

	/*
	 * TrovaAccompagnatoreFrancese
	 * Criteri: Cmin Cmax
	 */
	public synchronized int trovaAccompagnatoreFranceseCminCmax(int durata, int oraInizio, int oraFine) {
		int id = 0;

		id = cercaLavoratoreClasse3ISCmin(durata, oraInizio, oraFine);
		if (id == 0) {
			id = cercaLavoratoreClasse3NISCmax(durata, oraInizio, oraFine);
		}
		if (id == 0) {
			id = cercaLavoratoreClasse5ISCmin(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5NISCmax(durata, oraInizio, oraFine);
		} else {
			logger.severe("TrovaAccompagnatoreFranceseCminCmax: Non ho trovato Accompagnatori");
		}
		return id;
	}

	/*
	 * TrovaAccompagnatoreFrancese
	 * Criteri: Cmax Cmin
	 */
	public synchronized int trovaAccompagnatoreFranceseCmaxCmin(int durata, int oraInizio, int oraFine) {
		int id = 0;

		id = cercaLavoratoreClasse3ISCmax(durata, oraInizio, oraFine);
		if (id == 0) {
			id = cercaLavoratoreClasse3NISCmin(durata, oraInizio, oraFine);
		}
		if (id == 0) {
			id = cercaLavoratoreClasse5ISCmax(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5NISCmin(durata, oraInizio, oraFine);
		} else {
			logger.severe("TrovaAccompagnatoreFranceseCmaxCmin: Non ho trovato Accompagnatori");
		}
		return id;
	}

	/*
	 * TrovaAccompagnatoreFrancese
	 * Criteri: Cmax Cmax
	 */
	public synchronized int trovaAccompagnatoreFranceseCmaxCmax(int durata, int oraInizio, int oraFine) {
		int id = 0;

		id = cercaLavoratoreClasse3ISCmax(durata, oraInizio, oraFine);
		if (id == 0) {
			id = cercaLavoratoreClasse3NISCmax(durata, oraInizio, oraFine);
		}
		if (id == 0) {
			id = cercaLavoratoreClasse5ISCmax(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5NISCmax(durata, oraInizio, oraFine);
		} else {
			logger.severe("TrovaAccompagnatoreFranceseCmaxCmax: Non ho trovato Accompagnatori");
		}
		return id;
	}

	/*
	 * TrovaAccompagnatoreFrancese
	 * Criteri: Cmin Rand
	 */
	public synchronized int trovaAccompagnatoreFranceseCminRand(int durata, int oraInizio, int oraFine) {
		int id = 0;

		id = cercaLavoratoreClasse3ISCmin(durata, oraInizio, oraFine);
		if (id == 0) {
			id = cercaLavoratoreClasse3NISRandom(durata, oraInizio, oraFine);
		}

		if (id == 0) {
			id = cercaLavoratoreClasse5ISCmin(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5NISRandom(durata, oraInizio, oraFine);
		} else {
			logger.severe("TrovaAccompagnatoreFranceseCminRandom: Non ho trovato Accompagnatori");
		}
		return id;
	}

	/*
	 * TrovaAccompagnatoreFrancese
	 * Criteri: Cmax Rand
	 */
	public synchronized int trovaAccompagnatoreFranceseCmaxRand(int durata, int oraInizio, int oraFine) {
		int id = 0;

		id = cercaLavoratoreClasse3ISCmax(durata, oraInizio, oraFine);
		if (id == 0) {
			id = cercaLavoratoreClasse3NISRandom(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5ISCmax(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5NISRandom(durata, oraInizio, oraFine);
		} else {
			logger.severe("TrovaAccompagnatoreFranceseCmaxRandom: Non ho trovato Accompagnatori");
		}
		return id;
	}

	/*
	 * TrovaAccompagnatoreFrancese
	 * Criteri: Rand Cmin
	 */
	public synchronized int trovaAccompagnatoreFranceseRandCmin(int durata, int oraInizio, int oraFine) {
		int id = 0;
		id = cercaLavoratoreClasse3ISRandom(durata, oraInizio, oraFine);
		if (id == 0) {
			id = cercaLavoratoreClasse3NISCmin(durata, oraInizio, oraFine);
		}
		if (id == 0) {
			id = cercaLavoratoreClasse5ISRandom(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5NISCmin(durata, oraInizio, oraFine);
		} else {
			logger.severe("TrovaAccompagnatoreFranceseRandomCmin: Non ho trovato Accompagnatori");
		}
		return id;
	}

	/*
	 * TrovaAccompagnatoreFrancese
	 * Criteri: Rand Cmax
	 */
	public synchronized int trovaAccompagnatoreFranceseRandCmax(int durata, int oraInizio, int oraFine) {
		int id = 0;

		id = cercaLavoratoreClasse3ISRandom(durata, oraInizio, oraFine);
		if (id == 0) {
			id = cercaLavoratoreClasse3NISCmax(durata, oraInizio, oraFine);
		}
		if (id == 0) {
			id = cercaLavoratoreClasse5ISRandom(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5NISCmax(durata, oraInizio, oraFine);
		} else {
			logger.severe("TrovaAccompagnatoreFranceseRandomCmax: Non ho trovato Accompagnatori");
		}
		return id;
	}

	/*
	 * TrovaAccompagnatoreFrancese
	 * Criteri: Rand Rand
	 */
	public synchronized int trovaAccompagnatoreFranceseRandRand(int durata, int oraInizio, int oraFine) {
		int id = 0;

		id = cercaLavoratoreClasse3ISRandom(durata, oraInizio, oraFine);
		if (id == 0) {
			id = cercaLavoratoreClasse3NISRandom(durata, oraInizio, oraFine);
		}
		if (id == 0) {
			id = cercaLavoratoreClasse5ISRandom(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5NISRandom(durata, oraInizio, oraFine);
		} else {
			logger.severe("TrovaAccompagnatoreItalianoRandomRandom: Non ho trovato Accompagnatori");
		}
		return id;
	}

	/*
	 * LINGUA SPAGNOLO
	 */
	/*
	 * Metodo per trovare accompagnatori Spagnolo
	 * Input: C1, C2, durata, orainzio, orafine
	 */
	public synchronized int trovaAccompagnatoreSpagnolo(int durata, int oraInizio, int oraFine, int c1, int c2) {
		int id = 0;
		if(c1 == 1 & c2 == 1) {
			id = trovaAccompagnatoreSpagnoloCminCmin(durata, oraInizio, oraFine);
		} if (c1 == 1 & c2 == 2) {
			id = trovaAccompagnatoreSpagnoloCminCmax(durata, oraInizio, oraFine);
		} if (c1 == 2 & c2 == 1) {
			id = trovaAccompagnatoreSpagnoloCmaxCmin(durata, oraInizio, oraFine);
		} if (c1 == 2 & c2 == 2) {
			id = trovaAccompagnatoreSpagnoloCmaxCmax(durata, oraInizio, oraFine);
		} if (c1 == 1 & c2 == 3) {
			id = trovaAccompagnatoreSpagnoloCminRand(durata, oraInizio, oraFine);
		} if (c1 == 2 & c2 == 3) {
			id = trovaAccompagnatoreSpagnoloCmaxRand(durata, oraInizio, oraFine);
		} if (c1 == 3 & c2 == 1) {
			id = trovaAccompagnatoreSpagnoloRandCmin(durata, oraInizio, oraFine);
		} if (c1 == 3 & c2 == 2) {
			id = trovaAccompagnatoreSpagnoloRandCmax(durata, oraInizio, oraFine);
		} if (c1 == 3 & c2 == 3) {
			id = trovaAccompagnatoreSpagnoloRandRand(durata, oraInizio, oraFine);
		} else {
			//logger.severe("CRITERI ERRATI");
		}
		return id;
	}

	/*
	 * TrovaAccompagnatoreSpagnolo
	 * Criteri: Cmin Cmin
	 */
	public synchronized int trovaAccompagnatoreSpagnoloCminCmin(int durata, int oraInizio, int oraFine) {
		int id = 0;
		id = cercaLavoratoreClasse4ISCmin(durata, oraInizio, oraFine);
		if (id == 0) {
			id = cercaLavoratoreClasse4NISCmin(durata, oraInizio, oraFine);
		} 
		if (id == 0) {
			id = cercaLavoratoreClasse5ISCmin(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5NISCmin(durata, oraInizio, oraFine);
		} else {
			logger.severe("TrovaAccompagnatoreSpagnoloCminCmin: Non ho trovato Accompagnatori");
		}
		return id;
	}

	/*
	 * TrovaAccompagnatoreSpagnolo
	 * Criteri: Cmin Cmax
	 */
	public synchronized int trovaAccompagnatoreSpagnoloCminCmax(int durata, int oraInizio, int oraFine) {
		int id = 0;

		id = cercaLavoratoreClasse4ISCmin(durata, oraInizio, oraFine);
		if (id == 0) {
			id = cercaLavoratoreClasse4NISCmax(durata, oraInizio, oraFine);
		}
		if (id == 0) {
			id = cercaLavoratoreClasse5ISCmin(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5NISCmax(durata, oraInizio, oraFine);
		} else {
			logger.severe("TrovaAccompagnatoreSpagnoloCminCmax: Non ho trovato Accompagnatori");
		}
		return id;
	}

	/*
	 * TrovaAccompagnatoreSpagnolo
	 * Criteri: Cmax Cmin
	 */
	public synchronized int trovaAccompagnatoreSpagnoloCmaxCmin(int durata, int oraInizio, int oraFine) {
		int id = 0;

		id = cercaLavoratoreClasse4ISCmax(durata, oraInizio, oraFine);
		if (id == 0) {
			id = cercaLavoratoreClasse4NISCmin(durata, oraInizio, oraFine);
		}
		if (id == 0) {
			id = cercaLavoratoreClasse5ISCmax(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5NISCmin(durata, oraInizio, oraFine);
		} else {
			logger.severe("TrovaAccompagnatoreSpagnoloCmaxCmin: Non ho trovato Accompagnatori");
		}
		return id;
	}

	/*
	 * TrovaAccompagnatoreSpagnolo
	 * Criteri: Cmax Cmax
	 */
	public synchronized int trovaAccompagnatoreSpagnoloCmaxCmax(int durata, int oraInizio, int oraFine) {
		int id = 0;

		id = cercaLavoratoreClasse4ISCmax(durata, oraInizio, oraFine);
		if (id == 0) {
			id = cercaLavoratoreClasse4NISCmax(durata, oraInizio, oraFine);
		}
		if (id == 0) {
			id = cercaLavoratoreClasse5ISCmax(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5NISCmax(durata, oraInizio, oraFine);
		} else {
			logger.severe("TrovaAccompagnatoreSpagnoloCmaxCmax: Non ho trovato Accompagnatori");
		}
		return id;
	}

	/*
	 * TrovaAccompagnatoreSpagnolo
	 * Criteri: Cmin Rand
	 */
	public synchronized int trovaAccompagnatoreSpagnoloCminRand(int durata, int oraInizio, int oraFine) {
		int id = 0;

		id = cercaLavoratoreClasse4ISCmin(durata, oraInizio, oraFine);
		if (id == 0) {
			id = cercaLavoratoreClasse4NISRandom(durata, oraInizio, oraFine);
		}

		if (id == 0) {
			id = cercaLavoratoreClasse5ISCmin(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5NISRandom(durata, oraInizio, oraFine);
		} else {
			logger.severe("TrovaAccompagnatoreSpagnoloCminRandom: Non ho trovato Accompagnatori");
		}
		return id;
	}

	/*
	 * TrovaAccompagnatoreSpagnolo
	 * Criteri: Cmax Rand
	 */
	public synchronized int trovaAccompagnatoreSpagnoloCmaxRand(int durata, int oraInizio, int oraFine) {
		int id = 0;

		id = cercaLavoratoreClasse4ISCmax(durata, oraInizio, oraFine);
		if (id == 0) {
			id = cercaLavoratoreClasse4NISRandom(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5ISCmax(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5NISRandom(durata, oraInizio, oraFine);
		} else {
			logger.severe("TrovaAccompagnatoreSpagnoloCmaxRandom: Non ho trovato Accompagnatori");
		}
		return id;
	}

	/*
	 * TrovaAccompagnatoreSpagnolo
	 * Criteri: Rand Cmin
	 */
	public synchronized int trovaAccompagnatoreSpagnoloRandCmin(int durata, int oraInizio, int oraFine) {
		int id = 0;
		id = cercaLavoratoreClasse4ISRandom(durata, oraInizio, oraFine);
		if (id == 0) {
			id = cercaLavoratoreClasse4NISCmin(durata, oraInizio, oraFine);
		}
		if (id == 0) {
			id = cercaLavoratoreClasse5ISRandom(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5NISCmin(durata, oraInizio, oraFine);
		} else {
			logger.severe("TrovaAccompagnatoreSpagnoloRandomCmin: Non ho trovato Accompagnatori");
		}
		return id;
	}

	/*
	 * TrovaAccompagnatoreSpagnolo
	 * Criteri: Rand Cmax
	 */
	public synchronized int trovaAccompagnatoreSpagnoloRandCmax(int durata, int oraInizio, int oraFine) {
		int id = 0;

		id = cercaLavoratoreClasse4ISRandom(durata, oraInizio, oraFine);
		if (id == 0) {
			id = cercaLavoratoreClasse4NISCmax(durata, oraInizio, oraFine);
		}
		if (id == 0) {
			id = cercaLavoratoreClasse5ISRandom(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5NISCmax(durata, oraInizio, oraFine);
		} else {
			logger.severe("TrovaAccompagnatoreSpagnoloRandomCmax: Non ho trovato Accompagnatori");
		}
		return id;
	}

	/*
	 * TrovaAccompagnatoreSpagnolo
	 * Criteri: Rand Rand
	 */
	public synchronized int trovaAccompagnatoreSpagnoloRandRand(int durata, int oraInizio, int oraFine) {
		int id = 0;

		id = cercaLavoratoreClasse4ISRandom(durata, oraInizio, oraFine);
		if (id == 0) {
			id = cercaLavoratoreClasse4NISRandom(durata, oraInizio, oraFine);
		}
		if (id == 0) {
			id = cercaLavoratoreClasse5ISRandom(durata, oraInizio, oraFine);
		} if (id == 0) {
			id = cercaLavoratoreClasse5NISRandom(durata, oraInizio, oraFine);
		} else {
			logger.severe("TrovaAccompagnatoreItalianoRandomRandom: Non ho trovato Accompagnatori");
		}
		return id;
	}


	/*
	 * Classe 1
	 */
	/*
	 * Cerca Lavoratori Classe 1 In Servizio Cmin, Cmax, Random
	 */
	public synchronized int cercaLavoratoreClasse1ISCmin(int durata, int oraInizio, int oraFine) {
		int id = 0;

		for(int i=0; i< lavoratoriClasse1.size(); i++) {

			//Cerco un lavoratore in Servizio
			if(lavoratoriClasse1.get(i).isInServizio() == true ) {
				if(durata <= lavoratoriClasse1.get(i).getOreRimaste() && oraFine <= lavoratoriClasse1.get(i).getOraFineServizio() && oraInizio >= lavoratoriClasse1.get(i).getOraLibero()) {
					id = lavoratoriClasse1.get(i).getIdentificatore();
					Lavoratore l = new Lavoratore();
					l = lavoratoriClasse1.get(i);
					l.setOreRimaste(l.getOreRimaste() - durata);
					l.setOraLibero(l.getOraLibero() + durata);

					break;

				} else {
					//System.out.println("Niente");
				}
			}
		}

		return id;
	}

	public synchronized int cercaLavoratoreClasse1ISCmax(int durata, int oraInizio, int oraFine) {
		int id = 0;

		for(int i=lavoratoriClasse1.size()-1; i>=0; i--) {

			//Cerco un lavoratore in Servizio
			if(lavoratoriClasse1.get(i).isInServizio() == true ) {
				if(durata <= lavoratoriClasse1.get(i).getOreRimaste() && oraFine <= lavoratoriClasse1.get(i).getOraFineServizio()  && oraInizio >= lavoratoriClasse1.get(i).getOraLibero()) {
					id = lavoratoriClasse1.get(i).getIdentificatore();
					Lavoratore l = new Lavoratore();
					l = lavoratoriClasse1.get(i);
					l.setOreRimaste(l.getOreRimaste() - durata);
					l.setOraLibero(l.getOraLibero() + durata);

					break;

				} else {
					//System.out.println("Niente");
				}
			}
		}

		return id;
	}

	public synchronized int cercaLavoratoreClasse1ISRandom(int durata, int oraInizio, int oraFine) {
		int id = 0;

		Random random = new Random();
		for(int i=0; i< lavoratoriClasse1.size(); random.nextInt(lavoratoriClasse1.size())) {

			//Cerco un lavoratore in Servizio
			if(lavoratoriClasse1.get(i).isInServizio() == true ) {
				if(durata <= lavoratoriClasse1.get(i).getOreRimaste() && oraFine <= lavoratoriClasse1.get(i).getOraFineServizio()  && oraInizio >= lavoratoriClasse1.get(i).getOraLibero()) {
					id = lavoratoriClasse1.get(i).getIdentificatore();
					Lavoratore l = new Lavoratore();
					l = lavoratoriClasse1.get(i);
					l.setOreRimaste(l.getOreRimaste() - durata);
					l.setOraLibero(l.getOraLibero() - durata);

					break;
				} else {
					//System.out.println("Niente");
				}
			}
		}

		return id;
	}

	/*
	 * Cerca Lavoratori Classe 1 Non In Servizio Cmin, Cmax, Random
	 */
	public synchronized int cercaLavoratoreClasse1NISCmin(int durata, int oraInizio, int oraFine) {
		int id = 0;


		for(int i=0; i< lavoratoriClasse1.size(); i++) {
			if(lavoratoriClasse1.get(i).isInServizio() == false ) {	
				//System.out.println("Entro nell'else");
				id = lavoratoriClasse1.get(i).getIdentificatore();
				Lavoratore l = new Lavoratore();
				l = lavoratoriClasse1.get(i);
				l.setInServizio(true);
				l.setOraFineServizio(oraInizio + l.getOreTotaliServizio());
				l.setOreRimaste(l.getOreTotaliServizio() - durata);
				l.setOraLibero(oraInizio + durata);
				lavoratoriClasse1.set(i, l);

				break;
			}
		}
		return id;
	}

	public synchronized int cercaLavoratoreClasse1NISCmax(int durata, int oraInizio, int oraFine) {
		int id = 0;


		for(int i=lavoratoriClasse1.size()-1; i>=0; i--) {
			if(lavoratoriClasse1.get(i).isInServizio() == false ) {	
				//System.out.println("Entro nell'else");
				id = lavoratoriClasse1.get(i).getIdentificatore();
				Lavoratore l = new Lavoratore();
				l = lavoratoriClasse1.get(i);
				l.setInServizio(true);
				l.setOraFineServizio(oraInizio + l.getOreTotaliServizio());
				l.setOreRimaste(l.getOreTotaliServizio() - durata);
				l.setOraLibero(oraInizio + durata);
				lavoratoriClasse1.set(i, l);

				break;
			}
		}
		return id;
	}

	public synchronized int cercaLavoratoreClasse1NISRandom(int durata, int oraInizio, int oraFine) {
		int id = 0;

		Random random = new Random();
		for(int i=0; i< lavoratoriClasse1.size(); random.nextInt(lavoratoriClasse1.size())) {
			if(lavoratoriClasse1.get(i).isInServizio() == false ) {	
				//System.out.println("Entro nell'else");
				id = lavoratoriClasse1.get(i).getIdentificatore();
				Lavoratore l = new Lavoratore();
				l = lavoratoriClasse1.get(i);
				l.setInServizio(true);
				l.setOraFineServizio(oraInizio + l.getOreTotaliServizio());
				l.setOreRimaste(l.getOreTotaliServizio() - durata);
				l.setOraLibero(oraInizio + durata);
				lavoratoriClasse1.set(i, l);

				break;
			}
		}
		return id;
	}
	/*
	 * CLASSE 2
	 */
	/*
	 * Cerca Lavoratori Classe 2 In Servizio Cmin, Cmax, Random
	 */
	public synchronized int cercaLavoratoreClasse2ISCmin(int durata, int oraInizio, int oraFine) {
		int id = 0;

		for(int i=0; i< lavoratoriClasse2.size(); i++) {

			//Cerco un lavoratore in Servizio
			if(lavoratoriClasse2.get(i).isInServizio() == true ) {
				if(durata <= lavoratoriClasse2.get(i).getOreRimaste() && oraFine <= lavoratoriClasse2.get(i).getOraFineServizio() && oraInizio >= lavoratoriClasse2.get(i).getOraLibero()) {
					id = lavoratoriClasse2.get(i).getIdentificatore();
					Lavoratore l = new Lavoratore();
					l = lavoratoriClasse2.get(i);
					l.setOreRimaste(l.getOreRimaste() - durata);
					l.setOraLibero(l.getOraLibero() + durata);

					break;

				} else {
					////System.out.println("Niente");
				}
			}
		}

		return id;
	}

	public synchronized int cercaLavoratoreClasse2ISCmax(int durata, int oraInizio, int oraFine) {
		int id = 0;

		for(int i=lavoratoriClasse2.size()-1; i>=0; i--) {

			//Cerco un lavoratore in Servizio
			if(lavoratoriClasse2.get(i).isInServizio() == true ) {
				if(durata <= lavoratoriClasse2.get(i).getOreRimaste() && oraFine <= lavoratoriClasse2.get(i).getOraFineServizio()  && oraInizio >= lavoratoriClasse2.get(i).getOraLibero()) {
					id = lavoratoriClasse2.get(i).getIdentificatore();
					Lavoratore l = new Lavoratore();
					l = lavoratoriClasse2.get(i);
					l.setOreRimaste(l.getOreRimaste() - durata);
					l.setOraLibero(l.getOraLibero() + durata);

					break;

				} else {
					//System.out.println("Niente");
				}
			}
		}

		return id;
	}

	public synchronized int cercaLavoratoreClasse2ISRandom(int durata, int oraInizio, int oraFine) {
		int id = 0;

		Random random = new Random();
		for(int i=0; i< lavoratoriClasse2.size(); random.nextInt(lavoratoriClasse2.size())) {

			//Cerco un lavoratore in Servizio
			if(lavoratoriClasse2.get(i).isInServizio() == true ) {
				if(durata <= lavoratoriClasse2.get(i).getOreRimaste() && oraFine <= lavoratoriClasse2.get(i).getOraFineServizio()  && oraInizio >= lavoratoriClasse2.get(i).getOraLibero()) {
					id = lavoratoriClasse2.get(i).getIdentificatore();
					Lavoratore l = new Lavoratore();
					l = lavoratoriClasse2.get(i);
					l.setOreRimaste(l.getOreRimaste() - durata);
					l.setOraLibero(l.getOraLibero() - durata);

					break;
				} else {
					//System.out.println("Niente");
				}
			}
		}

		return id;
	}

	/*
	 * Cerca Lavoratori Classe 2 Non In Servizio Cmin, Cmax, Random
	 */
	public synchronized int cercaLavoratoreClasse2NISCmin(int durata, int oraInizio, int oraFine) {
		int id = 0;


		for(int i=0; i< lavoratoriClasse2.size(); i++) {
			if(lavoratoriClasse2.get(i).isInServizio() == false ) {	
				//System.out.println("Entro nell'else");
				id = lavoratoriClasse2.get(i).getIdentificatore();
				Lavoratore l = new Lavoratore();
				l = lavoratoriClasse2.get(i);
				l.setInServizio(true);
				l.setOraFineServizio(oraInizio + l.getOreTotaliServizio());
				l.setOreRimaste(l.getOreTotaliServizio() - durata);
				l.setOraLibero(oraInizio + durata);
				lavoratoriClasse2.set(i, l);

				break;
			}
		}
		return id;
	}

	public synchronized int cercaLavoratoreClasse2NISCmax(int durata, int oraInizio, int oraFine) {
		int id = 0;


		for(int i=lavoratoriClasse2.size()-1; i>=0; i--) {
			if(lavoratoriClasse2.get(i).isInServizio() == false ) {	
				//System.out.println("Entro nell'else");
				id = lavoratoriClasse2.get(i).getIdentificatore();
				Lavoratore l = new Lavoratore();
				l = lavoratoriClasse2.get(i);
				l.setInServizio(true);
				l.setOraFineServizio(oraInizio + l.getOreTotaliServizio());
				l.setOreRimaste(l.getOreTotaliServizio() - durata);
				l.setOraLibero(oraInizio + durata);
				lavoratoriClasse2.set(i, l);

				break;
			}
		}
		return id;
	}

	public synchronized int cercaLavoratoreClasse2NISRandom(int durata, int oraInizio, int oraFine) {
		int id = 0;

		Random random = new Random();
		for(int i=0; i< lavoratoriClasse2.size(); random.nextInt(lavoratoriClasse2.size())) {
			if(lavoratoriClasse2.get(i).isInServizio() == false ) {	
				//System.out.println("Entro nell'else");
				id = lavoratoriClasse2.get(i).getIdentificatore();
				Lavoratore l = new Lavoratore();
				l = lavoratoriClasse2.get(i);
				l.setInServizio(true);
				l.setOraFineServizio(oraInizio + l.getOreTotaliServizio());
				l.setOreRimaste(l.getOreTotaliServizio() - durata);
				l.setOraLibero(oraInizio + durata);
				lavoratoriClasse2.set(i, l);

				break;
			}
		}
		return id;
	}

	/*
	 * CLASSE 3
	 */
	/*
	 * Cerca Lavoratori Classe 3 In Servizio Cmin, Cmax, Random
	 */
	public synchronized int cercaLavoratoreClasse3ISCmin(int durata, int oraInizio, int oraFine) {
		int id = 0;

		for(int i=0; i< lavoratoriClasse3.size(); i++) {

			//Cerco un lavoratore in Servizio
			if(lavoratoriClasse3.get(i).isInServizio() == true ) {
				if(durata <= lavoratoriClasse3.get(i).getOreRimaste() && oraFine <= lavoratoriClasse3.get(i).getOraFineServizio() && oraInizio >= lavoratoriClasse3.get(i).getOraLibero()) {
					id = lavoratoriClasse3.get(i).getIdentificatore();
					Lavoratore l = new Lavoratore();
					l = lavoratoriClasse3.get(i);
					l.setOreRimaste(l.getOreRimaste() - durata);
					l.setOraLibero(l.getOraLibero() + durata);

					break;

				} else {
					//System.out.println("Niente");
				}
			}
		}

		return id;
	}

	public synchronized int cercaLavoratoreClasse3ISCmax(int durata, int oraInizio, int oraFine) {
		int id = 0;

		for(int i=lavoratoriClasse3.size()-1; i>=0; i--) {

			//Cerco un lavoratore in Servizio
			if(lavoratoriClasse3.get(i).isInServizio() == true ) {
				if(durata <= lavoratoriClasse3.get(i).getOreRimaste() && oraFine <= lavoratoriClasse3.get(i).getOraFineServizio()  && oraInizio >= lavoratoriClasse3.get(i).getOraLibero()) {
					id = lavoratoriClasse3.get(i).getIdentificatore();
					Lavoratore l = new Lavoratore();
					l = lavoratoriClasse3.get(i);
					l.setOreRimaste(l.getOreRimaste() - durata);
					l.setOraLibero(l.getOraLibero() + durata);

					break;

				} else {
					//System.out.println("Niente");
				}
			}
		}

		return id;
	}

	public synchronized int cercaLavoratoreClasse3ISRandom(int durata, int oraInizio, int oraFine) {
		int id = 0;

		Random random = new Random();
		for(int i=0; i< lavoratoriClasse3.size(); random.nextInt(lavoratoriClasse3.size())) {

			//Cerco un lavoratore in Servizio
			if(lavoratoriClasse3.get(i).isInServizio() == true ) {
				if(durata <= lavoratoriClasse3.get(i).getOreRimaste() && oraFine <= lavoratoriClasse3.get(i).getOraFineServizio()  && oraInizio >= lavoratoriClasse3.get(i).getOraLibero()) {
					id = lavoratoriClasse3.get(i).getIdentificatore();
					Lavoratore l = new Lavoratore();
					l = lavoratoriClasse3.get(i);
					l.setOreRimaste(l.getOreRimaste() - durata);
					l.setOraLibero(l.getOraLibero() - durata);

					break;
				} else {
					//System.out.println("Niente");
				}
			}
		}

		return id;
	}

	/*
	 * Cerca Lavoratori Classe 3 Non In Servizio Cmin, Cmax, Random
	 */
	public synchronized int cercaLavoratoreClasse3NISCmin(int durata, int oraInizio, int oraFine) {
		int id = 0;


		for(int i=0; i< lavoratoriClasse3.size(); i++) {
			if(lavoratoriClasse3.get(i).isInServizio() == false ) {	
				//System.out.println("Entro nell'else");
				id = lavoratoriClasse3.get(i).getIdentificatore();
				Lavoratore l = new Lavoratore();
				l = lavoratoriClasse3.get(i);
				l.setInServizio(true);
				l.setOraFineServizio(oraInizio + l.getOreTotaliServizio());
				l.setOreRimaste(l.getOreTotaliServizio() - durata);
				l.setOraLibero(oraInizio + durata);
				lavoratoriClasse3.set(i, l);

				break;
			}
		}
		return id;
	}

	public synchronized int cercaLavoratoreClasse3NISCmax(int durata, int oraInizio, int oraFine) {
		int id = 0;


		for(int i=lavoratoriClasse3.size()-1; i>=0; i--) {
			if(lavoratoriClasse3.get(i).isInServizio() == false ) {	
				//System.out.println("Entro nell'else");
				id = lavoratoriClasse3.get(i).getIdentificatore();
				Lavoratore l = new Lavoratore();
				l = lavoratoriClasse3.get(i);
				l.setInServizio(true);
				l.setOraFineServizio(oraInizio + l.getOreTotaliServizio());
				l.setOreRimaste(l.getOreTotaliServizio() - durata);
				l.setOraLibero(oraInizio + durata);
				lavoratoriClasse3.set(i, l);

				break;
			}
		}
		return id;
	}

	public synchronized int cercaLavoratoreClasse3NISRandom(int durata, int oraInizio, int oraFine) {
		int id = 0;

		Random random = new Random();
		for(int i=0; i< lavoratoriClasse3.size(); random.nextInt(lavoratoriClasse3.size())) {
			if(lavoratoriClasse3.get(i).isInServizio() == false ) {	
				//System.out.println("Entro nell'else");
				id = lavoratoriClasse3.get(i).getIdentificatore();
				Lavoratore l = new Lavoratore();
				l = lavoratoriClasse3.get(i);
				l.setInServizio(true);
				l.setOraFineServizio(oraInizio + l.getOreTotaliServizio());
				l.setOreRimaste(l.getOreTotaliServizio() - durata);
				l.setOraLibero(oraInizio + durata);
				lavoratoriClasse3.set(i, l);

				break;
			}
		}
		return id;
	}

	/*
	 * Classe 4
	 */
	/*
	 * Cerca Lavoratori Classe 4 In Servizio Cmin, Cmax, Random
	 */
	public synchronized int cercaLavoratoreClasse4ISCmin(int durata, int oraInizio, int oraFine) {
		int id = 0;

		for(int i=0; i< lavoratoriClasse4.size(); i++) {

			//Cerco un lavoratore in Servizio
			if(lavoratoriClasse4.get(i).isInServizio() == true ) {
				if(durata <= lavoratoriClasse4.get(i).getOreRimaste() && oraFine <= lavoratoriClasse4.get(i).getOraFineServizio() && oraInizio >= lavoratoriClasse4.get(i).getOraLibero()) {
					id = lavoratoriClasse4.get(i).getIdentificatore();
					Lavoratore l = new Lavoratore();
					l = lavoratoriClasse4.get(i);
					l.setOreRimaste(l.getOreRimaste() - durata);
					l.setOraLibero(l.getOraLibero() + durata);

					break;

				} else {
					//System.out.println("Niente");
				}
			}
		}

		return id;
	}

	public synchronized int cercaLavoratoreClasse4ISCmax(int durata, int oraInizio, int oraFine) {
		int id = 0;

		for(int i=lavoratoriClasse4.size()-1; i>=0; i--) {

			//Cerco un lavoratore in Servizio
			if(lavoratoriClasse4.get(i).isInServizio() == true ) {
				if(durata <= lavoratoriClasse4.get(i).getOreRimaste() && oraFine <= lavoratoriClasse4.get(i).getOraFineServizio()  && oraInizio >= lavoratoriClasse4.get(i).getOraLibero()) {
					id = lavoratoriClasse4.get(i).getIdentificatore();
					Lavoratore l = new Lavoratore();
					l = lavoratoriClasse4.get(i);
					l.setOreRimaste(l.getOreRimaste() - durata);
					l.setOraLibero(l.getOraLibero() + durata);

					break;

				} else {
					//System.out.println("Niente");
				}
			}
		}

		return id;
	}

	public synchronized int cercaLavoratoreClasse4ISRandom(int durata, int oraInizio, int oraFine) {
		int id = 0;

		Random random = new Random();
		for(int i=0; i< lavoratoriClasse4.size(); random.nextInt(lavoratoriClasse4.size())) {

			//Cerco un lavoratore in Servizio
			if(lavoratoriClasse4.get(i).isInServizio() == true ) {
				if(durata <= lavoratoriClasse4.get(i).getOreRimaste() && oraFine <= lavoratoriClasse4.get(i).getOraFineServizio()  && oraInizio >= lavoratoriClasse4.get(i).getOraLibero()) {
					id = lavoratoriClasse4.get(i).getIdentificatore();
					Lavoratore l = new Lavoratore();
					l = lavoratoriClasse4.get(i);
					l.setOreRimaste(l.getOreRimaste() - durata);
					l.setOraLibero(l.getOraLibero() - durata);

					break;
				} else {
					//System.out.println("Niente");
				}
			}
		}

		return id;
	}

	/*
	 * Cerca Lavoratori Classe 4 Non In Servizio Cmin, Cmax, Random
	 */
	public synchronized int cercaLavoratoreClasse4NISCmin(int durata, int oraInizio, int oraFine) {
		int id = 0;


		for(int i=0; i< lavoratoriClasse4.size(); i++) {
			if(lavoratoriClasse4.get(i).isInServizio() == false ) {	
				//System.out.println("Entro nell'else");
				id = lavoratoriClasse4.get(i).getIdentificatore();
				Lavoratore l = new Lavoratore();
				l = lavoratoriClasse4.get(i);
				l.setInServizio(true);
				l.setOraFineServizio(oraInizio + l.getOreTotaliServizio());
				l.setOreRimaste(l.getOreTotaliServizio() - durata);
				l.setOraLibero(oraInizio + durata);
				lavoratoriClasse4.set(i, l);

				break;
			}
		}
		return id;
	}

	public synchronized int cercaLavoratoreClasse4NISCmax(int durata, int oraInizio, int oraFine) {
		int id = 0;


		for(int i=lavoratoriClasse4.size()-1; i>=0; i--) {
			if(lavoratoriClasse4.get(i).isInServizio() == false ) {	
				//System.out.println("Entro nell'else");
				id = lavoratoriClasse4.get(i).getIdentificatore();
				Lavoratore l = new Lavoratore();
				l = lavoratoriClasse4.get(i);
				l.setInServizio(true);
				l.setOraFineServizio(oraInizio + l.getOreTotaliServizio());
				l.setOreRimaste(l.getOreTotaliServizio() - durata);
				l.setOraLibero(oraInizio + durata);
				lavoratoriClasse4.set(i, l);

				break;
			}
		}
		return id;
	}

	public synchronized int cercaLavoratoreClasse4NISRandom(int durata, int oraInizio, int oraFine) {
		int id = 0;

		Random random = new Random();
		for(int i=0; i< lavoratoriClasse4.size(); random.nextInt(lavoratoriClasse4.size())) {
			if(lavoratoriClasse4.get(i).isInServizio() == false ) {	
				//System.out.println("Entro nell'else");
				id = lavoratoriClasse4.get(i).getIdentificatore();
				Lavoratore l = new Lavoratore();
				l = lavoratoriClasse4.get(i);
				l.setInServizio(true);
				l.setOraFineServizio(oraInizio + l.getOreTotaliServizio());
				l.setOreRimaste(l.getOreTotaliServizio() - durata);
				l.setOraLibero(oraInizio + durata);
				lavoratoriClasse4.set(i, l);

				break;
			}
		}
		return id;
	}

	/*
	 * Classe 5
	 */
	/*
	 * Cerca Lavoratori Classe 5 In Servizio Cmin, Cmax, Random
	 */
	public synchronized int cercaLavoratoreClasse5ISCmin(int durata, int oraInizio, int oraFine) {
		int id = 0;

		for(int i=0; i< lavoratoriClasse5.size(); i++) {

			//Cerco un lavoratore in Servizio
			if(lavoratoriClasse5.get(i).isInServizio() == true ) {
				if(durata <= lavoratoriClasse5.get(i).getOreRimaste() && oraFine <= lavoratoriClasse5.get(i).getOraFineServizio() && oraInizio >= lavoratoriClasse5.get(i).getOraLibero()) {
					id = lavoratoriClasse5.get(i).getIdentificatore();
					Lavoratore l = new Lavoratore();
					l = lavoratoriClasse5.get(i);
					l.setOreRimaste(l.getOreRimaste() - durata);
					l.setOraLibero(l.getOraLibero() + durata);

					break;

				} else {
					//System.out.println("Niente");
				}
			}
		}

		return id;
	}

	public synchronized int cercaLavoratoreClasse5ISCmax(int durata, int oraInizio, int oraFine) {
		int id = 0;

		for(int i=lavoratoriClasse5.size()-1; i>=0; i--) {

			//Cerco un lavoratore in Servizio
			if(lavoratoriClasse5.get(i).isInServizio() == true ) {
				if(durata <= lavoratoriClasse5.get(i).getOreRimaste() && oraFine <= lavoratoriClasse5.get(i).getOraFineServizio()  && oraInizio >= lavoratoriClasse5.get(i).getOraLibero()) {
					id = lavoratoriClasse5.get(i).getIdentificatore();
					Lavoratore l = new Lavoratore();
					l = lavoratoriClasse5.get(i);
					l.setOreRimaste(l.getOreRimaste() - durata);
					l.setOraLibero(l.getOraLibero() + durata);

					break;

				} else {
					//System.out.println("Niente");
				}
			}
		}

		return id;
	}

	public synchronized int cercaLavoratoreClasse5ISRandom(int durata, int oraInizio, int oraFine) {
		int id = 0;

		Random random = new Random();
		for(int i=0; i< lavoratoriClasse5.size(); random.nextInt(lavoratoriClasse5.size())) {

			//Cerco un lavoratore in Servizio
			if(lavoratoriClasse5.get(i).isInServizio() == true ) {
				if(durata <= lavoratoriClasse5.get(i).getOreRimaste() && oraFine <= lavoratoriClasse5.get(i).getOraFineServizio()  && oraInizio >= lavoratoriClasse5.get(i).getOraLibero()) {
					id = lavoratoriClasse5.get(i).getIdentificatore();
					Lavoratore l = new Lavoratore();
					l = lavoratoriClasse5.get(i);
					l.setOreRimaste(l.getOreRimaste() - durata);
					l.setOraLibero(l.getOraLibero() - durata);

					break;
				} else {
					//System.out.println("Niente");
				}
			}
		}

		return id;
	}

	/*
	 * Cerca Lavoratori Classe 5 Non In Servizio Cmin, Cmax, Random
	 */
	public synchronized int cercaLavoratoreClasse5NISCmin(int durata, int oraInizio, int oraFine) {
		int id = 0;


		for(int i=0; i< lavoratoriClasse5.size(); i++) {
			if(lavoratoriClasse5.get(i).isInServizio() == false ) {	
				//System.out.println("Entro nell'else");
				id = lavoratoriClasse5.get(i).getIdentificatore();
				Lavoratore l = new Lavoratore();
				l = lavoratoriClasse5.get(i);
				l.setInServizio(true);
				l.setOraFineServizio(oraInizio + l.getOreTotaliServizio());
				l.setOreRimaste(l.getOreTotaliServizio() - durata);
				l.setOraLibero(oraInizio + durata);
				lavoratoriClasse5.set(i, l);

				break;
			}
		}
		return id;
	}

	public synchronized int cercaLavoratoreClasse5NISCmax(int durata, int oraInizio, int oraFine) {
		int id = 0;


		for(int i=lavoratoriClasse5.size()-1; i>=0; i--) {
			if(lavoratoriClasse5.get(i).isInServizio() == false ) {	
				//System.out.println("Entro nell'else");
				id = lavoratoriClasse5.get(i).getIdentificatore();
				Lavoratore l = new Lavoratore();
				l = lavoratoriClasse5.get(i);
				l.setInServizio(true);
				l.setOraFineServizio(oraInizio + l.getOreTotaliServizio());
				l.setOreRimaste(l.getOreTotaliServizio() - durata);
				l.setOraLibero(oraInizio + durata);
				lavoratoriClasse5.set(i, l);

				break;
			}
		}
		return id;
	}

	public synchronized int cercaLavoratoreClasse5NISRandom(int durata, int oraInizio, int oraFine) {
		int id = 0;

		Random random = new Random();
		for(int i=0; i< lavoratoriClasse5.size(); random.nextInt(lavoratoriClasse5.size())) {
			if(lavoratoriClasse5.get(i).isInServizio() == false ) {	
				//System.out.println("Entro nell'else");
				id = lavoratoriClasse5.get(i).getIdentificatore();
				Lavoratore l = new Lavoratore();
				l = lavoratoriClasse5.get(i);
				l.setInServizio(true);
				l.setOraFineServizio(oraInizio + l.getOreTotaliServizio());
				l.setOreRimaste(l.getOreTotaliServizio() - durata);
				l.setOraLibero(oraInizio + durata);
				lavoratoriClasse5.set(i, l);

				break;
			}
		}
		return id;
	}

/*
 * 
 */
	public synchronized void popolaLavoriDB() throws SQLException {
		for (int i=0; i<lavori.size(); i++) {
			DatabaseQuery.addLavoro(lavori.get(i));
		}
	}

	public synchronized void popolaLavoratoriDB(String istanza, int m, int L) throws SQLException{
		DatabaseQuery.addLavoratore(m, L, istanza);
	}

	
	public synchronized void getLavoriDB(String istanza) throws SQLException{
		ArrayList <Lavoro> lav = new ArrayList<>();
		lav = DatabaseQuery.getLavori(istanza);
		for(int i=0; i<lav.size(); i++) {
			lavori.add(i, lav.get(i));
		}
	}
	
	public synchronized void getLavoratoriDB(String istanza) throws SQLException{
		LavoratoreDaDatabase l = DatabaseQuery.getLavoratori(istanza);
		ArrayList <Lavoratore> lavorator = new ArrayList<>();
		aggiungiAccompagnatori(l.getM(), l.getL(), istanza);
		stampaArrayLavoratori();
	}

	public synchronized void delIstanza(String istanza) throws SQLException{
		DatabaseQuery.delLavoratore(istanza);
		DatabaseQuery.delLavoro(istanza);
	}
	/*
	 * Metodi di stampa su console
	 */	
	public void stampaArrayLavoratori() {
		System.out.println("CLASSE1------------------------------------------------");
		for(int i=0; i<lavoratoriClasse1.size(); i++) {
			System.out.println(lavoratoriClasse1.get(i).toString());
		}
		System.out.println("CLASSE2------------------------------------------------");
		for(int i=0; i<lavoratoriClasse2.size(); i++) {
			System.out.println(lavoratoriClasse2.get(i).toString());
		}
		System.out.println("CLASSE3------------------------------------------------");
		for(int i=0; i<lavoratoriClasse3.size(); i++) {
			System.out.println(lavoratoriClasse3.get(i).toString());
		}
		System.out.println("CLASSE4------------------------------------------------");
		for(int i=0; i<lavoratoriClasse4.size(); i++) {
			System.out.println(lavoratoriClasse4.get(i).toString());
		}
		System.out.println("CLASSE5------------------------------------------------");
		for(int i=0; i<lavoratoriClasse5.size(); i++) {
			System.out.println(lavoratoriClasse5.get(i).toString());
		}
	}

	/*
	 * Metodi di stampa su console
	 */	
	public void stampaArrayLavori() {
		System.out.println("STAMPO I LAVORI_________________________________");
		System.out.println("Lavori ordinati------------------------------------------------");
		for (int i=0; i<lavori.size(); i++) {
			System.out.println(lavori.get(i));
		}

	}
}



