package com.br.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	/* MySQL Connection */
	private String driver1 = "com.mysql.cj.jdbc.Driver";
	private String url1 = "jdbc:mysql://localhost:3306/torneios";
	private String user1 = "root";
	private String password1 = "password";
	
	/* Postgresql Connection */
	private String driver2 = "org.postgresql.Driver";
	private String url2 = "jdbc:postgresql://localhost:5432/torneios";
	private String user2 = "postgres";
	private String password2 = "12345";
	
	
	public Connection getConnection() {
		
		Connection conn = null;
		
		// Trying to connect mySQL
		try {
			Class.forName(driver1);
			conn = DriverManager.getConnection(url1,user1,password1);
			return conn;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		// Trying to connect postgresql
		try {
			Class.forName(driver2);
			conn = DriverManager.getConnection(url2,user2,password2);
			return conn;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}
}
