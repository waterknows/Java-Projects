/*
Name: Joseph Park
Date: 
Assignment: 
Input: 
Process: 
Output: 
*/
package assignment.pkg8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Assignment8 {
    public static void main(String[] args){
        boolean endProgram = false; //endprogram
        ArrayList<Appointment> AppList = new ArrayList(); //Holds the appointments

        while(!endProgram){
            try{
                switch(menu()){ //main menu
                    case 1:{ //Add appointment
                        int type = getType();
                        String description = getDescription();
                        SDate AppDate = getDate();
                        Appointment App = createAppointment(type,description,AppDate);
                        AppList.add(App);
                        break;
                    }
                    case 2:{ //See if an ppointment occurs
                        SDate AppDate = getDate();
                        int appLoc = checkDate(AppList,AppDate);
                        AppList.get(appLoc).print();
                        break;
                    }
                    case 3:{ //Clear day
                        SDate AppDate = getDate();
                        clearDay(AppList,AppDate);
                        break;
                    }
                    case 4:{ //Show Appointments
                        printAppointments(AppList);
                        break;
                    }
                    case 5:{ //Read in File
                        String fileName = getFileName();
                        readFile(AppList,fileName);
                        break;
                    }
                    case 6:{ //Save to File
                        String fileName = getFileName();
                        saveFile(AppList,fileName);
                        break;
                    }
                    case 7:{ //Exit
                        endProgram = true;
                        break;
                    }
                    case 0:{ //Test Bank Account
                        testBankAccount();
                        break;
                    }
                    default : throw new Exception("Invalid Menu Choice");
                }
            }
            catch(Exception e) {
                System.out.print(e.getMessage());
            }
        }
    }
    /**
     * tests bank account
     */
    public static void testBankAccount(){
        BankAccount B = new BankAccount(0.1);
        System.out.printf("This is the bank account: $%3.2s\n",B);
    }
    /**
     * creates an appointment
     * @param type type of appointment
     * @param description description
     * @param Date date
     * @return appointment
     * @throws Exception if date is invalid, or if type is invalid
     */
    public static Appointment createAppointment(int type, String description, SDate Date) throws Exception{
        switch(type){
            case 1:{ //OneTime
                return new OneTime(description,Date);
            }
            case 2:{ //Daily
                System.out.println("Start Date:");
                SDate StartDate = getDate();
                System.out.println("End Date:");
                SDate EndDate = getDate();
                return new Daily(description,Date,StartDate,EndDate);
            }
            case 3:{ //Monthly
                Scanner In = new Scanner(System.in);
                System.out.println("Start Month:");
                int startMonth = In.nextInt();
                System.out.println("End Month:");
                int endMonth = In.nextInt();
                return new Monthly(description,Date,startMonth,endMonth);
            }
            default : throw new Exception("Invalid Appointment Type");
        }
    }
    /**
     * checks a date for appointments
     * @param AppList appointment list
     * @param Date date
     * @return the index 
     */
    public static int checkDate(ArrayList<Appointment> AppList, SDate Date){
        int index = 0, year = Date.getYear(), month = Date.getMonth(), day = Date.getDay();
        for (Appointment App : AppList) {
            if(App.occursOn(year, month, day))
                return index;
            index++;
        }
        return -1;
    }
    /**
     * menu
     * @return menu choice 
     */
    public static int menu(){
        System.out.println("(1) to Add Appointment");
        System.out.println("(2) to Check Date");
        System.out.println("(3) to Clear Day");
        System.out.println("(4) to Show Appointments");
        System.out.println("(5) to Read from File");
        System.out.println("(6) to Save to File");
        System.out.println("(7) to Exit");
        System.out.println("(0) to Test Bank Account");
        Scanner In = new Scanner(System.in);
        return In.nextInt();
    }
    /**
     * reads from file
     * @param AppList the appointment list
     * @param fileName file name in string
     * @throws FileNotFoundException if file was not found
     * @throws Exception if date was invalid
     */
    public static void readFile(ArrayList<Appointment> AppList, String fileName) throws FileNotFoundException, Exception{
        try(Scanner In = new Scanner(new File(fileName))){
            while(In.hasNextLine()){
                String line = In.nextLine();
                try(Scanner Line = new Scanner(line)){
                    String description = Line.next();
                    String date = Line.next();
                    SDate ActualDate = readDate(date);
                    if(Line.hasNextInt()){
                        int startMonth = Line.nextInt();
                        int endMonth = Line.nextInt();
                        AppList.add(new Monthly(description,ActualDate,startMonth,endMonth));
                    }
                    else if(Line.hasNext()){
                        String startDate = Line.next();
                        String endDate = Line.next();
                        SDate StartDateAct = readDate(startDate);
                        SDate EndDateAct = readDate(endDate);
                        AppList.add(new Daily(description,ActualDate,StartDateAct,EndDateAct));
                    }
                    else
                        AppList.add(new OneTime(description,ActualDate));
                }
            }
        }
    }
    /**
     * creates a date from a string
     * @param date date string
     * @return the SDate date
     * @throws Exception if date is invalid
     */
    public static SDate readDate(String date) throws Exception{
        Scanner dateReader = new Scanner(date).useDelimiter("\\s*/\\s*");
            int month = dateReader.nextInt();
            int day = dateReader.nextInt();
            int year = dateReader.nextInt();
            return new SDate(year,month,day);
    }
    /**
     * saves to file
     * @param AppList the appointment list
     * @param fileName file name
     * @throws FileNotFoundException  if file was not found
     */
    public static void saveFile(ArrayList<Appointment> AppList, String fileName) throws FileNotFoundException{
        try(PrintWriter Out = new PrintWriter(new File(fileName))){
            for(Appointment App : AppList)
                Out.println(App.toString());
        }
    }
    /**
     * gets the file name
     * @return the file name
     */
    public static String getFileName(){
        Scanner In = new Scanner(System.in);
            System.out.println("Enter the directory of the file: ");
            return In.next();
    }
    /**
     * gets the description
     * @return description
     */
    public static String getDescription(){
        Scanner In = new Scanner(System.in);
            System.out.println("Enter the description of the appointment:");
            return In.nextLine();
    }
    /**
     * gets the date
     * @return date
     * @throws Exception if date is invalid
     */
    public static SDate getDate() throws Exception{
        Scanner In = new Scanner(System.in);
        System.out.println("Enter the date (MM/DD/YYYY):");
        String line = In.next();
        return readDate(line);
    }
    /**
     * gets the type
     * @return type
     */
    public static int getType(){
        Scanner In = new Scanner(System.in);
        System.out.println("Enter the type of appointment:");
        System.out.println("(1) One Time \n(2) Daily \n(3) Monthly");
        return In.nextInt();
    }
    /**
     * clears a day of appointments
     * @param AppList the appointment list
     * @param Date the date
     */
    public static void clearDay(ArrayList<Appointment> AppList, SDate Date){
        int index = 0;
        for(Appointment App : AppList){
            if(isEqual(App.getDate(),Date))
                AppList.remove(index);
            index++;
        }
    }
    /**
     * prints appointments
     * @param AppList appointment list
     */
    public static void printAppointments(ArrayList<Appointment> AppList){
        for(Appointment App : AppList){
            System.out.println(App.toString());
            System.out.println();
        }
    }
    /**
     * checks if two dates are equal (Better if is template)
     * @param Date1 date 1
     * @param Date2 date 2
     * @return true if equal
     */
    public static boolean isEqual(SDate Date1, SDate Date2){
        return (Date1.toString() == null ? Date2.toString() == null : Date1.toString().equals(Date2.toString()));
    }
}


