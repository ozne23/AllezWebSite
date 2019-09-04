package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Beans.CommentoProdotto;
import DBConnection.DriverManagerConnectionPool;

public class ModelCommentoProdotto {
	
private static final String TABLE_NAME = "CommentiProdotto";
	
	public synchronized void doSave(CommentoProdotto com) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + ModelCommentoProdotto.TABLE_NAME
				+ " (prodotto, commento) VALUES (?, ?)";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, com.getProdotto());
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
	
	public synchronized ArrayList<CommentoProdotto> doRetrieveByProdotto(int code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		ArrayList<CommentoProdotto> commenti = new ArrayList<CommentoProdotto>();

		CommentoProdotto bean = null;

		String selectSQL = "SELECT * FROM " + ModelCommentoProdotto.TABLE_NAME + " WHERE prodotto = ?";

		try {
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, code);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean = new CommentoProdotto();
				
				bean.setProdotto(rs.getInt("prodotto"));
				bean.setCommento(rs.getString("commento"));
				
				System.out.println(bean.getCommento());
				
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
