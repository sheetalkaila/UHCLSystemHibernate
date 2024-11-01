package UHCLSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Blackboard_Student extends Blackboard {

	@Override
	public void welcomeBlackboard(uhcluser loginuser)
	{
		Scanner input = new Scanner(System.in);
		String selection = "";
		Hibernate h = new Hibernate();
		
		while (!selection.equalsIgnoreCase("x")) 
		{
			System.out.println();
			System.out.println("Welcome to UHCL Blackboard!");
			System.out.println("Select your course:");
			
		
			ArrayList<String> e_courses = h.getMyEnrolledCourse(loginuser.getLoginID());
			
			for(int i =0;i < e_courses.size() ;i++) 
			{
				System.out.println(i+1 + "." + e_courses.get(i) );

			}
			System.out.println("x: leave Blackboard");
			
			selection = input.nextLine();
			if(selection.equalsIgnoreCase("x")) 
			{
				return;
			}
			int course_sel = 0;
			if(isInteger.test(selection)) 
			{
				course_sel = Integer.parseInt(selection);
			}
			
			String choose = "";
			
			while(!choose.equalsIgnoreCase("x")) 
			{
				System.out.println("Please select your options:");
				System.out.println("v: view course notes");
				System.out.println("x: leave the course");
				System.out.println();

				choose = input.nextLine(); // for v or x
				
				if (choose.equalsIgnoreCase("v")) {
					System.out.println("Course notes of "+e_courses.get(course_sel-1));
					
					ArrayList<CourseNote> coursenotes = h.getCourseNotes(e_courses.get(course_sel-1));
					
					if(coursenotes.size()==0) {System.out.println("None");
}
					for(int i =0;i < coursenotes.size() ;i++) 
					{
						System.out.println(coursenotes.get(i).getDatetime()+":"+coursenotes.get(i).getContent());

					}
					
				}
			
			}
			
			
		}
	}

}
