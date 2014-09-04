/* 
Name: Joseph Park
Date: September 3, 2014
Assignment: 2, Problem 3.22
Input: User inputs marital status and income
Process: Checks the status and income and calculates the tax
Output: Prints the tax required
*/
import java.util.Scanner;
public class A2P322 {
    static Scanner In = new Scanner(System.in);
    //Constants for the income ranges for each bracket (low, mid, high) for both single and married
    static final double LOW_MIN_S = 0.0;
    static final double LOW_MAX_S = 8000.0;
    static final double MID_MIN_S = 8000.0;
    static final double MID_MAX_S = 32000.0;
    static final double HIGH_MIN_S = 32000.0;
    static final double LOW_MIN_M = 0.0;
    static final double LOW_MAX_M = 16000.0;
    static final double MID_MIN_M = 16000.0;
    static final double MID_MAX_M = 64000.0;
    static final double HIGH_MIN_M = 64000.0;
    //Tax rate for each bracket per status
    static final double LOW_TAXRATE_S = 10.0;
    static final double MID_TAXRATE_S = 15.0;
    static final double HIGH_TAXRATE_S = 25.0;
    static final double LOW_TAXRATE_M = 10.0;
    static final double MID_TAXRATE_M = 15.0;
    static final double HIGH_TAXRATE_M = 25.0;
    //Additional amount added to tax for each bracket per status
    static final double LOW_ADD_S = 0.0;
    static final double MID_ADD_S = 800.0;
    static final double HIGH_ADD_S = 4400.0;
    static final double LOW_ADD_M = 0.0;
    static final double MID_ADD_M = 1600.0;
    static final double HIGH_ADD_M = 8800.0;
    public static void main(String[] args) {
        int status = GetStatus();
        double income = GetIncome();
        double tax = GetTax(status,income);
        Display(status,income,tax);
    }
    /**
     * Gets the status from user and checks it
     * @return the status 1 for single, 2 for married
     */
    static int GetStatus(){
        int status = -1;
        while(!CheckStatus(status)){
            System.out.print("Enter marital status.\n(1) For Single\n(2) For Married.\n");
            status = In.nextInt();
        }
        return status;
    }
    /**
     * Checks the status for validity
     * @param status the status should be 1 or 2
     * @return true for valid, false for not
     */
    static boolean CheckStatus(int status){
        return status == 1 || status == 2;
    }
    /**
     * Gets the income from user (has to be positive)
     * @return income from the user
     */
    static double GetIncome(){
        double income = -1;
        while(!CheckIncome(income)){
            System.out.print("Enter taxable income: ");
            income = In.nextDouble();
        }
        return income;
    }
    /**
     * Checks if the income is positive
     * @param income >= 0
     * @return true for valid, false for not
     */
    static boolean CheckIncome(double income){
        return income >= 0.0;
    }
    /**
     * Calculates the tax based on the status and income
     * @param status marital status
     * @param income taxable income
     * @return tax the tax calculated from status and income
     */
    static double GetTax(int status, double income){
        double tax = -1;
        if(status == 1){
            if(income >= LOW_MIN_S && income <= LOW_MAX_S){
                tax = CalculateTax(LOW_TAXRATE_S,LOW_MIN_S,LOW_ADD_S);
            }
            else if(income > MID_MIN_S && income <= MID_MAX_S){
                tax = CalculateTax(MID_TAXRATE_S,MID_MIN_S,MID_ADD_S);
            }
            else if(income > HIGH_MIN_S){
                tax = CalculateTax(HIGH_TAXRATE_S,HIGH_MIN_S,HIGH_ADD_S);
            }
        }
        else if(status == 2){
            if(income >= LOW_MIN_M && income <= LOW_MAX_M){
                tax = CalculateTax(LOW_TAXRATE_M,LOW_MIN_M,LOW_ADD_M);
            }
            else if(income > MID_MIN_M && income <= MID_MAX_M){
                tax = CalculateTax(MID_TAXRATE_M,MID_MIN_M,MID_ADD_M);
            }
            else if(income > HIGH_MIN_M){
                tax = CalculateTax(HIGH_TAXRATE_M,HIGH_MIN_M,HIGH_ADD_M);
            }            
        }
        return tax;
    }
    /**
     * Calculates the tax based on tax rate; income
     * @param taxRate the tax rate based on status and income
     * @param amountTaxed the amount taxed (lower bracket on income)
     * @param amountAdded the amount added to the tax
     * @return returns the tax 
     */
    static double CalculateTax(double taxRate, double amountTaxed, double amountAdded){
        return ((taxRate / 100.0) * amountTaxed) + amountAdded;
    }
    /**
     * Converts the status from integer to string to be outputted
     * @param status the integer form of status
     * @return the string form of status
     */
    static String ConvertStatus(int status){
        return status == 1 ? "Single" : "Married";
    }
    /**
     * Displays the status, income, and tax
     * @param status the status in string
     * @param income the income 
     * @param tax the tax
     */
    static void Display(int status, double income, double tax){
        System.out.printf("Your status is %s.\nYour taxable income is $%.2f.\nYour income tax is $%.2f.\n",ConvertStatus(status),income,tax);
    }
}

/*
Enter marital status.
(1) For Single
(2) For Married.
1
Enter taxable income: 0
Your status is Single.
Your taxable income is $0.00.
Your income tax is $0.00.

Enter marital status.
(1) For Single
(2) For Married.
0
Enter marital status.
(1) For Single
(2) For Married.
4
Enter marital status.
(1) For Single
(2) For Married.
2
Enter taxable income: -111
Enter taxable income: 16001
Your status is Married.
Your taxable income is $16001.00.
Your income tax is $4000.00.
*/