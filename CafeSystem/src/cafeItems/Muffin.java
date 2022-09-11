package cafeItems;

import database.ItemsTable;
import holder.Stock;

public class Muffin extends Item{
	
	private static String name  = "Muffin";
	private static double price = 3.50;
	private static int quantity;
	private static int id = 6825;
	
	Stock coffee = (q)->{
		Stock.updateStock(new Muffin(), q);	
	};
	
	static {
		try {
			quantity =	ItemsTable.setQuantity(6825);
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
		if(quantity == 0) {
			quantity = q;
		}
		else {
			quantity += q;
		}
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
