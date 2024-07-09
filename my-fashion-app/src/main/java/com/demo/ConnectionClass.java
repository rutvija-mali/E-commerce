package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {

	
	
	public static final String url = "jdbc:mysql://localhost:3306/ecommerce";
	public static final String username ="root";
	public static final String password ="root";
	
	 static {
	        // Load the MySQL JDBC driver during class initialization
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            System.err.println("Error loading MySQL JDBC Driver: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	
	public static Connection getConnctionMethod() throws SQLException
	{
		 
	    Connection con = DriverManager.getConnection(url,username,password);
	    
	    return con;
		
	}
}
