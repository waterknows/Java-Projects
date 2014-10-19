package assignment_9;
import javax.swing.JFrame;

public class DrawingWindow extends JFrame{
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 300;
    private OlympicRingDrawer Draw;
    /**
     * default constructor
     */
    public DrawingWindow(){
        createComponents();
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
    }
    /**
     * creates components
     */
    private void createComponents(){
        Draw = new OlympicRingDrawer();
        add(Draw);
    }
}