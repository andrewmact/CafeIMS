package cafeItems;

import database.ItemsTable;
import holder.Stock;

public class Muffin extends Item{
	
	private static String name  = "Muffin";
	private static double price = 3.50;
	private static int quantity;
	private static int id = 6825;
	
	Stock muffin = (q)->{
		boolean isOrdered = Stock.updateStock(new Muffin(), q);	
		
		if(isOrdered) {
			quantity += q;
		} 
	};
	
	static {
		try {
			quantity =	ItemsTable.getQuantity(6825);
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
		}
		else {
			return false;
		}
		
		if(this.quantity == 0) {
			muffin.order(10);
		}
		return true;
	}
	
	@Override
	public void orderQuantity(int quantity) {
		muffin.order(quantity);
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
		if((o instanceof Muffin) && (((Muffin) o).id == this.id)) {
			return true;
		}
       return false;
	}
	
}
