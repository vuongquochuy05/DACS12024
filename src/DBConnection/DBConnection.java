package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection c = null;

	public static void main(String[] args) {

	}

	public static Connection getConnection() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://DESKTOP-12J6D6C\\SQLEXPRESS;databaseName=DACS1;"
					+ "portNumber=1433;encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
			String username = "sa";
			String password = "123";
			c = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return c;
	}
	public static void closeConnection(Connection c) {
		try {
			if (c != null) {
				c.close();
				;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
