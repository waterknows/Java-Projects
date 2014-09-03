package assignments;
import java.util.Scanner;
public class A3P326 {
    static Scanner In = new Scanner(System.in);
    static final int THOUSAND = 1000;
    static final int HUNDRED = 100;
    static final int TEN = 10;
    static final int MIN = 1;
    static final int MAX = 3999;
    static final String ONE_R = "I";
    static final String FIVE_R = "V";
    static final String TEN_R = "X";
    static final String FIFTY_R = "L";
    static final String HUNDRED_R = "C";
    static final String FIVEHUNDRED_R = "D";
    static final String THOUSAND_R = "M";
    public static void main(String[] args) {
//        int integer = GetInput();
        for(int i = 1; i < 4000; i++){
            String numerals = ConvertToRomanNumeral(i);
            Display(i,numerals);    
        }
        
    }
    static int GetInput(){
        int input = -1;
        while(!CheckInput(input)){
            System.out.printf("Enter integer(%d - %d): ",MIN,MAX);
            input = In.nextInt();
        }
        return input;
    }
    static boolean CheckInput(int input){
        return input >= MIN && input <= MAX;
    }
    static int SplitThousand(int integer){
        return integer / THOUSAND;
    }
    static int SplitHundred(int integer){
        return (integer - (THOUSAND * SplitThousand(integer))) / HUNDRED;
    }
    static int SplitTen(int integer){
        return (integer - (THOUSAND * SplitThousand(integer)) - (HUNDRED * SplitHundred(integer))) / TEN;
    }
    static int SplitOne(int integer){
        return (integer - (THOUSAND * SplitThousand(integer)) - (HUNDRED * SplitHundred(integer)) - (TEN * SplitTen(integer)));
    }
    static String ConvertToRomanNumeral(int integer){
        int thousand = SplitThousand(integer), hundred = SplitHundred(integer), ten = SplitTen(integer), one = SplitOne(integer);
        String integerString = "";
        integerString += ConvertDigits(thousand,THOUSAND);
        integerString += ConvertDigits(hundred,HUNDRED);
        integerString += ConvertDigits(ten,TEN);
        integerString += ConvertDigits(one,1);
        return integerString;
    }
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
    static String ConvertCheck(int numOfDigits, String singleChar, String midChar, String nextChar){
        String digits = "";
        switch(numOfDigits){
            case 1:
            case 2:
            case 3: {
                for(int i = 0; i < numOfDigits; i++){
                    digits += singleChar;
                }
                break;
            }
            case 4: {
                digits += singleChar + midChar;
                break;
            }
            case 5: {
                digits += midChar;
                break;
            }
            case 6:
            case 7:
            case 8: {
                digits += midChar;
                for(int i = 5; i < numOfDigits; i++){
                    digits += singleChar;
                }
                break;
            }
            case 9: {
                digits += singleChar + nextChar;
                break;
            }
            case 0: {
                digits += "";
                break;
            }
            default: break;
        }
        return digits;
    }
    static void Display(int integer, String integerString){
//        System.out.printf("Integer: %d\nIn Roman Numerals: %s\n",integer,integerString);
        System.out.println(integer + " " + integerString);
    }
}
