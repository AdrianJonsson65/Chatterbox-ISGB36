package view;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


import controler.*;
import model.*;

public class LoginView {
	
	public LoginView() {}
	
	public void viewMessages(ArrayList<Message> messages) {
		if(messages.size() == 0) {
			System.out.println("No message created!");
		}else {
			System.out.println("Output\n");
			for(Message m : messages) {
				System.out.println("Message: " + m.toString());
			}
		}
		
	}
	
	public void login() throws SQLException {
		Scanner scan = new Scanner(System.in);
		while(true) {
			AuthController acont = new AuthController();
			MessageControler mcont = new MessageControler();
			User_Login User = acont.ConfirmLogin();
			if (User != null) {
				System.out.println("Welcome " + User.getName());
				while(true) {
					System.out.println(" 0 to exit \n 1 to view all messages \n 2 to view all own messages \n 3 to create new message");
					String answer = scan.next();
					
					switch(answer) {
					case "0":
						System.exit(0);
					case "1":
						mcont.viewAllMessages();
						break;
					case "2":
						mcont.viewAllOwnMessages(User);
						while(true) {
							String enter;
							DAO dao = new DAO();
							ArrayList<Message> messages = new ArrayList<>();
							messages = dao.getAllMessages();
							if (dao.getAllMessagesByUser(User).size() == 0) {
								System.out.println("0 to continue");
								enter = scan.next();
							}else {
								System.out.println("Do you want to delete a message? enter message ID or 0 to continue: ");
								enter = scan.next();
							}
							
							try {
								int enter2 = Integer.parseInt(enter);
								if(enter2 == 0) {
									break;
								} else if(enter2 > 0){
									mcont.deleteMessage(enter, User);
								}
							} catch(NumberFormatException e){
								System.out.println("Invalid input");
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
