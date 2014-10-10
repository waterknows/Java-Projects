import java.util.Calendar;
import java.util.Date;


public class Appointment {
	private String description = "";
	int day;
	int year;
	int month;
	
	public Appointment(){
		this(0,0,0);
	}
	
	public Appointment(int year, int month, int day) {
		this.day = day;
		this.year = year;
		this.month = month;
	}
	
	public Appointment(String newDescription, int year, int month, int day){
		this(year, month, day);
		description = newDescription;
	}
	
	
	public String getDescription(){
		return description;
	}
	
	public String getDate(){
		return year + "/" + month + "/" + day;
	}
	
	public void setDescription(String newDescription){
		System.out.println("Printing ");
		description = newDescription;
	}
	
	public void setDate(int year, int month, int day){
		this.day = day;
		this.year = year;
		this.month = month;
		
	}
	
	
	public boolean occursOn(int year, int month, int day){
		if(this.year == year && this.month== month && this.day== day)
			return true;
		else
			return false;
	}
	
}
