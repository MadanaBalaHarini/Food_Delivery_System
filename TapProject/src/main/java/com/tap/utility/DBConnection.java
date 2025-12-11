package com.tap.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String URL="jdbc:mysql://localhost:3306/tapfoods";
	private static final String USERNAME="root";
	private static final String PASSWORD="Bala@2025";
	private static Connection connection=null;
	
	public final static Connection getConnection(){
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
