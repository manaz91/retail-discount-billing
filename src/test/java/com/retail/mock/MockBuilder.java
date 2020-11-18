package com.retail.mock;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.retail.enums.ProductType;
import com.retail.enums.UserType;
import com.retail.model.Item;
import com.retail.model.Product;
import com.retail.model.User;

public class MockBuilder {
	
	private static final int USER_LOYALTY_TIME_PERIOD_IN_YRS = 2;
		
	public static MockBuilder getMockBuilder(MockBuilder mockBuilder) {
		return mockBuilder;
	}
	public static User getAffiliateUser() {
		User user = new User(UserType.AFFILIATE, "testUser001", "Affiliate", LocalDateTime.now().minusYears(3));
		return user;
	}
	
	public static User getEmployeeUser() {
		User user = new User(UserType.EMPLOYEE, "testUser111", "John", LocalDateTime.now().minusYears(3));
		return user;
	}
	
	public static User getLoyalUser() {
		User user = new User(UserType.CUSTOMER, "testUser222", "Caroll", LocalDateTime.now().minusYears(USER_LOYALTY_TIME_PERIOD_IN_YRS).minusDays(1));
		return user;
	}
	
	public static User getNonLoyalUser() {
		User user = new User(UserType.CUSTOMER, "testUser333", "Jan", LocalDateTime.now().minusYears(USER_LOYALTY_TIME_PERIOD_IN_YRS).plusDays(1));
		return user;
	}

	public static User getUserById(String userId) {
		User user = new User(UserType.CUSTOMER, userId, "Arya", LocalDateTime.now().minusYears(USER_LOYALTY_TIME_PERIOD_IN_YRS).plusDays(1));
		return user;
	}
	
	public static User getUserByName(String name) {
		User user = new User(UserType.CUSTOMER, "testUser333", name, LocalDateTime.now().minusYears(USER_LOYALTY_TIME_PERIOD_IN_YRS).plusDays(1));
		return user;
	}
	
	public static Item getItemWithDiscountableProduct(int quantity) {
		return new Item(getDiscountableProduct(), quantity);
	}
	
	public static Item getItemWithNonDiscountableProduct(int quantity) {
		return new Item(getNonDiscountableProduct(), quantity);
	}
	
	public static List<Item> getItemListWithMultipleProducts() {
		List<Item> items = new ArrayList<Item>();
		items.add(getItemWithDiscountableProduct(10));
		items.add(getItemWithNonDiscountableProduct(5));
		return items;
	}
	public static Product getDiscountableProduct() {
		Product product = new Product();
		product.setProductId("S1111111");
		product.setProductName("Notebook");
		product.setProductType(ProductType.OTHERS);
		product.setRate(57.99);
		
		return product;
	}
	
	public static Product getNonDiscountableProduct() {
		Product product = new Product();
		product.setProductId("G1111111");
		product.setProductName("Rice");
		product.setProductType(ProductType.GROCERY);
		product.setRate(49.99);
		
		return product;
	}
}
