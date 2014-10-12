package assignment.pkg8;
public class Appointment {
    private String description;
    private SDate Date;
    /**
     * Default constructor
     */
    public Appointment(){
        description = "";
        Date = new SDate();
    }
    /**
     * Constructor with description and date argument
     * @param newDescription description
     * @param NewDate date
     */
    public Appointment(String newDescription, SDate NewDate){
        description = newDescription;
        Date = NewDate;
    }
    /**
     * Constructor with description and date as int arguments
     * @param newDescription description
     * @param year year
     * @param month month
     * @param day day
     * @throws Exception if the month and day are invalid 
     */
    public Appointment(String newDescription, int year, int month, int day) throws Exception{
        description = newDescription;
        Date = new SDate(year,month,day);
    }
    /**
     * gets the description
     * @return description
     */
    public String getDescription(){
        return description;
    }
    /**
     * gets the date
     * @return date
     */
    public SDate getDate(){
        return Date;
    }
    /**
     * sets the description
     * @param newDescription the new description
     */
    public void setDescription(String newDescription){
        description = newDescription;
    }
    /**
     * sets the date
     * @param year new year
     * @param month new month
     * @param day new day
     * @throws Exception if the month and day are invalid
     */
    public void setDate(int year, int month, int day) throws Exception{
        Date.setYear(year);
        Date.setMonth(month);
        Date.setDay(day);
    }
    /**
     * prints the description and date
     */
    public void print(){
        System.out.println("Date: ");
        Date.print();
        System.out.println("\nDescription: \n" + description);
    }
    /**
     * checks if the appointment occurs on a date
     * @param year year
     * @param month month
     * @param day day
     * @return true if the appointment occurs on the date, false
     */
    public boolean occursOn(int year, int month, int day){
        return (Date.getYear() == year) && (Date.getMonth() == month) && (Date.getDay() == day);
    }
    /**
     * returns a string description of the appointment
     * @return 
     */
    @Override
    public String toString(){
        return description + " " + Date.toString();
    }
}
