package com.majorbit.springboot_due.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	
	public static Connection getConnection() throws SQLException {

 		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		
			String connectionUrl = "jdbc:mysql://127.0.0.1:3306/databasetest?user=root&password=1234";
	
			Connection db = DriverManager.getConnection(connectionUrl);
			System.out.println("Connessi al db \n");
		return db;
		} catch (ClassNotFoundException e) {
			System.out.println("Errore caricamento Driver");
			e.printStackTrace();
			return null;
		} 
	}

}
