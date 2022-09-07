package cafeItems;

public class Mug extends Item {

	String name  = "Mug";
	double price = 10.99;
	int quantity;
	int id = 3;
	

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
		
}
