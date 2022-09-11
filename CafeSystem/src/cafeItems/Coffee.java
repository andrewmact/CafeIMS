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
			quantity =	ItemsTable.setQuantity(2233);
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
		return quantity;
	}
	@Override
	public int getID() {
		return id;
	}
	
	@Override
	public void setQuantity(int q) {
			quantity += q;
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
