package a8;
import java.util.Random;
public class Resistor{
    private double nominalResistance;
    private double tolerance;
    private double actualResistance;
    public Resistor(){
        nominalResistance = tolerance = actualResistance = 0;
    }
    public Resistor(double nominalResistance, double tolerance){
        this.nominalResistance = nominalResistance;
        this.tolerance = tolerance;
        setActualResistance();
    }
    public void setNominal(double nominalResistance){
        this.nominalResistance = nominalResistance;
        setActualResistance();
    }
    public void setTolerance(double tolerance){
        this.tolerance = tolerance;
        setActualResistance();
    }
    public double getNominal(){
        return nominalResistance;
    }
    public double getTolerance(){
        return tolerance;
    }
    public double getActual(){
        return actualResistance;
    }
    public String[] getColorBands(){
        String[] colorList = new String[4];
        for(int index = 0; index < 4; index++){
            colorList[index] = calculateColor(index + 1);
        }
        return colorList;
    }
    private void setActualResistance(){
        Random Rand = new Random();
        actualResistance = Rand.nextDouble() * (calculateMax() - calculateMin()) + calculateMin();
    }
    private String calculateColor(int place){
        if(place == 1){
            int firstDigit = (int)getActualSig()/10;
            return colorCheckDigit(firstDigit);
        }
        else if(place == 2){
            int secondDigit = (int)(getActualSig() - getActualSig()/10);
            return colorCheckDigit(secondDigit);
        }
        else if(place == 3){
            return colorCheckMult(getActualExp());
        }
        else{
            return colorCheckTol(tolerance);
        }
    }
    private String colorCheckDigit(int modif){
        switch(modif){
            case 0:{
                return "Black";
                break;
            }
            case 1:{
                return "Brown";
                break;
            }
            //TODO Switches for all three check functions
            //Maybe store in multidimensional array 
            //One string array for color
            //Another double array for digits/exp/tolerance that matches
            
        }
    }
    private String colorCheckMult(int multi){
        
    }
    private String colorCheckTol(double tol){
        
    }
    private double calculateMax(){
        return nominalResistance + (nominalResistance * tolerance);
    }
    private double calculateMin(){
        return nominalResistance - (nominalResistance * tolerance);
    }
    private double getActualSig(){
        double actualTemp = actualResistance;
        while(actualTemp / 100 >= 1){
            actualTemp /= 10;
        }
        return actualTemp;
    }
    private int getActualExp(){
        int exp = 0;
        double actualTemp = actualResistance;
        while(actualTemp / 100 >= 1){
            exp++;
            actualTemp /= 10;
        }
        return exp;
    }
}