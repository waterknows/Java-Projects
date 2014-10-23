package assignment10;

import java.awt.Graphics;
import javax.swing.JComponent;

public class TriangleComponent extends JComponent{
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int x3;
    private int y3;
    private boolean onePoint;
    private boolean twoPoint;
    private boolean threePoint;
    
    public TriangleComponent(){
        x1 = y1 = x2 = y2 = x3 = y3 = 0;
        onePoint = twoPoint = threePoint = false;
    }
    @Override
    public void paintComponent(Graphics g){
        if(onePoint)
            g.drawOval(x1,x2,0,0);
        if(twoPoint)
            g.drawLine(x1,y1,x2,y2);
        if(threePoint){
            g.drawLine(x2,y2,x3,y3);
            g.drawLine(x1,y1,x3,y3);
        }
    }
    public void drawPoint(int x, int y){
        x1 = x;
        y1 = y;
        onePoint = true;
        repaint();
    }
    public void drawLine(int x, int y){
        x2 = x;
        y2 = y;
        twoPoint = true;
        repaint();
    }
    public void drawTri(int x, int y){
        x3 = x;
        y3 = y;
        threePoint = true;
        repaint();
    }
    public void reset(){
        onePoint = twoPoint = threePoint = false;
        repaint();
    }
    public boolean getFirst(){
        return onePoint;
    }
    public boolean getSecond(){
        return twoPoint;
    }
    public boolean getThird(){
        return threePoint;
    }
}