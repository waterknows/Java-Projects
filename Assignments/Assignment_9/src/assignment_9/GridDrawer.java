package assignment_9;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class GridDrawer extends JComponent{
    private static final int MAXDIM = 500;
    private int size;
    private int n = 1;
    /**
     * paints components
     * @param g 
     */
    @Override
    public void paintComponent(Graphics g){
        int x = 0, y = 0;
        calculateSize(n);
        g.setColor(Color.BLACK);
        for(int i = 0; i < n; i++){ //draws the grid
            for(int j = 0; j < n; j++){
                g.drawRect(x,y,size,size);
                x += size;
            }
            x = 0;
            y += size;
        }
    }
    /**
     * calculates the size of the boxes
     * @param n number of boxes
     */
    private void calculateSize(int n){
        size = MAXDIM/n;
    }
    /**
     * sets the number of boxes
     * @param n 
     */
    public void setN(int n){
        this.n = n;
    }
    /**
     * repaints
     */
    public void redraw(){
        repaint();
    }
}
        