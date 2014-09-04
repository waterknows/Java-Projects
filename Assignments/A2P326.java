/* 
Name: Joseph Park
Date: September 3, 2014
Assignment: 2, Problem 3.26
Input: User inputs a number from 1 to 3999
Process: Checks the number and converts it to a roman numeral string
Output: Prints the corresponding roman numeral
*/
import java.util.Scanner;
public class A2P326 {
    static Scanner In = new Scanner(System.in);
    //Constants for each digit place
    static final int THOUSAND = 1000;
    static final int HUNDRED = 100;
    static final int TEN = 10;
    static final int MIN = 1;
    static final int MAX = 3999;
    //Constants for each Roman Numeral
    static final String ONE_R = "I";
    static final String FIVE_R = "V";
    static final String TEN_R = "X";
    static final String FIFTY_R = "L";
    static final String HUNDRED_R = "C";
    static final String FIVEHUNDRED_R = "D";
    static final String THOUSAND_R = "M";
    public static void main(String[] args) {
        int integer = GetInput();
        String numerals = ConvertToRomanNumeral(integer);
        Display(integer,numerals);         
    }
    /**
     * Gets input from user
     * @return input (1 - 3999)
     */
    static int GetInput(){
        int input = -1;
        while(!CheckInput(input)){
            System.out.printf("Enter integer(%d - %d): ",MIN,MAX);
            input = In.nextInt();
        }
        return input;
    }
    /**
     * Checks input for validity (between MIN and MAX)
     * @param input (1 - 3999)
     * @return true if valid, false if not
     */
    static boolean CheckInput(int input){
        return input >= MIN && input <= MAX;
    }
    /**
     * Calculates how many digits in thousandth place
     * @param integer 
     * @return the digit in the thousandth place
     */
    static int SplitThousand(int integer){
        return integer / THOUSAND;
    }
    /**
     * Calculates the digit in the hundredth place
     * @param integer
     * @return digit in the hundredth place
     */
    static int SplitHundred(int integer){
        return (integer - (THOUSAND * SplitThousand(integer))) / HUNDRED;
    }
    /**
     * Calculates the digit in the tens place
     * @param integer
     * @return digit in the tens place
     */
    static int SplitTen(int integer){
        return (integer - (THOUSAND * SplitThousand(integer)) - (HUNDRED * SplitHundred(integer))) / TEN;
    }
    /**
     * Calculates the digit in the ones place
     * @param integer
     * @return digit in the ones place
     */
    static int SplitOne(int integer){
        return (integer - (THOUSAND * SplitThousand(integer)) - (HUNDRED * SplitHundred(integer)) - (TEN * SplitTen(integer)));
    }
    /**
     * Converts the integer to roman numeral
     * @param integer
     * @return the roman numeral string
     */
    static String ConvertToRomanNumeral(int integer){
        int thousand = SplitThousand(integer), hundred = SplitHundred(integer), ten = SplitTen(integer), one = SplitOne(integer);
        String integerString = ""; //Performs conversion for each digit separately
        integerString += ConvertDigits(thousand,THOUSAND);
        integerString += ConvertDigits(hundred,HUNDRED);
        integerString += ConvertDigits(ten,TEN);
        integerString += ConvertDigits(one,1);
        return integerString; //Then adds them up into one string
    }
    /**
     * Converts the digits into their respective roman numeral
     * @param numOfDigits
     * @param digitPlace
     * @return the roman numeral string per digit
     */
    static String ConvertDigits(int numOfDigits, int digitPlace){
        String digits = "";
        if(digitPlace == THOUSAND){
            digits += ConvertCheck(numOfDigits,THOUSAND_R, "?", "&");
        }
        else if(digitPlace == HUNDRED){
            digits += ConvertCheck(numOfDigits,HUNDRED_R,FIVEHUNDRED_R,THOUSAND_R);
        }
        else if(digitPlace == TEN){
            digits += ConvertCheck(numOfDigits,TEN_R,FIFTY_R,HUNDRED_R);
        }
        else if(digitPlace == 1){
            digits += ConvertCheck(numOfDigits,ONE_R,FIVE_R,TEN_R);
        }
        return digits;
    }
    /**
     * Checks which number it is and gets the respective string
     * @param numOfDigits
     * @param singleChar
     * @param midChar
     * @param nextChar
     * @return the respective roman numeral string 
     */
    static String ConvertCheck(int numOfDigits, String singleChar, String midChar, String nextChar){
        String digits = "";
        switch(numOfDigits){
            case 1:
            case 2: // 1 - 3 have a pattern of just repeating the single numeral IE I or X or C
            case 3: {
                for(int i = 0; i < numOfDigits; i++){
                    digits += singleChar;
                }
                break;
            } //4 is the single numeral and then the mid numeral IE IV, XL, CD
            case 4: {
                digits += singleChar + midChar;
                break;
            } //4 is the mid numeral IE V L D
            case 5: {
                digits += midChar;
                break;
            } //6-8 is the mid numeral with up to 3 single numerals following IE VII, LX, DCCC
            case 6:
            case 7:
            case 8: {
                digits += midChar;
                for(int i = 5; i < numOfDigits; i++){
                    digits += singleChar;
                }
                break;
            } //9 is the single numeral with the next stage numeral IE IX, XC, CM
            case 9: {
                digits += singleChar + nextChar;
                break;
            } //For zeros, there is nothing
            case 0: {
                digits += "";
                break;
            }
            default: break;
        }
        return digits;
    }
    /**
     * Displays the integer and the roman numeral string
     * @param integer
     * @param integerString 
     */
    static void Display(int integer, String integerString){
//        System.out.printf("Integer: %d\nIn Roman Numerals: %s\n",integer,integerString);
        System.out.println(integer + " " + integerString);
    }
}

/*
Enter integer(1 - 3999): 0
Enter integer(1 - 3999): 4000
Enter integer(1 - 3999): -1
Enter integer(1 - 3999): 577
577 DLXXVII

Enter integer(1 - 3999): 2804
2804 MMDCCCIV
*/