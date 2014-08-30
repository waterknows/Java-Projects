/* 
Name: Joseph Park
Date: August 29, 2014
Assignment: 1, Problem 2.25
Input: User inputs the amount due and the amount received at a cash register
Process: The change is separated into dollars, quarters, dimes, nickels, and pennies
Output: The amount of each currency type is printed
*/
import java.util.Scanner;
public class A1P225 {
    static Scanner In = new Scanner(System.in);
    static final int DOLLARS = 100; //Constants for the value of each type in pennies
    static final int QUARTERS = 25;
    static final int DIMES = 10;
    static final int NICKELS = 5;
    static final int PENNIES = 1;
    static final int MAX_TYPE = 5; //The number of types (excludes half-dollars and anything above dollar
    static final int CONVERSION = 100; //Conversion factor for changing from $a.bc notation to abc
    static final String[] moneyNameList = {"Dollar", "Quarter", "Dime", "Nickel", "Penny"}; //List of the names of the types
    static final int[] moneyTypeList = {DOLLARS, QUARTERS, DIMES, NICKELS, PENNIES}; //List of the values of each type
    public static void main(String[] args) {
        double due = GetAmountDue();
        double received;
        while(true){ //Loop checks if the amount recieved is less than the amount due
            received = GetAmountReceived();
            if(Math.max(due, received) == received)
                break;
            System.out.printf("You are short $%.2f\n", due - received); 
        }
        int change = CalculateChange(ConvertToPennies(due),ConvertToPennies(received));
        int[] moneyList = CalculateChangePerType(change);
        Print(moneyList);
    }//Asks user for the amount due and returns it
    static double GetAmountDue(){
        return Input("Due");
    }//Asks user for the amount received and returns it
    static double GetAmountReceived(){
        return Input("Received");
    }//The more general input function
    static double Input(String type){
        double input;
        while(true){
            System.out.printf("Enter amount %s: ",type);
            input = In.nextDouble();
            if(CheckInput(input))
                return input;
            System.out.print("Invalid amount.\n");
        }
    }//Input validation
    static boolean CheckInput(double input){
        return !IsNegative(input);
//                && CheckPrecision(input); 
    }//Checks if the inputs are negative
    static boolean IsNegative(double value){
        return value < 0.0;
    }//Checks the precision of the inputs (how many digits past the decimal point) NOTE: Currently does not function correctly
//    static boolean CheckPrecision(double value){
//        return (((int)(value * CONVERSION * CONVERSION)) / CONVERSION) % 1 == 0;
//    }
    //Converts the amount to pennies
    static int ConvertToPennies(double amount){
        return (int)(amount * CONVERSION);
    }//Updates the amount after checking each money type
    static int UpdateAmount(int amount, int moneyAmount, int moneyFactor){
        return amount - (moneyAmount * moneyFactor);
    }//Calculates how much of a money type is required for the change
    static int CalculateMoneyType(int amount, int moneyFactor){
        return amount / moneyFactor;
    }//Calculates how much change is required
    static int CalculateChange(int amountDue, int amountReceived){
        return amountReceived - amountDue;
    }//Calculates the amount of each money type for the change
    static int[] CalculateChangePerType(int amount){
        int[] moneyList = new int[MAX_TYPE];
        for(int i = 0; i < MAX_TYPE; i++){
            moneyList[i] = CalculateMoneyType(amount,moneyTypeList[i]);
            amount = UpdateAmount(amount,moneyList[i],moneyTypeList[i]);
        }
        return moneyList;
    }//Prints the amount of each money type
    static void Print(int[] moneyList){
        for(int i = 0; i < MAX_TYPE; i++){
            System.out.printf("%d %s(s)\n",moneyList[i],moneyNameList[i]);
        }
    }
}

/*
Enter amount Due: -1.23
Invalid amount.
Enter amount Due: 1.19
Enter amount Received: 1.03
You are short $0.16
Enter amount Received: 0.00
You are short $1.19
Enter amount Received: 7.67
6 Dollar(s)
1 Quarter(s)
2 Dime(s)
0 Nickel(s)
3 Penny(s)
*/