package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DriverManagerConnectionPool {

	static private List<Connection> freeDbConnections;
	
	static {
			freeDbConnections = new LinkedList<Connection>();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("");
			} catch (ClassNotFoundException e) {
				System.out.println("DB driver not found!");
			} catch (Exception e) {
				System.out.println("DB connection pool error!");
				e.printStackTrace();
			}
		}
	
	
	//crea una nuova connessione, cambiare questo per farlo funzionare su un altro db!
	public static Connection createDBConnection() throws SQLException{
		
		String db = "Allez";
		String username="progetto";
		String passwd="ProgettoTSW";
		
		Connection newConnection = DriverManager.getConnection("jdbc:mysql://52.212.118.97:3306/"+db+"?serverTimezone=CET", username, passwd);
				newConnection.setAutoCommit(false);
		return newConnection;
		
	}
	
	// dai una connessione 
	@SuppressWarnings("resource")
	public static Connection getDbConnection() throws SQLException{
		
		Connection con;
		
		if(! freeDbConnections.isEmpty())
		{
			con = (Connection) freeDbConnections.get(0);
			freeDbConnections.remove(0);
			
			try {
				if(con.isClosed()) con = getDbConnection();
			}catch(SQLException e)
			{
				con = getDbConnection();
			}
		}else {
			con = createDBConnection();
		}
		
		return con;
	}
	
	
	//rilasci la connessione
	public static synchronized void releaseConnection(Connection connection) {
		freeDbConnections.add(connection);
	}
	
	
}
