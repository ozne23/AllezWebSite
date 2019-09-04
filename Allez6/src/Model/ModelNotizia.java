
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import Beans.Notizia;
import Beans.Prodotto;
import DBConnection.DriverManagerConnectionPool;

public class ModelNotizia {
	
private static final String TABLE_NAME = "Notizie";
	
	public synchronized void doSave(Notizia notizia) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + ModelNotizia.TABLE_NAME
				+ " (titolo, notizia,immagine) VALUES (?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, notizia.getTitolo());
			preparedStatement.setString(2, notizia.getNotizia());
			preparedStatement.setString(3, notizia.getImmagine());

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
	
	public synchronized Collection<Notizia> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Notizia> notizie = new LinkedList<Notizia>();

		String selectSQL = "SELECT * FROM " + ModelNotizia.TABLE_NAME;


		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Notizia bean = new Notizia();

				bean.setTitolo(rs.getString("titolo"));
				bean.setNotizia(rs.getString("notizia"));
				bean.setImmagine(rs.getString("immagine"));
			
				notizie.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return notizie;
	}
	
	public synchronized Notizia doRetrieveByKey(String titolo) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Notizia bean = new Notizia();

		String selectSQL = "SELECT * FROM " + ModelNotizia.TABLE_NAME +" Where titolo = ?";


		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, titolo);
			
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				

				bean.setTitolo(rs.getString("titolo"));
				bean.setNotizia(rs.getString("notizia"));
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
	

}
