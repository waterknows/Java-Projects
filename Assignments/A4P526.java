/*
Name: Joseph Park
Date: September 5, 2014
Assignment: 4, Problem 5.26
Input: User inputs a bar code string
Process: Converts the bar code into a zip code
Output: Outputs the zip code
*/
import java.util.Scanner;
public class A4P526 {
    static final int BAR_CODE_LENGTH = 32; //total length of the bar code
    static final int BAR_NUMBER = 6; //number of bars that represent a digit (5 digits for zip code + 1 check digit)
    static final int BAR_LENGTH = 5; //length of each bar that represents a digit
    static final char FULL_BAR = '|'; //char symbol for a full bar (1)
    static final char HALF_BAR = ':'; //char symbol for a half bar (0)
    
    public static void main(String[] args) {
        String barCodeFull = getBarCode(BAR_CODE_LENGTH,FULL_BAR,HALF_BAR);
        String barCodeRelevant = ridEndPoints(barCodeFull);
        int[] zipCode = convertBarToZip(barCodeRelevant,BAR_NUMBER,BAR_LENGTH,FULL_BAR,HALF_BAR);
        printZip(zipCode,BAR_NUMBER);
    }
    /**
     * Gets a string input from user
     * @return the string
     */
    public static String getInputString(){
        Scanner Input = new Scanner(System.in);
        return Input.next();
    }
    /**
     * Checks if the string is the same length as the provided length
     * @param string 
     * @param length
     * @return True for is the same length, False for not
     */
    public static boolean isSameLen(String string, int length){
        return length == string.length();
    }
    /**
     * checks if the endpoints of the bar code are full bars
     * @param barCode the bar code
     * @param fullBar the char for a full bar
     * @return True for endpoints match, or False for they are not full bars
     */
    public static boolean checkEndPoint(String barCode, char fullBar){
        int length = barCode.length();
        return barCode.charAt(0) == fullBar && barCode.charAt(length - 1) == fullBar;
    }
    /**
     * checks if the string is composed of two specific chars
     * @param string the string
     * @param char1 char1 that should appear in the string
     * @param char2 the second char
     * @return  True if the string is composed only of those two chars, False for not
     */
    public static boolean isCertainChars(String string, char char1, char char2){
        char charAtIndex;
        for(int index = 0; index < string.length(); index++){
            charAtIndex = string.charAt(index);
            if(charAtIndex != char1){
                if(charAtIndex != char2)
                    return false;
            }
        }
        return true;
    }
    /**
     * Gets the bar code input from user, checks validity via length, chars, and endpoints
     * @param length length of the bar code
     * @param fullBar char for a full bar
     * @param halfBar char for a half bar
     * @return the valid bar code
     */
    public static String getBarCode(int length, char fullBar, char halfBar){
        boolean validString = false;
        String barCode = null;
        while(!validString){
            System.out.println("Enter Bar Code: ");
            barCode = getInputString();
            if(isSameLen(barCode,length) && checkEndPoint(barCode,fullBar) && isCertainChars(barCode,fullBar,halfBar))
                validString = true;
        }
        return barCode;
    }
    /**
     * Creates a new string that is a copy of the old one, except it does not have the endpoints
     * @param barCode the original bar code with endpoints
     * @return a new bar code without end points
     */
    public static String ridEndPoints(String barCode){
        int length = barCode.length();
        return barCode.substring(1,length - 1);
    }
    /**
     * splits a string into an array of substrings of equal length
     * @param string the original master string
     * @param numSubString the number of substrings
     * @param sizeSubString the length of each substring
     * @return an array of substrings
     */
    public static String[] splitString(String string, int numSubString, int sizeSubString){
        String[] subStrings = new String[numSubString];
        int startIndex = 0, endIndex = sizeSubString; 
        for(int index = 0; index < numSubString; index++){
            subStrings[index] = string.substring(startIndex,endIndex);
            startIndex = endIndex; //Move up the start index to the end index (end index is exclusive, not inclusive)
            endIndex += sizeSubString; //Move up the end index by the size of the substring
        }
        return subStrings;
    }
    /**
     * converts the bar code to an array of digits representing the zip code
     * @param barCode the bar code to be converted
     * @param barNum the number of bars in the bar code (bars represent a digit in the zip code)
     * @param barLength the length of each bar
     * @param fullBar the symbol for a full bar
     * @param halfBar the symbol for a half bar
     * @return the integer array representing the zip code
     */
    public static int[] convertBarToZip(String barCode,int barNum, int barLength, char fullBar, char halfBar){
        String[] bars = splitString(barCode,barNum,barLength); //Split the barcode into individual bars
        int[] zipCode = new int[barNum];
        int index = 0;
        for(String bar : bars){ //Each element in the substring array
            zipCode[index] = barToInt(bar,fullBar,halfBar);
            index++;
        }
        return zipCode;
    }
    /**
     * converts a bar into a digit
     * @param bar the bar
     * @param fullBar the full bar symbol
     * @param halfBar half bar symbol
     * @return the digit that the bar represents
     */
    public static int barToInt(String bar, char fullBar, char halfBar){
        int length = bar.length(); //length of the bar
        int[] barCodeInt = new int[length]; //temporary array to hold the integer representations of the bar 
        int barNum = 0; //the actual digit
        char charAtIndex; //the character at an index in the bar
        for(int index = 0; index < length; index++){ //loop to convert the bar into its integer code
            charAtIndex = bar.charAt(index);
            if(charAtIndex == fullBar) //Full bars are 1s
                barCodeInt[index] = 1;
            else if(charAtIndex == halfBar) //Half bars are 0s
                barCodeInt[index] = 0;
        }
        for(int index = 0; index < length; index++){ //loop to translate the integer bar code into a digit
            switch(index){ //Goes through each part of the code
                case 0:{
                    barNum += 7 * barCodeInt[index];
                    break;
                }
                case 1:{
                    barNum += 4 * barCodeInt[index];
                    break;
                }
                case 2:{
                    barNum += 2 * barCodeInt[index];
                    break;
                }
                case 3:{
                    barNum += 1 * barCodeInt[index];
                    break;
                }
                default: break;
            }
        }
        if(barCodeInt[0] == 1 && barCodeInt[1] == 1) //The exception case for 0; doesnt follow any rules
            barNum = 0;
        return barNum;
    }
    /**
     * gets the sum of the integer array
     * @param intArray the integer array
     * @return the sum
     */
    public static int sumInt(int[] intArray){
        int sum = 0;
        for(int num : intArray){
            sum += num;
        }
        return sum;
    }
    /**
     * checks if the check digit is valid; the check digit is valid if the sum of the zip code's digits (including the check digit) is divisible by 10
     * @param zip the zip code array (includes the check digit)
     * @return True for check digit is correct, false for it is not
     */
    public static boolean validateCheckDigit(int[] zip){
        int sum = sumInt(zip);
        int remain = sum % 10;
        return remain == 0;
    }
    /**
     * prints the zip code and whether or not the check digit is valid
     * @param zipCode the zip code array
     * @param length the length of the zip code
     */
    public static void printZip(int[] zipCode, int length){
        System.out.print("Zip Code: ");
        for(int index = 0; index < length - 1; index++){
            System.out.print(zipCode[index]);
        }
        boolean isValid = validateCheckDigit(zipCode);
        if(isValid)
            System.out.println("\nCheck Digit: " + zipCode[length - 1]);
        else
            System.out.println("\nCheck Digit is not valid.");
    }
}

/*
Enter Bar Code:  //Checks if the characters are | or :
asdfef
Enter Bar Code: //Checks if the length is 32
|||||||||||||||
Enter Bar Code:  //Checks if the end points are |
:|:|:::|:|:||::::::||:|::|:::||:
Enter Bar Code: 
||:|:::|:|:||::::::||:|::|:::|||
Zip Code: 95014
Check Digit: 1
*/