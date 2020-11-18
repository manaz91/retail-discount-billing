package com.retail.entity.test;


import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

import com.retail.mock.MockBuilder;
import com.retail.model.User;

public class UserTest {

	private static final int CUSTOMER_LOYALTY_TIME_PERIOD_IN_YRS = 2;
	
	@Test
	public void shouldReturnTrueForLoyalUser() {
		User user = MockBuilder.getLoyalUser();
		Assert.assertTrue(user.isLoyalUser());
	}
	
	@Test
	public void shouldReturnFalseForNonEmployee() {
		User user = MockBuilder.getAffiliateUser();
		Assert.assertFalse(user.isLoyalUser());
	}
	
	@Test
	public void shouldReturnFalseForNonLoyalUser() {
		User user = MockBuilder.getNonLoyalUser();
		Assert.assertFalse(user.isLoyalUser());
	}
	
	@Test
	public void shouldReturnUserId() {
		String userId = "testUser333";
		User user = MockBuilder.getUserById(userId);
		Assert.assertEquals(userId, user.getUserId());
	}

	
	@Test
	public void shouldReturnUserName() {
		String name = "Jan";
		User user = MockBuilder.getUserByName(name);
		Assert.assertEquals(name, user.getUserName());
	}
	
	@Test
	public void shouldReturnCreatedOn() {
		User user = MockBuilder.getNonLoyalUser();
		Assert.assertEquals(LocalDateTime.now().minusYears(CUSTOMER_LOYALTY_TIME_PERIOD_IN_YRS).plusDays(1), user.getCreatedOn());
	}
}
