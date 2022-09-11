package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

   public class DatabaseConnect {
	
    	static private String url ="jdbc:mysql://localhost:3306/CafeIMS";
    	static private String username = "root";
    	static private String password = "jav5B3An?@";

	public static Connection getConnection() {
		
		try(Connection con = DriverManager.getConnection(url, username, password)){
			return con;
		} catch (SQLException sql) {
			sql.printStackTrace();
			return null;
		} 
		    
	}
}
