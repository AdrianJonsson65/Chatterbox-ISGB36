package model;

import java.math.*;
import java.util.*;

public class User_Login {

	private String name;
	private String username;
	private String password;
	private String role;
	private Message[] messages;
	
	public User_Login(String name, String username, String password, String role) {
		//setName(name);
		this.name = name;
		//setUsername();
		this.username = username;
		//setPassword(password);
		this.password = password;
		//setRole(role);
		this.role = role;
		
		messages = new Message[0];
	}
	
	
	
	public void setName(String name) {
		if(name.length() <= 2) {
			System.out.println("*Name has to be more than 2 letters");
		}else {
			this.name = name;
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setUsername() {
		String[] uName = this.name.split("\\s");
		int randomNr = (int)(Math.random() * 500)+1;
		String username = uName[0] + randomNr;
		String lowCaseUname = username.toLowerCase();
			this.username = lowCaseUname;
		
	}
	
	public void setPassword(String password) {
		if(name.length() <= 2) {
			System.out.println("*Password has to be more than 2 character");
		}else {
			this.password = password;
		}
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void addOwnMessage(String text, Object obj) {
		
		messages = Arrays.copyOf(messages, messages.length + 1);
		messages[messages.length - 1].setText(text);
		messages[messages.length - 1].setAuthor(this);
		messages[messages.length - 1].setDate(new Date());
		messages[messages.length - 1].setmId(messages.length -1);
	}
	
	public String [] getOwnMessages(){
		return messages;
	}

}
