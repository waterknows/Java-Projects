package assignment_9;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;


public class OlympicRingDrawer extends JComponent{
    private static final int WIDTH = 100;
    private static final int HEIGHT = 100;
    private static final int TOP = 3;
    private static final int BOTTOM = 2;
    private static final int SPACING = 5;
    private static final int THICKNESS = 10;
    private static final Color C[] = {Color.BLUE,Color.BLACK,Color.ORANGE,Color.YELLOW,Color.GREEN};
    /**
     * draws rings
     * @param x x coord
     * @param y y coord
     * @param C color
     */
    private void drawRing(int x, int y, Color C, Graphics g){
        g.setColor(C);
        int modif = 0;
        for(int i = 0; i < THICKNESS; i++){ //To create a thickness for the ring
            g.drawOval(x++,y++,WIDTH + modif--,HEIGHT + modif--);            
        }
    }
    /**
     * gets next x
     * @param x coord
     * @return next coord
     */
    private int getNext(int x){
        return x + WIDTH + SPACING;
    }
    /**
     * gets next (in half)
     * @param x coord
     * @return  next coord
     */
    private int getNextHalf(int x){
        return x + HEIGHT/2;
    }
    /**
     * paints components
     * @param g the graphics
     */
    @Override
    public void paintComponent(Graphics g){
        int x = 0;
        int y = 0;
        for(int i = 0; i < TOP; i++){ //Top half
            drawRing(x,y,C[i],g);
            x = getNext(x);
        }
        y = getNextHalf(y);
        x = getNextHalf(0);
        for(int i = 0; i < BOTTOM; i++){ //Bottom half
            drawRing(x,y,C[i + TOP],g);
            x = getNext(x);
        }
    }
        
}