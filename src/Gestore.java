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
			lavoratore.setOreRimaste(12);
			lavoratore.setOraFineServizio(0);
			lavoratore.setIstanza(istanza);
			lavoratoriClasse1.add(lavoratore);
			//System.out.println("Aggiungo lavoratore: "+lavoratore.toString());

		}

		//Lavoratori Classe 2
		for(i=divisioneClassi+1;i<=divisioneClassi *2;i++) {
			lavoratore = new Lavoratore();			

			lavoratore.setIdentificatore(i);
			lavoratore.setOreTotaliServizio(12);
			lavoratore.setLingua("ie");
			lavoratore.setOreRimaste(12);
			lavoratore.setOraFineServizio(0);
			lavoratore.setIstanza(istanza);
			lavoratoriClasse2.add(lavoratore);
			//System.out.println("Aggiungo lavoratore: "+lavoratore.toString());
		}

		//Lavoratori Classe 3
		for(i=divisioneClassi *2+1;i<=divisioneClassi *3;i++) {
			lavoratore = new Lavoratore();			
			lavoratore.setIdentificatore(i);
			lavoratore.setOreTotaliServizio(12);
			lavoratore.setLingua("ief");
			lavoratore.setOreRimaste(12);
			lavoratore.setOraFineServizio(0);
			lavoratore.setIstanza(istanza);
			lavoratoriClasse3.add(lavoratore);
			//System.out.println("Aggiungo lavoratore: "+lavoratore.toString());


		}

		//Lavoratori Classe 4
		for(i=divisioneClassi *3+1;i<=divisioneClassi *4;i++) {
			lavoratore = new Lavoratore();			
			lavoratore.setIdentificatore(i);
			lavoratore.setOreTotaliServizio(12);
			lavoratore.setLingua("ies");
			lavoratore.setOreRimaste(12);
			lavoratore.setOraFineServizio(0);
			lavoratore.setIstanza(istanza);
			lavoratoriClasse4.add(lavoratore);
			//System.out.println("Aggiungo lavoratore: "+lavoratore.toString());

		}

		//Lavoratori Classe 5
		for(i=divisioneClassi *4+1;i<=n;i++) {
			lavoratore = new Lavoratore();			
			lavoratore.setIdentificatore(i);
			lavoratore.setOreTotaliServizio(12);
			lavoratore.setLingua("iefs");
			lavoratore.setOreRimaste(12);
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



