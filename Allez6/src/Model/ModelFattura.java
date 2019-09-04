package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import Beans.Fattura;
import DBConnection.DriverManagerConnectionPool;

public class ModelFattura {
	
private static final String TABLE_NAME = "Fattura";
private static final int iva = 22;
private static final String piva = "06575921215";
private static final String causale = "Acquista presso il negozio Allez";
	
	public synchronized void doSave(Fattura fattura) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + ModelFattura.TABLE_NAME
				+ " (data, ora, iva, pIva, totale, utente, causale) VALUES (CURDATE(), CURTIME(), ?, ?, ?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, iva);
			preparedStatement.setString(2, piva);
			preparedStatement.setDouble(3, fattura.getTotale());
			preparedStatement.setString(4, fattura.getUtente());
			preparedStatement.setString(5, causale);

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
	
	public synchronized boolean doDelete(int id, String utente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + ModelFattura.TABLE_NAME + " WHERE ID = ? AND utente = ? ";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, utente);

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
	
	
	public synchronized Collection<Fattura> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Fattura> fatture = new LinkedList<Fattura>();

		String selectSQL = "SELECT * FROM " + ModelFattura.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Fattura bean = new Fattura();

				bean.setID(rs.getInt("ID"));
				bean.setData(rs.getString("data"));
				bean.setOra(rs.getString("ora"));
				bean.setIva(rs.getInt("iva"));
				bean.setpIva(rs.getString("pIva"));
				bean.setTotale(rs.getDouble("totale"));
				bean.setUtente(rs.getString("utente"));
				bean.setCausale(rs.getString("causale"));
				
				fatture.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return fatture;
	}
	public synchronized Collection<Fattura> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Fattura> fatture = new LinkedList<Fattura>();

		String selectSQL = "SELECT * FROM " + ModelFattura.TABLE_NAME;

	

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Fattura bean = new Fattura();

				bean.setID(rs.getInt("ID"));
				bean.setData(rs.getString("data"));
				bean.setOra(rs.getString("ora"));
				bean.setIva(rs.getInt("iva"));
				bean.setpIva(rs.getString("pIva"));
				bean.setTotale(rs.getDouble("totale"));
				bean.setUtente(rs.getString("utente"));
				bean.setCausale(rs.getString("causale"));
				
				fatture.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return fatture;
	}
	
	
	public synchronized Fattura doRetrieveByKey(int id, String utente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Fattura bean = new Fattura();

		String selectSQL = "SELECT * FROM " + ModelFattura.TABLE_NAME + " WHERE ID = ? AND utente = ?  ";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, utente);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setID(rs.getInt("ID"));
				bean.setData(rs.getString("data"));
				bean.setOra(rs.getString("ora"));
				bean.setIva(rs.getInt("iva"));
				bean.setpIva(rs.getString("pIva"));
				bean.setTotale(rs.getDouble("totale"));
				bean.setUtente(rs.getString("utente"));
				bean.setCausale(rs.getString("causale"));
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
	public synchronized Collection<Fattura> doRetrieveByDate(String start, String end) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Fattura bean = new Fattura();
		Collection<Fattura> fatture = new LinkedList<Fattura>();

		String selectSQL = "SELECT * FROM " + ModelFattura.TABLE_NAME + " WHERE data >= ? AND data <= ?  ";
				//SELECT * FROM table WHERE date_column >= '2014-01-01' AND date_column <= '2015-01-01';
		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, start);
			preparedStatement.setString(2, end);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				 bean = new Fattura();
				bean.setID(rs.getInt("ID"));
				bean.setData(rs.getString("data"));
				bean.setOra(rs.getString("ora"));
				bean.setIva(rs.getInt("iva"));
				bean.setpIva(rs.getString("pIva"));
				bean.setTotale(rs.getDouble("totale"));
				bean.setUtente(rs.getString("utente"));
				bean.setCausale(rs.getString("causale"));
				
				
				fatture.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return fatture;
	}
	
	public synchronized Fattura ultimaFatturaUtente(String utente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Fattura bean = new Fattura();

		String selectSQL = "SELECT * FROM " + ModelFattura.TABLE_NAME + " WHERE  utente = ?  ORDER BY ID DESC";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, utente);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setID(rs.getInt("ID"));
				bean.setData(rs.getString("data"));
				bean.setOra(rs.getString("ora"));
				bean.setIva(rs.getInt("iva"));
				bean.setpIva(rs.getString("pIva"));
				bean.setTotale(rs.getDouble("totale"));
				bean.setUtente(rs.getString("utente"));
				bean.setCausale(rs.getString("causale"));
				break;
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
	
	public synchronized ArrayList<Fattura> FattureUtente(String utente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Fattura> fatture = new ArrayList<Fattura>();
		
		Fattura bean = null;

		String selectSQL = "SELECT * FROM " + ModelFattura.TABLE_NAME + " WHERE  utente = ?  ORDER BY ID DESC";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, utente);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean = new Fattura();
				
				bean.setID(rs.getInt("ID"));
				bean.setData(rs.getString("data"));
				bean.setOra(rs.getString("ora"));
				bean.setIva(rs.getInt("iva"));
				bean.setpIva(rs.getString("pIva"));
				bean.setTotale(rs.getDouble("totale"));
				bean.setUtente(rs.getString("utente"));
				bean.setCausale(rs.getString("causale"));
				fatture.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return fatture;
	}
	
}
