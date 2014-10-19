package assignment_9;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class GridWindow extends JFrame{
    private static final int FRAME_WIDTH =  700;
    private static final int FRAME_HEIGHT = 700;
    private GridDrawer Grid;
    private JTextField text;
    private JButton submit;
    private JPanel panel;
    /**
     * default constructor
     */
    public GridWindow(){
        createComponents();
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
    }
    /**
     * create components
     */
    private void createComponents(){
        Grid = new GridDrawer();
        Grid.setPreferredSize(new Dimension(500,500));
        text = new JTextField(10);
        submit = new JButton("Submit");
        submit.addActionListener(new ActionListener(){ //Anonymous Action Listener
            @Override
            public void actionPerformed(ActionEvent ae) {
                Grid.setN(Integer.parseInt(text.getText())); //Sets the rows and columns
                Grid.redraw();
            }
        });
        panel = new JPanel();
        panel.add(text);
        panel.add(submit);
        panel.add(Grid);
        add(panel);

        
    }
}