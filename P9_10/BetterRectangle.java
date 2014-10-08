import java.awt.Rectangle;


public class BetterRectangle extends Rectangle{
	
	public BetterRectangle(int width, int height) {
		super(width,height);
	}
	
	public double getPerimeter() {
		return 2*super.height + 2*super.width;
	}
	
	
	public double getArea() {
		return super.height * super.width;
	}
}
