package holder;

public class Cafe {
	/**
	 * 
	 * This class is used to test run code
	 * 
	 */
	public static void main(String[] args) {
		
	Menu menu = new Menu();
	Order order = new Order();
	
		order.add(1, menu.getMuffin()); 
		order.add(2, menu.getCoffee("s", 1));
		order.displayOrder();
		  
		order.remove(menu.getCoffee("s", 1));
		order.displayOrder();
		 
	}

}
