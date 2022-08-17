package commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getConnection() throws Exception, SQLException {
		Class.forName("org.mariadb.jdbc.Driver");
		String url = "jdbc:mariadb://localhost:3306/test";
		String dbuser = "root";
		String dbpw = "1234";
		Connection conn = DriverManager.getConnection(url, dbuser, dbpw);
		return conn;
	}
}
