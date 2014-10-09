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
		Appointment[] Reminders = new  Appointment[5];
//		for(int i = 0; i < 5; i++){
//			Reminders[i] = new Appointment("Hello",2014,10,9);
//		}
//		for (Appointment appointment : Reminders) {
//			
////			appointment.setDate(2014, 10, 9); // make every appointment occurs today
//			System.out.println("For date " + appointment.getDate());
//			System.out.print("Appointment description : ");
//			temp = in.next(); // get description
//			appointment.setDescription(temp);
//		}
		
		Appointment app = new Appointment(":",2014,10,9);
		//debug : print all the filled appointments
//		for (Appointment appointment : Reminders) {
			System.out.println(app.AppCalendar.toString());
			System.out.println("Date : " + app.getDate());
			System.out.println("Appointment : " + app.getDescription() + "\n----");
//		}
//		
		//testcase for Daily
		
		
		
		in.close();
	}

}
