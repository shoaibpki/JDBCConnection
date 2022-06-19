package com.simplilear.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private String url = "jdbc:mysql://localhost:3306/phase2";
	private String userId = "root";
	private String password = "root";
	private Connection connection;
	
	public DBConnection() {
		
		try {
			// step 1: Register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step 2: Get connection Object
			this.connection = DriverManager.getConnection(url, userId, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("connection not estebished");
		}
	}
	
	public Connection getConnection() {
		return this.connection;
	}
}
