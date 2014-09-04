/* 
Name: Joseph Park
Date: September 3, 2014
Assignment: 2, Problem 3.32
Input: User inputs his/her PIN
Process: Checks the PIN against stored PIN
Output: Ends the program if correct. If not, asks the user three more times before closing
*/
import java.util.Scanner;
public class A2P332 {
    static Scanner In = new Scanner(System.in);
    static final int ACTUAL_PIN = 1234;
    static final int MAX_ATTEMPTS = 3;
    public static void main(String[] args) {
        SimulateATM();
    }
    /**
     * Simulates the ATM PIN entering by asking for the PIn and checking if it is valid
     * @return 
     */
    static int SimulateATM(){
        int numOfTries = MAX_ATTEMPTS;
        int PIN;
        while(numOfTries > 0){ //If the number of tries is more than 0
            PIN = GetPIN();    //Asks user for PIN
            if(CheckPIN(PIN)){
                System.out.println("Your PIN is corret.");
                return 1; 
            }
            else{ //Decrements the number of tries
                numOfTries--;
                System.out.printf("Your PIN is incorrect. You have %d attempt(s) remaining.\n",numOfTries);
            }
        }
        System.out.println("Your bank card is blocked.");
        return 0;
    }
    /**
     * Asks user for PIN
     * @return 
     */
    static int GetPIN(){
        System.out.println("Enter your PIN.");
        return In.nextInt();
    }
    /**
     * Checks against the stored PIN to check if it is correct
     * @param PIN
     * @return true for correct, false for incorrect
     */
    static boolean CheckPIN(int PIN){
        return PIN == ACTUAL_PIN;
    }
}

/*
Enter your PIN.
-1
Your PIN is incorrect. You have 2 attempt(s) remaining.
Enter your PIN.
111111
Your PIN is incorrect. You have 1 attempt(s) remaining.
Enter your PIN.
10000
Your PIN is incorrect. You have 0 attempt(s) remaining.
Your bank card is blocked.

Enter your PIN.
1234
Your PIN is corret.
*/