package assignment.pkg8;

public class OneTime extends Appointment{
    /**
     * Constructor with description and date as int arguments
     * @param description description
     * @param year year
     * @param month month
     * @param day day
     * @throws Exception if the month and day are invalid 
     */
    public OneTime(String description, int year, int month, int day) throws Exception{
        super(description,year,month,day);
    }
    /**
     * Constructor with description and date arguments
     * @param description description
     * @param Date  date
     */
    public OneTime(String description, SDate Date){
        super(description,Date);
    }
}