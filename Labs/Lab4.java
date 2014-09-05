/*
Name: Joseph Park & Josue Segura, Group 8
Date: September 4, 2014
Input: User inputs a zip code
Process: Converts zip code to bar code & calculates check digit
Output: Prints the barcode and zipcode
*/
package lab4;
import java.util.Scanner;
public class Lab4 {
    static final int ZIP_MIN = 0;
    static final int ZIP_MAX = 99999;
    public static void main(String[] args) {
        int zip = getInput(ZIP_MIN,ZIP_MAX);
        int[][] digitList = new int[6][6];
        placeDigits(digitList, zip, 6);
        placeBarCode(digitList,6,6);
        printDigit(digitList,6,6);
        printBarCode(digitList,6,6);
    }
    /**
     * Asks user for input between min and max
     * @param min min input
     * @param max max input
     * @return the input
     */
    public static int getInput(int min, int max){
        Scanner In = new Scanner(System.in);
        int input = 0;
        boolean endInput = false;
        while(!endInput){
            System.out.println("Enter: ");
            input = In.nextInt();
            if(checkInput(input,min,max))
                endInput = true;
        }
        In.close();
        return input;
    }
    /**
     * Checks input
     * @param input 
     * @param min the minimum value
     * @param max the maximum value
     * @return true for valid, false for not valid
     */
    public static boolean checkInput(int input, int min, int max){
        return input >= min && input <= max;
    }
    /**
     * converts the first digit place to a digit
     * @param integer the integer
     * @param digitPlace the digit place
     * @return the digit at the digit place
     */
    public static int convertFirstDigit(int integer, int digitPlace){
        return integer / digitPlace;
    }
    /**
     * places all of the digits into the masterlist
     * @param masterList the master array
     * @param integer the zip
     * @param size the size of the rows
     */
    public static void placeDigits(int[][] masterList, int integer, int size){
        int integerTemp = integer;
        int digitPlace = (int)Math.pow(10,size - 2);
        for(int i = 0; i < size - 1; i++){
            masterList[i][0] = convertFirstDigit(integerTemp,digitPlace);
            integerTemp -= masterList[i][0] * digitPlace;
            digitPlace /= 10;
        }
        masterList[size - 1][0] = getCheckDigit(masterList, size);
    }
    /**
     * places the bar code array into the master list
     * @param masterList the master array
     * @param rowSize the row size
     * @param colSize  the column size
     */
    public static void placeBarCode(int[][] masterList, int rowSize, int colSize){
        int[] tempArray;
        for(int i = 0; i < rowSize; i++){
            tempArray = convertDigitToBar(masterList[i][0]);
            System.arraycopy(tempArray,0,masterList[i],1,5);
        }
    }
    /**
     * converts a digit to barcode
     * @param digit the digit to be converted
     * @return an array for barcode
     */
    public static int[] convertDigitToBar(int digit){
        int[] barCode = {0,0,0,0,0};
        int digitTemp = digit;
        if(digitTemp == 0){
            barCode[0] = 1;
            barCode[1] = 1;
        }
        while(digitTemp != 0){
            if(digitTemp >= 7){
                barCode[0] = 1;
                digitTemp -= 7;
            }
            else if(digitTemp >= 4){
                barCode[1] = 1;
                digitTemp -= 4;
            }
            else if(digitTemp >= 2){
                barCode[2] = 1;
                digitTemp -= 2;
            }
            else if(digitTemp == 1){
                barCode[3] = 1;
                digitTemp -= 1;
            }
        }
        if(digit == 7 || digit == 4 || digit == 2 || digit == 1)
            barCode[4] = 1;
        return barCode;
    }
    /**
     * prints the digits and the bar code code
     * @param masterList the master array
     * @param rowSize row size
     * @param colSize column size
     */
    public static void printDigit(int[][] masterList, int rowSize, int colSize){
        for(int i = 0; i < rowSize ; i++){
            for(int j= 0 ; j < colSize; j++){
                System.out.print(masterList[i][j] + " ");
            }
            System.out.println();
        }
    }
    /**
     * gets the check digit
     * @param masterList the master array
     * @param rowSize the row size
     * @return the check digit
     */
    public static int getCheckDigit(int[][] masterList, int rowSize){
        int sum = 0;
        for(int i = 0; i < rowSize; i++){
            sum += masterList[i][0];
        }
        return 10 - (sum % 10);
    }
    /**
     * prints the barcode
     * @param masterList
     * @param rowSize
     * @param colSize 
     */
    public static void printBarCode(int[][] masterList, int rowSize, int colSize){
        System.out.print("|");
        for(int i = 0; i < rowSize; i++){
            for(int j = 1; j < colSize; j++){
                if(masterList[i][j] == 1)
                    System.out.print("|");
                else if(masterList[i][j] == 0)
                    System.out.print(":");
            }
        }
        System.out.print("|");
    }
    
}
/*
Enter: 
95014
9 1 0 1 0 0 
5 0 1 0 1 0 
0 1 1 0 0 0 
1 0 0 0 1 1 
4 0 1 0 0 1 
1 0 0 0 1 1 
||:|:::|:|:||::::::||:|::|:::|||
*/