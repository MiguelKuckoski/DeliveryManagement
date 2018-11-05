package persistencia.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	public static Connection getConnection() {
		Connection con= null;
		String url = "jdbc:postgresql://127.0.0.1:5432/transportadora_entrega_rapida";
		String user = "postgres";
		String password = "admin";
		
		try {
			Class.forName("org.postgresql.driver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return con;
		
	}
}
