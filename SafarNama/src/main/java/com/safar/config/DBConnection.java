package com.safar.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String URL = "jdbc:derby:C:\\Users\\Lenovo\\MyDB;create=true";
    private static final String USER = "admin";
    private static final String PASSWORD = "admin";
    
    public static Connection getConnection() {
    	Connection conn = null;
    		
    	try {
    		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
    		conn =  DriverManager.getConnection(URL, USER, PASSWORD);
    	} catch(ClassNotFoundException | SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return conn;
    }
}
