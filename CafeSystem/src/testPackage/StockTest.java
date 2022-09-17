package testPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import cafeItems.Coffee;
import cafeItems.Mug;
import holder.CafeMenu;
import holder.Stock;

class StockTest {
	Mug tester = new Mug();
	
	//fm = functional method
	Stock fm = (quantity)->{
		
	};
	
	@Test
	void testStockOrder() {
		Assert.assertNotNull(tester);
		
	}
	
	@Test
	void testStockChecker() {
		CafeMenu menu = new CafeMenu();
	
		Coffee coffee = new Coffee();
		int coffeeQuantity = coffee.getQuantity();	
		int stockQuantity = Stock.checkStock(coffee);
		Assert.assertEquals(coffeeQuantity, stockQuantity);
		
	}

	@Test
	void testStockUpdate() {
		Coffee coffee = new Coffee();
	//	int quantity = coffee.getQuantity();
		
		Assert.assertTrue(Stock.updateStock(coffee, 10));
		Assert.assertEquals(Stock.checkStock(coffee), 20);
	}
}
