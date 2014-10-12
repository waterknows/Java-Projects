package assignment.pkg8;
public class SDate{
    private int year;
    private int month;
    private int day;
    private static final int dayList[] = {31,28,31,30,31,30,31,31,30,31,30,31};
    /**
     * Default Constructor
     */
    public SDate(){
        year = month = day = 0;
    }
    /**
     * Constructor with date as int argument
     * @param year year
     * @param month month
     * @param day day
     * @throws Exception if the month and day are invalid 
     */
    public SDate(int year, int month, int day) throws Exception{
        if(!isPositive(year) && !isPositive(month) && !isPositive(day))
            throw new Exception("Constructor Date Zero or Negative");
        if(!checkMonth(month))
            throw new Exception("Constructor Month Mismatch");
        if(!checkDay(day,month)) 
            throw new Exception("Constructor Day Mismatch") ;
        this.year = year;
        this.month = month;
        this.day = day;
    }
    /**
     * gets the year
     * @return year
     */
    public int getYear(){
        return year;
    }
    /**
     * gets the month
     * @return month
     */
    public int getMonth(){
        return month;
    }
    /**
     * gets the day
     * @return day
     */
    public int getDay(){
        return day;
    }
    /**
     * sets the year
     * @param year the year
     * @throws Exception if the year is negative
     */
    public void setYear(int year) throws Exception{
        if(!isPositive(year))
            throw new Exception("Year Zero or Negative");
        this.year = year;
    }
    /**
     * sets the month
     * @param month month
     * @throws Exception  if the month is invalid
     */
    public void setMonth(int month) throws Exception{
        if(!checkMonth(month))
            throw new Exception("Month Out of Bounds");
        if(!isPositive(month))
            throw new Exception("Month Zero or Negative");
        this.month = month;
    }
    /**
     * sets the day
     * @param day day
     * @throws Exception if the day is invalid 
     */
    public void setDay(int day) throws Exception{
        if(!checkDay(day,this.month))
            throw new Exception("Day Out of Bounds");
        if(!isPositive(day))
            throw new Exception("Day Zero or Negative");
        this.day = day;
    }
    /**
     * Gets the day of the week
     * @return the day
     */ //unfinished
    public String getDayOfWeek(){
        return "";
    }
    /**
     * gets the number of days since jan 1 1900
     * @return days since
     */
    public int daysSince(){
        int years = year - 1900 - 1;
        int days = (int)(years * 365.25);
        for(int i = 0; i < month - 2; i++)
            days += getNumberOfDays(i);
        days += day;
        return days;
    }
    /**
     * prints
     */
    public void print(){
        System.out.print(month + "/" + day + "/" + year);
    }
    /**
     * gets the string description
     * @return 
     */
    @Override
    public String toString(){
        return month + "/" + day + "/" + year;
    }
    /**
     * checks if is positive
     * @param number
     * @return true for is positive
     */
    private boolean isPositive(int number){
        return number > 0;
    }
    /**
     * checks the day
     * @param day day
     * @param month month
     * @return true if is valid
     */
    private boolean checkDay(int day, int month){
        return isPositive(day) && day <= getNumberOfDays(month);
    }
    /**
     * checks the month
     * @param month month
     * @return true if is valid
     */
    private boolean checkMonth(int month){
        return isPositive(month) && month <= 12;
    }
    /**
     * gets the number of days in month
     * @param month month
     * @return number of days
     */
    private int getNumberOfDays(int month){
        return dayList[month - 1];
    }
    
}