package assignment.pkg8;
import java.io.IOException;
import java.util.Formattable;
import java.util.Formatter;

public class BankAccount implements Formattable{ //Barebones Bank Account Class
    private double balance;
    /**
     * Default Constructor
     */
    public BankAccount(){
        balance = 0.0;
    }
    /**
     * Constructor with balance argument
     * @param newBalance the balance
     */
    public BankAccount(double newBalance){
        balance = newBalance;
    }
    /**
     * Gets the balance
     * @return the balance
     */
    public double getBalance(){
        return balance;
    }
    /**
     * Sets the balance
     * @param newBalance the new balance 
     */
    public void setBalance(double newBalance){
        balance = newBalance;
    }
    /**
     * formats the object; overrides formattable interface
     * @param frmtr Formatter function object
     * @param flags flags for printf (ignored)
     * @param width the width in printf
     * @param precision the precision in printf
     */
    @Override
    public void formatTo(Formatter frmtr, int flags, int width, int precision) {
        Appendable Appender = frmtr.out(); //Make Appendable object
        String balanceString = convertToString(); //Convert to string
        int decimal = findDecimalPlace(balanceString); //Find decimal place
        int numbersAfter = balanceString.length() - decimal; //Find the numbers after decimal
        
        balanceString = setPrecision(balanceString,precision,decimal,numbersAfter); //Set the precision
        balanceString = setWidth(balanceString,width); //Set the width
        try {
            Appender.append(balanceString);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
    /**
     * converts the balance to string
     * @return the string version of balance
     */
    private String convertToString(){
        return "" + balance;
    }
    /**
     * Finds the index of the decimal in the string
     * @param balanceString the string balance
     * @return the index of the decimal
     */
    private int findDecimalPlace(String balanceString){
        for(int i = 0; i < balanceString.length(); i++){
            if(balanceString.charAt(i) == '.')
                return i;
        }
        return -1;
    }
    /**
     * sets the precision in the string
     * @param balanceString the string balance
     * @param precision the precision
     * @param decimal the index of the decimal
     * @param numbersAfter the numbers after decimal
     * @return the formatted string
     */
    private String setPrecision(String balanceString, int precision, int decimal, int numbersAfter){
        if(numbersAfter > precision)
            return balanceString.substring(0,decimal + precision + 1);
        else if(numbersAfter < precision){
            for(int i = 0; i < precision - numbersAfter; i++)
                balanceString += 0;
        }
        return balanceString;
    }
    /**
     * sets the width of the string
     * @param balanceString the string balance
     * @param width the width of the string
     * @return the formatted string
     */
    private String setWidth(String balanceString, int width){
        if(balanceString.length() < width){
            for(int i = 0; i < width - balanceString.length(); i++)
                balanceString += " ";
        }
        return balanceString;
    }
}

