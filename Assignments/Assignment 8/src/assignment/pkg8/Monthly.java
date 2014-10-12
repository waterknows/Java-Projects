package assignment.pkg8;
public class Monthly extends Appointment{
//Appointment that occurs once a month
//Occurs on a specific day (Not Date) of the month
    private int startMonth;
    private int endMonth;
    /**
     * Default constructor
     */
    public Monthly(){
        super();
        startMonth = endMonth = 0;
    }
    /**
     * Constructor with description and date argument
     * @param newDescription description
     * @param NewDate date
     */
    public Monthly(String newDescription, SDate NewDate){
        super(newDescription,NewDate);
        startMonth = endMonth = 0;
    }
    /**
     * Constructor with description and date as int argument
     * @param newDescription description
     * @param year year
     * @param month month
     * @param day day
     * @throws Exception if the month and day are invalid 
     */
    public Monthly(String newDescription, int year, int month, int day) throws Exception{
        super(newDescription,year,month,day);
        startMonth = endMonth = 0;
    }
    /**
     * Constructor with description, date, startdate, and enddate argument
     * @param newDescription description
     * @param NewDate the date
     * @param startMonth starting month
     * @param endMonth ending MOnth
     */
    public Monthly(String newDescription, SDate NewDate, int startMonth, int endMonth){
        super(newDescription,NewDate);
        this.startMonth = startMonth;
        this.endMonth = endMonth;
    }
    /**
     * gets the start month
     * @return start month
     */
    public int getStart(){
        return startMonth;
    }
    /**
     * gets the end month
     * @return end month
     */
    public int getEnd(){
        return endMonth;
    }
    /**
     * checks if the appointment occurs on the date
     * @param year year
     * @param month month
     * @param day day
     * @return True if the appointment occurs
     */
    @Override
    public boolean occursOn(int year, int month, int day){
        return month >= startMonth && month <= endMonth;
    }
    /**
     * returns the string description of the appointment
     * @return 
     */
    @Override
    public String toString(){
        return super.toString() + " " + startMonth + " " + endMonth;
    }
}