import java.util.Calendar;
import java.util.Date;


public class Monthly extends Appointment{
	//Appointment that occurs once a month
	//Occurs on a specific day (Not Date) of the month
	private int startMonth;
	private int endMonth;
	private int dayOfMonth;
	public Monthly(){
		super();
		startMonth = endMonth = dayOfMonth = 0;
	}
	public Monthly(String newDescription, Date NewDate){
		super(newDescription,NewDate);
		startMonth = endMonth = dayOfMonth = 0;
	}
	
	public Monthly(String newDescription, int year, int month, int day){
		super(newDescription,year,month,day);
		startMonth = endMonth = dayOfMonth = 0;
	}
	
	public Monthly(String newDescription, Date NewDate, int startMonth, int endMonth, int dayOf){
		super(newDescription,NewDate);
		this.startMonth = startMonth;
		this.endMonth = endMonth;
		dayOfMonth = dayOf;
	}
	
	public int getStart(){
		return startMonth;
	}
	
	public int getEnd(){
		return endMonth;
	}
	
	public int getDayOf(){
		return dayOfMonth;
	}
	
	public boolean occursOn(int year, int month, int day){
		Calendar Temp = Calendar.getInstance();
		Temp.set(year, month,day);
		return month >= startMonth && month <= endMonth;
	}
	
}
