package UHCLSystem;

import java.util.Scanner;

public class eService_Faculty extends eService{

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
				System.out.println("courses");
				// display the list of courses  //getMyTeachingCourse from data class		
				//display the name of students who enrolled in each course //getMyEnrolledStudentNames from data class 
			}

		}
	}

}
