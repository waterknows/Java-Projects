/*
Name: Joseph Park, Tony Salim
Date: October 7, 2014
Assignment: Lab 7, Problem 8.9
*/
package labp8_9;

public class Person{
    private String name;
    private int yearOfBirth;

    /**
     * Default constructor
     */
    public Person(){
        name = "";
        yearOfBirth = 0;
    }

    /**
     * Constructor with two arg
     * @param newName name of person
     * @param newYear year of birth
     */
    public Person(String newName, int newYear){
        name = newName;
        yearOfBirth = newYear;
    }

    /**
     * returns the name of person
     * @return name
     */
    public String getName(){
        return name;
    }

    /**
     * returns the year of birth of person
     * @return the year
     */
    public int getYear(){
        return yearOfBirth;
    }

    /**
     * Sets the name of person
     * @param newName the name
     */
    public void setName(String newName){
        name = newName;
    }

    /**
     * Sets the year of birth of person
     * @param newYear the year
     */
    public void setYear(int newYear){
        yearOfBirth = newYear;
    }

    /**
     * Describes the person in string (name, year)
     * @return the string
     */
    @Override 
    public String toString(){
        return  "Name: " + name + "\nYear: " + yearOfBirth;
    }
}
