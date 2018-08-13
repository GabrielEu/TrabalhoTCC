package br.com.escolatcc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private final String url = "jdbc:mysql://localhost:3306/escolatcc";
	private final String user = "root";
	private final String password = "";

	public Connection obterConexao() {
		Connection conexao = null;

		try {
			conexao = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return conexao;
	}

}
