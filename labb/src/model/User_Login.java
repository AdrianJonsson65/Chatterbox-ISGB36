package model;

public class User_Login {

	private String name;
	private String username;
	private String password;
	private String role;
	private Message[] messages;
	
<<<<<<< HEAD
	
	//Constructor
=======
	/*
	 * User_Login Model
	 */
>>>>>>> main
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
	
<<<<<<< HEAD
	
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
	
	public void setPassword(String password) {
		if(name.length() <= 2) {
			System.out.println("*Password has to be more than 2 character");
		}else {
			this.password = password;
		}
	}
	
	//Getters
=======
>>>>>>> main
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
<<<<<<< HEAD
	//Functions
	public void addOwnMessage(String text) {
		
		messages = Arrays.copyOf(messages, messages.length + 1);
		messages[messages.length - 1].setText(text);
		messages[messages.length - 1].setAuthor(this);
		messages[messages.length - 1].setDate(new Date());
		messages[messages.length - 1].setmId(messages.length -1);
	}
	
	
	
	public String [] getOwnMessages(List messages, User_Login obj){
		int i = 0;
		Message [] mess = new Message[messages.size()];
		for(int j = 0; j < messages.size(); j++) {
			mess[j] = (Message) messages.get(j);
		}
		String [] ownMessages = new String[i];
		for (Message m : mess) {
			if(m.getAuthor().equals(obj.getName())) {
				i++;
				ownMessages[i-1] = m.toString();
			}
		}
		return ownMessages;
	}
=======
	public static User_Login []users = {
			new User_Login("John Nash", "jnash", "123", "User"),
			new User_Login("Timmy Hjelm", "thjelm", "123", "User"),
			new User_Login("Linus Lokgård", "llokgard", "123", "User"),
			new User_Login("Adrian Jonsson", "ajonsson", "123", "User")
	};
>>>>>>> main

}
