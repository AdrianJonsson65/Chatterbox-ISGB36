package model;

public class User_Login {

	private String name;
	private String username;
	private String password;
	private String role;
	private Message[] messages;
	
	/*
	 * User_Login Model
	 */
	public User_Login(String name, String username, String password, String role) {
		//setName(name);
		this.name = name;
		//setUsername();
		this.username = username;
		//setPassword(password);
		this.password = password;
		//setRole(role);
		this.role = role;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public static User_Login []users = {
			new User_Login("John Nash", "jnash", "123", "User"),
			new User_Login("Timmy Hjelm", "thjelm", "123", "User"),
			new User_Login("Linus Lokgård", "llokgard", "123", "User"),
			new User_Login("Adrian Jonsson", "ajonsson", "123", "User")
	};

}
