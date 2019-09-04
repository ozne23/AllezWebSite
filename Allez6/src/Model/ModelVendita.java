package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import Beans.Vendita;
import DBConnection.DriverManagerConnectionPool;

public class ModelVendita {
	
private static final String TABLE_NAME = "Vendita";
	
	public synchronized void doSave(Vendita vendita) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + ModelVendita.TABLE_NAME
				+ " (prezzoVendita, iva, quantita, prodotto, fattura, taglia, colore) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setDouble(1, vendita.getPrezzoVendita());
			preparedStatement.setInt(2, vendita.getIva());
			preparedStatement.setInt(3, vendita.getQuantità());
			preparedStatement.setInt(4, vendita.getProdotto());
			preparedStatement.setInt(5, vendita.getFattura());
			preparedStatement.setString(6, vendita.getTaglia());
			preparedStatement.setString(7, vendita.getColore());

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
	
	public synchronized boolean doDelete(int prodotto, int fattura, String taglia, String colore) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + ModelVendita.TABLE_NAME + " WHERE prodotto = ? AND fattura = ? AND taglia = ? AND colore = ?";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, prodotto);
			preparedStatement.setInt(2, fattura);
			preparedStatement.setString(3, taglia);
			preparedStatement.setString(4, colore);

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
	
	
	public synchronized Collection<Vendita> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Vendita> vendite = new LinkedList<Vendita>();

		String selectSQL = "SELECT * FROM " + ModelVendita.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Vendita bean = new Vendita();

				bean.setPrezzoVendita(rs.getDouble("prezzoVendita"));
				bean.setIva(rs.getInt("iva"));
				bean.setQuantità(rs.getInt("quantita"));
				bean.setProdotto(rs.getInt("prodotto"));
				bean.setFattura(rs.getInt("fattura"));
				bean.setTaglia(rs.getString("taglia"));
				bean.setColore(rs.getString("colore"));
				
				vendite.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return vendite;
	}
	
	public synchronized Collection<Vendita> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Vendita> vendite = new LinkedList<Vendita>();

		String selectSQL = "SELECT * FROM " + ModelVendita.TABLE_NAME;

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Vendita bean = new Vendita();

				bean.setPrezzoVendita(rs.getDouble("prezzoVendita"));
				bean.setIva(rs.getInt("iva"));
				bean.setQuantità(rs.getInt("quantita"));
				bean.setProdotto(rs.getInt("prodotto"));
				bean.setFattura(rs.getInt("fattura"));
				bean.setTaglia(rs.getString("taglia"));
				bean.setColore(rs.getString("colore"));
				
				vendite.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return vendite;
	}
	public synchronized Vendita doRetrieveByKey(int prodotto, int fattura, String taglia, String colore) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Vendita bean = new Vendita();

		String selectSQL = "SELECT * FROM " + ModelVendita.TABLE_NAME + " WHERE prodotto = ? AND fattura = ? AND taglia = ? AND colore = ?";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, prodotto);
			preparedStatement.setInt(2, fattura);
			preparedStatement.setString(3, taglia);
			preparedStatement.setString(4, colore);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setPrezzoVendita(rs.getDouble("prezzoVendita"));
				bean.setIva(rs.getInt("iva"));
				bean.setQuantità(rs.getInt("quantita"));
				bean.setProdotto(rs.getInt("prodotto"));
				bean.setFattura(rs.getInt("fattura"));
				bean.setTaglia(rs.getString("taglia"));
				bean.setColore(rs.getString("colore"));
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
	
	public synchronized ArrayList<Vendita> doRetrieveByFattura( int fattura) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Vendita> vendite = new ArrayList<Vendita>();
		
		Vendita bean = null;
		

		String selectSQL = "SELECT * FROM " + ModelVendita.TABLE_NAME + " WHERE  fattura = ?";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, fattura);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean = new Vendita();
				
				bean.setPrezzoVendita(rs.getDouble("prezzoVendita"));
				bean.setIva(rs.getInt("iva"));
				bean.setQuantità(rs.getInt("quantita"));
				bean.setProdotto(rs.getInt("prodotto"));
				bean.setFattura(rs.getInt("fattura"));
				bean.setTaglia(rs.getString("taglia"));
				bean.setColore(rs.getString("colore"));
				vendite.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return vendite;
	}

}
