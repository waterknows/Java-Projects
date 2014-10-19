package assignment_9;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JComponent;

public class RectangleMaker extends JComponent{
    private static final int HEIGHT = 50;
    private static final int WIDTH = 100;
    private static final int MAXHEIGHT = 500 - HEIGHT;
    private static final int MAXWIDTH = 500 - WIDTH;
    private int num = 0;
    /**
     * paints components
     * @param g 
     */
    @Override
    public void paintComponent(Graphics g){
        int x; 
        int y; 
        Color C; 
        for(int i = 0; i < num; i++){ //randomly creates rectangles
            x = getRand(0,MAXWIDTH);
            y = getRand(0,MAXHEIGHT);
            C = new Color(getRand(0,255),getRand(0,255),getRand(0,255));
            g.setColor(C);
            g.fillRect(x,y,HEIGHT,WIDTH);
        }
    }
    /**
     * gets random number
     * @param min min value
     * @param max max value
     * @return random number
     */
    private int getRand(int min, int max){
        Random Rand = new Random();
        return Rand.nextInt((max - min) + 1) + min;
    }
    /**
     * sets the number of rectangles
     * @param num 
     */
    public void setNum(int num){
        this.num = num;
    }
    /**
     * gets the number of rectangles
     * @return 
     */
    public int getNum(){
        return num;
    }
    /**
     * repaints
     */
    public void redraw(){
        repaint();
    }
}
        