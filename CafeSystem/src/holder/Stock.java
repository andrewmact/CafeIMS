package holder;

import cafeItems.Item;
import database.ItemsTable;
import database.OrdersTable;

@FunctionalInterface
public interface Stock {

	public static int checkStock(Item i) {
		try {
			 int stock = ItemsTable.getQuantity(i.getID());
			 return stock;
		}
		catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static boolean updateStock(Item i, int quantity) {
		try {
			OrdersTable.orderItem(i, quantity);
			ItemsTable.updateQuantity(i, i.getQuantity()+quantity);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	abstract void order(int quantity);
	
}
