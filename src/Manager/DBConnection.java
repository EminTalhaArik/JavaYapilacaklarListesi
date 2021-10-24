package Manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	Connection connection = null;
	
	public Connection connect() {
		
		try {
			this.connection = DriverManager.getConnection("jdbc:mariadb://localhost:3325/yapilacaklarlistesi?user=root&password=12345");
		
			return connection;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return connection;
	}
	
}
