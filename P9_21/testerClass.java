import java.util.Scanner;

/* Name : Joseph Park, Tony Lim
 * Date : Oct 9, 2014
 * Assignment : P9.21
 * Description : Making an Appointment to check for appointments of a date
 */


public class testerClass {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String temp = "";
		
		//testcase for 1 appointment
		Appointment Notification = new Appointment("Test",1,1,1);
		System.out.println("Default descpt : " + Notification.getDescription());
		System.out.println("Default date : " + Notification.getDate());
		
		
		
		//testcase for Appointments
		Appointment[] Reminders = new  Appointment[5];

		
		
		/*
		 * This is the correct instantiation of array
		 */
//		for (int i = 0; i < Reminders.length; i++) {
//			Reminders[i] = new Appointment();
//			Reminders[i].setDate(2014, 10, 9);
//			System.out.println("For date " + Reminders[i].getDate());
//			System.out.print("Appointment description : ");
//			temp = in.next(); // get description
//			Reminders[i].setDescription(temp);
//		}

		//This will gives error
		for (Appointment appointment : Reminders) {
			appointment = new Appointment();
			appointment.setDate(2014, 10, 9); // make every appointment occurs today
			System.out.println("For date " + appointment.getDate());
			System.out.print("Appointment description : ");
			temp = in.next(); // get description
			appointment.setDescription(temp);
		}
		
		//This is okay, no accessor
		for (Appointment appointment : Reminders) {
//			System.out.println("Date : " + appointment.getDate());
			System.out.println("Appointment : " + appointment.getDescription() + "\n----");
		}
		in.close();
	}

}
