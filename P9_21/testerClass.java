import java.util.Scanner;

/* Name : Joseph Park, Tony Lim
 * Date : Oct 9, 2014
 * Assignment : P9.21
 * Description : Making an Appointment to check for appointments of a date
 */


public class testerClass {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String temp;
		
		//testcase for Appointments
		Appointment[] reminders = new  Appointment[5];
		for(int i = 0; i < 5; i++){
			reminders[i] = new Appointment(); //by default, it should be set to today's date
			System.out.println("For date " + reminders[i].getDate());
			System.out.print("Appointment description : "); 
			temp = in.nextLine(); // get description
			reminders[i].setDescription(temp);
		}
		
		for (Appointment app: reminders) {
			System.out.println("Date : " + app.getDate());
			System.out.println("Appointment : " + app.getDescription());
		}
		
		//try to print all appointments on the day
		// ex : 2014-10-10
		System.out.println("Here's the list of appointments on 2014-10-10.");
		for (Appointment memo : reminders) {
			if(memo.occursOn(2014, 10, 10))
				System.out.println("- " + memo.getDescription());
		}

		in.close();
	}

}
