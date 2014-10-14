package restaurant;

import java.util.ArrayList;

public class Bill {
	double static const TAX = .1; // this is in percentage
	ArrayList<ItemFood> foodList;
	
	public void add_item(ItemFood food) {
		foodList.add(food);
	}

}
