package view;
import java.util.Scanner;


import controler.*;
import model.*;

public class LoginView {
	
	public LoginView() {}
	
	public void viewMessages(Message[] messages) {
		System.out.println("Output\n");
		for(Message m : messages) {
			System.out.println("Message: " + m.toString());
		}
	}
	
	public void login() {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("Ange username");
			String username = scan.next();
			System.out.println("Ange password");
			String password = scan.next();
			User_Login User = AuthController.ConfirmLogin(username, password);
			MessageControler mcont = new MessageControler();
			if (User != null) {
				System.out.println("Welcome " + User.getName());
				while(true) {
					System.out.println(" 0 to exit \n 1 to view all messages \n 2 to view all own messages \n 3 to create new message");
					String answer = scan.next();
					
					switch(answer) {
					case "0":
						return;
					case "1":
						mcont.viewAllMessages();
						break;
					case "2":
						mcont.viewAllOwnMessages(User);
						while(true) {
							System.out.println("Do you want to delete a message? enter message ID or 0 to continue: ");
							int enter = scan.nextInt();
							if(enter == 0) {
								break;
							}else if(enter > 0){
								mcont.deleteMessage(enter, User);
							}
						}
						break;
					case "3":
						System.out.println("Write your message here: ");
						String text = scan.next();
						text += scan.nextLine();
						mcont.createMessage(text, User);
						break;
						
						
						
					}
				//Message.ViewAll(); //User exists, logins user and redirects to messages.
				}
				
			} else {
				System.out.println("Användare finns inte");
			}
		}
	
	
	}
}
