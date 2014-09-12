/*
Name: Joseph Park, Waverly Chin
Date: September 11, 2014
Assignment: Lab 5
Input: input and output file name
Process: Fixes the zip codes
Output: Outputs the fixed zip codes to a file
*/
package lab5;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class Lab5 {
    public static void main(String[] args) {
        try { //try
            System.out.print("For the input: "); //Input file name
            String fileName = input();
            System.out.print("For the output: "); //Output file name
            String outFileName = input();
            File inFile = new File(fileName); //input file
            File outFile = new File(outFileName); //output file
            Scanner fileIn = new Scanner(inFile); //Reads the input file
            Scanner lineRead;
            PrintWriter fileOut = new PrintWriter(outFile); //Writes to output file
            while(fileIn.hasNextLine()){ //While not end of file
                String line = fileIn.nextLine(); //Get line
                lineRead = new Scanner(line); //Reads the line
                while(lineRead.hasNext()){ //While not end of line
                    String part = lineRead.next(); //Get each word
                    if(part.matches("\\d{3}")){ //If the word is 3 digits
    //                    System.out.print(part + "-" + part);
                        fileOut.print(part + "-" + part); //Write to file the fixed format
                    }
                    else{
    //                    System.out.print(part);
                        fileOut.print(part); //Else just write to file
                    }
    //                System.out.print(" ");
                    fileOut.print(" ");
                }
                lineRead.close(); //Close the line reader
    //            System.out.println();
                fileOut.println(); //Print endl
            }
            fileOut.close(); //Close the output
            fileIn.close(); //Close the input
        }
        catch (FileNotFoundException exception){ //If file was not found
            System.out.println("File Not Found.");
        }
    }
    /**
     * gets input
     * @return file directory
     */
    public static String input(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the file directory.");
        String file = in.next();
        return file;
    }
}

/*
run:
For the input: Enter the file directory.
C:\Users\g\Desktop\Zips.txt
For the output: Enter the file directory.
C:\Users\g\Desktop\ZipsFixed.txt
BUILD SUCCESSFUL (total time: 30 seconds)

*/