/*
Name: Joseph Park, Tony Salim
Date: October 7, 2014
Assignment: Lab 7, Problem 8.9
*/
package labp8_9;

public class LabP8_9 {
    public static void main(String[] args) {
        Person P = new Person();
        Person Pa = new Person("A",2000);
        System.out.println("Default Person");
        System.out.println(P.toString());
        System.out.println("Person");
        System.out.println(Pa.toString());
        
        Student S = new Student();
        Student Sb = new Student("b",2001,"CS");
        System.out.println("Default Student");
        System.out.println(S.toString());
        System.out.println("Student");
        System.out.println(Sb.toString());
        
        Instructor I = new Instructor();
        Instructor Ic = new Instructor("c",2002,1.00);
        System.out.println("Default Instructor");
        System.out.println(I.toString());
        System.out.println("Instructor");
        System.out.println(Ic.toString());
    }
}
