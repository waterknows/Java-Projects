package a1p225;
import java.util.Scanner;
public class A1P225 {
    static Scanner In = new Scanner(System.in);
    static final int DOLLARS = 100;
    static final int QUARTERS = 25;
    static final int DIMES = 10;
    static final int NICKELS = 5;
    static final int PENNIES = 1;
    static final int MAX_TYPE = 5;
    static final int CONVERSION = 100;
    static final String[] moneyNameList = {"Dollar", "Quarter", "Dime", "Nickel", "Penny"};
    static final int[] moneyTypeList = {DOLLARS, QUARTERS, DIMES, NICKELS, PENNIES};
    public static void main(String[] args) {
        double due = GetAmountDue();
        double received;
        while(true){
            received = GetAmountReceived();
            if(Math.max(due, received) == received)
                break;
            System.out.printf("You are short $%.2f\n", due - received);
        }
        int change = CalculateChange(ConvertToPennies(due),ConvertToPennies(received));
        int[] moneyList = CalculateChangePerType(change);
        Print(moneyList);
    }
    static double GetAmountDue(){
        return Input("Due");
    }
    static double GetAmountReceived(){
        return Input("Received");
    }
    static double Input(String type){
        double input;
        while(true){
            System.out.printf("Enter amount %s: ",type);
            input = In.nextDouble();
            if(CheckInput(input))
                return input;
            System.out.print("Invalid amount.\n");
        }
    }
    static boolean CheckInput(double input){
        return !IsNegative(input) && CheckPrecision(input); 
    }
    static boolean IsNegative(double value){
        return value < 0.0;
    }
    static boolean CheckPrecision(double value){
        return (((int)(value * CONVERSION * CONVERSION)) / CONVERSION) % 1 == 0;
    }
    static int ConvertToPennies(double amount){
        return (int)(amount * CONVERSION);
    }
    static int UpdateAmount(int amount, int moneyAmount, int moneyFactor){
        return amount - (moneyAmount * moneyFactor);
    }
    static int CalculateMoneyType(int amount, int moneyFactor){
        return amount / moneyFactor;
    }
    static int CalculateChange(int amountDue, int amountReceived){
        return amountReceived - amountDue;
    }
    static int[] CalculateChangePerType(int amount){
        int[] moneyList = new int[MAX_TYPE];
        for(int i = 0; i < MAX_TYPE; i++){
            moneyList[i] = CalculateMoneyType(amount,moneyTypeList[i]);
            amount = UpdateAmount(amount,moneyList[i],moneyTypeList[i]);
        }
        return moneyList;
    }
    static void Print(int[] moneyList){
        for(int i = 0; i < MAX_TYPE; i++){
            System.out.printf("%d %s(s)\n",moneyList[i],moneyNameList[i]);
        }
    }
}
