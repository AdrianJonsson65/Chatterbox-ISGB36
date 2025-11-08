package model;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class DAO {
	private Connection conn;
	public DAO() {}
	public Connection getConnection() {
		// Change the path the database (.db) file on your machine...
		// Just by changing the URL you point to another database
		
		String dbURL = "jdbc:sqlite:C:/Users/adria/OneDrive/Dokument/Uni/ISGB36/Chatterbox-ISGB36/Chatterbox-ISGB36/labb/CaseStudy.db";
		try {
		conn = DriverManager.getConnection(dbURL);
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return conn;
	}
	
	public ArrayList<User_Login> getAllUsers() throws SQLException {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String querySQL = "SELECT * FROM User;";
		ResultSet rs = stmt.executeQuery(querySQL);
		ArrayList<User_Login> users = new ArrayList<>();
		while (rs.next()) {
		
		String name = rs.getString("name");
		String password = rs.getString("password");
		String username = rs.getString("username");
		String role = rs.getString("role");
		
		users.add(new User_Login(name, username, password, role));
		}
		
		stmt.close();
		rs.close();
		conn.close();
		return users;
		}
	
	public ArrayList<Message> getAllMessages() throws SQLException {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String sql = """
			    SELECT m.messageId, m.text, m.date,
			           u.userId, u."name", u.username, u.password, u.role
			    FROM Message m
			    JOIN "User" u ON m."user" = u.username
			    ORDER BY m.messageId
			""";
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList<Message> messages = new ArrayList<>();
		while (rs.next()) {
		
		int id = rs.getInt("messageId");
		String text = rs.getString("text");
		Date date = rs.getDate("date");
		User_Login user = new User_Login(
			rs.getString("name"),
			rs.getString("username"),
			rs.getString("password"),
			rs.getString("role")
		);
		
		messages.add(new Message(id, text, user, date));
		}
		
		stmt.close();
		rs.close();
		conn.close();
		return messages;
		}
	
	public ArrayList<Message> getAllMessagesByUser(User_Login ul) throws SQLException {
	    String sql = """
	        SELECT m.messageId, m.text, m.date,
	               u.userId, u."name", u.username, u.password, u.role
	        FROM Message m
	        JOIN "User" u ON m."user" = u.username
	        WHERE u.username = ?
	        ORDER BY m.messageId
	    """;

	    ArrayList<Message> messages = new ArrayList<>();

	    try (Connection conn = getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        
	        ps.setString(1, ul.getUsername());

	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                User_Login user = new User_Login(
	                    rs.getString("name"),
	                    rs.getString("username"),
	                    rs.getString("password"),
	                    rs.getString("role")
	                );

	                String dateStr = rs.getString("date"); // lagrad som TEXT i DB
	                // om Message tar en String för datum:
	                Message msg = new Message(
	                    rs.getInt("messageId"),
	                    rs.getString("text"),
	                    user,
	                    rs.getString("date")
	                );

	                messages.add(msg);
	            }
	        }
	    }

	    return messages;
	}

	
	public int addNewMessage(String text, String date, User_Login ul) throws SQLException {
	    try (Connection conn = getConnection()) {
	        try (Statement pragma = conn.createStatement()) {
	            pragma.execute("PRAGMA foreign_keys = ON");
	        }
	        String sql = "INSERT INTO Message (text, date, \"user\") VALUES (?, ?, ?)";
	        try (PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setString(1, text);
	            ps.setString(2, date);                 
	            ps.setString(3, ul.getUsername());     
	            return ps.executeUpdate();
	        }
	    }
	}
	
	//Delete message function till databasen
	public int deleteMessage(String mId) throws SQLException {
		Connection conn = getConnection();
		String deleteSQL = "DELETE FROM Message WHERE messageId=?;";
		PreparedStatement pstmt = conn.prepareStatement(deleteSQL);
		pstmt.setString(1, mId);
		int deleteStatus = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return deleteStatus;
	}
	 

	
	
	
	

}
