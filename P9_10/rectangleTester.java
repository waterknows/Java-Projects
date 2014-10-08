import java.util.Scanner;

/* Name : Tony Lim, Joseph Park
 * Date : Oct 8, 2014
 * Assignment : P9.10 and P9.11
 * Description : Making rectangle
 */


public class rectangleTester {

	public static void main(String[] args) {
		try(Scanner in = new Scanner(System.in)){
			System.out.print("Please insert the height : ");
			int rec_height = in.nextInt();
			System.out.print("Please insert the width  : ");
			int rec_width = in.nextInt();

			BetterRectangle R = new BetterRectangle(rec_width, rec_height);
			System.out.println("Here's the area: " +  R.getArea());
			System.out.println("Here's the perimeter: " +  R.getPerimeter());
		}

	}

}
