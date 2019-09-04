package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import Beans.Item;
import DBConnection.DriverManagerConnectionPool;

public class ModelItem {
	
private static final String TABLE_NAME = "Item";
	
	public synchronized void doSave(Item item) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + ModelItem.TABLE_NAME
				+ " (taglia, colore, prodotto, sconto, disponibilita, prezzo, immagine) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, item.getTaglia());
			preparedStatement.setString(2, item.getColore());
			preparedStatement.setInt(3, item.getProdotto());
			preparedStatement.setInt(4, item.getSconto());
			preparedStatement.setInt(5, item.getDisponibilità());
			preparedStatement.setDouble(6, item.getPrezzo());
			preparedStatement.setString(7, item.getImmagine());

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
	
	public synchronized boolean doDelete(String taglia, String colore, int prodotto) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + ModelItem.TABLE_NAME + " WHERE taglia = ? AND colore = ? AND prodotto = ?";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, taglia);
			preparedStatement.setString(2, colore);
			preparedStatement.setInt(3, prodotto);

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
	
	
	public synchronized Collection<Item> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Item> items = new LinkedList<Item>();

		String selectSQL = "SELECT * FROM " + ModelItem.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Item bean = new Item();

				bean.setTaglia(rs.getString("taglia"));
				bean.setColore(rs.getString("colore"));
				bean.setProdotto(rs.getInt("prodotto"));
				bean.setSconto(rs.getInt("sconto"));
				bean.setDisponibilità(rs.getInt("disponibilita"));
				bean.setPrezzo(rs.getDouble("prezzo"));
				bean.setImmagine(rs.getString("immagine"));
				items.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return items;
	}
	
	
	public synchronized Item doRetrieveByKey(String taglia, String colore, int prodotto) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Item bean = new Item();

		String selectSQL = "SELECT * FROM " + ModelItem.TABLE_NAME + " WHERE taglia = ? AND colore = ? AND prodotto = ?";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, taglia);
			preparedStatement.setString(2, colore);
			preparedStatement.setInt(3, prodotto);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setTaglia(rs.getString("taglia"));
				bean.setColore(rs.getString("colore"));
				bean.setProdotto(rs.getInt("prodotto"));
				bean.setSconto(rs.getInt("sconto"));
				bean.setDisponibilità(rs.getInt("disponibilita"));
				bean.setPrezzo(rs.getDouble("prezzo"));
				bean.setImmagine(rs.getString("immagine"));
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
	public synchronized void doMod(Item item) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "UPDATE " + ModelItem.TABLE_NAME +
				" SET sconto = ? , disponibilita = ?, prezzo = ?"
				+ " WHERE  taglia = ? and  colore = ? and  prodotto = ?";
			
			
		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, item.getSconto());
			preparedStatement.setInt(2, item.getDisponibilità());
			preparedStatement.setDouble(3, item.getPrezzo());
			preparedStatement.setString(4, item.getTaglia());
			preparedStatement.setString(5, item.getColore());
			preparedStatement.setInt(6, item.getProdotto());
			
			
			System.out.println("Prepared Statement after bind variables set:\n\t" + preparedStatement.toString());
			System.out.println("prima update");
			preparedStatement.executeUpdate();
			System.out.println("dopoupdate");
			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					System.out.println("fallisce");
					preparedStatement.close();
			} finally {
				System.out.println("fallisce");
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
	}
	
	
	public synchronized ArrayList<Item> doRetrieveByProd(int prodotto) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

	
		
		ArrayList<Item> items = new ArrayList<>();
		String selectSQL = "SELECT * FROM " + ModelItem.TABLE_NAME + " WHERE  prodotto = ?";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, prodotto);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Item bean = new Item();
				bean.setTaglia(rs.getString("taglia"));
				bean.setColore(rs.getString("colore"));
				bean.setProdotto(rs.getInt("prodotto"));
				bean.setSconto(rs.getInt("sconto"));
				bean.setDisponibilità(rs.getInt("disponibilita"));
				bean.setPrezzo(rs.getDouble("prezzo"));
				bean.setImmagine(rs.getString("immagine"));
				items.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return items;
	}
	
	public synchronized void doModDisponibilita(Item item, int disp) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "UPDATE " + ModelItem.TABLE_NAME +
				" SET  disponibilita = ?"
				+ " WHERE  taglia = ? and  colore = ? and  prodotto = ?";
			
			
		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, disp);
			preparedStatement.setString(2, item.getTaglia());
			preparedStatement.setString(3, item.getColore());
			preparedStatement.setInt(4, item.getProdotto());
			
			
			System.out.println("Prepared Statement after bind variables set:\n\t" + preparedStatement.toString());
			System.out.println("prima update");
			preparedStatement.executeUpdate();
			System.out.println("dopoupdate");
			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					System.out.println("fallisce");
					preparedStatement.close();
			} finally {
				System.out.println("fallisce");
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
	}

}
