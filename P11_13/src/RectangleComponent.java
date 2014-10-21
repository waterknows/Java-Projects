import java.awt.Graphics;

import javax.swing.JComponent;
/**
This component displays a rectangle that can be moved.
 */
@SuppressWarnings("serial")
public class RectangleComponent extends JComponent
{
	private static final int RECTANGLE_WIDTH = 20;
	private static final int RECTANGLE_HEIGHT = 30;
	private int xLeft;
	private int yTop;
	public RectangleComponent()
	{
		xLeft = 0;
		yTop = 0;
	}
	public void paintComponent(Graphics g)
	{
		g.fillRect(xLeft, yTop, RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
	}
	/**
Moves the rectangle by a given amount.
@param dx the amount to move in the x-direction
@param dy the amount to move in the y-direction
	 */
	public void moveRectangleBy(int dx, int dy)
	{
		if(xLeft + RECTANGLE_WIDTH == 300 || xLeft == 0)
			dx *= -1;
		if(yTop + RECTANGLE_HEIGHT == 400 || yTop == 0)
			dy *= -1;
		xLeft = xLeft + dx;
		yTop = yTop + dy;
		repaint();
	}

}