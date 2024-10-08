package Jdbc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class ConnectionFactory {
    
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/anime_store";
		String usuario = "root";
		String senha = "root";
		
		return DriverManager.getConnection(url, usuario, senha);
    }

	public static JdbcRowSet getJdbcRowSet() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/anime_store";
		String usuario = "root";
		String senha = "root";
		JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
		jdbcRowSet.setUrl(url);
		jdbcRowSet.setUsername(usuario);
		jdbcRowSet.setPassword(senha);
		return jdbcRowSet;
	}
}
