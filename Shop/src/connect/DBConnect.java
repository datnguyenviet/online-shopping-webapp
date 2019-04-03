package connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?useTimezone=true&serverTimezone=UTC", "root", "intheend123");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
}
}
