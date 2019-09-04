package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import Beans.Falesia;
import DBConnection.DriverManagerConnectionPool;

public class ModelFalesia {

private static final String TABLE_NAME = "Falesia";
	
	public synchronized void doSave(Falesia falesia) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + ModelFalesia.TABLE_NAME
				+ " (indice, nome, regione, immagine, descrizione, posizione) VALUES (?, ?, ?, ?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, falesia.getIndice());
			preparedStatement.setString(2, falesia.getNome());
			preparedStatement.setString(3, falesia.getRegione());
			preparedStatement.setString(4, falesia.getImmagine());
			preparedStatement.setString(5, falesia.getDescrizione());
			preparedStatement.setString(6, falesia.getPosizione());

			preparedStatement.executeUpdate();

			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
	}
	
	public synchronized boolean doDelete(int index) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + ModelFalesia.TABLE_NAME + " WHERE indice = ?";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, index);

			result = preparedStatement.executeUpdate();

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return (result != 0);
	}
	
	
	public synchronized Collection<Falesia> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Falesia> falesie = new LinkedList<Falesia>();

		String selectSQL = "SELECT * FROM " + ModelFalesia.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Falesia bean = new Falesia();

				bean.setIndice(rs.getInt("indice"));
				bean.setNome(rs.getString("nome"));
				bean.setRegione(rs.getString("regione"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setImmagine(rs.getString("immagine"));
				bean.setPosizione(rs.getString("posizione"));
				falesie.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return falesie;
	}
	public synchronized Collection<Falesia> doRetrieveAll(String order, String falesia) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Falesia> falesie = new LinkedList<Falesia>();

		String selectSQL = "SELECT * FROM " + ModelFalesia.TABLE_NAME +" WHERE regione= ?";

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}
		
		System.out.print(selectSQL);
		

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, falesia);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Falesia bean = new Falesia();

				bean.setIndice(rs.getInt("indice"));
				bean.setNome(rs.getString("nome"));
				bean.setRegione(rs.getString("regione"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setImmagine(rs.getString("immagine"));
				bean.setPosizione(rs.getString("posizione"));
				falesie.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return falesie;
	}
	
	
	public synchronized Falesia doRetrieveByKey(int code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Falesia bean = new Falesia();

		String selectSQL = "SELECT * FROM " + ModelFalesia.TABLE_NAME + " WHERE indice = ?";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, code);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setIndice(rs.getInt("indice"));
				bean.setNome(rs.getString("nome"));
				bean.setRegione(rs.getString("regione"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setImmagine(rs.getString("immagine"));
				bean.setPosizione(rs.getString("posizione"));
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return bean;
	}
	public synchronized Collection<Falesia> doRetrieveByGroup() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Falesia> falesie = new LinkedList<Falesia>();

		String selectSQL = "SELECT regione,immagine FROM " + ModelFalesia.TABLE_NAME + " GROUP BY regione,immagine";
			
			
			
		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			

			while (rs.next()) {
				Falesia bean = new Falesia();

			//	bean.setIndice(rs.getInt("indice"));
			//	bean.setNome(rs.getString("nome"));
				bean.setRegione(rs.getString("regione"));
			//	bean.setDescrizione(rs.getString("descrizione"));
				bean.setImmagine(rs.getString("immagine"));
			//bean.setPosizione(rs.getString("posizione"));
				falesie.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return falesie;
	}
	
}
