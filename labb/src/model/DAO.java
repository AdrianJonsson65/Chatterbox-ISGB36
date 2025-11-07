package model;

import java.sql.*;
import java.util.*;

public class DAO {
	private Connection conn;
	
	public Connection getConnection() {
		// Change the path the database (.db) file on your machine...
		// Just by changing the URL you point to another database
		
		String dbURL = "jdbc:sqlite:C:\\Users\\adria\\OneDrive\\Dokument\\Uni\\ISGB36\\Chatterbox-ISGB36\\Chatterbox-ISGB36\\labb";
		try {
		conn = DriverManager.getConnection(dbURL);
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return conn;
	}

}
