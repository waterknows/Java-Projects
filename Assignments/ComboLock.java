
package a8;
public class ComboLock {
    private int combo1;
    private int combo2;
    private int combo3;
    private int numberAt;
    private boolean clicked1;
    private boolean clicked2;
    private boolean clicked3;
    private final int MAX_NUM = 39;
    public ComboLock(){
        combo1 = combo2 = combo3 = numberAt = 0;
        clicked1 = clicked2 = clicked3 = false;
    }
    public ComboLock(int newCombo1, int newCombo2, int newCombo3) throws Exception{
        if(comboIsValid(newCombo1) && comboIsValid(newCombo2) && comboIsValid(newCombo3)){
            combo1 = newCombo1;
            combo2 = newCombo2;
            combo3 = newCombo3;
        }
        else
            throw new Exception("Invalid default combination");
        clicked1 = clicked2 = clicked3 = false;
        numberAt = 0;
    }
    public int getPosition(){
        return numberAt;
    }
    public void reset(){
        numberAt = 0;
        clicked1 = clicked2 = clicked3 = false;
    }
    public void turnLeft(int ticks){
        for(int it = 1; it <= ticks; it++){
            if(numberAt == 0)
                numberAt = MAX_NUM;
            else
                numberAt--;
        }
        if(numberAt == combo2)
            clicked2 = true;
    }
    public void turnRight(int ticks){
        for(int it = 1; it <= ticks; it++){
            if(numberAt == MAX_NUM)
                numberAt = 0;
            else
                numberAt++;
        }
        if(numberAt == combo1)
            clicked1 = true;
        if(numberAt == combo3)
            clicked3 = true;
    }
    public boolean open(){
        return clicked1 && clicked2 && clicked3;
    }
    private boolean comboIsValid(int newCombo){
        return newCombo <= MAX_NUM && !isNegative(newCombo);
    }
    private boolean isNegative(int integer){
        return integer < 0;
    }
    
}
