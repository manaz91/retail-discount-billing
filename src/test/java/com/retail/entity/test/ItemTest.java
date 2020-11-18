package com.retail.entity.test;

import org.junit.Assert;
import org.junit.Test;

import com.retail.mock.MockBuilder;
import com.retail.model.Item;
import com.retail.model.Product;

public class ItemTest {
	
	
	@Test
	public void shouldGetNoDiscountForNonDiscountableProduct() {
		Product product = MockBuilder.getNonDiscountableProduct();
		Item item = new Item(product, 4);
		Assert.assertEquals(199.96, item.getDiscountedPrice(5), 0);
	}
	
	@Test
	public void shouldGetDiscountedPriceForDiscountableProduct() {
		Product product = MockBuilder.getDiscountableProduct();
		Item item = new Item(product, 4);
		Assert.assertEquals(220.36, item.getDiscountedPrice(5), 0.1);
	}
	
	@Test
	public void shouldGetNoDiscountForZeroDiscountPercentage() {
		Product product = MockBuilder.getDiscountableProduct();
		Item item = new Item(product, 4);
		Assert.assertEquals(231.96, item.getDiscountedPrice(0), 0);
		
	}
	@Test
	public void shoulGetProduct() {
		Product product = MockBuilder.getNonDiscountableProduct();
		Item item = new Item(product, 4);
		Assert.assertEquals(product, item.getProduct());
	}
	@Test
	public void shouldGetQuantity() {
		Product product = MockBuilder.getNonDiscountableProduct();
		Item item = new Item(product, 4);
		Assert.assertEquals(4, item.getQuantity());
	}
	@Test
	public void shouldGetTotalCost() {
		Product product = MockBuilder.getNonDiscountableProduct();
		Item item = new Item(product, 4);
		Assert.assertEquals(199.96, item.getTotalCost(),0);
	}
}
