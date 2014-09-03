package assignments;
import java.util.Scanner;
public class A3P322 {
    static Scanner In = new Scanner(System.in);
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
    static final double LOW_TAXRATE_S = 10.0;
    static final double MID_TAXRATE_S = 15.0;
    static final double HIGH_TAXRATE_S = 25.0;
    static final double LOW_TAXRATE_M = 10.0;
    static final double MID_TAXRATE_M = 15.0;
    static final double HIGH_TAXRATE_M = 25.0;
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
    static int GetStatus(){
        int status = -1;
        while(!CheckStatus(status)){
            System.out.print("Enter marital status.\n(1) For Single\n(2) For Married.\n");
            status = In.nextInt();
        }
        return status;
    }
    static boolean CheckStatus(int status){
        return status == 1 || status == 2;
    }
    static double GetIncome(){
        double income = -1;
        while(!CheckIncome(income)){
            System.out.print("Enter taxable income: ");
            income = In.nextDouble();
        }
        return income;
    }
    static boolean CheckIncome(double income){
        return income >= 0.0;
    }
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
    static double CalculateTax(double taxRate, double amountTaxed, double amountAdded){
        return ((taxRate / 100.0) * amountTaxed) + amountAdded;
    }
    static String ConvertStatus(int status){
        return status == 1 ? "Single" : "Married";
    }
    static void Display(int status, double income, double tax){
        System.out.printf("Your status is %s.\nYour taxable income is $%.2f.\nYour income tax is $%.2f.\n",ConvertStatus(status),income,tax);
    }
}

