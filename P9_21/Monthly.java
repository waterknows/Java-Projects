

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
	public Monthly(String newDescription, int newYear, int newMonth, int newDay){
		super(newDescription,newYear, newMonth, newDay);
		startMonth = endMonth = dayOfMonth = 0;
	}
	
	public Monthly(String newDescription, int newYear, int newMonth, int newDay, int startMonth, int endMonth, int dayOf){
		super(newDescription,newYear,newMonth,newDay);
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
		return month >= startMonth && month <= endMonth;
	}
	
}
