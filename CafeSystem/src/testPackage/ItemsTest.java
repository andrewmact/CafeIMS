package testPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import cafeItems.Coffee;
import cafeItems.Muffin;
import cafeItems.Mug;
import database.ItemsTable;

class ItemsTest {

	Coffee coffee = new Coffee();
	/**
	static private String name  = "Coffee";
	static private double price = 2.50;
	static private int quantity;
	static private int id = 2233;
	 */
	@Test
	void testCoffee() {
		assertNotNull(coffee);
		
		String name = coffee.getName();
		double price = coffee.getPrice();
		int quantity = coffee.getQuantity();
		int id = coffee.getID();
		
		assertEquals("Coffee", name);
		assertEquals(2.50, price);
		assertEquals(quantity, 10);
		assertEquals(2233, id);
	}
	
	@Test
	void testItemsHeldQunatity() {
		/**
		 * Held Quantity: Boolean
		 * - checks to see if the requested quantity is enough to fullfill the order
		 * quantity = 10
		 */
		coffee.setQuantity(10);
		
		Assert.assertTrue(coffee.heldQuantity(5));
		Assert.assertTrue(coffee.heldQuantity(10));
		Assert.assertFalse(coffee.heldQuantity(11));		
	}
	
	@Test
	void testItemsUpdateQuantity() {
		/**
		 * Update Quantity: Boolean
		 * - When coffee is bought quantity is removed
		 */
		coffee.setQuantity(10);
		
		//quantity = 10
		Assert.assertTrue(coffee.updateQuantity(5));
		//quantity = 5, not enough
		Assert.assertFalse(coffee.updateQuantity(10));
		Assert.assertEquals(coffee.getQuantity(), 5);
		//quantity = 5, will equal 0
		Assert.assertTrue(coffee.updateQuantity(5));
		Assert.assertEquals(coffee.getQuantity(), 10);
	}
	
	@Test
	void testItemsOrder() {
		coffee.setQuantity(10);
		
		Assert.assertEquals(coffee.getQuantity(), 10);
		coffee.orderQuantity(10);
		Assert.assertEquals(coffee.getQuantity(), 20);
	}
	
	Muffin muffin = new Muffin();
	/**
	private static String name  = "Muffin";
	private static double price = 3.50;
	private static int quantity;
	private static int id = 6825;
	 */
	@Test 
	void testMuffin() {
		assertNotNull(muffin);
		
		String name = muffin.getName();
		double price = muffin.getPrice();
		int quantity = muffin.getQuantity();
		int id = muffin.getID();
		
		assertEquals("Muffin", name);
		assertEquals(3.50, price);
		assertEquals(quantity, 25);
		assertEquals(6825, id);
	}
	
	@Test
	void testMuffinQunatity() {
	
	}	
	
	Mug mug = new Mug();
	/**
	private static String name  = "Mug";
	private static double price = 10.99;
	private static int quantity;
	private static int id = 3344; 
	 */
	@Test 
	void testMug() {
		assertNotNull(mug);
		
		String name = mug.getName();
		double price = mug.getPrice();
		int quantity = mug.getQuantity();
		int id = mug.getID();
		
		assertEquals("Mug", name);
		assertEquals(10.99, price);
		assertEquals(quantity, 10);
		assertEquals(3344, id);
	}
	
	@Test
	void testMugQunatity() {
		
	}	
}
