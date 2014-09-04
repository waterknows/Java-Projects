/* 
Name: Joseph Park
Date: September 3, 2014
Assignment: 2, Problem 3.18
Input: User inputs the month and day in numbers
Process: Checks the month and day and finds the season associated to it
Output: Prints the season
*/
import java.util.Scanner;
public class A2P318 {
    static Scanner In = new Scanner(System.in);
//    static final int monthList[] = {31,28,31,30,31,30,31,31,30,31,30,31};
    public static void main(String[] args) {
        int month = GetMonth();
        int day = GetDay(month);
        String season = GetSeason(month,day);
        Display(month,day,season);
    }
    /**
     * Method asks user for the month and checks the input if valid
     * @param None
     * @return month The month in integer
     */
    static int GetMonth(){
        int month = 0;
        while(!CheckMonth(month)){
            System.out.print("Enter month(1 - 12): ");
            month = In.nextInt();
        }
        return month;
    }
    /**
     * Method asks user for the day and checks if it is valid (depends on the month)
     * @param month The month user input previously (dependent on GetMonth())
     * @return day The day in integer
     */
    static int GetDay(int month){
        int day = 0;
        while(!CheckDay(day,month)){
            System.out.print("Enter day(1 - 28/30/31): ");
            day = In.nextInt();
        }
        return day;
    }
    /**
     * Method checks the month if it is between 1 and 12 (The only valid months in the Gregorian calender)
     * @param month The month the user inputted in the GetMont()
     * @return  true if the month is valid, false if it is not
     */
    static boolean CheckMonth(int month){
        return month >= 1 && month <= 12;
    }
    /**
     * Method checks the day if it is valid (dependent on GetMonth() for the month)
     * @param day The day the user inputted in GetDay()
     * @param month The month the user inputted in GetMonth()
     * @return true if the day is valid, false if it is not
     */
    static boolean CheckDay(int day, int month){
        if(day >= 1){
            switch(month){ //Switch, cleaner than a massive if/else
                case 1: //Months that have 31 days
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12: {
                    if(day <= 31)
                        return true;
                    break;
                }
                case 2: { //For Feb
                    if(day <= 28)
                        return true;
                    break;
                }
                case 4: //Months that have 30 days
                case 6:
                case 9:
                case 11: {
                    if(day <= 30)
                        return true;
                    break;
                }
                default: {
                    break;
                }
            }
        }
            return false;
    }
    /**
     * Method finds the season associated with the given month and day
     * @param month the month the user inputted in GetMonth
     * @param day the day the user inputted in GetDay
     * @return The season in string 
     */
    static String GetSeason(int month, int day){
        String seasonTemp = GetSeasonPrimary(month);
        return GetSeasonSecondary(month,day,seasonTemp);
    }
    /**
     * Method Gets the season associated by month only
     * @param month The month
     * @return Season in string associated by month only
     */
    static String GetSeasonPrimary(int month){
        String seasonTemp = "";
        switch(month){ //All seasons are moved up one month (IE winter begins at 1 instead of 12) so that it can be shifted for the 21 days
            case 1: //First three months
            case 2:
            case 3: {
                seasonTemp = "Winter";
                break;
            }
            case 4:// Second three months
            case 5:
            case 6: {
                seasonTemp = "Spring";
                break;
            }
            case 7: //Third three months
            case 8:
            case 9: {
                seasonTemp = "Summer";
                break;
            }
            case 10: //Last three months
            case 11:
            case 12: {
                seasonTemp = "Fall";
                break;
            }
            default: break;
        }
        return seasonTemp;
    }
    /**
     * Method gets the true season associated by month and day (day 21 for change in season every 3 months)
     * @param month The month in integer
     * @param day The day in integer
     * @param season The season associated by month in string
     * @return The True season associated by month and day
     */
    static String GetSeasonSecondary(int month, int day, String season){
        String seasonFinal = "";
        if(month % 3 == 0 && day >= 21){ //Every three months and 21 days
            switch(season){//Moves the season by one (IE winter becomes spring, spring becomes summer, etc)
                case "Winter": { 
                    seasonFinal = "Spring";
                    break;
                }
                case "Spring": {
                    seasonFinal = "Summer";
                    break;
                }
                case "Summer": {
                    seasonFinal = "Fall";
                    break;
                }
                case "Fall": {
                    seasonFinal = "Winter";
                    break;
                }
                default: break;
            }
        }
        else
            seasonFinal = season;
        return seasonFinal;
    }
    /**
     * Method displays the month, day, and season
     * @param month The month in integer
     * @param day The day in integer
     * @param season The season in string
     * @return None
     */
    static void Display(int month, int day, String season){
        System.out.printf("Month : %d\nDay: %d\nSeason: %s\n",month,day,season);
    }
}

/*
Enter month(1 - 12): 0
Enter month(1 - 12): -1
Enter month(1 - 12): 13
Enter month(1 - 12): 2
Enter day(1 - 28/30/31): 0
Enter day(1 - 28/30/31): 29
Enter day(1 - 28/30/31): 21
Month : 2
Day: 21
Season: Winter
*/