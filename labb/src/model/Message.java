package model;
 import java.sql.SQLException;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
 
public class Message {

	private int mId;
	private String text;
	private User_Login author;
	private Date date;
	//User_Login user;
	
	//Constructors
	public Message(int mId,String text, User_Login author, Date date) {
		setmId(mId);
		setText(text);
		setAuthor(author);
		setDate(date);
	}
	
	public Message(int mId, String text, User_Login author, String date)  {
		setmId(mId);
		setText(text);
		setAuthor(author);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
        	Date dateToDate = sdf.parse(date);
        	setDate(dateToDate);
        }catch(ParseException e) {
        	e.printStackTrace();
        }
		
		
	}
	public Message(String text) {
		this.text = text;
	}
	
	public Message(int mId, String text, Date date) {
		this.mId = mId;
		this.text = text;
		this.date = date;
	}
	
	public Message() {}
	
	//Setters 
	public void setmId(int id) {
		this.mId = id;
	}
	
	public void setText(String text) {
		if(text.length()>1000) {
			System.out.println("Texten är för lång");
		}else {
			this.text = text;
		}
	}
	
	public void setAuthor(User_Login obj) {
		this.author = obj;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	// Getters
	public User_Login getAuthor() {
		return this.author;
	}
	
	public int getMId() {
		return this.mId;
	}
	
	public String getText() {
		return this.text;
	}
	
	public String getDate() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = sdf.format(date);
		return dateString;
	}
	
	public ArrayList<Message> getAllMessages() throws SQLException {
		DAO dao = new DAO();
		ArrayList<Message> messages = dao.getAllMessages();
		return messages;
	}
	
	//Functions
	public void createMessage(String text, User_Login obj, ArrayList<Message> messages) throws SQLException {
		this.text = text;
		this.mId = messages.size() + 1;
		this.author = obj;
		this.date = new Date();
		DAO dao = new DAO();
		String date = getDate();
		dao.addNewMessage(text, date, obj);
		
	}
	
	public ArrayList<Message> addMessage(String text, User_Login user) throws SQLException {
		DAO dao = new DAO();
		ArrayList<Message> messages =  dao.getAllMessages();
		Message newMsg = new Message();
		newMsg.createMessage(text, user, messages);
		messages.add(newMsg);
		
		System.out.println("Message added!");
		return messages;
	}
	
	
	// Behöver fixas, man kommer inte in i if satsen utan else körs varje gång
	public ArrayList<Message> deleteMessage(String mId, User_Login obj) throws SQLException {
		DAO dao = new DAO();
		ArrayList<Message> messages = dao.getAllMessages();
		int id = Integer.parseInt(mId);
		id -= 1;
		User_Login author = messages.get(id).getAuthor();
		if (author.equals(obj)) {
			messages.remove(id);
			System.out.println("Message deleted!");
		}else {
			System.out.println("You can only delete your own posts");
		}
		
		return messages;
	}
	
	/*
	public static Message[] messages = {
		new Message(1,"Hej det är ett test", new Date()),
		new Message(2,"Test 2", new Date()),
		new Message(3,"Test 3", new Date())
	};*/
	
	
	@Override
	public String toString() {
		return this.mId + "\n Published by: " + this.author + "\n " + this.text + "\n " + this.date + "; \n";
	}
	
	@Override
	public boolean equals(Object obj) {
		User_Login user = (User_Login) obj;
		return (this.author.getName() == user.getName());
	}
}
