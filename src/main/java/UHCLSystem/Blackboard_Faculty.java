package UHCLSystem;

import java.util.Scanner;

public class Blackboard_Faculty extends Blackboard {

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
			// display the list of courses  //getMyTeachingCourse from data class
			System.out.println("Please select your options:");
			System.out.println("v: view course notes");
			System.out.println("p: post new course note");
			System.out.println("x: leave the course");
			System.out.println();

			selection = input.nextLine();
			System.out.println();

			if (selection.equalsIgnoreCase("v")) {
				System.out.println("view course notes");
				//display the list of course notes //getCourseNotes from data class
			}
			if (selection.equalsIgnoreCase("p")) {
				System.out.println("please enter your new note:");
				CourseNote cn = new CourseNote();
				cn.setContent(input.nextLine()); // doubt
				System.out.println("Your note is added to the course. Your students can see it now");

			}
			
			
		}
	}
	
}
