package UHCLSystem;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UHCLESystem {

	public static void main(String[] args) {
		Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);

		Scanner input = new Scanner(System.in);
		String selection = "";

		while (!selection.equalsIgnoreCase("x")) // while not x, keep displaying the menu
		{
			// display the menu
			System.out.println();
			System.out.println("**** Go Hawks! ****");
			System.out.println("Please make your selection");
			System.out.println("1: e-Service");
			System.out.println("2: BlackBoard");
			System.out.println("x: Leave");
			System.out.println();

			// get the selection from the user
			selection = input.nextLine();
			System.out.println();

			if (selection.equals("1")) {
				System.out.println("Please enter your id: ");
				String id = input.nextLine();
				System.out.println("Please enter your password: ");
				String password = input.nextLine();
				Hibernate h = new Hibernate();				
				uhcluser loginuser = h.login(id,password);
				
				eService e = null;
				
				if(loginuser.getType().equalsIgnoreCase("student")) 
				{
					e = new eService_Student();					
				}
				else if(loginuser.getType().equalsIgnoreCase("faculty")) 
				{
					e = new eService_Faculty();
				}
				else
				{
					System.out.println("Not valid user type");
				}
				
				e.welcomeEservice(loginuser);


			}

			if (selection.equals("2")) {
				System.out.println("Please enter your id: ");
				String id = input.nextLine();
				System.out.println("Please enter your password: ");
				String password = input.nextLine();			
				uhcluser loginuser = (new Hibernate()).login(id,password);
				
				Blackboard b = null;
				
				if(loginuser.getType().equalsIgnoreCase("student")) 
				{
					b = new Blackboard_Student();					
				}
				else if(loginuser.getType().equalsIgnoreCase("faculty")) 
				{
					b = new Blackboard_Faculty();
				}
				else
				{
					System.out.println("Not valid user type");
				}
				
				b.welcomeBlackboard(loginuser);
				

			}
		}
	}

}
