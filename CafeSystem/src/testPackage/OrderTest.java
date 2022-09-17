package testPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import cafeItems.Coffee;
import cafeItems.Muffin;
import cafeItems.Mug;
import holder.Order;

class OrderTest {
	
	@Test
	void testAdd() {
		//A coffee equals $2.50
		Order order = new Order();
		
		Coffee coffee = new Coffee();
		order.add(1, coffee);
		double total = order.getTotal();
		
		Assert.assertTrue(total == 2.50);
	}

	@Test
	void testRemove() {
		Order order = new Order();
		
		Coffee coffee = new Coffee();
		order.add(1, coffee);
		double total = order.getTotal();
		
		Assert.assertTrue(total == 2.50);
		
		order.remove(coffee);
		total = order.getTotal();
		Assert.assertTrue(total == 0.0);
		Assert.assertFalse(total == 2.50);
	}
	
	@Test
	void testDisplayOrder() {
		Order order = new Order();
		
		order.add(2, new Coffee());
		order.add(4, new Muffin());
		order.add(1, new Mug());
		
		order.displayOrder();
	}
	
	@Test
	void testPurchaseOrder() {
		Order order = new Order();
		
		String test1 = "Visa";
		Assert.assertTrue(order.purchaseOrder(test1));
		
		String test2 = "MasterCard";
		Assert.assertTrue(order.purchaseOrder(test2));
		
		String test3 = "Cash";
		Assert.assertTrue(order.purchaseOrder(test3));
		
		String test4 = "something";
		Assert.assertFalse(order.purchaseOrder(test4));
	}
	
	@Test
	void testCheckItemsTrue() {
		Order order = new Order();
		
		Coffee coffee = new Coffee();
			   coffee.setQuantity(15);
		Muffin muffin = new Muffin();
			   muffin.setQuantity(15);
		Mug mug = new Mug();
			mug.setQuantity(15);
			
		order.add(2, coffee);
		order.add(4, muffin);
		order.add(1, mug);
		
		order.checkoutItems();
		
		Assert.assertEquals(coffee.getQuantity(), 13);
		Assert.assertEquals(muffin.getQuantity(), 11);
		Assert.assertEquals(mug.getQuantity(), 14);
	}
	
}
