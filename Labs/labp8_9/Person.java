package labp8_9;
public class Person{
    private String name;
    private int yearOfBirth;
    
    public Person(){
        name = "";
        yearOfBirth = 0;
    }
    public Person(String newName, int newYear){
        name = newName;
        yearOfBirth = newYear;
    }
    public String getName(){
        return name;
    }
    public int getYear(){
        return yearOfBirth;
    }
    public void setName(String newName){
        name = newName;
    }
    public void setYear(int newYear){
        yearOfBirth = newYear;
    }
    public String toString(){
        return  "Name: " + name + "\nYear: " + yearOfBirth;
    }
}