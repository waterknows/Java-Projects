package studentgradebook;

public class Student implements Comparable{
    private String first;
    private String last;
    private int id;
    
    public Student(String first, String last, int id){
        this.first = first;
        this.last = last;
        this.id = id;
    }
    
    public String getFirst(){return first;}
    public String getLast(){return last;}
    public int getID(){return id;}
    
    public void setFirst(String first){this.first = first;}
    public void setLast(String last){this.last = last;}
    public void setID(int id){this.id = id;}

    @Override
    public int compareTo(Object t) {
        Student Other = (Student) t;
        if(last.equals(Other.getLast())){
            if(first.equals(Other.getFirst()))
                return id - Other.getID();
            else return first.compareTo(Other.getFirst());
        } else return last.compareTo(Other.getLast());
    }
    
    @Override
    public String toString(){
        return last + ", " + first + " (" + id + ")"; 
    }
}