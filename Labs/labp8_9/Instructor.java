/*
Name: Joseph Park, Tony Salim
Date: October 7, 2014
Assignment: Lab 7, Problem 8.9
*/
package labp8_9;
public class Instructor extends Person{
    private double salary;
    /**
     * Default constructor
     */
    public Instructor(){
        super(); //Not necessary
        salary = 0.0;
    }
    /**
     * Constructor with three arg
     * @param newName name of instructor
     * @param newYear year of birth of instructor
     * @param newSalary salary of instructor
     */
    public Instructor(String newName, int newYear, double newSalary){
        super(newName,newYear); //Calls super constructor
        salary = newSalary;
    }
    /**
     * returns the salary
     * @return salary
     */
    public double getSalary(){
        return salary;
    }
    /**
     * Sets the salary
     * @param newSalary  the salary
     */
    public void setSalary(double newSalary){
        salary = newSalary;
    }
    /**
     * Describes the instructor (name, year, salary)
     * @return the string
     */
    @Override
    public String toString(){
        return super.toString() + "\nSalary: " + salary;
    }
}