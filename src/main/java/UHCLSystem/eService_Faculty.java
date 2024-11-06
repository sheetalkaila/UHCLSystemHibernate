package UHCLSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class eService_Faculty extends eService{

	@Override
	public void welcomeEservice(uhcluser loginuser)
	{
		Scanner input = new Scanner(System.in);
		String selection = "";
		Hibernate h = new Hibernate();
		
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
				
				ArrayList<String> tech_courses =h.getMyTeachingCourse(loginuser.getLoginID());
				
				for(String tc: tech_courses) 
				{
					System.out.println(tc);
					System.out.println("Students enrolled:");

					ArrayList<String> stu_name = h.getMyEnrolledStudentNames(tc);
					for(String s : stu_name) 
					{
						System.out.println(s);
						System.out.println();


					}

				}
				
				
			}

		}
	}

}
