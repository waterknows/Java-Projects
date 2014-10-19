/*
Name: Joseph Park
Date: 
Assignment: 
Input: 
Process: 
Output: 
*/
package assignment_9;

import javax.swing.JFrame;


public class Assignment_9 {
    public static void main(String[] args) {
        testOlympicRing();
        testRectangle();
        testGrid();
    }
    /**
     * Test Olympic Ring
     */
    public static void testOlympicRing(){
        JFrame window = new DrawingWindow();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
    /**
     * Test Rectangle
     */
    public static void testRectangle(){
        JFrame window = new RectangleWindow();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
    /**
     * Test Grid
     */
    public static void testGrid(){
        JFrame window = new GridWindow();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
