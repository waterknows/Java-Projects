package labp8_9;
public class Student extends Person{
    private String major;
    
    public Student(){
        super(); //Not necessary
        major = "";
    }
    public Student(String newName, int newYear, String newMajor){
        super(newName,newYear);
        major = newMajor;
    }
    public String getMajor(){
        return major;
    }
    public void setMajor(String newMajor){
        major = newMajor;
    }
    public String toString(){
        return super.toString() + "\nMajor: " + major;
    }
}