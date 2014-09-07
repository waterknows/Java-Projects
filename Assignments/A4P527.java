/*
Name: Joseph Park
Date: September 5, 2014
Assignment: 4, Problem 5.27
Input: User inputs a roman numeral string
Process: Converts the roman numeral into an integer
Output: Outputs the integer
*/
import java.util.Scanner;
public class A4P527 {
    private static final char[] charList = {'I','V','X','L','C','D','M'};
    public static void main(String[] args) {
        String roman = getRomanNumeral();
        int number = convertRomanNumeralToInt(roman);
        printRomanNumeral(roman,number);
    }
    /**
     * asks user for a roman numeral string and checks if the chars are correct (Auto uppers the string)
     * @return the roman numeral string
     */
    public static String getRomanNumeral(){
        boolean validNumeral = false;
        Scanner Input = new Scanner(System.in);
        String romanNumeral = null;
        while(!validNumeral){
            System.out.println("Enter roman numeral (no spaces):");
            romanNumeral = Input.next();
            romanNumeral = romanNumeral.toUpperCase(); //Upper the string
            if(checkChars(romanNumeral,charList))
                validNumeral = true;
        }
        Input.close();
        return romanNumeral;
    }
    /**
     * checks if the chars in the string are only the ones in the char list
     * @param string 
     * @param charList list of chars to be used as a check
     * @return true for the string is comprised of only chars in charlist, False for other chars
     */
    public static boolean checkChars(String string, char[] charList){
        char charInString;
        boolean charIsValid = false;
        for(int index = 0; index < string.length(); index++){
            charInString = string.charAt(index);
            charIsValid = false;
            for(char ch : charList){
                if(charInString == ch)
                    charIsValid = true;
            }
        }
        return charIsValid;
    }
    /**
     * converts the roman numeral string to an integer
     * @param romanNumeral
     * @return the integer
     */
    public static int convertRomanNumeralToInt(String romanNumeral){
        String tempNumeral = romanNumeral;
        int total = 0, valFirst, valSecond;
        while(!tempNumeral.isEmpty()){ //While the string is not empty
            valFirst = convertSingleRomanToInt(tempNumeral.charAt(0)); //Get the first char and find the int value
            if(tempNumeral.length() == 1){ //If the string length is 1 (only one char)
                total += valFirst; //Add the value of that char to total
                tempNumeral = tempNumeral.substring(1); //Remove the char
            }
            else{ //More than 1
                valSecond = convertSingleRomanToInt(tempNumeral.charAt(1)); //Find the value of the second char
                if(valFirst >= valSecond){ //If the first char is greater than second char
                    total += valFirst; //Add the first char
                    tempNumeral = tempNumeral.substring(1); //Remove the first char
                }
                else{
                    total += valSecond - valFirst; //Add the second char - first char
                    tempNumeral = tempNumeral.substring(2); //Remove both
                }
            }
        }
        return total;
    }
    /**
     * converts a single roman numeral char to an integer (Finds the value of each roman numeral)
     * @param romanSingle the single char 
     * @return the value of the single char
     */
    public static int convertSingleRomanToInt(char romanSingle){
        int value = 0;
        switch(romanSingle){
            case 'I':{
                value = 1;
                break;
            }
            case 'V':{
                value = 5;
                break;
            }
            case 'X':{
                value = 10;
                break;
            }
            case 'L':{
                value = 50;
                break;
            }
            case 'C':{
                value = 100;
                break;
            }
            case 'D':{
                value = 500;
                break;
            }
            case 'M':{
                value = 1000;
                break;
            }
            default : break;
        }
        return value;
    }
    /**
     * prints the roman numeral string and the integer value
     * @param romanNumeral
     * @param intNumeral 
     */
    public static void printRomanNumeral(String romanNumeral, int intNumeral){
        System.out.println("Roman Numeral: " + romanNumeral);
        System.out.println("Number: " + intNumeral);
    }
}

/*
Enter roman numeral (no spaces):
MCMLXXVIII
Roman Numeral: MCMLXXVIII
Number: 1978

Enter roman numeral (no spaces):
abh
Enter roman numeral (no spaces):
-1
Enter roman numeral (no spaces):
MMXIV
Roman Numeral: MMXIV
Number: 2014
*/