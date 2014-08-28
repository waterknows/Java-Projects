/*
Name: Joseph Park & Shelly Shao, Group 15
Date: August 28, 2014
Assignment: Lab 2, Problem 3.33
Input: User inputs cost of Groceries
Processing: Categorizes the cost and calculates the discount
Output: Prints the discount 
*/


package lab2p34;
import java.util.Scanner;
public class Lab2P34 {
    static Scanner In = new Scanner(System.in);
    public static void main(String[] args) {
        double cost = GetCost();
        double discount = GetDiscount(cost);
        Print(discount,cost);
    }
    //Asks user for cost
    static double GetCost(){
        double cost;
        while(true){
            System.out.print("Enter the cost of your groceries: ");
            cost = In.nextDouble();
            if(CheckInput( cost))
                return cost;
            System.out.print("Invalid cost.\n");
        }
    }//Checks input for negative
    static boolean CheckInput(double value){
        return value >= 0.0;
    }//Categorizes the input for the discount
    static double GetDiscount(double cost){
        if(cost < 10.0)
            return 0;
        else if(cost <= 60.0)
            return CalculateDiscount(cost,8.0);
        else if(cost <= 150.0)
            return CalculateDiscount(cost,10.0);
        else if(cost <= 210.0)
            return CalculateDiscount(cost,12.0);
        else
            return CalculateDiscount(cost,14.0);
    }//Calculates the discount
    static double CalculateDiscount(double cost, double discount){
        return cost * (discount / 100.0);
    }//Prints
    static void Print(double discount, double cost){
        System.out.printf("You win a discount coupon of $%.2f.",discount);
        if(cost != 0.0)
             System.out.printf("(%.0f",100.0 * (discount / cost));
        else
            System.out.printf("(%.0f",0.0);
        System.out.println("% of your purchase)");
    }   
}
/*
Enter the cost of your groceries: 0
You win a discount coupon of $0.00.(0% of your purchase)

Enter the cost of your groceries: -123
Invalid cost.
Enter the cost of your groceries: 10.01
You win a discount coupon of $0.80.(8% of your purchase)

Enter the cost of your groceries: 60.01
You win a discount coupon of $6.00.(10% of your purchase)

Enter the cost of your groceries: 209.99
You win a discount coupon of $25.20.(12% of your purchase)

Enter the cost of your groceries: 212
You win a discount coupon of $29.68.(14% of your purchase)
*/