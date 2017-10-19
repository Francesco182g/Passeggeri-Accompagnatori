/* 
	@copy Coded by Francesco Garofalo 2017
 */
import java.util.ArrayList;



import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DatabaseQuery {

	private static ArrayList <Lavoratore> lavoratori = new ArrayList<>(); 
	private static ArrayList <Lavoro> lavori = new ArrayList<>();
	
	//Query per metodi SQL
	private static String queryGetLavori;
	private static String queryGetLavoratori;
	private static String queryAddLavoro;
	private static String queryAddLavoratore;
	private static String queryDelLavoro;
	private static String queryDelLavoratore;
	
	public DatabaseQuery(/*ArrayList lavori, ArrayList lavoratori*/) {
		super();
		//lavori = new ArrayList<Lavoro>();
		//lavoratori = new ArrayList<Lavoratore>();
	}
	
	/**
	 * Ritorna la lista di tutti i lavori presenti nel db
	 * 
	 * @param istanza
	 * @return ArrayList lavori
	 * @throws SQLException
	 */
	//@SuppressWarnings({ "rawtypes", "unchecked" })
	public synchronized static ArrayList getLavori(String istanza) throws SQLException{
		Connection connection = null;
		PreparedStatement psListaLavori= null;
		lavori = new ArrayList<Lavoro>();
		try{
			connection = Database.getConnection();
			psListaLavori = connection.prepareStatement(queryGetLavori);

			psListaLavori.setString(1, istanza);
			ResultSet rs = psListaLavori.executeQuery();

			while(rs.next()){
				Lavoro pr = new Lavoro();
				pr.setCodicePasseggero(rs.getInt("codicePasseggero"));
				pr.setLingua(rs.getString("lingua"));
				pr.setOraInizio(rs.getInt("oraInizio"));
				pr.setDurata(rs.getInt("durata"));
				pr.setOraFine(rs.getInt("oraFine"));
				pr.setLavoratoreAssegnato(rs.getInt("lavoratoreAssegnato"));
				pr.setIstanza(rs.getString("istanza"));
				//pr.setLavoratoreAssegnato("NULLA PER ORA");
				lavori.add(pr);
			}

		}
		finally {
			try {
				if(psListaLavori != null)
					psListaLavori.close();
				if(psListaLavori !=null)
					psListaLavori.close();
			} catch(SQLException e) {
				e.printStackTrace();			
			}
			finally {
				connection.close();
				Database.releaseConnection(connection);
			}
		}
		return lavori;
	}

	
	/**
	 * Ritorna la lista di tutti i lavoratori presenti nel db
	 * 
	 * @param istanza
	 * @return ArrayList lavoratori
	 * @throws SQLException
	 */
	public synchronized static LavoratoreDaDatabase getLavoratori(String istanza) throws SQLException{
		Connection connection = null;
		PreparedStatement psListaLavoratori= null;
		LavoratoreDaDatabase pr = new LavoratoreDaDatabase();
		lavoratori = new ArrayList<Lavoratore>();
		try{
			connection = Database.getConnection();
			psListaLavoratori = connection.prepareStatement(queryGetLavoratori);

			psListaLavoratori.setString(1, istanza);
			ResultSet rs = psListaLavoratori.executeQuery();

			while(rs.next()){

				pr.setIstanza(rs.getString("istanza"));
				pr.setL(rs.getInt("L"));
				pr.setM(rs.getInt("m"));
			}

		}
		finally {
			try {
				if(psListaLavoratori != null)
					psListaLavoratori.close();
				if(psListaLavoratori !=null)
					psListaLavoratori.close();
			} catch(SQLException e) {
				e.printStackTrace();			
			}
			finally {
				connection.close();
				Database.releaseConnection(connection);
			}
		}
		return pr;
	}
	
	/**
	 * Aggiunge un lavoratore nel database
	 * 
	 * @param Lavoratore
	 * @return boolean value
	 * @throws SQLException
	 */
	public synchronized static boolean addLavoratore(int m, int L, String istanza) throws SQLException{
		Connection connection = null;
		PreparedStatement psAddLavoratore = null;

		try{
			connection = Database.getConnection();
			psAddLavoratore = connection.prepareStatement(queryAddLavoratore);

			psAddLavoratore.setString(1, istanza);
			psAddLavoratore.setInt(2, L);
			psAddLavoratore.setInt(3, m);
			psAddLavoratore.executeUpdate();

			connection.commit();
			System.out.println("Aggiungo un lavoratore: "+ psAddLavoratore.toString());
		} finally {
			try{
				if(psAddLavoratore != null)
					psAddLavoratore.close();
			} finally {
				Database.releaseConnection(connection);
			}
		}

		return true;
	}
	
	/**
	 * Aggiunge un lavoro nel database
	 * 
	 * @param Lavoro
	 * @return boolean value
	 * @throws SQLException
	 */
	public synchronized static boolean addLavoro(Lavoro lavoro) throws SQLException{
		Connection connection = null;
		PreparedStatement psAddLavoro = null;

		try{
			connection = Database.getConnection();
			psAddLavoro = connection.prepareStatement(queryAddLavoro);

			psAddLavoro.setInt(1, lavoro.getCodicePasseggero());
			psAddLavoro.setString(2, lavoro.getLingua());
			psAddLavoro.setInt(3, lavoro.getOraInizio());
			psAddLavoro.setInt(4, lavoro.getDurata());
			psAddLavoro.setInt(5, lavoro.getOraFine());
			psAddLavoro.setInt(6, lavoro.getLavoratoreAssegnato());
			psAddLavoro.setString(7, lavoro.getIstanza());
			psAddLavoro.executeUpdate();
			connection.commit();
			System.out.println("Aggiungo un lavoro: "+ psAddLavoro.toString());
		} finally {
			try{
				if(psAddLavoro != null)
					psAddLavoro.close();
			} finally {
				Database.releaseConnection(connection);
			}
		}

		return true;
	}
	
	/**
	 * Rimuove un lavoro dando come parametro l'istanza nel database
	 * 
	 * @param istanza
	 * @return boolean value
	 * @throws SQLException
	 */
	public synchronized static boolean delLavoro(String istanza) throws SQLException{
		Connection connection = null;
		PreparedStatement psDelLavoro = null;

		try{
			connection = Database.getConnection();
			psDelLavoro = connection.prepareStatement(queryDelLavoro);
			psDelLavoro.setString(1, istanza);

			psDelLavoro.executeUpdate();

			connection.commit();
		} finally {
			try{
				if(psDelLavoro != null)
					psDelLavoro.close();
			} finally {
				Database.releaseConnection(connection);
			}
		}

		return true;
	}
	/**
	 * Rimuove un lavoratore con l'istanza data come parametro nel database
	 * 
	 * @param istanza
	 * @return boolean value
	 * @throws SQLException
	 */
	public synchronized static boolean delLavoratore(String istanza) throws SQLException{
		Connection connection = null;
		PreparedStatement psDelLavoratore = null;

		try{
			connection = Database.getConnection();
			psDelLavoratore = connection.prepareStatement(queryDelLavoratore);
			psDelLavoratore.setString(1, istanza);

			psDelLavoratore.executeUpdate();

			connection.commit();
		} finally {
			try{
				if(psDelLavoratore != null)
					psDelLavoratore.close();
			} finally {
				Database.releaseConnection(connection);
			}
		}

		return true;
	}
	/*
	 * Contiene tutte i nomi sql da utilizzare per effettuare le query
	 */
	static {
		queryGetLavori ="SELECT * FROM sys.lavoro WHERE istanza = ?";
		queryGetLavoratori ="SELECT * FROM sys.lavoratore WHERE istanza = ?";

		queryAddLavoro = "INSERT INTO sys.lavoro (codicePasseggero, lingua, oraInizio, durata, oraFine, lavoratoreAssegnato, istanza) VALUES (?, ?, ?, ?, ?, ?, ?)";
		queryAddLavoratore = "INSERT INTO sys.lavoratore (istanza, L, m) VALUES (?, ?, ?)"; 
	
		queryDelLavoro = "DELETE FROM sys.lavoro WHERE istanza = ?";
		queryDelLavoratore = "DELETE FROM sys.lavoratore WHERE istanza = ?";
	}
	
}
