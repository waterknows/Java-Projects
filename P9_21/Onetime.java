import java.util.Date;


public class Onetime extends Appointment{
	//Appointment that occurs once
	//Has a unique date
	public Onetime(){
		super();
	}
	public Onetime(String newDescription, Date NewDate){
		super(newDescription,NewDate);
	}
}
