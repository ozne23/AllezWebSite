package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import Beans.Utente;
import DBConnection.DriverManagerConnectionPool;

public class ModelUtente {
	
private static final String TABLE_NAME = "Utente";
	
	public synchronized void doSave(Utente utente) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + ModelUtente.TABLE_NAME
				+ " (username, password, tipo, telefono, sesso, nome, cognome, dataNascita, cap, provincia, via, citta, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, utente.getUsername());
			preparedStatement.setString(2, utente.getPassword());
			preparedStatement.setInt(3, utente.getTipo());
			preparedStatement.setString(4, utente.getTelefono());
			preparedStatement.setString(5, utente.getSesso());
			preparedStatement.setString(6, utente.getNome());
			preparedStatement.setString(7, utente.getCognome());
			preparedStatement.setString(8, utente.getDataNascita());
			preparedStatement.setInt(9, utente.getCap());
			preparedStatement.setString(10, utente.getProvincia());
			preparedStatement.setString(11, utente.getVia());
			preparedStatement.setString(12, utente.getCittà());
			preparedStatement.setString(13, utente.getEmail());

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
	
	public synchronized boolean doDelete(String username) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + ModelUtente.TABLE_NAME + " WHERE username = ? ";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, username);

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
	
	
	public synchronized Collection<Utente> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Utente> utenti = new LinkedList<Utente>();

		String selectSQL = "SELECT * FROM " + ModelUtente.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Utente bean = new Utente();

				bean.setUsername(rs.getString("username"));
				bean.setPassword(rs.getString("password"));
				bean.setTipo(rs.getInt("tipo"));
				bean.setTelefono(rs.getString("telefono"));
				bean.setSesso(rs.getString("sesso"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setDataNascita(rs.getString("dataNascita"));
				bean.setCap(rs.getInt("cap"));
				bean.setProvincia(rs.getString("provincia"));
				bean.setVia(rs.getString("via"));
				bean.setCittà(rs.getString("citta"));
				bean.setEmail(rs.getString("email"));
				
				utenti.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return utenti;
	}
	
	
	public synchronized Utente doRetrieveByKey(String username) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Utente bean = new Utente();

		String selectSQL = "SELECT * FROM " + ModelUtente.TABLE_NAME + " WHERE username = ?";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, username);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setUsername(rs.getString("username"));
				bean.setPassword(rs.getString("password"));
				bean.setTipo(rs.getInt("tipo"));
				bean.setTelefono(rs.getString("telefono"));
				bean.setSesso(rs.getString("sesso"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setDataNascita(rs.getString("dataNascita"));
				bean.setCap(rs.getInt("cap"));
				bean.setProvincia(rs.getString("provincia"));
				bean.setVia(rs.getString("via"));
				bean.setCittà(rs.getString("citta"));
				bean.setEmail(rs.getString("email"));
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

	
	public synchronized Collection<Utente> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Utente> utenti = new LinkedList<Utente>();

		String selectSQL = "SELECT * FROM " + ModelUtente.TABLE_NAME;

		

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Utente bean = new Utente();

				bean.setUsername(rs.getString("username"));
				bean.setPassword(rs.getString("password"));
				bean.setTipo(rs.getInt("tipo"));
				bean.setTelefono(rs.getString("telefono"));
				bean.setSesso(rs.getString("sesso"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setDataNascita(rs.getString("dataNascita"));
				bean.setCap(rs.getInt("cap"));
				bean.setProvincia(rs.getString("provincia"));
				bean.setVia(rs.getString("via"));
				bean.setCittà(rs.getString("citta"));
				bean.setEmail(rs.getString("email"));
				
				utenti.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return utenti;
	}

}
