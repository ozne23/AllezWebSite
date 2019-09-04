package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Beans.CommentoFalesia;
import DBConnection.DriverManagerConnectionPool;

public class ModelCommentoFalesia {
	
private static final String TABLE_NAME = "CommentiFalesie";
	
	public synchronized void doSave(CommentoFalesia com) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + ModelCommentoFalesia.TABLE_NAME
				+ " (falesia, commento) VALUES (?, ?)";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, com.getFalesia());
			preparedStatement.setString(2, com.getCommento());

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
	
	public synchronized ArrayList<CommentoFalesia> doRetrieveByFalesia(int code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		ArrayList<CommentoFalesia> commenti = new ArrayList<CommentoFalesia>();

		CommentoFalesia bean = null;

		String selectSQL = "SELECT * FROM " + ModelCommentoFalesia.TABLE_NAME + " WHERE falesia = ?";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, code);
			
			System.out.print(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean = new CommentoFalesia();
				
				bean.setFalesia(rs.getInt("falesia"));
				bean.setCommento(rs.getString("commento"));
				
				commenti.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return commenti;
	}
	

}
