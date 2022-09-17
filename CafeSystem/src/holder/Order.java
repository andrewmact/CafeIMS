package holder;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;

import cafeItems.Item;


public class Order {
	
	double totalPrice = 0;
	int totalQuantity = 0;
	HashMap<Item, Integer> order;
	
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	public Order(){
		order = new HashMap<Item, Integer>();
	}
	
	public void add(int quantity, Item i) {
		
		if(i.heldQuantity(quantity)) {
			order.put(i, quantity);
			totalPrice += i.getPrice()*quantity;
		}
	}
	
	public void remove(Item i) {
		int quantity = order.remove(i);
		totalPrice -= i.getPrice()*quantity;
	}
	
	
	public double getTotal(){
		return totalPrice;
	}
	
	
	public void displayOrder() {
		order.entrySet().forEach(System.out::println);
		System.out.println("Total Price: $"+df.format(totalPrice));
	}
	
	public boolean purchaseOrder(String payment) {
		boolean paid = false;
		
		switch(payment) {
		case "Visa": paid = true;
			break;
		case "MasterCard": paid = true;
			break;
		case "Cash": paid = true;
			break;
		}	
		if(paid) {
		checkoutItems();
		displayOrder();
		}
		return paid;
	}
	
	Item item;
	public void checkoutItems() {
		
		order.entrySet().stream().forEach((entry)->{
		item = entry.getKey();
		int q = entry.getValue();
	
			item.updateQuantity(q);
	});
						
	}
}
