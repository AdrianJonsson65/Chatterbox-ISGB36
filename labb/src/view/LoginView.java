package view;
import java.util.Scanner;


import controler.*;
import model.*;

public class LoginView {
	
	public LoginView() {
		Scanner scan = new Scanner(System.in);
	
		System.out.println("Ange username");
		String username = scan.next();
		System.out.println("Ange password");
		String password = scan.next();
		User_Login User = AuthController.ConfirmLogin(username, password);
		if (User != null) {
			System.out.println("Welcome " + User.getName());
			System.out.println(" 0 to exit \n 1 to view all messages \n 2 to view all own messages \n 3 to create new message");
			String answer = scan.next();
			switch(answer) {
			case "0":
				break;
			case "1":
				
				break;
			case "2":
				User.getOwnMessages(null, User);
				break;
			case "3":
				System.out.println("Write your message here: ");
				String text = scan.next();
				text += scan.nextLine();
				Message message = new Message(text);
				System.out.println(message);
				
				
				
			}
			//Message.ViewAll(); //User exists, logins user and redirects to messages.
			
		} else {
			System.out.println("Användare finns inte");
		}
	
}
}
