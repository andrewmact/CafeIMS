package cafeItems;

import database.ItemsTable;
import holder.Stock;

public class Mug extends Item {
	
	private static String name  = "Mug";
	private static double price = 10.99;
	private static int quantity;
	private static int id = 3344;
	
	Stock coffee = (q)->{
		Stock.updateStock(new Mug(), q);	
	};
	
	static {
		try {
			quantity =	ItemsTable.setQuantity(3344);
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "$"+price+" "+name;	
	}
	
	@Override
	public int hashCode() {
		return id;
	}
	@Override
    public boolean equals(Object o) {
		if((o instanceof Mug) && (((Mug) o).id == this.id)) {
			return true;
		}
       return false;
	}
}
