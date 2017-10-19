
public class LavoratoreDaDatabase {
	private String istanza;
	private int L;
	private int m;
	public LavoratoreDaDatabase(String istanza, int l, int m) {
		super();
		this.istanza = istanza;
		L = l;
		this.m = m;
	}
	public LavoratoreDaDatabase() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getIstanza() {
		return istanza;
	}
	public void setIstanza(String istanza) {
		this.istanza = istanza;
	}
	public int getL() {
		return L;
	}
	public void setL(int l) {
		L = l;
	}
	public int getM() {
		return m;
	}
	public void setM(int m) {
		this.m = m;
	}
	@Override
	public String toString() {
		return "LavoratoreDaDatabase [istanza=" + istanza + ", L=" + L + ", m=" + m + "]";
	}
	
}
