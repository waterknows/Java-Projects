package assignments;

import java.util.Scanner;
public class A3P318 {
    static Scanner In = new Scanner(System.in);
//    static final int monthList[] = {31,28,31,30,31,30,31,31,30,31,30,31};
    public static void main(String[] args) {
        int month = GetMonth();
        int day = GetDay(month);
        String season = GetSeason(month,day);
        Display(month,day,season);
    }
    static int GetMonth(){
        int month = 0;
        while(!CheckMonth(month)){
            System.out.print("Enter month(1 - 12): ");
            month = In.nextInt();
        }
        return month;
    }
    static int GetDay(int month){
        int day = 0;
        while(!CheckDay(day,month)){
            System.out.print("Enter day(1 - 28/30/31): ");
            day = In.nextInt();
        }
        return day;
    }
    static boolean CheckMonth(int month){
        return month >= 1 && month <= 12;
    }
    static boolean CheckDay(int day, int month){
        if(day >= 1){
            switch(month){
                case 1: 
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
                case 2: {
                    if(day <= 28)
                        return true;
                    break;
                }
                case 4:
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
    static String GetSeason(int month, int day){
        String seasonTemp = GetSeasonPrimary(month,day);
        return GetSeasonSecondary(month,day,seasonTemp);
    }
    static String GetSeasonPrimary(int month, int day){
        String seasonTemp = "";
        switch(month){
            case 1:
            case 2:
            case 3: {
                seasonTemp = "Winter";
                break;
            }
            case 4:
            case 5:
            case 6: {
                seasonTemp = "Spring";
                break;
            }
            case 7:
            case 8:
            case 9: {
                seasonTemp = "Summer";
                break;
            }
            case 10:
            case 11:
            case 12: {
                seasonTemp = "Fall";
                break;
            }
            default: break;
        }
        return seasonTemp;
    }
    static String GetSeasonSecondary(int month, int day, String season){
        String seasonFinal = "";
        if(month % 3 == 0 && day >= 21){
            switch(season){
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
    static void Display(int month, int day, String season){
        System.out.printf("Month : %d\nDay: %d\nSeason: %s\n",month,day,season);
    }
}
