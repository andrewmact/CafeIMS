package holder;

import cafeItems.Coffee;
import cafeItems.Muffin;
import cafeItems.Mug;

public class CafeMenu {	

	public Coffee getCoffee(String size, int additive) {
		Coffee coffee = new Coffee();
		
		if(coffee.getQuantity() >= 10) {
			return coffee;
		} 
		else if(coffee.getQuantity() < 10 && coffee.getQuantity() > 0){
			coffee.orderQuantity(10);
			return coffee;
		}
		return null;
		
	}
	
	public Muffin getMuffin() {
		Muffin muffin = new Muffin();
		
		if(muffin.getQuantity() >= 10) {
			return muffin;
		} 
		else if(muffin.getQuantity() < 10 && muffin.getQuantity() > 0) {
			muffin.orderQuantity(10);
			return muffin;
		}
			return null;
		
	}
	
	public Mug getMug() {
		Mug mug = new Mug();
		
		if(mug.getQuantity() >= 10) {
			return mug;
		} 
		else if(mug.getQuantity() < 10 && mug.getQuantity() > 0) {
			mug.orderQuantity(10);
			return mug;
		}
			return null;
	}
	
	
}
