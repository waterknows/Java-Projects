package a1p2.pkg19;
import java.util.Scanner;
public class A1P219 {
    static Scanner In = new Scanner(System.in);
    public static void main(String[] args) {
        String[] monthList = FillArray();
        int monthNum = GetInput();
        String month = GetMonth(monthNum,monthList);
        Print(month);
//        for(int i = 0; i < 12; i++){
//            Print(GetMonth(i + 1,monthList));
//        }
    }
    static String[] FillArray(){
        String[] month = {"January","February","March","April","May","June","July","August","September",
            "October","November","December"};
        return month;
    }
    static int GetInput(){
        int month;
        while(true){
            System.out.print("Enter the month in number: ");
            month = In.nextInt();
            if(CheckInput(month))
                return month;
            System.out.print("Invalid month.\n");
        }
    }
    static boolean CheckInput(int value){
        return value <= 12 && value >= 1;
    }
    static String GetMonth(int monthNum, String[] monthList){
        return monthList[monthNum - 1];
    }
    static void Print(String month){
        System.out.println(month);
    }
}
