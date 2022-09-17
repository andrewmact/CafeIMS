package cafeItems;

import database.ItemsTable;
import holder.Stock;

public class Coffee extends Item {
	
	static private String name  = "Coffee";
	static private double price = 2.50;
	static private int quantity;
	static private int id = 2233;
	
	Stock coffee = (q)->{
		boolean isOrdered = Stock.updateStock(new Coffee(), q);	
		
		if(isOrdered) {
			quantity += q;
		} 
	};
	
	static {
		try {
			quantity =	ItemsTable.getQuantity(2233);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public double getPrice() { 
		return price;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getQuantity() {
		quantity = ItemsTable.getQuantity(2233);
		return quantity;
	}
	@Override
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public int getID() {
		return id;
	}
	
	@Override
	public boolean heldQuantity(int quantity) {
		if(this.quantity >= quantity) {
			return true;
		}
		else {
			System.out.println("Stock difference is "+this.quantity+" - "+quantity+" = "+(this.quantity - quantity));
			return false;
		}
	}
	@Override
	public boolean updateQuantity(int quantity) {
		
		if(heldQuantity(quantity)) {
			this.quantity -= quantity;
			ItemsTable.updateQuantity(new Coffee(), this.quantity);
		}
		else {
			return false;
		}
		
		if(this.quantity == 0) {
			coffee.order(10);
		}
		return true;
	}
	
	@Override
	public void orderQuantity(int quantity) {
		coffee.order(quantity);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public String toString() {
		return "$"+price+" "+name;	
	}
	
	@Override
	public int hashCode() {
		return id;
	}
	
	@Override
    public boolean equals(Object o) {
		if((o instanceof Coffee) && (((Coffee) o).id == this.id)) {
			return true;
		}
       return false;
	}

	
}
