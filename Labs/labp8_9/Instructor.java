package labp8_9;
public class Instructor extends Person{
    private double salary;
    
    public Instructor(){
        super(); //Not necessary
        salary = 0.0;
    }
    public Instructor(String newName, int newYear, double newSalary){
        super(newName,newYear);
        salary = newSalary;
    }
    public double getSalary(){
        return salary;
    }
    public void setSalary(double newSalary){
        salary = newSalary;
    }
    public String toString(){
        return super.toString() + "\nSalary: " + salary;
    }
}