/*
Name: Joseph Park
Date: September 5, 2014
Assignment: 3, Problem 4.32
Input: User inputs credit card number
Process: Calculates whether it is valid or not
Output: Prints whether it is valid or not. Prints a valid check digit if it is not valid
*/
import java.util.Scanner;
public class A3P432 {
    private static final int INPUT_MIN = 0;
    private static final int INPUT_MAX = 99999999;
    private static final int SIZE = 8;
    
    public static void main(String[] args) {
        
        int ccNum = getInputInt(INPUT_MIN,INPUT_MAX);       
        int[] ccNumArray = separateIntToArray(ccNum);
        int isValid = isValidCard(ccNumArray);
        print(ccNumArray,isValid);
    
//        int[] ccNumArray;
//        int isValid, ccNum;
//        for(int i = 10001000; i <= 10001100; i++){
//            ccNum = i;
//            System.out.println("Num: " + i);
//            ccNumArray = separateIntToArray(ccNum);
//            isValid = isValidCard(ccNumArray);
//            
//            if(isValid == -1)
//                System.out.println("Valid");
//            else
//                System.out.println("New Check Digit: " + isValid);
//        }
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
     * Method separates an integer into an integer array of its digits
     * @param integer the integer to be separated
     * @return the integer array of digits
     */
    public static int[] separateIntToArray(int integer){
        int intTemp = integer;
        int numOfDigits = getNumOfDigitsInt(integer);
        int digitPlace = (int)Math.pow(10,numOfDigits - 1);
        int[] intArray = createArrayInt(SIZE);
        int n = 0;
        while(numOfDigits < SIZE){ //Fills in missing zeroes at the beginning
            intArray[n] = 0;
            n++;
            numOfDigits++;
        }
        for(int i = n; i < SIZE; i++){ //Separates the digits and places them in the array
            intArray[i] = intTemp / digitPlace; //Will return the leftmost digit
            intTemp -= intArray[i] * digitPlace; //Subtract that digit place
            digitPlace /= 10; //Move down the digit place 
        }
        return intArray;
    }
    /**
     * Method creates and initializes an int array of size with 0's
     * @param size the size of the array
     * @return the array of 0's
     */
    public static int[] createArrayInt(int size){
        int[] array = new int[size];
        for(int i = 0; i < size; i++){
            array[i] = 0;
        }
        return array;
    }
    /**
     * Method gets the number of digits in an integer
     * @param integer the integer 
     * @return the number of digits 
     */
    public static int getNumOfDigitsInt(int integer){
        int numOfDigits = 0;
        int digitPlace = 1;
        boolean endDigitCheck = false;
        while(!endDigitCheck){ 
            if(integer / digitPlace == 0) //If the digit place exceeds the highest digit place
                endDigitCheck = true;
            else{
                numOfDigits++;
                digitPlace *= 10;
            }
        }
        return numOfDigits;
    }
    /**
     * Method gets the size of an integer array
     * @param intArray the integer array
     * @return the size
     */
    public static int getSize(int[] intArray){
        int size = 0;
        for(int i : intArray){
            size++;
        }
        return size;
    }
    /**
     * Determines if the credit card number is valid
     * @param ccArray the credit card number array
     * @return True for valid, False for not valid
     */
    public static int isValidCard(int[] ccArray){
       int sumOfEveryOtherR = sumEveryOtherByMultipleReversed(ccArray,1);
       int doubledSumOfEveryOther = sumEveryOtherByMultiple(ccArray,2);
       int finalSum = sumOfEveryOtherR + doubledSumOfEveryOther;
       int size = getSize(ccArray);
       if(lastDigitIsZero(finalSum))
           return -1;
       else
           return getValidCheckDigit(finalSum,ccArray[size - 1]);
    }
   /**
    * Method gets the sum of every other integer in the array, starting from the end
    * @param intArray the integer array
    * @param multiple the multiple to be applied
    * @return the sum
    */
    public static int sumEveryOtherByMultipleReversed(int[] intArray, int multiple){
       int size = getSize(intArray);
       boolean skip = false;
       int sum = 0;
       for(int i = size - 1; i >= 0; i--){ //Begins reversed
           if(!skip){ //Skips every other digit
               if(intArray[i] * multiple >= 10) //If the integer is no longer a digit, its digits are added together
                   sum += ((intArray[i] * multiple) / 10) + ((intArray[i] * multiple) % 10);
               else
                   sum += intArray[i] * multiple;
               skip = true;
           }
           else
               skip = false;
       }
       return sum;
    }
    /**
     * Sums multiple of the every other integer in the array
     * @param intArray
     * @param multiple
     * @return the sum
     */
    public static int sumEveryOtherByMultiple(int[] intArray, int multiple){
       int size = getSize(intArray);
       boolean skip = false;
       int sum = 0;
       for(int i = 0; i < size; i++){ //Same as the reversed, but no longer reversed
           if(!skip){
               if(intArray[i] * multiple >= 10)
                   sum += ((intArray[i] * multiple) / 10) + ((intArray[i] * multiple) % 10);
               else
                   sum += intArray[i] * multiple;
               skip = true;
           }
           else
               skip = false;
       }
       return sum;
    }
    /**
     * checks if the last digit is zero
     * @param integer
     * @return True if the last digit is zero, False if not
     */
    public static boolean lastDigitIsZero(int integer){
        return integer % 10 == 0;
    }
    /**
     * gets a valid check digit based on the rest of the cc digits
     * @param finalSum the final sum in the validity calculation
     * @param checkDigit the original check digit
     * @return the closest check digits that is valid
     */
    public static int getValidCheckDigit(int finalSum, int checkDigit){
        int diff = finalSum % 10;
//        System.out.println(finalSum);
//        System.out.println(diff);
//        System.out.println(checkDigit);
        if(checkDigit - diff >= 0) //If it will stay positive, move it down
            return checkDigit - diff;
        else //If it will be negative, then move it up
            return checkDigit + (10 - diff);

    }
    /**
     * prints the cc num and the new check digit if not valid
     * @param intArray
     * @param checkDigit 
     */
    public static void print(int[] intArray, int checkDigit){
        for(int i : intArray){
            System.out.print(i);
        }
        System.out.println();
        if(checkDigit == -1)
            System.out.println("Valid.");
        else
            System.out.println("New Check Digit: " + checkDigit);
    }
}
/*
Enter:
-1
Enter:
11231231
11231231
New Check Digit: 0

Enter:
12345674
12345674
Valid.

Enter:
2346
00002346
New Check Digit: 5
*/