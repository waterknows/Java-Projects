package assignment_9;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class RectangleWindow extends JFrame{
    private static final int FRAME_WIDTH =  700;
    private static final int FRAME_HEIGHT = 700;
    private RectangleMaker Rect;
    private JTextField text;
    private JButton submit;
    private JPanel panel;
    /**
     * default constructor
     */
    public RectangleWindow(){
        createComponents();
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
    }
    /**
     * creates components
     */
    private void createComponents(){
        Rect = new RectangleMaker();
        Rect.setPreferredSize(new Dimension(500,500));
        text = new JTextField(10); //Text Field
        submit = new JButton("Submit"); //Button
        submit.addActionListener(new ActionListener(){ //Anonymous Action Listener
            @Override
            public void actionPerformed(ActionEvent ae) {
                Rect.setNum(Integer.parseInt(text.getText())); //Change the number of rectangles
                Rect.redraw();
            }
        });
        panel = new JPanel();
        panel.add(text);
        panel.add(submit);
        panel.add(Rect);
        add(panel);

        
    }
}