package model;
 import java.util.*;
 
public class Message {

	private int mId;
	private String text;
	private User_Login author;
	private Date date;
	
	//Constructors
	public Message(int mId,String text, User_Login author, Date date) {
		setmId(mId);
		setText(text);
		setAuthor(author);
		setDate(date);
	}
	
	public Message(String text) {
		this.text = text;
	}
	
	
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
	
	public void setAuthor(Object obj) {
		User_Login u = (User_Login) obj;
		this.author.setName(u.getName());
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	// Getters
	public String getAuthor() {
		return this.author.getName();
	}
	public void createMessage(String text, User_Login obj, Message [] messages) {
		this.text = text;
		this.mId = messages.length;
		this.author.setName(obj.getName());
		this.date = new Date();
		
	}
	
	public Message [] addMessage(String text, Message [] messages, User_Login user) {
		messages = Arrays.copyOf(messages, messages.length + 1);
		messages[messages.length - 1].createMessage(text, user, messages);
		return messages;
	}
	
	
	
	@Override
	public String toString() {
		return "" + this.text + " \n";
	}
	
	@Override
	public boolean equals(Object obj) {
		User_Login user = (User_Login) obj;
		return (this.author.getName() == user.getName());
	}
}
