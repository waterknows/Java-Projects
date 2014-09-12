/*
Name: Joseph Park
Date: September 12, 2014
Assignment: 6, Problem 7.8
Input: From file
Process: reverses each line of the file
Output: outputs the file
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class A6P78 {
    public static void main(String[] args) {
        String file = "C:\\Users\\g\\Desktop\\TODO.txt";
        reverseFile(file);
    }
    public static Scanner connectFile(String fileName) throws FileNotFoundException{
        return new Scanner(new File(fileName));
    }
    public static void reverseFile(String fileName){
        try{
            Scanner fileIn = connectFile(fileName);
            
            File tempFile = new File("C:\\Users\\g\\Desktop\\tempOut.txt");
            PrintWriter fileOut = new PrintWriter(tempFile);
            
            while(fileIn.hasNextLine()){
                String line = fileIn.nextLine();
                String reversed = reverse(line);
                fileOut.println(reversed);
            }
            
            fileIn.close();
            fileOut.close();
            fileOut = new PrintWriter(fileName);
            fileIn = new Scanner(tempFile);
            while(fileIn.hasNextLine()){
                String line = fileIn.nextLine();
                fileOut.println(line);
            }
            fileIn.close();
            fileOut.close();
            tempFile.delete();
        }
        catch (FileNotFoundException exception) {
            System.out.println("File Not Found.");
        }
    }
    public static String reverse(String string){
        String reversed = "";
        for(int index = string.length() - 1; index >= 0; index--)
            reversed += string.charAt(index);
        return reversed;
    }
}
