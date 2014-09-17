package a8;
public class Moth{
    private double position;
    public Moth(){
        position = 0;
    }
    public Moth(double initialPos){
        position = initialPos;
    }
    public void moveToLight(double lightPos){
        position = getMiddle(position,lightPos);
    }
    public double getPosition(){
        return position;
    }
    private double getMiddle(double pos1, double pos2){
        return (pos1 + pos2) / 2;
    }
}