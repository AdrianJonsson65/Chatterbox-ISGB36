package main;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		
		User_Login john = new User_Login("John Nash","jnash","123","user");
		
		while (choice != 1 && choice != 2) {
			System.out.println("Choose an option: ");
			System.out.println("1 - Login");
			System.out.println("2 - Continue as Guest");
			System.out.println("Select option 1 or 2 to Continue");
			
			choice = scan.nextInt();
			if (choice != 1 && choice != 2) {
				System.out.println("Invalid option, try again!");
			}
		}
		if (choice == 1) {
			//Call Login Class.
			//Scanner Scan = new Scanner(System.in);
			
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
		else {
			//Call Guest Class.
		}
		
		
		
		
	}

}
