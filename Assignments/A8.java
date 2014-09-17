/*
Name: Joseph Park
Date: 
Assignment: 
Input: 
Process: 
Output: 
*/
package a8;
import java.util.Scanner;
public class A8 {
    public static void main(String[] args) {
        testMoth();
    }
    public static void testComboLock(){
        try (Scanner in = new Scanner(System.in)) {
            ComboLock lock = new ComboLock(10,12,14);            
            boolean endInput = false;
            while(!endInput){
                System.out.println("Position is at: " + lock.getPosition());
                System.out.println("(1) to Turn Left\n(2) to Turn Right\n(3) to Open\n(4) to Reset\n(5) to exit");
                char choice = in.next().charAt(0);
                switch(choice){
                    case '1':{
                        System.out.println("How many ticks?");
                        int ticks = in.nextInt();
                        lock.turnLeft(ticks);
                        break;
                    }
                    case '2':{
                        System.out.println("How many ticks?");
                        int ticks = in.nextInt();
                        lock.turnRight(ticks);
                        break;
                    }
                    case '3':{
                        if(lock.open())
                            System.out.println("The lock opened!");
                        else
                            System.out.println("Wrong combination.");
                        break;
                    }
                    case '4':{
                        lock.reset();
                        break;
                    }
                    case '5':{
                        endInput = true;
                        break;
                    }
                    default : break;
                }
                
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void testLetter(){
        Letter Mail = new Letter("Joseph","Joe");
        Mail.addLine("Hello!");
        Mail.addLine("World!");
        String mail = Mail.getText();
        System.out.println(mail);
    }
    
    public static void testMoth(){
        Moth A = new Moth(2.0);
        A.moveToLight(6.0);
        System.out.println(A.getPosition());
        A.moveToLight(16.0);
        System.out.println(A.getPosition());
        A.moveToLight(-1.0);
        System.out.println(A.getPosition());
        A.moveToLight(5.2);
        System.out.println(A.getPosition());
    }
}
