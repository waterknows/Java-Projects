package assignment.pkg8;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Daily extends Appointment{
//Appointment that occurs daily in a date range
//Occurs everyday within that range
    private SDate StartDate;
    private SDate EndDate;
    /**
     * Default constructor
     */
    public Daily(){
        super();
        StartDate = new SDate();
        EndDate = new SDate();
    }
    /**
     * Constructor with description and date argument
     * @param newDescription description
     * @param NewDate date
     */
    public Daily(String newDescription, SDate NewDate){
        super(newDescription,NewDate);
        StartDate = new SDate();
        EndDate = new SDate();
    }
    /**
     * Constructor with description and date as int argument
     * @param newDescription description
     * @param year year
     * @param month month
     * @param day day
     * @throws Exception if the month and day are invalid 
     */
    public Daily(String newDescription, int year, int month, int day) throws Exception{
        super(newDescription,year,month,day);
        StartDate = new SDate();
        EndDate = new SDate();
    }
    /**
     * Constructor with description, date, startdate, and enddate argument
     * @param newDescription description
     * @param NewDate the date
     * @param NewStart starting date
     * @param NewEnd  ending date
     */
    public Daily(String newDescription, SDate NewDate, SDate NewStart, SDate NewEnd){
        super(newDescription,NewDate);
        StartDate = NewStart;
        EndDate = NewEnd;
    }
    /**
     * gets the start date
     * @return start date
     */
    public SDate getStart(){
        return StartDate;
    }
    /**
     * gets the end date
     * @return end date
     */
    public SDate getEnd(){
        return EndDate;
    }
    /**
     * checks if the appointment occurs on the date
     * @param year year
     * @param month month
     * @param day day
     * @return True if the appointment occurs, false
     */
    @Override
    public boolean occursOn(int year, int month, int day) {
        SDate Temp = null;
        try {
            Temp = new SDate(year,month,day);
        } catch (Exception ex) {
            Logger.getLogger(Daily.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (StartDate.daysSince() <= Temp.daysSince()) && (EndDate.daysSince() >= Temp.daysSince());
    }
    /**
     * returns the string description of the appointment
     * @return 
     */
    @Override
    public String toString(){
        return super.toString() + " " + StartDate.toString() + " " + EndDate.toString();
    }
}