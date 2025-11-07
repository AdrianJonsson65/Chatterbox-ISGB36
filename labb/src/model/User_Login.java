package model;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
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
	
	public User_Login() {}
	

	
	//Setters
	public void setName(String name) {
			this.name = name;
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
	
	public void setUserName(String uName) {
		this.username = uName;
	}
	
	public void setPassword(String password) {
		if(name.length() <= 2) {
			System.out.println("*Password has to be more than 2 character");
		}else {
			this.password = password;
		}
	}
	
	//Getters

	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	/*
	public Message [] getMessages() {
		return this.messages;
	}
	
	public Message [] getOwnMessages(User_Login obj){
		return obj.getMessages();
	}

	//Functions
	
	public Message [] addOwnMessage(String text, User_Login obj) {
		
		messages = Arrays.copyOf(messages, messages.length + 1);
		Message newMsg = new Message();
		newMsg.setAuthor(obj);
		newMsg.setDate(new Date());
		newMsg.setmId(newMsg.getAllMessages().length);
		newMsg.setText(text);
		messages[messages.length - 1] = newMsg;
		return messages;
	}
	
	public Message [] deleteOwnMessage(String mId, User_Login obj) {
		int id = Integer.parseInt(mId);
		Message [] newMessages = new Message[messages.length - 1];
		int j = 0;
		for (Message m : obj.getOwnMessages(obj)) {
			if (id != m.getMId()) {
				newMessages[j] = m;
				j++;
			}
		}
		
		messages = null;
		messages = newMessages;
		return messages;
	}*/
	
	
	
	public User_Login login() throws SQLException {
		DAO dao = new DAO();
		Scanner scan = new Scanner(System.in);
			System.out.println("Ange username");
			String username = scan.next();
			System.out.println("Ange password");
			String password = scan.next();
			ArrayList<User_Login> users = new ArrayList<>();
			users = dao.getAllUsers();
		for (User_Login UL : users) {
			if (UL.getUsername().equals(username) && UL.getPassword().equals(password)) {
				return UL;
			}
		}
		return null;
	}
	
	
	
	public ArrayList<User_Login> getUsers()throws SQLException {
		DAO dao = new DAO();
		ArrayList<User_Login> users = new ArrayList<>();
		users = dao.getAllUsers();
		return users;
	}
	
	@Override
	public String toString() {
		return this.name +  " ";
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true; 
	    if (obj == null || getClass() != obj.getClass())
	        return false;

	    User_Login ul = (User_Login) obj;
	    return this.username.equals(ul.username);
	}



}
