package holder;

import cafeItems.Coffee;
import cafeItems.Muffin;
import cafeItems.Mug;

public class Menu {	

	Coffee getCoffee(String size, int additive) {
		return new Coffee();
	}

	Muffin muffin;
	
	Muffin getMuffin() {
		return new Muffin();
	}
	
	Mug getMug() {
		return new Mug();
	}
	
	
}
