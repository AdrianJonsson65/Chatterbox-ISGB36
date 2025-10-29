package view;

import controler.MessageControler;
import model.Message;

import java.util.*;

public class GuestView {
	
	public void viewMessages(Message[] messages) {
		if(messages.length == 0) {
			System.out.println("No message created!");
		}else {
			System.out.println("Output\n");
			for(Message m : messages) {
				System.out.println("Message: " + m.toString());
			}
		}
		
	}
	
	public void ViewAllMessages() {
		LoginView loginview = new LoginView();
		while(true) {
			MessageControler mcont = new MessageControler();
			System.out.println(" 0 to exit \n 1 to view all messages \n 2 to log in");
			Scanner scan = new Scanner(System.in);
			String choice = scan.next();

			switch(choice) {
			 	case "0":
			 		System.exit(0);
			 	case "1":
			 		mcont.viewAllMessages();
			 		break;
			 	case "2":
			 		loginview.login();
			 		break;
			 	default:
			 		System.out.println("Invalid choice, try again!");		
				
			}
		}
	}
}
