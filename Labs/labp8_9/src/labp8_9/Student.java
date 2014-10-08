/*
Name: Joseph Park, Tony Salim
Date: October 7, 2014
Assignment: Lab 7, Problem 8.9
*/
package labp8_9;
public class Student extends Person{
    private String major;

    /**
     * Default constructor
     */
    public Student(){
        super(); //Not necessary
        major = "";
    }

    /**
     * Constructor
     * @param newName name
     * @param newYear year of birth
     * @param newMajor major
     */
    public Student(String newName, int newYear, String newMajor){
        super(newName,newYear); //super constructor
        major = newMajor;
    }

    /**
     * returns the major
     * @return major
     */
    public String getMajor(){
        return major;
    }

    /**
     * sets the major
     * @param newMajor major
     */
    public void setMajor(String newMajor){
        major = newMajor;
    }

    /**
     * returns string of (name,year,major)
     * @return 
     */
    @Override
    public String toString(){
        return super.toString() + "\nMajor: " + major;
    }
}
