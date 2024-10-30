package UHCLSystem;

import java.util.Scanner;

public class eService_Student extends eService {

	@Override
	public void welcomeEservice()
	{
		Scanner input = new Scanner(System.in);
		String selection = "";
		
		while (!selection.equalsIgnoreCase("x")) 
		{
			System.out.println();
			System.out.println("Welcome to UHCL eService:");
			System.out.println("v: view my courses");
			System.out.println("r: register a course");
			System.out.println("x: Logout");
			System.out.println();

			selection = input.nextLine();
			System.out.println();

			if (selection.equalsIgnoreCase("v")) {
				/*if(course == null )
				{
					System.out.println("You do not have any course registered!");

				}
				else
				{
					System.out.println("view my courses");
					// display the list of courses //getMyEnrolledCourse from data class
				}*/
			}
			if (selection.equalsIgnoreCase("r")) {
					System.out.println("Welcome to register a new course!");
					System.out.println("These are the courses available to you:");
					// display the list of courses //getMyOpenCourse from data class
					System.out.println("Or any other key to exit");
					//after selecting one course
					System.out.println("The course is added to your schedule!");


					
			}

			}

		}
	

}
