package com.retail.service.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.retail.exception.CustomException;
import com.retail.mock.MockBuilder;
import com.retail.model.Item;
import com.retail.model.User;
import com.retail.service.DiscountService;
import com.retail.service.impl.DiscountServiceImpl;

public class DiscountServiceImplTest {
	Logger logger = LoggerFactory.getLogger(DiscountServiceImplTest.class);
	private DiscountService discountService;
	private List<Item> items;
	
	@Before
	public void setUp() {
		discountService = new DiscountServiceImpl();
		items = MockBuilder.getItemListWithMultipleProducts();
	}
	@Test
	public void shouldGetMockBuilder() {
		MockBuilder mockBuilder = new MockBuilder();
		Assert.assertEquals(mockBuilder, MockBuilder.getMockBuilder(mockBuilder));
	}
	@Test
	public void shouldCalculateBillForDiscountEligibleUser() {
		User user = MockBuilder.getLoyalUser();
		try {
			Assert.assertEquals(761.00, discountService.calculatePayableAmount(user, items), 0);
		} catch (CustomException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void shouldCalculateBillForNonEligibleUser() {
		User user = MockBuilder.getNonLoyalUser();
		try {
			Assert.assertEquals(790.00, discountService.calculatePayableAmount(user, items), 0);
		} catch (CustomException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void shouldCalculateBillforAffiliateUser() {
		User affiliateUser = MockBuilder.getAffiliateUser();
		try {
			Assert.assertEquals(737.00, discountService.calculatePayableAmount(affiliateUser, items), 0);
		} catch (CustomException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void shouldCalculateBillForEmployeeUser() {
		User employeeUser = MockBuilder.getEmployeeUser();
		try {
			Assert.assertEquals(626.00, discountService.calculatePayableAmount(employeeUser, items), 0);
		} catch (CustomException e) {
			e.printStackTrace();
		}
	}
}
