import java.util.Scanner;

import javax.swing.JFrame;

import restaurant.Bill;
import restaurant.BillViewer;
import restaurant.ItemFood;

/* Name : Joseph Park, Tony Lim
 * Date : Oct 14, 2014
 * Assignment : P10.35
 * Description : Making a restaurant bill calculator
 */



public class testRestaurant {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// testBills (Working)
		// testFrame
		// Combine
		// testFinalResult
		
		//Test the bill
		Bill Chipotle = new Bill();
		Chipotle.add_item(new ItemFood("Burrito", 5.3));
		Chipotle.add_item(new ItemFood("Apple", 5.6));
		Chipotle.add_item(new ItemFood("Taco", 10.54));
		System.out.println(Chipotle.getItemAndPrice());
		System.out.println("");

		
		//Test the Frame
		JFrame billFrame = new BillViewer();
//		billFrame.setSize(40);
		billFrame.setTitle("Restaurant Bill");
		billFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		billFrame.setVisible(true);
		
	}

}
