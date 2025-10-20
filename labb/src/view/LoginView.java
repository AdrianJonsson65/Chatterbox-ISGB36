package view;
import java.util.Scanner;

public class LoginView {
	
	public LoginView() {
		Scanner scan = new Scanner(System.in);
		User_Login john = new User_Login("John Nash","jnash","123","user");
	
	
		System.out.println("Ange username");
		String username = scan.next();
		System.out.println("Ange password");
		String password = scan.next();
	
		if(username.equals(john.getUsername()) && password.equals(john.getPassword())) {
			System.out.println("Användaren finns");
		} else {
			System.out.println("Användare finns inte");
		}
	
}
}
