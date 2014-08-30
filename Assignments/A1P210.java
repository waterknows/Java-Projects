/* 
Name: Joseph Park
Date: August 29, 2014
Assignment: 1, Problem 2.10
Input: User inputs the cost, miles driven, gas, mpg, 
and resale value of a hybrid car and a non-hybrid car
Process: Calculates the total net cost per car 
and compares the values to determine whether the hybrid car is worth buying
Output: Prints the total net cost per car and the advice as to whether to buy the hybrid car
*/
import java.util.Scanner;

public class A1P210{
    static Scanner In = new Scanner(System.in);
    static final double COMPARE_MOD = 1.02; //This is a modifier added to the comparison//Increases the effective value of a hybrid car due to its gas saving nature by a little
    static final double NUM_OF_YEARS = 5.0; //This is the number of years for total miles and resale value
    static final double RESALE_PERCENT = 38.2; //This is the percentage of the original cost the resale value will be
    public static void main(String[] args){
        double gasCost = GetInput("Enter the average cost of gas per gallon: ");
        
        System.out.println("\n//For the Hybrid Car//");//For Hybrids
        double costInitialHybrid = GetInput("Initial cost: ");
        double milesDrivenHybrid = GetInput("Estimated miles driven per year: ");
        double gasEffHybrid = GetInput("Estimated gas efficiency in miles per gallon: ");
//        double resaleValueHybrid = GetInput("Estimated resale value after " + NUM_OF_YEARS + " years: ");
        double resaleValueHybrid = CalculateResaleValue(costInitialHybrid);
        double totalCostHybrid = CalculateTotalCost(costInitialHybrid,milesDrivenHybrid,gasCost,gasEffHybrid,resaleValueHybrid,NUM_OF_YEARS);
        System.out.println("\n");
        PrintValues(costInitialHybrid,milesDrivenHybrid,gasCost,gasEffHybrid,resaleValueHybrid,NUM_OF_YEARS,totalCostHybrid);
        
        System.out.println("\n//For the Diesel Car//");//For Diesel
        double costInitialDiesel = GetInput("Initial cost: ");
        double milesDrivenDiesel = GetInput("Estimated miles driven per year: ");
        double gasEffDiesel = GetInput("Estimated gas efficiency in miles per gallon: ");
//        double resaleValueDiesel = GetInput("Estimated resale value after " + NUM_OF_YEARS + " years: ");
        double resaleValueDiesel = CalculateResaleValue(costInitialDiesel);
        double totalCostDiesel = CalculateTotalCost(costInitialDiesel,milesDrivenDiesel,gasCost,gasEffDiesel,resaleValueDiesel,NUM_OF_YEARS);
        System.out.println("\n");
        PrintValues(costInitialDiesel,milesDrivenDiesel,gasCost,gasEffDiesel,resaleValueDiesel,NUM_OF_YEARS,totalCostDiesel);
        
        boolean result = CompareCars(totalCostHybrid,totalCostDiesel);
        PrintResult(result);   
        In.close();
    }//General input function//Asks user for input, validates it, and returns it once valid
    static double GetInput(String message){
        double value;
        while(true){
            System.out.printf("%s",message);
            value = In.nextDouble();
            if(!IsNegative(value)){ //Input validation
                return value;
            }
            System.out.println("Invalid input."); 
        }
    } //Checks if the value is negative
    static boolean IsNegative(double value){
        return value < 0.0;
    } //Calculates the resale value based on initial cost and resale percentage
    static double CalculateResaleValue(double initialCost){
        return initialCost * (RESALE_PERCENT / 100.0);
    } //Calculates the total cost (initial + total gas - resale)//Better worded as total value
    static double CalculateTotalCost(double initialCost, double milesPerYear, 
            double gasPrice, double milesPerGallon, double resaleValue, double numOfYears){
//        double totalMiles = milesPerYear * numOfYears;
//        double effectiveGallons = totalMiles / milesPerGallon;
//        double totalGasCost = effectiveGallons * gasPrice;
//        double totalCost = initialCost + totalGasCost - resaleValue;
//        return totalCost;
        return initialCost + (((milesPerYear * numOfYears) / milesPerGallon) * gasPrice) - resaleValue;
    } //Compares the total costs/values of the two types of cars//Returns true if hybrid with modifier is greater than diesel
    static boolean CompareCars(double costHybrid, double costDiesel){
        return costHybrid * COMPARE_MOD <= costDiesel;
    } //Prints the input values along with the total cost
    static void PrintValues(double initialCost, double milesPerYear, double gasPrice, 
            double milesPerGallon, double resaleValue, double numOfYears, double totalCost){
        System.out.printf("Initial Cost of Car: $%.2f\nMiles Per Year for %.2f Years: "
                + "%.2f miles x %.2f years = %.2f miles\nAverage Price of Gas Per Gallon: $%.2f\n"
                + "Gas Efficiency of Car: %.2f miles per gallon\nEstimated Resale Value: $%.2f\n"
                + "Total Cost of Car: $%.2f\n\n",initialCost,numOfYears,milesPerYear,numOfYears,
                milesPerYear*numOfYears,gasPrice,milesPerGallon,resaleValue,totalCost);
    } //Prints the comparison result
    static void PrintResult(boolean compareResult){
        if(compareResult)
            System.out.println("You should buy the Hybrid Car.");
        else
            System.out.println("You should not buy the Hybrid Car.");
    }
    
