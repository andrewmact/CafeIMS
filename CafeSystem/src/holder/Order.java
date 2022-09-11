package holder;

import java.util.HashMap;

import cafeItems.Coffee;
import cafeItems.Item;


public class Order {
	
	double totalPrice = 0;
	int totalQuantity = 0;
	HashMap<Item, Integer> order;
	
	Order(){
		order = new HashMap<Item, Integer>();
	}
	
	void add(int quantity, Item i) {
		order.put(i, quantity);
		totalPrice += i.getPrice()*quantity;
	}
	
	void remove(Item i) {
		int quantity = order.remove(i);
		totalPrice -= i.getPrice()*quantity;
	}
	
	
	double getTotal(){
		return totalPrice;
	}
	
	
	void displayOrder() {
		order.entrySet().forEach(System.out::println);
		System.out.println("Total Price: $"+totalPrice);
	}
	
	boolean purchaseOrder(String payment) {
		
		return true;
	}
}
