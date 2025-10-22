package view;
import java.util.Scanner;
//View for the start interface which allows user login or to continue as a guest depending on the choice made.
public class StartView {

	public StartView(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		
		while (choice != 1 && choice != 2) {
			System.out.println("Choose an option: ");
			System.out.println("1 - Login");
			System.out.println("2 - Continue as Guest");
			System.out.println("Select option 1 or 2 to Continue");
			
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Choice 1 - CONFIRMATION MESSAGE");
				new LoginView();
				break;
			case 2:
				System.out.println("Choice 2 - CONFIRMATION MESSAGE");
				//Message.viewAll(); 
				break;
			default:
				System.out.println("Invalid Choice - CONFIRMATION MESSAGE");
				System.out.println("Please enter a valid option!");
			}
		}
	}
}
