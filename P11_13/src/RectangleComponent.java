import java.awt.Color;
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
	int dx = 1;
	int dy = 1;
	boolean hitwall = false;
	private int xLeft;
	private int yTop;
	private float R, G, B;
	
	public RectangleComponent()
	{
		R = 0.0f;
		G = 0.0f;
		B = 0.0f;
		xLeft = 0;
		yTop = 0;
	}
	public void paintComponent(Graphics g)
	{
		if(hitwall) {
			R = (float)(Math.random());
			G = (float)(Math.random());
			B = (float)(Math.random());
			hitwall = false;
		}
		g.setColor(new Color(R,G,B));
		g.fillRect(xLeft, yTop, RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
	}
	/**
Moves the rectangle by a given amount.
@param dx the amount to move in the x-direction
@param dy the amount to move in the y-direction
	 */
	public void moveRectangleBy()
	{
		if(     (xLeft + RECTANGLE_WIDTH == 300) && (dx > 0)    || 
				(xLeft == 0 && dx < 0)   ) {
			dx *= -1;
			hitwall = true;
		}
		if( (yTop + RECTANGLE_HEIGHT == 400 && dy > 0)  || 
				(yTop == 0 && dy < 0) ) {
			dy *= -1;
			hitwall = true;
		}
		xLeft = xLeft + dx;
		yTop = yTop + dy;
		repaint();
	}

}