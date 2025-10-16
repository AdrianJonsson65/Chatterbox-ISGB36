package main;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		
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
		}
		else {
			//Call Guest Class.
		}
		
		
	}

}
