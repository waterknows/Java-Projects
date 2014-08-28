package a1p2.pkg10;
/* 
Name: Joseph Park
Date: August 29, 2014
Assignment: 1, Problem 2.10
Description: Computes the intial cost of hybrid car + gas 
             and compares with resale value to determine whether it is worth buying
*/
import java.util.Scanner;
public class A1P210 {
    static Scanner Input = new Scanner(System.in);
    static final double MOD_CONSTANT = 3.34;
    static final double YEARS = 5;
    public static void main(String[] args) {
         double car = GetCarCost();
         double miles = GetMilesPerYear();
         double gas = GetGasPrice();
         double mpg = GetGasEfficiency();
         double resale = GetResaleValue();
         double cost = CalculateTotalCost(car,miles,gas,mpg,YEARS);
         double mod = CalculateModifier(YEARS,miles);
         boolean worth = CompareCosts(cost,resale,mod);
         Output(car,miles,gas,mpg,YEARS,cost,resale,worth);
    }
    static double GetCarCost(){
        return GetInputValue("estimated cost of a new car");
    }
    static double GetMilesPerYear(){
        return GetInputValue("estimated miles driven per year");
    }
    static double GetGasPrice(){
        return GetInputValue("estimated gas price");
    }
    static double GetGasEfficiency(){
        return GetInputValue("estimated efficiency in miles per gallon");
    }
    static double GetResaleValue(){
        return GetInputValue("estimated resale value after 5 years");
    }
    static double GetInputValue(String valueCommand){
        System.out.printf("Enter %s: ", valueCommand);
        return Input();
    }
    static double Input(){
        while(true){
            double value = Input.nextFloat();
            if(CheckInput(value))
                return value;
            System.out.println("Invalid number. Try again.");
        }    
    }
    static boolean CheckInput(double value){
        return value > 0.0;
    }
    static double CalculateTotalCost(double initialCost, double milesPerYear, double gasPrice, double gasEfficiency, double years){
        return initialCost + (((milesPerYear * years) / gasEfficiency) * gasPrice);
    }
    static boolean CompareCosts(double totalCost, double resaleValue, double modifier){
        return totalCost < resaleValue * modifier;
    }
    static double CalculateModifier(double years, double milesPerYear){
        return (years * milesPerYear) / MOD_CONSTANT; 
    }
    static void Output(double initialCost, double milesPerYear, double gasPrice, double gasEfficiency, double years, double totalCost, double resaleValue, boolean worth){
        System.out.printf("\n\nInitial Cost of Car: $%.2f\nMiles Driven Per Year for %.2f year(s23): %.2f mile(s) x %.2f year(s) = %.2f\nPrice of Gas Per Gallon: $%.2f\n"
                +         "Gas Efficiency: %.2f mpg\nTotal Cost of Car: $%.2f\nResale Value of Car: $%.2f\n",initialCost,years,milesPerYear,years,milesPerYear * years,
                          gasPrice,gasEfficiency,totalCost,resaleValue);
        if(worth)
            System.out.println("Buy the Car!");
        else
            System.out.println("Don't buy the Car!");
    }
    
}
