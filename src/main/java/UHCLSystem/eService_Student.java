package UHCLSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class eService_Student extends eService {

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
			System.out.println("r: register a course");
			System.out.println("x: Logout");
			System.out.println();

			selection = input.nextLine();
			System.out.println();

			if (selection.equalsIgnoreCase("v")) {
				
				ArrayList<String> e_courses = h.getMyEnrolledCourse(loginuser.getLoginID());
				
				if(e_courses.size() == 0 )
				{
					System.out.println("You do not have any course registered!");

				}
				else
				{			
					for(int i =0;i < e_courses.size() ;i++) 
					{
						String inst = h.getInstructor(e_courses.get(i));
						System.out.println(e_courses.get(i)+",Instructor: Dr."+inst);

					}
				}
			}
			if (selection.equalsIgnoreCase("r")) {
					System.out.println("Welcome to register a new course!");
					System.out.println("These are the courses available to you:");
					
					
					ArrayList<String> open_courses = h.getMyOpenCourse(loginuser.getLoginID());
					
					for(int i =0;i < open_courses.size() ;i++) 
					{
						System.out.println(i+1 + "." + open_courses.get(i) );

					}					
					System.out.println("Or any other key to exit");
					
					selection = input.nextLine();
					int course_sel = 0;
					if(isInteger.test(selection)) 
					{
						course_sel = Integer.parseInt(selection);
					}
					
					h.registerCourse(loginuser.getLoginID(), open_courses.get(course_sel-1));					
					System.out.println("The course is added to your schedule!");


					
			}

			}

		}

	

}
