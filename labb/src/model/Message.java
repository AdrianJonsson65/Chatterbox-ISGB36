package model;
 import java.util.*;
 
public class Message {

	private int mId;
	private String text;
	private String author;
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
	
	public void setAuthor(User_Login obj) {
		this.author = obj.getName();	
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	/*public String createMessage() {
		
	}
	
	public String readMassage() {
		
	}*/
}
