
public class Lavoratore {
	private int identificatore;
	private int oreTotaliServizio;
	private String lingua;
	private int oreRimaste;
	private int oraFineServizio;
	private boolean inServizio;
	private int oraLibero;
	private String istanza;
	
	public Lavoratore(int identificatore, int oreTotaliServizio, String lingua, int oreRimaste, int oraFineServizio,
			boolean inServizio, int oraLibero, String istanza) {
		super();
		this.identificatore = identificatore;
		this.oreTotaliServizio = oreTotaliServizio;
		this.lingua = lingua;
		this.oreRimaste = oreRimaste;
		this.oraFineServizio = oraFineServizio;
		this.inServizio = inServizio;
		this.oraLibero = oraLibero;
		this.istanza = istanza;
	}

	public Lavoratore() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdentificatore() {
		return identificatore;
	}

	public void setIdentificatore(int identificatore) {
		this.identificatore = identificatore;
	}

	public int getOreTotaliServizio() {
		return oreTotaliServizio;
	}

	public void setOreTotaliServizio(int oreTotaliServizio) {
		this.oreTotaliServizio = oreTotaliServizio;
	}

	public String getLingua() {
		return lingua;
	}

	public void setLingua(String lingua) {
		this.lingua = lingua;
	}

	public int getOreRimaste() {
		return oreRimaste;
	}

	public void setOreRimaste(int oreRimaste) {
		this.oreRimaste = oreRimaste;
	}

	public int getOraFineServizio() {
		return oraFineServizio;
	}

	public void setOraFineServizio(int oraFineServizio) {
		this.oraFineServizio = oraFineServizio;
	}

	public boolean isInServizio() {
		return inServizio;
	}

	public void setInServizio(boolean inServizio) {
		this.inServizio = inServizio;
	}

	public int getOraLibero() {
		return oraLibero;
	}

	public void setOraLibero(int oraLibero) {
		this.oraLibero = oraLibero;
	}

	public String getIstanza() {
		return istanza;
	}

	public void setIstanza(String istanza) {
		this.istanza = istanza;
	}

	@Override
	public String toString() {
		return "Lavoratore [identificatore=" + identificatore + ", oreTotaliServizio=" + oreTotaliServizio + ", lingua="
				+ lingua + ", oreRimaste=" + oreRimaste + ", oraFineServizio=" + oraFineServizio + ", inServizio="
				+ inServizio + ", oraLibero=" + oraLibero + ", istanza=" + istanza + "]";
	}
	
	
}