/*
(1) to Add Appointment
(2) to Check Date
(3) to Clear Day
(4) to Show Appointments
(5) to Read from File
(6) to Save to File
(7) to Exit
(0) to Test Bank Account
1
Enter the type of appointment:
(1) One Time 
(2) Daily 
(3) Monthly
1
Enter the description of the appointment:
Today
Enter the date (MM/DD/YYYY):
10/12/2014
(1) to Add Appointment
(2) to Check Date
(3) to Clear Day
(4) to Show Appointments
(5) to Read from File
(6) to Save to File
(7) to Exit
(0) to Test Bank Account
1
Enter the type of appointment:
(1) One Time 
(2) Daily 
(3) Monthly
3
Enter the description of the appointment:
Blah
Enter the date (MM/DD/YYYY):
1/1/2014
Start Month:
1
End Month:
12
(1) to Add Appointment
(2) to Check Date
(3) to Clear Day
(4) to Show Appointments
(5) to Read from File
(6) to Save to File
(7) to Exit
(0) to Test Bank Account
1
Enter the type of appointment:
(1) One Time 
(2) Daily 
(3) Monthly
2
Enter the description of the appointment:
asdf
Enter the date (MM/DD/YYYY):
06/30/2000
Start Date:
Enter the date (MM/DD/YYYY):
06/30/2000
End Date:
Enter the date (MM/DD/YYYY):
06/30/2014
(1) to Add Appointment
(2) to Check Date
(3) to Clear Day
(4) to Show Appointments
(5) to Read from File
(6) to Save to File
(7) to Exit
(0) to Test Bank Account
4
Today 10/12/2014

Blah 1/1/2014 1 12

asdf 6/30/2000 6/30/2000 6/30/2014

(1) to Add Appointment
(2) to Check Date
(3) to Clear Day
(4) to Show Appointments
(5) to Read from File
(6) to Save to File
(7) to Exit
(0) to Test Bank Account
5
Enter the directory of the file: 
C:\Users\BrosephPKC\Desktop\Apps.txt
null(1) to Add Appointment
(2) to Check Date
(3) to Clear Day
(4) to Show Appointments
(5) to Read from File
(6) to Save to File
(7) to Exit
(0) to Test Bank Account
4
Today 10/12/2014

Blah 1/1/2014 1 12

asdf 6/30/2000 6/30/2000 6/30/2014

Hello 1/1/2011

Monthly 1/5/2014 3 7

Daily 6/30/1993 6/30/1993 8/19/2000

(1) to Add Appointment
(2) to Check Date
(3) to Clear Day
(4) to Show Appointments
(5) to Read from File
(6) to Save to File
(7) to Exit
(0) to Test Bank Account
3
Enter the date (MM/DD/YYYY):
10/12/2014
null(1) to Add Appointment
(2) to Check Date
(3) to Clear Day
(4) to Show Appointments
(5) to Read from File
(6) to Save to File
(7) to Exit
(0) to Test Bank Account
4
Blah 1/1/2014 1 12

asdf 6/30/2000 6/30/2000 6/30/2014

Hello 1/1/2011

Monthly 1/5/2014 3 7

Daily 6/30/1993 6/30/1993 8/19/2000

(1) to Add Appointment
(2) to Check Date
(3) to Clear Day
(4) to Show Appointments
(5) to Read from File
(6) to Save to File
(7) to Exit
(0) to Test Bank Account
6
Enter the directory of the file: 
C:\Users\BrosephPKC\Desktop\Apps.txt
(1) to Add Appointment
(2) to Check Date
(3) to Clear Day
(4) to Show Appointments
(5) to Read from File
(6) to Save to File
(7) to Exit
(0) to Test Bank Account
7
*/

/*

*/