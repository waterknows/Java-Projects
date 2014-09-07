/*
Name: Joseph Park
Date: September 5, 2014
Assignment: 4, Problem 5.18
Input: User inputs an integer
Process: Calculates the number of digits in the integer
Output: Outputs the number of digits
*/
import java.util.Scanner;
public class A4P518 {
    public static void main(String[] args) {
        int integer = getInputInt(0,2147483647);
        int digits = getDigit(integer);
        System.out.println("Digits: " + digits);
    }
        /**
     * Method asks user for integer input between min and max
     * @param min min value
     * @param max max value
     * @return the input
     */
    public static int getInputInt(int min, int max){
        Scanner Input = new Scanner(System.in); //Scanner for input stream
        boolean endInput = false; 
        int input = 0;
        while(!endInput){ //master loop for controlling input
            System.out.println("Enter:");
            input = Input.nextInt();
            if(!isNegativeInt(input) && isBetweenInt(input,min,max))
                endInput = true; //Check if the input is valid
        }
        return input;
    }
    /**
     * Method checks an integer if it is negative
     * @param integer the integer
     * @return True for negative, False for positive
     */
    public static boolean isNegativeInt(int integer){
        return integer < 0;
    }
    /**
     * Method checks an integer if it is between min and max
     * @param integer the integer
     * @param min the min value
     * @param max the max value
     * @return True if it is between min and max, False if it is not
     */
    public static boolean isBetweenInt(int integer, int min, int max){
        return integer >= min && integer <= max;
    }
    /**
     * recursive method counts how many digits an integer has
     * @param integer
     * @return number of digits
     */
    public static int getDigit(int integer){
        if(integer < 10)
            return 1;
        else
            return getDigit(integer / 10) + 1;
    }
}
