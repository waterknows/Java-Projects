package a1p223;
import java.util.Scanner;
public class A1P223 {
    static Scanner In = new Scanner(System.in);
    static final int PHONE_DIGITS = 10;
    public static void main(String[] args) {
        String number = GetInput();
        String numberCleaned = CleanNumber(number);
        Print(numberCleaned);
    }
    static String GetInput(){
        String number;
        while(true){
            System.out.print("Enter phone number: ");
            number = In.next();
            if(CheckInput(number))
                return number;
            System.out.print("Invalid number.");
        }
    }
    static boolean CheckInput(String value){
        return CheckInputLength(value) && CheckInputDigits(value);
    }
    static boolean CheckInputLength(String value){
        return value.length() == PHONE_DIGITS;
    }
    static boolean CheckInputDigits(String value){
        char[] numberChar = new char[PHONE_DIGITS];
        value.getChars(0, PHONE_DIGITS, numberChar, 0);
        for(int i = 0; i < PHONE_DIGITS; i++){
            if(!Character.isDigit(numberChar[i]))
                return false;
        }
        return true;
    }
    static String CleanNumber(String number){
        return "(" + number.substring(0,3) + ") " + number.substring(3,6) + "-" + number.substring(6,10);
    }
    static void Print(String numberCleaned){
        System.out.println(numberCleaned);
    }
}
