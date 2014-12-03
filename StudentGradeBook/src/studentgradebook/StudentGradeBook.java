/*
Name: Joseph Park
Date: 
Assignment: 
Input: 
Process: 
Output: 
*/
package studentgradebook;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class StudentGradeBook {
    public static final char[] gradeLetters = {'A','B','C','D','F'};
    public static final char[] gradeFollow = {'+','-'};
    public static void main(String[] args) {
//        Map<Integer,Map<Student,String>> map = new TreeMap<>();
        Map<Integer,Student> sMap = new TreeMap<>();
        Map<Student,String> pMap = new TreeMap<>();
        boolean end = false;
        try (Scanner In = new Scanner(System.in)) {
            while(!end){
                switch(Character.toUpperCase(menu(In))){
                    case 'A':{
                        System.out.println("Enter first, last, id, then grade:");
                        String first = In.next();
                        String last = In.next();
//                        System.out.println("Enter id: ");
                        int id = In.nextInt();
//                        System.out.println("Enter grade: ");
                        String grade = In.next();
                        error(add(sMap,pMap,new Student(first,last,id),grade));
                        break;
                    }
                    case 'R':{
                        System.out.println("Enter student id: ");
                        int id = In.nextInt();
                        error(remove(sMap,pMap,id));
                        break;
                    }
                    case 'M':{
                        System.out.println("Enter student id then grade: ");
                        int id = In.nextInt();
//                        System.out.println("Enter new grade: ");
                        String grade = In.next();
                        error(modify(sMap,pMap,id,grade));
                        break;
                    }
                    case 'P':{
                        print(sMap,pMap);
                        break;
                    }
                    case 'E':{
                        end = true;
                        break;
                    }
                    default : break;
                }
            }
        }
    }
    public static char menu(Scanner In){
        System.out.println("(A)dd Student");
        System.out.println("(R)emove Student");
        System.out.println("(M)odify Student");
        System.out.println("(P)rint Students");
        System.out.println("(E)xit");
        return In.next().charAt(0);
    }
    public static int add(Map<Integer,Student> sMap, Map<Student,String> pMap, Student s, String grade){
        if(!isGradeValid(grade)) return 3;
        if(sMap.containsKey((Integer)s.getID())) return 2;
        sMap.put((Integer)s.getID(), s);
        pMap.put(s,grade);
        return 0;
    }
    public static int remove(Map<Integer,Student> sMap, Map<Student,String> pMap, int id){ //Remove by ID
        if(!sMap.containsKey((Integer)id)) return 1;
        pMap.remove(sMap.get(id));
        sMap.remove((Integer)id);
        return 0;
    }
    public static int modify(Map<Integer,Student> sMap, Map<Student,String> pMap, int id, String grade){ //by ID
        if(!sMap.containsKey((Integer)id)) return 1;
        pMap.remove(sMap.get(id));
        pMap.put(sMap.get(id),grade);
        return 0;
    }
    public static void print(Map<Integer,Student> sMap, Map<Student,String> pMap){ //by Name
        for(Student s : pMap.keySet())
            System.out.println(s.toString() + ": " + pMap.get(s));
       
    }
    public static void sort(Map<Integer,Map<Student,String>> map){ //Sorts via Comparable
        
    }
    public static boolean isGradeValid(String grade){
//        System.out.println(grade.length());
        if(grade.length() == 0 || grade.length() > 2) return false;
        char letter = grade.charAt(0);
//        System.out.println(letter);
        Character.toUpperCase(letter);
//        System.out.println(letter);
        if(find(gradeLetters,letter,0,5) == -1) return false;
        if(grade.length() == 1) return true;
        char follow = grade.charAt(1);
//        System.out.println(follow);
        return find(gradeFollow,follow,0,2) != -1;
    }
    public static int find(char[] a, char c, int from, int length){
        for(int i = from; i < length; i++)
            if(a[i] == c) return i;
        return -1;
    }
    public static void error(int code){
        switch(code){
            case 0: break;
            case 1: {
                System.out.println("Student ID not found.");
                break;
            }
            case 2:{
                System.out.println("Student ID already exists.");
                break;
            }
            case 3:{
                System.out.println("Invalid grade.");
                break;
            }
            default : break;
        }
    }
}


/*
run:
(A)dd Student
(R)emove Student
(M)odify Student
(P)rint Students
(E)xit
A
Enter first and last name of student:
Joseph Park
Enter id: 
00967714
Enter grade: 
A+
(A)dd Student
(R)emove Student
(M)odify Student
(P)rint Students
(E)xit
M
Enter student id: 
00967714
Enter new grade: 
F
(A)dd Student
(R)emove Student
(M)odify Student
(P)rint Students
(E)xit
P
Park, Joseph (967714): F
(A)dd Student
(R)emove Student
(M)odify Student
(P)rint Students
(E)xit
A
Enter first and last name of student:
Joseph Park
Enter id: 
00967714
Enter grade: 
F
Student ID already exists.
(A)dd Student
(R)emove Student
(M)odify Student
(P)rint Students
(E)xit
e
(A)dd Student
(R)emove Student
(M)odify Student
(P)rint Students
(E)xit
E
BUILD SUCCESSFUL (total time: 27 seconds)

*/