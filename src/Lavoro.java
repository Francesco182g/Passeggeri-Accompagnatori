
public class Lavoro {
	private int codicePasseggero;
	private String lingua;
	private int oraInizio; //1MIN
	private int durata;
	private int oraFine;	//24MAX
	private int lavoratoreAssegnato;
	private String istanza;
	
	public Lavoro() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Lavoro(int codicePasseggero, String lingua, int oraInizio, int durata, int oraFine, int lavoratoreAssegnato,
			String istanza) {
		super();
		this.codicePasseggero = codicePasseggero;
		this.lingua = lingua;
		this.oraInizio = oraInizio;
		this.durata = durata;
		this.oraFine = oraFine;
		this.lavoratoreAssegnato = lavoratoreAssegnato;
		this.istanza = istanza;
	}
	public int getCodicePasseggero() {
		return codicePasseggero;
	}
	public void setCodicePasseggero(int codicePasseggero) {
		this.codicePasseggero = codicePasseggero;
	}
	public String getLingua() {
		return lingua;
	}
	public void setLingua(String lingua) {
		this.lingua = lingua;
	}
	public int getOraInizio() {
		return oraInizio;
	}
	public void setOraInizio(int oraInizio) {
		this.oraInizio = oraInizio;
	}
	public int getDurata() {
		return durata;
	}
	public void setDurata(int durata) {
		this.durata = durata;
	}
	public int getOraFine() {
		return oraFine;
	}
	public void setOraFine(int oraFine) {
		this.oraFine = oraFine;
	}
	public int getLavoratoreAssegnato() {
		return lavoratoreAssegnato;
	}
	public void setLavoratoreAssegnato(int lavoratoreAssegnato) {
		this.lavoratoreAssegnato = lavoratoreAssegnato;
	}
	public String getIstanza() {
		return istanza;
	}
	public void setIstanza(String istanza) {
		this.istanza = istanza;
	}
	
	@Override
	public String toString() {
		return "Lavoro [codicePasseggero=" + codicePasseggero + ", lingua=" + lingua + ", oraInizio=" + oraInizio
				+ ", durata=" + durata + ", oraFine=" + oraFine + ", lavoratoreAssegnato=" + lavoratoreAssegnato
				+ ", istanza=" + istanza + "]";
	} 
	
}