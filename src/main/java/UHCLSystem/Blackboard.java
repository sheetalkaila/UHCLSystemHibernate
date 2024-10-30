package UHCLSystem;

import java.util.Scanner;

public abstract class Blackboard {
	
	public void welcomeBlackboard()
	{
		Scanner input = new Scanner(System.in);
		String selection = "";
		
		while (!selection.equalsIgnoreCase("x")) 
		{
			System.out.println();
			System.out.println("Welcome to UHCL Blackboard!");
			System.out.println("Select your course:");
			System.out.println("x: Leave Blackboard");
			System.out.println();

			selection = input.nextLine();
			System.out.println();


		}
	}
	
}
