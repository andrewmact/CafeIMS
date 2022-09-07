package cafeItems;

public abstract class Item {
	public String name;
	public double price;
	public int quantity;
	
	public abstract double getPrice();
	public abstract String getName();
	
	public abstract int getQuantity();
	public abstract void setQuantity(int quantity);
	public abstract int getID();
}
