package UHCLSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Blackboard_Faculty extends Blackboard {

	@Override
	public void welcomeBlackboard(uhcluser loginuser) {
		Scanner input = new Scanner(System.in);
		String selection = "";
		Hibernate h = new Hibernate();

		while (!selection.equalsIgnoreCase("x")) {
			System.out.println();
			System.out.println("Welcome to UHCL Blackboard!");
			System.out.println("Select your course:");

			ArrayList<String> tech_courses = h.getMyTeachingCourse(loginuser.getLoginID());

			for (int i = 0; i < tech_courses.size(); i++) {
				System.out.println(i + 1 + "." + tech_courses.get(i));

			}
			System.out.println("x: leave Blackboard");
			
			selection = input.nextLine();
			if (selection.equalsIgnoreCase("x")) {
				return;
			}
			int course_sel = 0;
			if (isInteger.test(selection)) {
				course_sel = Integer.parseInt(selection);
			}

			String choose = "";

			while (!choose.equalsIgnoreCase("x")) {
				System.out.println("Please select your options:");
				System.out.println("v: view course notes");
				System.out.println("p: post new course note");
				System.out.println("x: leave the course");
				System.out.println();

				choose = input.nextLine(); 

				if (choose.equalsIgnoreCase("v")) {
					System.out.println("Course notes of " + tech_courses.get(course_sel - 1));

					ArrayList<CourseNote> coursenotes = h.getCourseNotes(tech_courses.get(course_sel - 1));

					if (coursenotes.size() == 0) {
						System.out.println("None");
					}
					for (int i = 0; i < coursenotes.size(); i++) {
						System.out.println(coursenotes.get(i).getDatetime() + ":" + coursenotes.get(i).getContent());

					}

				}

				if (choose.equalsIgnoreCase("p")) {
					System.out.println("please enter your new note:");
					CourseNote cn = new CourseNote();
					cn.setContent(input.nextLine());
					cn.setUserID(loginuser.getLoginID());
					cn.setCourseID(tech_courses.get(course_sel - 1));
					cn.setDatetime(DateAndTime.DateTime());
					h.writeNote(cn);
					System.out.println("Your note is added to the course. Your students can see it now");

				}
			
			}

		}
	}

}
