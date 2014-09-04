/*
Name: Joseph Park
Date: September 5, 2014
Assignment: 3, Problem 4.20
Input: User inputs the length of a side of a cube
Process: None
Output: Prints a solid square of length and a hollow square of length
*/

import java.util.Scanner;
public class A3P420 {
    static Scanner In = new Scanner(System.in);
    public static void main(String[] args) {
        int sideLength = GetInputInt();
        DisplaySolidSquare(sideLength);
        System.out.println();
        DisplayHollowSquare(sideLength);
    }
    /**
     * Method asks user for an integer input that is positive 
     * @return input once it is valid
     */
    static int GetInputInt(){
        boolean inputIsValid = false; //Set valid to false
        int input = 0; //Initialize input to zero
        while(!inputIsValid){ //while the input is not valid
            System.out.println("Enter an integer:");
            input = In.nextInt();
            if(!IsNegative(input)) //Check if the input is positive
                inputIsValid = true;
        }
        return input;
    }
    /**
     * Method checks an integer if it is negative
     * @param integer any integer
     * @return true if integer is negative, false if it is zero or positive
     */
    static boolean IsNegative(int integer){
        return integer < 0;
    }
    /**
     * Method prints a solid square of length with *
     * @param length The length of the solid square
     */
    static void DisplaySolidSquare(int length){
        for(int i = 1; i <= length; i++){
            for(int j = 1; j <= length; j++){
                System.out.print("* ");
            }
            System.out.println("");
        }
    }
    /**
     * Method prints a hollow square of length with *
     * @param length The length of the side
     */
    static void DisplayHollowSquare(int length){
        for(int i = 1; i <= length; i++){
            for(int j = 1; j <= length; j++){
                if(i == 1 || i == length)
                    System.out.print("* ");
                else if(j == 1)
                    System.out.print("* ");
                else if(j == length)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println("");
        }
    }
}

/*
Enter an integer:
-1
Enter an integer:
5
* * * * * 
* * * * * 
* * * * * 
* * * * * 
* * * * * 

* * * * * 
*       * 
*       * 
*       * 
* * * * * 
*/