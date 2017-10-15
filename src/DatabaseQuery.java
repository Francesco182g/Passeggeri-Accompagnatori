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
	 * @param null
	 * @return ArrayList Prodotti
	 * @throws SQLException
	 */
	//@SuppressWarnings({ "rawtypes", "unchecked" })
	public synchronized static ArrayList getLavori() throws SQLException{
		Connection connection = null;
		PreparedStatement psListaLavori= null;
		lavori = new ArrayList<Lavoro>();
		try{
			connection = Database.getConnection();
			psListaLavori = connection.prepareStatement(queryGetLavori);

			ResultSet rs = psListaLavori.executeQuery();

			while(rs.next()){
				Lavoro pr = new Lavoro();
				pr.setCodicePasseggero(rs.getInt("codicePasseggero"));
				pr.setLingua(rs.getString("lingua"));
				pr.setOraInizio(rs.getInt("oraInizio"));
				pr.setDurata(rs.getInt("durata"));
				pr.setOraFine(rs.getInt("oraFine"));
				pr.setLavoratoreAssegnato(rs.getInt("lavoratoreAssegnato"));
				pr.setOraFine(pr.getOraInizio() + pr.getDurata());
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
	 * @param null
	 * @return ArrayList Prodotti
	 * @throws SQLException
	 */
	public synchronized static ArrayList getLavoratori() throws SQLException{
		Connection connection = null;
		PreparedStatement psListaLavoratori= null;
		lavoratori = new ArrayList<Lavoratore>();
		try{
			connection = Database.getConnection();
			psListaLavoratori = connection.prepareStatement(queryGetLavoratori);

			ResultSet rs = psListaLavoratori.executeQuery();

			while(rs.next()){
				Lavoratore pr = new Lavoratore();
				pr.setIdentificatore(rs.getInt("idlavoratore"));
				pr.setOreTotaliServizio(rs.getInt("oreTotaliServizio"));
				pr.setLingua(rs.getString("lingua"));
				pr.setOreTotaliServizio(rs.getInt("oraFineServizio"));
				pr.setInServizio(rs.getBoolean("inServizio"));
				lavoratori.add(pr);
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
		return lavoratori;
	}
	
	/**
	 * Aggiunge un lavoratore nel database
	 * 
	 * @param Lavoratore
	 * @return boolean value
	 * @throws SQLException
	 */
	public synchronized static boolean addLavoratore(Lavoratore lavoratore) throws SQLException{
		Connection connection = null;
		PreparedStatement psAddLavoratore = null;

		try{
			connection = Database.getConnection();
			psAddLavoratore = connection.prepareStatement(queryAddLavoratore);

			psAddLavoratore.setInt(1, lavoratore.getIdentificatore());
			psAddLavoratore.setInt(2, lavoratore.getOreTotaliServizio());
			psAddLavoratore.setString(3, lavoratore.getLingua());
			psAddLavoratore.setInt(4, lavoratore.getOreRimaste());
			psAddLavoratore.setInt(5, lavoratore.getOraFineServizio());
			psAddLavoratore.setBoolean(6, lavoratore.isInServizio());
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
	 * Rimuove un lavoro nel database
	 * 
	 * @param codiceLavoro
	 * @return boolean value
	 * @throws SQLException
	 */
	public synchronized static boolean delLavoro(int codiceLavoro) throws SQLException{
		Connection connection = null;
		PreparedStatement psDelLavoro = null;

		try{
			connection = Database.getConnection();
			psDelLavoro = connection.prepareStatement(queryDelLavoro);
			psDelLavoro.setInt(1, codiceLavoro);

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
	 * Rimuove un lavoratore nel database
	 * 
	 * @param idLavoratore
	 * @return boolean value
	 * @throws SQLException
	 */
	public synchronized static boolean delLavoratore(int idLavoratore) throws SQLException{
		Connection connection = null;
		PreparedStatement psDelLavoratore = null;

		try{
			connection = Database.getConnection();
			psDelLavoratore = connection.prepareStatement(queryDelLavoratore);
			psDelLavoratore.setInt(1, idLavoratore);

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
		queryGetLavori ="SELECT * FROM sys.lavoro";
		queryGetLavoratori = "SELECT * FROM sys.lavoratore";

		queryAddLavoro = "INSERT INTO sys.lavoro (codicePasseggero, lingua, oraInizio, durata, oraFine, lavoratoreAssegnato) VALUES (?, ?, ?, ?, ?, ?)";
		queryAddLavoratore = "INSERT INTO sys.lavoratore (idLavoratore, oreTotaliServizio, lingua, oreRimaste, oraFineServizio, inServizio) VALUES (?, ?, ?, ?, ?, ?)"; 
	
		queryDelLavoro = "DELETE FROM sys.lavoro WHERE codicePasseggero = ?";
		queryDelLavoratore = "DELETE FROM sys.lavoratore WHERE idLavoratore = ?";
	}
	
}
