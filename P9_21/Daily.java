import java.sql.Date;
import java.util.Calendar;


public class Daily extends Appointment{
	//Appointment that occurs daily in a date range
	//Occurs everyday within that range

	private int startYear;
	private int startMonth;
	private int startDay;
	private int endYear;
	private int endMonth;
	private int endDay;
	
	public Daily(){
		super();
		startYear = startMonth = startDay = endYear = endMonth = endDay = 0;
	}
	
	public Daily(String newDescription, int year, int month, int day){
		super(newDescription,year,month,day);
		startYear = startMonth = startDay = endYear = endMonth = endDay = 0;
	}
	
	public Daily(String newDescription, int year, int month, int day, Date StartDate, Date EndDate){
		super(newDescription,year,month,day);
		startYear = StartDate.getYear();
	}
	
	public boolean occursOn(int year, int month, int day){
		Calendar Temp = Calendar.getInstance();
		Temp.set(year,month,day);
		return Temp.compareTo(StartDate) >= 0 && Temp.compareTo(EndDate) <= 0;
	}
	
}
