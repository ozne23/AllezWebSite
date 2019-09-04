package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import Beans.Prodotto;
import DBConnection.DriverManagerConnectionPool;

public class ModelProdotto {
	
	private static final String TABLE_NAME = "Prodotto";
	
	public synchronized void doSave(Prodotto product) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + ModelProdotto.TABLE_NAME
				+ " (nome, marca, immagine, descrizione,categoria,cancellato) VALUES (?, ?, ?,?,?,?)";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, product.getNome());
			preparedStatement.setString(2, product.getMarca());
			preparedStatement.setString(3, product.getImmagine());
			preparedStatement.setString(4, product.getDescrizione());
			preparedStatement.setString(5, product.getCategoria());
			preparedStatement.setInt(6, product.isCancellato());

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
	
	public synchronized boolean doDelete(int code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + ModelProdotto.TABLE_NAME + " WHERE codice=?";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, code);
			System.out.println(preparedStatement);

			result = preparedStatement.executeUpdate();

			connection.commit();
		} catch(Exception e) {
			e.printStackTrace();
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return (result != 0);
	}
	
	
	public synchronized Collection<Prodotto> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Prodotto> products = new ArrayList<Prodotto>();

		String selectSQL = "SELECT * FROM " + ModelProdotto.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Prodotto bean = new Prodotto();

				bean.setCodice(rs.getInt("codice"));
				bean.setNome(rs.getString("nome"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setMarca(rs.getString("marca"));
				bean.setImmagine(rs.getString("immagine"));
				bean.setCancellato(rs.getInt("cancellato"));
				products.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return products;
	}
	
	public synchronized Collection<Prodotto> doRetrieveAll(String order, String categoria) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Prodotto> products = new ArrayList<Prodotto>();

		String selectSQL = "SELECT * FROM " + ModelProdotto.TABLE_NAME +" WHERE categoria= ?";

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}
		
		System.out.print(selectSQL);
		

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, categoria);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Prodotto bean = new Prodotto();

				bean.setCodice(rs.getInt("codice"));
				bean.setNome(rs.getString("nome"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setMarca(rs.getString("marca"));
				bean.setImmagine(rs.getString("immagine"));
				bean.setCancellato(rs.getInt("cancellato"));
				products.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return products;
	}
	
	
	public synchronized Prodotto doRetrieveByKey(int code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Prodotto bean = new Prodotto();

		String selectSQL = "SELECT * FROM " + ModelProdotto.TABLE_NAME + " WHERE codice = ?";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, code);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setCodice(rs.getInt("codice"));
				bean.setNome(rs.getString("nome"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setMarca(rs.getString("marca"));
				bean.setImmagine(rs.getString("immagine"));
				bean.setCancellato(rs.getInt("cancellato"));
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
	
	public synchronized Collection<Prodotto> doRetrieveByName(String name) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Prodotto> products = new ArrayList<Prodotto>();
		
		String selectSQL = "SELECT * FROM " + ModelProdotto.TABLE_NAME + " WHERE nome = ?";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, name);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Prodotto bean = new Prodotto();
				
				bean.setCodice(rs.getInt("codice"));
				bean.setNome(rs.getString("nome"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setMarca(rs.getString("marca"));
				bean.setImmagine(rs.getString("immagine"));
				bean.setCancellato(rs.getInt("cancellato"));
				products.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return products;
	}
	
	public synchronized ArrayList<Prodotto> doRetrieveByMarca(String marca) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Prodotto> products = new ArrayList<Prodotto>();
		
		String selectSQL = "SELECT * FROM " + ModelProdotto.TABLE_NAME + " WHERE marca = ?";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, marca);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Prodotto bean = new Prodotto();
				
				bean.setCodice(rs.getInt("codice"));
				bean.setNome(rs.getString("nome"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setMarca(rs.getString("marca"));
				bean.setImmagine(rs.getString("immagine"));
				bean.setCancellato(rs.getInt("cancellato"));
				products.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return products;
	}
	
	public synchronized void doMod(Prodotto product) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "UPDATE " + ModelProdotto.TABLE_NAME +
				" SET nome = ?, marca = ?,immagine = ?, descrizione = ? , categoria = ? "
				+ " WHERE codice = ?";
			
			System.out.println("prima del try");
		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, product.getNome());
			preparedStatement.setString(2, product.getMarca());
			preparedStatement.setString(3, product.getImmagine());
			preparedStatement.setString(4, product.getDescrizione());
			preparedStatement.setString(5, product.getCategoria());
			preparedStatement.setInt(6, product.getCodice());
			
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
	
	
	public synchronized Collection<Prodotto> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Prodotto> products = new LinkedList<Prodotto>();

		String selectSQL = "SELECT * FROM " + ModelProdotto.TABLE_NAME;

		

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Prodotto bean = new Prodotto();

				bean.setCodice(rs.getInt("codice"));
				bean.setNome(rs.getString("nome"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setMarca(rs.getString("marca"));
				bean.setImmagine(rs.getString("immagine"));
				bean.setCancellato(rs.getInt("cancellato"));
				products.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return products;
	}
	
	public synchronized void Cancella(int codice) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "UPDATE " + ModelProdotto.TABLE_NAME +
				" SET cancellato = 1 "
				+ " WHERE codice = ?";
			
			System.out.println("prima del try");
		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, codice);
			
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
