package cafeItems;

public class Coffee extends Item{
	
	String name  = "Coffee";
	double price = 2.50;
	int quantity;
	int id = 1;
	

	
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

}
