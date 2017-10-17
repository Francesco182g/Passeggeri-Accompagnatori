/* 
	@copy Coded by Francesco Garofalo 2017
 */

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Logger;


public class Gestore {
	//private ArrayList lavoratori, Array che contiene tutti i lavoratori (NON UTILIZZATO)
	private ArrayList <Lavoratore> lavoratoriClasse1 = new ArrayList<>(); //Italiano
	private ArrayList <Lavoratore> lavoratoriClasse2 = new ArrayList<>(); //Italiano,Inglese
	private ArrayList <Lavoratore> lavoratoriClasse3 = new ArrayList<>();; //Italiano,Inglese,Francese
	private ArrayList <Lavoratore> lavoratoriClasse4 = new ArrayList<>(); //Italiano,Inglese,Spagnolo
	private ArrayList <Lavoratore> lavoratoriClasse5 = new ArrayList<>(); //Italiano,Inglese,Francese, Spagnolo
	private ArrayList <Lavoro> lavori = new ArrayList<>();
	private ArrayList <Lavoro> lavoriSenzaAccompagnatori = new ArrayList<>();

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
		System.out.println(m+ " e "+ divisioneClassi);
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
		for(i=divisioneClassi+1;i<=divisioneClassi *2;i++) {
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
		for(i=divisioneClassi *2+1;i<=divisioneClassi *3;i++) {
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
		for(i=divisioneClassi *3+1;i<=divisioneClassi *4;i++) {
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
		for(i=divisioneClassi *4+1;i<=n;i++) {
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
			lavoro.setOraInizio(random.nextInt(24));//Valore max 
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
			lavoro.setOraInizio(random.nextInt(24));//Valore max 
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
			lavoro.setOraInizio(random.nextInt(24));//Valore max 240
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
			lavoro.setOraInizio(random.nextInt(24));//Valore max 240
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
		for(int i=0; i< lavori.size(); i++) {
			if(lavori.get(i).getLingua()== "ita") {
				int id = trovaAccompagnatoreItaliano(lavori.get(i).getDurata(), lavori.get(i).getOraInizio(), lavori.get(i).getOraFine(), c1, c2);
				if(id != 0) {
					lavori.get(i).setLavoratoreAssegnato(id);
				} else {
					logger.info("Nessun accompagnatore trovato per: "+lavori.get(i).getCodicePasseggero());
				}
			} if(lavori.get(i).getLingua() == "eng") {
				//int id = trovaAccompagnatoreInglese();
			} if(lavori.get(i).getLingua() == "fra") {
				//int id = trovaAccompagnatoreFrancese();
			} if(lavori.get(i).getLingua() == "spa") {
				//int id = trovaAccompagnatoreSpagnolo();
			}
		}
	}

	/*
	 * Metodo per trovare accompagnatori Italiani
	 * Input: C1, C2, durata, orainzio, orafine
	 */
	public synchronized int trovaAccompagnatoreItaliano(int durata, int oraInizio, int oraFine, int c1, int c2) {
		int id = 0;
		if(c1 == 1 & c2 == 1) {
			id = trovaAccompagnatoreItalianoCminCmin(durata, oraInizio, oraFine);
		} else if (c1 == 1 & c2 == 2) {
			id = trovaAccompagnatoreItalianoCminCmax(durata, oraInizio, oraFine);
		} else if (c1 == 2 & c2 == 1) {
			id = trovaAccompagnatoreItalianoCmaxCmin(durata, oraInizio, oraFine);
		} else if (c1 == 2 & c2 == 2) {
			id = trovaAccompagnatoreItalianoCmaxCmax(durata, oraInizio, oraFine);
		} else if (c1 == 1 & c2 == 3) {
			id = trovaAccompagnatoreItalianoCminRand(durata, oraInizio, oraFine);
		} else if (c1 == 2 & c2 == 3) {
			id = trovaAccompagnatoreItalianoCmaxRand(durata, oraInizio, oraFine);
		} else if (c1 == 3 & c2 == 1) {
			id = trovaAccompagnatoreItalianoRandCmin(durata, oraInizio, oraFine);
		} else if (c1 == 3 & c2 == 2) {
			id = trovaAccompagnatoreItalianoRandCmax(durata, oraInizio, oraFine);
		} else if (c1 == 3 & c2 == 3) {
			id = trovaAccompagnatoreItalianoRandRand(durata, oraInizio, oraFine);
		} else {
			logger.severe("CRITERI ERRATI");
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
		int r = rand.nextInt(1);
		if(r == 1) {
			if (id == 0) {
				//id = cercaLavoratoreClasse3ISCmin(durata, oraInizio, oraFine);
			} if (id == 0) {
				//id = cercaLavoratoreClasse3NISCmin(durata, oraInizio, oraFine);
			}
		} else {
			if (id == 0) {
				//id = cercaLavoratoreClasse4ISCmin(durata, oraInizio, oraFine);
			} if (id == 0) {
				//id = cercaLavoratoreClasse4NISCmin(durata, oraInizio, oraFine);
			} 
		}
		if (id == 0) {
			//id = cercaLavoratoreClasse5ISCmin(durata, oraInizio, oraFine);
		} if (id == 0) {
			//id = cercaLavoratoreClasse5NISCmin(durata, oraInizio, oraFine);
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
		int r = rand.nextInt(1);
		if(r == 1) {
			if (id == 0) {
				//id = cercaLavoratoreClasse3ISCmin(durata, oraInizio, oraFine);
			} if (id == 0) {
				//id = cercaLavoratoreClasse3NISCmax(durata, oraInizio, oraFine);
			}
		} else {
			if (id == 0) {
				//id = cercaLavoratoreClasse4ISCmin(durata, oraInizio, oraFine);
			} if (id == 0) {
				//id = cercaLavoratoreClasse4NISCmax(durata, oraInizio, oraFine);
			} 
		}
		if (id == 0) {
			//id = cercaLavoratoreClasse5ISCmin(durata, oraInizio, oraFine);
		} if (id == 0) {
			//id = cercaLavoratoreClasse5NISCmax(durata, oraInizio, oraFine);
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
		int r = rand.nextInt(1);
		if(r == 1) {
			if (id == 0) {
				//id = cercaLavoratoreClasse3ISCmax(durata, oraInizio, oraFine);
			} if (id == 0) {
				//id = cercaLavoratoreClasse3NISCmin(durata, oraInizio, oraFine);
			}
		} else {
			if (id == 0) {
				//id = cercaLavoratoreClasse4ISCmax(durata, oraInizio, oraFine);
			} if (id == 0) {
				//id = cercaLavoratoreClasse4NISCmin(durata, oraInizio, oraFine);
			} 
		}
		if (id == 0) {
			//id = cercaLavoratoreClasse5ISCmax(durata, oraInizio, oraFine);
		} if (id == 0) {
			//id = cercaLavoratoreClasse5NISCmin(durata, oraInizio, oraFine);
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
		int r = rand.nextInt(1);
		if(r == 1) {
			if (id == 0) {
				//id = cercaLavoratoreClasse3ISCmax(durata, oraInizio, oraFine);
			} if (id == 0) {
				//id = cercaLavoratoreClasse3NISCmax(durata, oraInizio, oraFine);
			}
		} else {
			if (id == 0) {
				//id = cercaLavoratoreClasse4ISCmax(durata, oraInizio, oraFine);
			} if (id == 0) {
				//id = cercaLavoratoreClasse4NISCmax(durata, oraInizio, oraFine);
			} 
		}
		if (id == 0) {
			//id = cercaLavoratoreClasse5ISCmax(durata, oraInizio, oraFine);
		} if (id == 0) {
			//id = cercaLavoratoreClasse5NISCmax(durata, oraInizio, oraFine);
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
		int r = rand.nextInt(1);
		if(r == 1) {
			if (id == 0) {
				//id = cercaLavoratoreClasse3ISCmin(durata, oraInizio, oraFine);
			} if (id == 0) {
				//id = cercaLavoratoreClasse3NISRandom(durata, oraInizio, oraFine);
			}
		} else {
			if (id == 0) {
				//id = cercaLavoratoreClasse4ISCmin(durata, oraInizio, oraFine);
			} if (id == 0) {
				//id = cercaLavoratoreClasse4NISRandom(durata, oraInizio, oraFine);
			} 
		}
		if (id == 0) {
			//id = cercaLavoratoreClasse5ISCmin(durata, oraInizio, oraFine);
		} if (id == 0) {
			//id = cercaLavoratoreClasse5NISRandom(durata, oraInizio, oraFine);
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
		int r = rand.nextInt(1);
		if(r == 1) {
			if (id == 0) {
				//id = cercaLavoratoreClasse3ISCmax(durata, oraInizio, oraFine);
			} if (id == 0) {
				//id = cercaLavoratoreClasse3NISRandom(durata, oraInizio, oraFine);
			}
		} else {
			if (id == 0) {
				//id = cercaLavoratoreClasse4ISCmax(durata, oraInizio, oraFine);
			} if (id == 0) {
				//id = cercaLavoratoreClasse4NISRandom(durata, oraInizio, oraFine);
			} 
		}
		if (id == 0) {
			//id = cercaLavoratoreClasse5ISCmax(durata, oraInizio, oraFine);
		} if (id == 0) {
			//id = cercaLavoratoreClasse5NISRandom(durata, oraInizio, oraFine);
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
		int r = rand.nextInt(1);
		if(r == 1) {
			if (id == 0) {
				//id = cercaLavoratoreClasse3ISRandom(durata, oraInizio, oraFine);
			} if (id == 0) {
				//id = cercaLavoratoreClasse3NISCmin(durata, oraInizio, oraFine);
			}
		} else {
			if (id == 0) {
				//id = cercaLavoratoreClasse4ISRandom(durata, oraInizio, oraFine);
			} if (id == 0) {
				//id = cercaLavoratoreClasse4NISCmin(durata, oraInizio, oraFine);
			} 
		}
		if (id == 0) {
			//id = cercaLavoratoreClasse5ISRandom(durata, oraInizio, oraFine);
		} if (id == 0) {
			//id = cercaLavoratoreClasse5NISCmin(durata, oraInizio, oraFine);
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
		int r = rand.nextInt(1);
		if(r == 1) {
			if (id == 0) {
				//id = cercaLavoratoreClasse3ISRandom(durata, oraInizio, oraFine);
			} if (id == 0) {
				//id = cercaLavoratoreClasse3NISCmax(durata, oraInizio, oraFine);
			}
		} else {
			if (id == 0) {
				//id = cercaLavoratoreClasse4ISRandom(durata, oraInizio, oraFine);
			} if (id == 0) {
				//id = cercaLavoratoreClasse4NISCmax(durata, oraInizio, oraFine);
			} 
		}
		if (id == 0) {
			//id = cercaLavoratoreClasse5ISRandom(durata, oraInizio, oraFine);
		} if (id == 0) {
			//id = cercaLavoratoreClasse5NISCmax(durata, oraInizio, oraFine);
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
		int r = rand.nextInt(1);
		if(r == 1) {
			if (id == 0) {
				//id = cercaLavoratoreClasse3ISRandom(durata, oraInizio, oraFine);
			} if (id == 0) {
				//id = cercaLavoratoreClasse3NISRandom(durata, oraInizio, oraFine);
			}
		} else {
			if (id == 0) {
				//id = cercaLavoratoreClasse4ISRandom(durata, oraInizio, oraFine);
			} if (id == 0) {
				//id = cercaLavoratoreClasse4NISRandom(durata, oraInizio, oraFine);
			} 
		}
		if (id == 0) {
			//id = cercaLavoratoreClasse5ISRandom(durata, oraInizio, oraFine);
		} if (id == 0) {
			//id = cercaLavoratoreClasse5NISRandom(durata, oraInizio, oraFine);
		} else {
			logger.severe("TrovaAccompagnatoreItalianoRandomRandom: Non ho trovato Accompagnatori");
		}
		return id;
	}


	/*
	 * Cerca Lavoratori Classe 1 In Servizio Cmin, Cmax, Random
	 */
	public synchronized int cercaLavoratoreClasse1ISCmin(int durata, int oraInizio, int oraFine) {
		int id = 0;
		boolean trovato = false;
		for(int i=0; i< lavoratoriClasse1.size(); i++) {

			//Cerco un lavoratore in Servizio
			if(lavoratoriClasse1.get(i).isInServizio() == true && trovato==false) {
				if(durata <= lavoratoriClasse1.get(i).getOreRimaste() && oraFine <= lavoratoriClasse1.get(i).getOraFineServizio() && oraInizio >= lavoratoriClasse1.get(i).getOraLibero()) {
					id = lavoratoriClasse1.get(i).getIdentificatore();
					Lavoratore l = new Lavoratore();
					l = lavoratoriClasse1.get(i);
					l.setOreRimaste(l.getOreRimaste() - durata);
					l.setOraLibero(l.getOraLibero() + durata);
					trovato = true;
					break;

				} else {
					System.out.println("Niente");
				}
			}
		}

		return id;
	}

	public synchronized int cercaLavoratoreClasse1ISCmax(int durata, int oraInizio, int oraFine) {
		int id = 0;
		boolean trovato = false;
		for(int i=lavoratoriClasse1.size(); i>0; i--) {

			//Cerco un lavoratore in Servizio
			if(lavoratoriClasse1.get(i).isInServizio() == true && trovato==false) {
				if(durata <= lavoratoriClasse1.get(i).getOreRimaste() && oraFine <= lavoratoriClasse1.get(i).getOraFineServizio()  && oraInizio >= lavoratoriClasse1.get(i).getOraLibero()) {
					id = lavoratoriClasse1.get(i).getIdentificatore();
					Lavoratore l = new Lavoratore();
					l = lavoratoriClasse1.get(i);
					l.setOreRimaste(l.getOreRimaste() - durata);
					l.setOraLibero(l.getOraLibero() + durata);
					trovato = true;
					break;

				} else {
					System.out.println("Niente");
				}
			}
		}

		return id;
	}

	public synchronized int cercaLavoratoreClasse1ISRandom(int durata, int oraInizio, int oraFine) {
		int id = 0;
		boolean trovato = false;
		Random random = new Random();
		for(int i=0; i< lavoratoriClasse1.size(); random.nextInt(lavoratoriClasse1.size())) {

			//Cerco un lavoratore in Servizio
			if(lavoratoriClasse1.get(i).isInServizio() == true && trovato==false) {
				if(durata <= lavoratoriClasse1.get(i).getOreRimaste() && oraFine <= lavoratoriClasse1.get(i).getOraFineServizio()  && oraInizio >= lavoratoriClasse1.get(i).getOraLibero()) {
					id = lavoratoriClasse1.get(i).getIdentificatore();
					Lavoratore l = new Lavoratore();
					l = lavoratoriClasse1.get(i);
					l.setOreRimaste(l.getOreRimaste() - durata);
					l.setOraLibero(l.getOraLibero() - durata);
					trovato = true;
					break;
				} else {
					System.out.println("Niente");
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
		boolean trovato = false;

		for(int i=0; i< lavoratoriClasse1.size(); i++) {
			if(lavoratoriClasse1.get(i).isInServizio() == false && trovato==false) {	
				//System.out.println("Entro nell'else");
				id = lavoratoriClasse1.get(i).getIdentificatore();
				Lavoratore l = new Lavoratore();
				l = lavoratoriClasse1.get(i);
				l.setInServizio(true);
				l.setOraFineServizio(oraInizio + l.getOreTotaliServizio());
				l.setOreRimaste(l.getOreTotaliServizio() - durata);
				l.setOraLibero(oraInizio + durata);
				lavoratoriClasse1.set(i, l);
				trovato = true;
				break;
			}
		}
		return id;
	}

	public synchronized int cercaLavoratoreClasse1NISCmax(int durata, int oraInizio, int oraFine) {
		int id = 0;
		boolean trovato = false;

		for(int i=lavoratoriClasse1.size(); i>0; i--) {
			if(lavoratoriClasse1.get(i).isInServizio() == false && trovato==false) {	
				//System.out.println("Entro nell'else");
				id = lavoratoriClasse1.get(i).getIdentificatore();
				Lavoratore l = new Lavoratore();
				l = lavoratoriClasse1.get(i);
				l.setInServizio(true);
				l.setOraFineServizio(oraInizio + l.getOreTotaliServizio());
				l.setOreRimaste(l.getOreTotaliServizio() - durata);
				l.setOraLibero(oraInizio + durata);
				lavoratoriClasse1.set(i, l);
				trovato = true;
				break;
			}
		}
		return id;
	}

	public synchronized int cercaLavoratoreClasse1NISRandom(int durata, int oraInizio, int oraFine) {
		int id = 0;
		boolean trovato = false;
		Random random = new Random();
		for(int i=0; i< lavoratoriClasse1.size(); random.nextInt(lavoratoriClasse1.size())) {
			if(lavoratoriClasse1.get(i).isInServizio() == false && trovato==false) {	
				//System.out.println("Entro nell'else");
				id = lavoratoriClasse1.get(i).getIdentificatore();
				Lavoratore l = new Lavoratore();
				l = lavoratoriClasse1.get(i);
				l.setInServizio(true);
				l.setOraFineServizio(oraInizio + l.getOreTotaliServizio());
				l.setOreRimaste(l.getOreTotaliServizio() - durata);
				l.setOraLibero(oraInizio + durata);
				lavoratoriClasse1.set(i, l);
				trovato = true;
				break;
			}
		}
		return id;
	}

	/*
	 * Cerca Lavoratori Classe 2 In Servizio Cmin, Cmax, Random
	 */
	public synchronized int cercaLavoratoreClasse2ISCmin(int durata, int oraInizio, int oraFine) {
		int id = 0;
		boolean trovato = false;
		for(int i=0; i< lavoratoriClasse2.size(); i++) {

			//Cerco un lavoratore in Servizio
			if(lavoratoriClasse2.get(i).isInServizio() == true && trovato==false) {
				if(durata <= lavoratoriClasse2.get(i).getOreRimaste() && oraFine <= lavoratoriClasse2.get(i).getOraFineServizio() && oraInizio >= lavoratoriClasse2.get(i).getOraLibero()) {
					id = lavoratoriClasse2.get(i).getIdentificatore();
					Lavoratore l = new Lavoratore();
					l = lavoratoriClasse2.get(i);
					l.setOreRimaste(l.getOreRimaste() - durata);
					l.setOraLibero(l.getOraLibero() + durata);
					trovato = true;
					break;

				} else {
					System.out.println("Niente");
				}
			}
		}

		return id;
	}

	public synchronized int cercaLavoratoreClasse2ISCmax(int durata, int oraInizio, int oraFine) {
		int id = 0;
		boolean trovato = false;
		for(int i=lavoratoriClasse2.size(); i>0; i--) {

			//Cerco un lavoratore in Servizio
			if(lavoratoriClasse2.get(i).isInServizio() == true && trovato==false) {
				if(durata <= lavoratoriClasse2.get(i).getOreRimaste() && oraFine <= lavoratoriClasse2.get(i).getOraFineServizio()  && oraInizio >= lavoratoriClasse2.get(i).getOraLibero()) {
					id = lavoratoriClasse2.get(i).getIdentificatore();
					Lavoratore l = new Lavoratore();
					l = lavoratoriClasse2.get(i);
					l.setOreRimaste(l.getOreRimaste() - durata);
					l.setOraLibero(l.getOraLibero() + durata);
					trovato = true;
					break;

				} else {
					System.out.println("Niente");
				}
			}
		}

		return id;
	}

	public synchronized int cercaLavoratoreClasse2ISRandom(int durata, int oraInizio, int oraFine) {
		int id = 0;
		boolean trovato = false;
		Random random = new Random();
		for(int i=0; i< lavoratoriClasse2.size(); random.nextInt(lavoratoriClasse2.size())) {

			//Cerco un lavoratore in Servizio
			if(lavoratoriClasse2.get(i).isInServizio() == true && trovato==false) {
				if(durata <= lavoratoriClasse2.get(i).getOreRimaste() && oraFine <= lavoratoriClasse2.get(i).getOraFineServizio()  && oraInizio >= lavoratoriClasse2.get(i).getOraLibero()) {
					id = lavoratoriClasse2.get(i).getIdentificatore();
					Lavoratore l = new Lavoratore();
					l = lavoratoriClasse2.get(i);
					l.setOreRimaste(l.getOreRimaste() - durata);
					l.setOraLibero(l.getOraLibero() - durata);
					trovato = true;
					break;
				} else {
					System.out.println("Niente");
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
		boolean trovato = false;

		for(int i=0; i< lavoratoriClasse2.size(); i++) {
			if(lavoratoriClasse2.get(i).isInServizio() == false && trovato==false) {	
				//System.out.println("Entro nell'else");
				id = lavoratoriClasse2.get(i).getIdentificatore();
				Lavoratore l = new Lavoratore();
				l = lavoratoriClasse2.get(i);
				l.setInServizio(true);
				l.setOraFineServizio(oraInizio + l.getOreTotaliServizio());
				l.setOreRimaste(l.getOreTotaliServizio() - durata);
				l.setOraLibero(oraInizio + durata);
				lavoratoriClasse2.set(i, l);
				trovato = true;
				break;
			}
		}
		return id;
	}

	public synchronized int cercaLavoratoreClasse2NISCmax(int durata, int oraInizio, int oraFine) {
		int id = 0;
		boolean trovato = false;

		for(int i=lavoratoriClasse2.size(); i>0; i--) {
			if(lavoratoriClasse2.get(i).isInServizio() == false && trovato==false) {	
				//System.out.println("Entro nell'else");
				id = lavoratoriClasse2.get(i).getIdentificatore();
				Lavoratore l = new Lavoratore();
				l = lavoratoriClasse2.get(i);
				l.setInServizio(true);
				l.setOraFineServizio(oraInizio + l.getOreTotaliServizio());
				l.setOreRimaste(l.getOreTotaliServizio() - durata);
				l.setOraLibero(oraInizio + durata);
				lavoratoriClasse2.set(i, l);
				trovato = true;
				break;
			}
		}
		return id;
	}

	public synchronized int cercaLavoratoreClasse2NISRandom(int durata, int oraInizio, int oraFine) {
		int id = 0;
		boolean trovato = false;
		Random random = new Random();
		for(int i=0; i< lavoratoriClasse2.size(); random.nextInt(lavoratoriClasse2.size())) {
			if(lavoratoriClasse2.get(i).isInServizio() == false && trovato==false) {	
				//System.out.println("Entro nell'else");
				id = lavoratoriClasse2.get(i).getIdentificatore();
				Lavoratore l = new Lavoratore();
				l = lavoratoriClasse2.get(i);
				l.setInServizio(true);
				l.setOraFineServizio(oraInizio + l.getOreTotaliServizio());
				l.setOreRimaste(l.getOreTotaliServizio() - durata);
				l.setOraLibero(oraInizio + durata);
				lavoratoriClasse2.set(i, l);
				trovato = true;
				break;
			}
		}
		return id;
	}




	/*
	 * Metodi Database
	 */
	public synchronized void svuotaDBPasseggeri() throws SQLException {
		for(int i=0; i<n; i++) {
			DatabaseQuery.delLavoro(i);
		}
	}

	public synchronized void svuotaDBAccompagnatori() throws SQLException {
		for(int j=0; j<m; j++) {
			DatabaseQuery.delLavoratore(j);
		}
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



