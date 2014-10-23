/*
Name: Joseph Park
Date: 
Assignment: 
Input: 
Process: 
Output: 
*/
package assignment10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Assignment10 {
    public static void main(String[] args) {
//        testP11_12();
        testP11_22();
    }
    public static void testP11_12(){
        final int DELAY = 1000;
        final JLabel time = new JLabel();

        class TimerListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent event){
                Date CurrentTime = new Date();
                time.setText("" + CurrentTime);
            }
        }
        ActionListener listener = new TimerListener();
        Timer t = new Timer(DELAY,listener);
        t.start();
        JFrame frame = new JFrame();
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(time);
        frame.setVisible(true);
    }
    public static void testP11_22(){
        JFrame frame = new TriangleViewer();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void testP11_25(){
        
    }
}
