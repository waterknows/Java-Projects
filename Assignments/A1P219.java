/* 
Name: Joseph Park
Date: August 29, 2014
Assignment: 1, Problem 2.19
Input: User inputs the number of a month
Process: The number is checked against an array of all of the months, and is matched with the name of the month
Output: The name of the month is printed
*/
import java.util.Scanner;
public class A1P219 {
    static Scanner In = new Scanner(System.in);
    static final String[] monthList = {"January","February","March","April","May","June","July","August","September",
                                   "October","November","December"};
    public static void main(String[] args) {
        int monthNum = GetInput();
        String month = GetMonth(monthNum);
        Print(month);
    }//Asks for input and returns it
    static int GetInput(){
        int month;
        while(true){ //Loop that continuously asks for valid input
            System.out.print("Enter the month in number: ");
            month = In.nextInt();
            if(CheckInput(month))
                return month;
            System.out.print("Invalid month.\n");
        }
    }//Checks if the input is between 1 and 12
    static boolean CheckInput(int value){
        return value <= 12 && value >= 1;
    }//Checks against the month list and returns the name of the matching month
    static String GetMonth(int monthNum){
        return monthList[monthNum - 1];
    }//Prints the name of the month
    static void Print(String month){
        System.out.println(month);
    }
}

/*
Enter the month in number: 0
Invalid month.
Enter the month in number: 13
Invalid month.
Enter the month in number: -1
Invalid month.
Enter the month in number: 7
July
*/