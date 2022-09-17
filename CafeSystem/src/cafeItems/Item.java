package cafeItems;

public abstract class Item {
	
	public abstract double getPrice();
	public abstract String getName();
	public abstract int getID();
	
	public abstract int getQuantity();
	public abstract void setQuantity(int quantity);
	public abstract boolean heldQuantity(int quantity);
	public abstract boolean updateQuantity(int quantity);
	public abstract void orderQuantity(int quantity);
}