    //    static double Calculate(double gasPrice){
//        double costInitial = GetInput("Initial cost: ");
//        double milesDriven = GetInput("Estimated miles driven per year: ");
//        double gasEff = GetInput("Estimated gas efficiency in miles per gallon: ");
//        double resaleValue = GetInput("Estimated resale value after " + NUM_OF_YEARS + " years: ");
//        return CalculateTotalCost(costInitial,milesDriven,gasPrice,gasEff,resaleValue,NUM_OF_YEARS);
//    }

}
/*
Enter the average cost of gas per gallon: 3.90

//For the Hybrid Car//
Initial cost: 33000
Estimated miles driven per year: 15000
Estimated gas efficiency in miles per gallon: 40.2


Initial Cost of Car: $33000.00
Miles Per Year for 5.00 Years: 15000.00 miles x 5.00 years = 75000.00 miles
Average Price of Gas Per Gallon: $3.90
Gas Efficiency of Car: 40.20 miles per gallon
Estimated Resale Value: $12606.00
Total Cost of Car: $27670.12


//For the Diesel Car//
Initial cost: 16000
Estimated miles driven per year: 15000
Estimated gas efficiency in miles per gallon: 19.3


Initial Cost of Car: $16000.00
Miles Per Year for 5.00 Years: 15000.00 miles x 5.00 years = 75000.00 miles
Average Price of Gas Per Gallon: $3.90
Gas Efficiency of Car: 19.30 miles per gallon
Estimated Resale Value: $6112.00
Total Cost of Car: $25043.44

You should not buy the Hybrid Car.


Enter the average cost of gas per gallon: -1
Invalid input.
Enter the average cost of gas per gallon: 3.90

//For the Hybrid Car//
Initial cost: 23000
Estimated miles driven per year: 15000
Estimated gas efficiency in miles per gallon: 40.2


Initial Cost of Car: $23000.00
Miles Per Year for 5.00 Years: 15000.00 miles x 5.00 years = 75000.00 miles
Average Price of Gas Per Gallon: $3.90
Gas Efficiency of Car: 40.20 miles per gallon
Estimated Resale Value: $8786.00
Total Cost of Car: $21490.12


//For the Diesel Car//
Initial cost: 16000
Estimated miles driven per year: 15000
Estimated gas efficiency in miles per gallon: 19.3


Initial Cost of Car: $16000.00
Miles Per Year for 5.00 Years: 15000.00 miles x 5.00 years = 75000.00 miles
Average Price of Gas Per Gallon: $3.90
Gas Efficiency of Car: 19.30 miles per gallon
Estimated Resale Value: $6112.00
Total Cost of Car: $25043.44

You should buy the Hybrid Car.
BUILD SUCCESSFUL (total time: 34 
*/