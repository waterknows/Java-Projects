import java.util.Calendar;
import java.util.Date;


public class Appointment {
	private String description;
	private Calendar AppCalendar;
	
	public Appointment(){
		description = "";
		AppCalendar = Calendar.getInstance();
	}
	
	public Appointment(String newDescription, Date NewDate){
		description = newDescription;
		AppCalendar.setTime(NewDate);
	}
	
	public Appointment(String newDescription, int year, int month, int day){
		description = newDescription;
		AppCalendar.set(year,month,day);
	}
	
	public String getDescription(){
		return description;
	}
	
	public String getDate(){
		return AppCalendar.toString();
	}
	
	public void setDescription(String newDescription){
		description = newDescription;
	}
	
	public void setDate(int year, int month, int day){
		AppCalendar.set(year,month,day);
	}
	public void setDate(Date NewDate){
		AppCalendar.setTime(NewDate);
	}
	
	public boolean occursOn(int year, int month, int day){
		Calendar Temp = null;
		Temp.set(year,month,day);
		return AppCalendar.compareTo(Temp) == 0;
	}
	
}
