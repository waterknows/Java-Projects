import java.awt.Rectangle;


public class BetterRectangle extends Rectangle{
	/**
	 * Default Constructor
	 */
	public BetterRectangle(){
		super();
	}
	
	/**
	 * Constructor takes height and width
	 * @param width width of the rectangle
	 * @param height height of the rectangle
	 */
	public BetterRectangle(int width, int height) { 
		super(width,height);
	}
	
	/**
	 * Constructor takes pos and height and width
	 * @param x x coordinates input
	 * @param y y coordinates input
	 * @param width width of the rectangle
	 * @param height height of the rectangle
	 */
	public BetterRectangle(int x, int y,int width, int height) { 
		super(x,y,width,height);
	}
	
	/**
	 * Returns the perimeter
	 * @return the perimeter in double
	 */
	public double getPerimeter() {
		return 2*super.height + 2*super.width;
	}
	
	/**
	 * Returns the area
	 * @return the area in double
	 */
	public double getArea() {
		return super.height * super.width;
	}
}
