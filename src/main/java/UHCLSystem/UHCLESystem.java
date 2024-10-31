package UHCLSystem;

import java.util.Scanner;

public class UHCLESystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		String selection = "";

		while (!selection.equalsIgnoreCase("x")) // while not x, keep displaying the menu
		{
			// display the menu
			System.out.println();
			System.out.println("**** Go Hawks! ****");
			System.out.println("Please make your selection");
			System.out.println("1: e-Service");
			System.out.println("2: BlackBoard");
			System.out.println("x: Leave");
			System.out.println();

			// get the selection from the user
			selection = input.nextLine();
			System.out.println();

			if (selection.equals("1")) {
				System.out.println("Please enter your id: ");
				String id = input.nextLine();
				System.out.println("Please enter your password: ");
				String password = input.nextLine();

			}

			if (selection.equals("2")) {
				System.out.println("Please enter your id: ");
				String id = input.nextLine();
				System.out.println("Please enter your password: ");
				String password = input.nextLine();
				// login eService;

			}
		}
	}

}
