package restaurant;

import java.util.ArrayList;

public class Bill {
	final static double TAX = .1; // this is in percentage
	ArrayList<ItemFood> foodList = new ArrayList<ItemFood>();
	
	public void add_item(ItemFood food) {
		foodList.add(food);
	}

	public String getItemAndPrice() {
		String myList = "";
		for (ItemFood itemFood : foodList) {
			myList += (itemFood.foodName + " : " + itemFood.foodPrice + "\n");
		}
		return myList;
	}
	public double getTotalPrice() {
		double sum = 0;
		for (ItemFood itemFood : foodList) {
			sum += itemFood.foodPrice;
		}
		
		sum += (sum*TAX);
		return sum;
	}
}
