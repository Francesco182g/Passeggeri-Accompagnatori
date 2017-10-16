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
	 * Si occupa di ordinare gli elementi dell'array di passeggeri
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
		int criterio1 = verificaCriterio(c1);
		int criterio2 = verificaCriterio(c2);


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
				if(durata <= lavoratoriClasse1.get(i).getOreRimaste() && oraFine <= lavoratoriClasse1.get(i).getOraFineServizio()) {
					id = lavoratoriClasse1.get(i).getIdentificatore();
					Lavoratore l = new Lavoratore();
					l = lavoratoriClasse1.get(i);
					l.setOreRimaste(l.getOreRimaste() - durata);
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
				if(durata <= lavoratoriClasse1.get(i).getOreRimaste() && oraFine <= lavoratoriClasse1.get(i).getOraFineServizio()) {
					id = lavoratoriClasse1.get(i).getIdentificatore();
					Lavoratore l = new Lavoratore();
					l = lavoratoriClasse1.get(i);
					l.setOreRimaste(l.getOreRimaste() - durata);
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
				if(durata <= lavoratoriClasse1.get(i).getOreRimaste() && oraFine <= lavoratoriClasse1.get(i).getOraFineServizio()) {
					id = lavoratoriClasse1.get(i).getIdentificatore();
					Lavoratore l = new Lavoratore();
					l = lavoratoriClasse1.get(i);
					l.setOreRimaste(l.getOreRimaste() - durata);
					trovato = true;
					break;

				} else {
					System.out.println("Niente");
				}
			}
		}
		
	 return id;
	}
	
	public synchronized int cercaLavoratoreClasse1NISCmin(int durata, int oraInizio, int oraFine) {
		int id = 0;
		
		return id;
	}
	
	/*
	 * Metodo per la ricerca di un lavoratore italiano nelle classi da 1 a 5
	 */
	public synchronized int cercaLavoratoreItalianoCminCmin(int durata, int oraInizio, int oraFine) {
		int id = 0;

		boolean trovatoclasse1 = false;
		boolean trovatoclasse2 = false;
		boolean trovatoclasse3 = false;
		boolean trovatoclasse4 = false;
		boolean trovatoclasse5 = false;
		boolean trovato = false;
		for(int i=0; i<lavoratoriClasse1.size(); i++) {
			//Cerco un lavoratore in Servizio

			if(lavoratoriClasse1.get(i).isInServizio() == true) {
				if(durata <= lavoratoriClasse1.get(i).getOreRimaste() && oraFine <= lavoratoriClasse1.get(i).getOraFineServizio()) {
					id = lavoratoriClasse1.get(i).getIdentificatore();
					Lavoratore l = new Lavoratore();
					l = lavoratoriClasse1.get(i);
					l.setOreRimaste(l.getOreRimaste() - durata);
					trovatoclasse1 = true;
					trovato = true;
					break;
				}
				else {
					System.out.println("Niente");
				}
			}
			//Cerco un lavoratore che non è già in servizio
			//Controllo quali sono tutti i lavoratori che lo possono svolgere e scelgo 
			//un criterio random, 
			else if(lavoratoriClasse1.get(i).isInServizio() == false && trovato==false) {

				System.out.println("Entro nell'else");
				id = lavoratoriClasse1.get(i).getIdentificatore();
				Lavoratore l = new Lavoratore();
				l = lavoratoriClasse1.get(i);
				l.setInServizio(true);
				l.setOraFineServizio(oraInizio + l.getOreTotaliServizio());
				l.setOreRimaste(l.getOreTotaliServizio() - durata);
				trovatoclasse1 = true;
				trovato = true;
				break;
			}
		}
		/*
		 * Cerca nela Classe dei lavoratori 2
		 */
		if(trovatoclasse1 == false && trovato==false) {

			for(int i=0; i<lavoratoriClasse2.size(); i++) {
				//Cerco un lavoratore in Servizio
				if(lavoratoriClasse2.get(i).isInServizio() == true && trovato==false) {
					if(durata <= lavoratoriClasse2.get(i).getOreRimaste() && oraFine <= lavoratoriClasse2.get(i).getOraFineServizio()) {
						id = lavoratoriClasse2.get(i).getIdentificatore();
						Lavoratore l = new Lavoratore();
						l = lavoratoriClasse2.get(i);
						l.setOreRimaste(l.getOreRimaste() - durata);
						trovatoclasse2 = true;
						trovato = true;
						break;
					}
					else {
						System.out.println("Niente");
					}
				}

				//Cerco un lavoratore che non è già in servizio
				else if(lavoratoriClasse2.get(i).isInServizio() == false && trovato==false) {
					//System.out.println("Entro nell'else");
					id = lavoratoriClasse2.get(i).getIdentificatore();
					Lavoratore l = new Lavoratore();
					l = lavoratoriClasse2.get(i);
					l.setInServizio(true);
					l.setOraFineServizio(oraInizio + 12);
					l.setOreRimaste(12 - durata);
					trovatoclasse2 = true;
					trovato = true;
					break;
				}
			}
		}
		/*
		 * Cerca lavoratori classe3
		 */
		if(trovatoclasse2 == false && trovato==false) {

			for(int i=0; i<lavoratoriClasse3.size(); i++) {
				//Cerco un lavoratore in Servizio
				if(lavoratoriClasse3.get(i).isInServizio() == true && trovato==false) {
					if(durata <= lavoratoriClasse3.get(i).getOreRimaste() && oraFine <= lavoratoriClasse3.get(i).getOraFineServizio()) {
						id = lavoratoriClasse3.get(i).getIdentificatore();
						Lavoratore l = new Lavoratore();
						l = lavoratoriClasse3.get(i);
						l.setOreRimaste(l.getOreRimaste() - durata);
						trovatoclasse3 = true;
						trovato = true;
						break;

					}
					else {
						System.out.println("Niente");
					}
				}
				//Cerco un lavoratore che non è già in servizio
				else if(lavoratoriClasse3.get(i).isInServizio() == false && trovato==false) {	
					//System.out.println("Entro nell'else");
					id = lavoratoriClasse3.get(i).getIdentificatore();
					Lavoratore l = new Lavoratore();
					l = lavoratoriClasse3.get(i);
					l.setInServizio(true);
					l.setOraFineServizio(oraInizio + 12);
					l.setOreRimaste(12 - durata);
					trovatoclasse3 = true;
					trovato = true;
					break;
				}
			}
		}

		/*
		 * Cerca lavoratori classe4
		 */
		if(trovatoclasse3 == false && trovato==false) {
			for(int i=0; i<lavoratoriClasse4.size(); i++) {
				//Cerco un lavoratore in Servizio
				if(lavoratoriClasse4.get(i).isInServizio() == true && trovato==false) {
					if(durata <= lavoratoriClasse4.get(i).getOreRimaste() && oraFine <= lavoratoriClasse4.get(i).getOraFineServizio()) {
						id = lavoratoriClasse4.get(i).getIdentificatore();
						Lavoratore l = new Lavoratore();
						l = lavoratoriClasse4.get(i);
						l.setOreRimaste(l.getOreRimaste() - durata);
						trovatoclasse4 = true;
						trovato = true;
						break;

					}
					else {
						System.out.println("Niente");
					}
				}
				//Cerco un lavoratore che non è già in servizio
				else if(lavoratoriClasse4.get(i).isInServizio() == false && trovato==false) {	
					//System.out.println("Entro nell'else");
					id = lavoratoriClasse4.get(i).getIdentificatore();
					Lavoratore l = new Lavoratore();
					l = lavoratoriClasse4.get(i);
					l.setInServizio(true);
					l.setOraFineServizio(oraInizio + 12);
					l.setOreRimaste(12 - durata);
					trovatoclasse4 = true;
					trovato = true;
					break;
				}
			}
		}

		/*
		 * Cerca lavoratori classe5
		 */
		if(trovatoclasse4 == false && trovato==false) {
			for(int i=0; i<lavoratoriClasse5.size(); i++) {
				//Cerco un lavoratore in Servizio
				if(lavoratoriClasse5.get(i).isInServizio() == true && trovato==false) {
					if(durata <= lavoratoriClasse5.get(i).getOreRimaste() && oraFine <= lavoratoriClasse5.get(i).getOraFineServizio()) {
						id = lavoratoriClasse5.get(i).getIdentificatore();
						Lavoratore l = new Lavoratore();
						l = lavoratoriClasse5.get(i);
						l.setOreRimaste(l.getOreRimaste() - durata);
						trovatoclasse5 = true;
						trovato = true;
						break;

					}
					else {
						System.out.println("Niente");
					}
				}
				//Cerco un lavoratore che non è già in servizio
				else if(lavoratoriClasse5.get(i).isInServizio() == false && trovato==false) {	
					//System.out.println("Entro nell'else");
					id = lavoratoriClasse5.get(i).getIdentificatore();
					Lavoratore l = new Lavoratore();
					l = lavoratoriClasse5.get(i);
					l.setInServizio(true);
					l.setOraFineServizio(oraInizio + 12);
					l.setOreRimaste(12 - durata);
					trovatoclasse5 = true;
					trovato = true;
					break;
				}
			}
		}

		return id;
	}


	/*
	 * Metodo per la verifica del criterio inserito
	 */
	public synchronized int verificaCriterio(int criterio) {
		int risultatoVerifica = 0;
		if(criterio == 1) {
			risultatoVerifica = 1;
		} else if(criterio == 2) {
			risultatoVerifica = 2;
		} else if(criterio == 3) {
			risultatoVerifica = 3;
		}
		else {
			logger.severe("ESCO DAL PROGRAMMA: Criterio inserito non valito (RANGE 1-3");
		}
		return risultatoVerifica;
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



