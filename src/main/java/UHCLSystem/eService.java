package UHCLSystem;

import java.util.Scanner;

public abstract class eService {
	
	public void welcomeEservice()
	{
		Scanner input = new Scanner(System.in);
		String selection = "";
		
		while (!selection.equalsIgnoreCase("x")) 
		{
			System.out.println();
			System.out.println("Welcome to UHCL eService:");
			System.out.println("v: view my courses");
			System.out.println("x: Logout");
			System.out.println();

			selection = input.nextLine();
			System.out.println();

			if (selection.equalsIgnoreCase("v")) {
				System.out.println("view my courses");

			}

		}
	}
	
	
}
