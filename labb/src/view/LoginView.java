package view;
import java.util.Scanner;

import controler.AuthController;
import model.User_Login;

public class LoginView {
	
	public LoginView() {
		Scanner scan = new Scanner(System.in);
	
		System.out.println("Ange username");
		String username = scan.next();
		System.out.println("Ange password");
		String password = scan.next();
		User_Login User = AuthController.ConfirmLogin(username, password);
		if (User != null) {
			//Message.ViewAll(); //User exists, logins user and redirects to messages.
			
		} else {
			System.out.println("Användare finns inte");
		}
	
}
}
