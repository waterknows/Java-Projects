/* 
Name: Joseph Park
Date: August 29, 2014
Assignment: 1, Problem 2.23
Input: User inputs a phone number i.e. 6262230090
Process: The phone number is cleaned to look like this i.e. (626) 223-0090
Output: The cleaned phone number is printed
*/
import java.util.Scanner;
public class A1P223 {
    static Scanner In = new Scanner(System.in);
    static final int PHONE_DIGITS = 10; //Number of digits in a phone number (not including paranthesis or hyphen)
    public static void main(String[] args) {
        String number = GetInput();
        String numberCleaned = CleanNumber(number);
        Print(numberCleaned);
    }//Asks user for input and returns it. There is a loop for input validation
    static String GetInput(){
        String number;
        while(true){
            System.out.print("Enter phone number: ");
            number = In.next();
            if(CheckInput(number))
                return number;
            System.out.println("Invalid number.");
        }
    }//Checks input 
    static boolean CheckInput(String value){
        return CheckInputLength(value) && CheckInputDigits(value);
    }//Checks if input is correct length (10 digits)
    static boolean CheckInputLength(String value){
        return value.length() == PHONE_DIGITS;
    }//Checks if the input is all numbers (no other characters)
    static boolean CheckInputDigits(String value){
        char[] numberChar = new char[PHONE_DIGITS];
        value.getChars(0, PHONE_DIGITS, numberChar, 0);
        for(int i = 0; i < PHONE_DIGITS; i++){
            if(!Character.isDigit(numberChar[i]))
                return false;
        }
        return true;
    }//Cleans the phone number. Surrounds the first three digits with paranthesis adds a space afer it,
     //and a hyphen between digits 4-6 and the last four digits
    static String CleanNumber(String number){
        return "(" + number.substring(0,3) + ") " + number.substring(3,6) + "-" + number.substring(6,10);
    }//Prints the cleaned phone number
    static void Print(String numberCleaned){
        System.out.println(numberCleaned);
    }
}

/*
Enter phone number: 1523523513413432535235
Invalid number.
Enter phone number: 123124abefufhuoie/3poifh3
Invalid number.
Enter phone number: abcdefgh
Invalid number.
Enter phone number: 1010001111
(101) 000-1111
*/