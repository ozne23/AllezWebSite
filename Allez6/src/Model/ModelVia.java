package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import Beans.Via;
import DBConnection.DriverManagerConnectionPool;

public class ModelVia {
	
private static final String TABLE_NAME = "Via";
	
	public synchronized void doSave(Via via) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + ModelVia.TABLE_NAME
				+ " (nome, falesia, descrizione, grado, lunghezza, settore) VALUES (?, ?, ?, ?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, via.getNome());
			preparedStatement.setInt(2, via.getFalesia());
			preparedStatement.setString(3, via.getDescrizione());
			preparedStatement.setString(4, via.getGrado());
			preparedStatement.setInt(5, via.getLunghezza());
			preparedStatement.setString(6, via.getSettore());

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
	
	public synchronized boolean doDelete(String nome, int falesia) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + ModelVia.TABLE_NAME + " WHERE nome = ? AND falesia = ?";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, nome);
			preparedStatement.setInt(2,falesia);

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
	
	
	public synchronized Collection<Via> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Via> vie = new LinkedList<Via>();

		String selectSQL = "SELECT * FROM " + ModelVia.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Via bean = new Via();

				bean.setNome(rs.getString("nome"));
				bean.setFalesia(rs.getInt("falesia"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setGrado(rs.getString("grado"));
				bean.setLunghezza(rs.getInt("lunghezza"));
				bean.setSettore(rs.getString("settore"));
				vie.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return vie;
	}
	public synchronized Collection<Via> doRetrieveAll(String order, String falesia) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Via> vie = new LinkedList<Via>();

		String selectSQL = "SELECT * FROM " + ModelVia.TABLE_NAME +" WHERE falesia= ?";

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
				Via bean = new Via();

				bean.setNome(rs.getString("nome"));
				bean.setFalesia(rs.getInt("falesia"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setGrado(rs.getString("grado"));
				bean.setLunghezza(rs.getInt("lunghezza"));
				bean.setSettore(rs.getString("settore"));
				vie.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return vie;
	}
	
	public synchronized Via doRetrieveByKey(String nome, int falesia) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Via bean = new Via();

		String selectSQL = "SELECT * FROM " + ModelVia.TABLE_NAME + " WHERE nome = ? AND falesia = ?";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, nome);
			preparedStatement.setInt(2, falesia);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setNome(rs.getString("nome"));
				bean.setFalesia(rs.getInt("falesia"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setGrado(rs.getString("grado"));
				bean.setLunghezza(rs.getInt("lunghezza"));
				bean.setSettore(rs.getString("settore"));
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
	

}
