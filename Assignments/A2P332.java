package assignments;
import java.util.Scanner;
public class A3P332 {
    static Scanner In = new Scanner(System.in);
    static final int ACTUAL_PIN = 1234;
    static final int MAX_ATTEMPTS = 3;
    public static void main(String[] args) {
        SimulateATM();
    }
    static int SimulateATM(){
        int numOfTries = MAX_ATTEMPTS;
        int PIN;
        while(numOfTries > 0){
            PIN = GetPIN();    
            if(CheckPIN(PIN)){
                System.out.println("Your PIN is corret.");
                return 1;
            }
            else{
                numOfTries--;
                System.out.printf("Your PIN is incorrect. You have %d attempt(s) remaining.\n",numOfTries);
            }
        }
        System.out.println("Your bank card is blocked.");
        return 0;
    }
    static int GetPIN(){
        System.out.println("Enter your PIN.");
        return In.nextInt();
    }
    static boolean CheckPIN(int PIN){
        return PIN == ACTUAL_PIN;
    }
}
