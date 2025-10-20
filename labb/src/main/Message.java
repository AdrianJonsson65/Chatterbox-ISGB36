package main;
 import java.util.*;
 
public class Message {

	private int mId;
	private String text;
	private User_login author;
	private Date date;
	
	
	public Massage(int mId,String text, User_login author, Date date) {
		setmId(mId);
		setText(text);
		setAuthor(author);
		setDate(date);
	}
	//Setters 
	public void setmId(int id) {
		if (equals(id)) {
			System.out.println("Kan inte ha samma id som ett annat meddelande");
		}else {
			this.mId = id;
		}
	}
	
	public void setText(String text) {
		if(text.length()>1000) {
			System.out.println("Texten är för lång");
		}else {
			this.text = text;
		}
	}
	
	public void setAuthor(User_Login author) {
		this.author = author;	
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String createMessage() {
		
	}
	
	public String readMassage() {
		
	}
}
