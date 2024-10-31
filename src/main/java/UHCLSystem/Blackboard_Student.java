package UHCLSystem;

import java.util.Scanner;

public class Blackboard_Student extends Blackboard {

	@Override
	public void welcomeBlackboard()
	{
		Scanner input = new Scanner(System.in);
		String selection = "";
		
		while (!selection.equalsIgnoreCase("x")) 
		{
			System.out.println();
			System.out.println("Welcome to UHCL Blackboard!");
			System.out.println("Select your course:");						 
			System.out.println("Please select your options:");
			System.out.println("v: view course notes");
			System.out.println("x: leave the course");
			System.out.println("x: Leave Blackboard");
			System.out.println();

			selection = input.nextLine();
			System.out.println();

			if (selection.equalsIgnoreCase("v")) {
				System.out.println("view course notes");
				//display the list of course notes //getCourseNotes from data class
			}
		}
	}

}
