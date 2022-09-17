package testPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import cafeItems.Coffee;
import cafeItems.Muffin;
import cafeItems.Mug;
import database.ItemsTable;
import holder.CafeMenu;
import holder.Stock;

class MenuTest {

	CafeMenu menu = new CafeMenu();
	
	@Test
	void testCoffee() {
		Coffee coffee = new Coffee();
		Coffee coffeeMenu = menu.getCoffee("m", 0);
		
		Assert.assertEquals(coffee, coffeeMenu);
	}
	@Test
	void testMuffin() {
		Muffin muffin = new Muffin();
		Muffin muffin2 = menu.getMuffin();
		
		Assert.assertEquals(muffin, muffin2);
	}
	@Test
	void testMug() {
		Mug mug = new Mug();
		Mug mug2 = menu.getMug();

		Assert.assertEquals(mug, mug2);
	}

	@Test
	void testQuantityCheck() {
		Coffee coffee = new Coffee();
		ItemsTable.updateQuantity(coffee, 9);
		int q1 = coffee.getQuantity();
		Assert.assertEquals(q1, 9);
		
		Coffee test = menu.getCoffee("m", 0);
		int q2 = test.getQuantity();
		Assert.assertEquals(q2, 19);
	}
}
