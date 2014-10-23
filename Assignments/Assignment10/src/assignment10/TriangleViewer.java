package assignment10;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;


public class TriangleViewer extends JFrame{
    private static final int WIDTH = 400;
    private static final int HEIGHHT = 400;
    private TriangleComponent Tri;
    class MouseListen implements MouseListener{
        public void mouseClicked(MouseEvent event){
            int x = event.getX();
            int y = event.getY();
            if(!Tri.getFirst())
                Tri.drawPoint(x,y);
            else if(!Tri.getSecond())
                Tri.drawLine(x,y);
            else if(!Tri.getThird())
                Tri.drawTri(x,y);
            else
                Tri.reset();
        }
        public void mousePressed(MouseEvent event){}
        public void mouseReleased(MouseEvent event){}
        public void mouseEntered(MouseEvent event){}
        public void mouseExited(MouseEvent event){}
    }
    public TriangleViewer(){
        Tri = new TriangleComponent();
        add(Tri);
        MouseListener listen = new MouseListen();
        Tri.addMouseListener(listen);
        setSize(WIDTH,HEIGHT);
    }
}