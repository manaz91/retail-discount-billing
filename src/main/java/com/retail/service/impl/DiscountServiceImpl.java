package com.retail.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.retail.constants.Constants;
import com.retail.constants.ErrorConstants;
import com.retail.enums.UserType;
import com.retail.exception.ApiException;
import com.retail.model.Item;
import com.retail.model.User;
import com.retail.service.DiscountService;

/*
 * Author: Manaz
 * */
public class DiscountServiceImpl implements DiscountService {
	
	Logger logger = LoggerFactory.getLogger(DiscountServiceImpl.class);
	
	/*
	 * Calculates total payable amount using list of items based on user type
	 * request: User, List<Item> 
	 * response: double
	 * throws ApiException
	 * */
	public double calculatePayableAmount(User user, List<Item> items) throws ApiException {
		double totalDiscountedPrice = 0;
		double discountPercentage = getDiscountForUser(user);
		for(Item item:items) {
			totalDiscountedPrice = totalDiscountedPrice + item.getDiscountedPrice(discountPercentage);
		}		 
		return Math.round(totalDiscountedPrice - getDiscountBasedOnTotal(totalDiscountedPrice));
	}

	/*
	 * Calculates discount for user based on user type
	 * request: User 
	 * response: double
	 * */
	private double getDiscountForUser(User user) {
		UserType userType = user.getUserType();
		return (userType == UserType.EMPLOYEE || userType == UserType.AFFILIATE || user.isLoyalUser()) ? userType.getDiscount() : 0;
	}
	
	/*
	 * Calculates discount on total for each hundred
	 * request: double 
	 * response: double
	 * throws ApiException
	 * */
	private double getDiscountBasedOnTotal(double totalDiscountedPrice) throws ApiException {
		try {
			return Math.floor(totalDiscountedPrice / 100) * Constants.DISCOUNT_PER_HUNDRED;
		} catch(Exception e) {
	        logger.error(e.getMessage());
			throw new ApiException(ErrorConstants.SERVICE_EXCEPTION);
		}
	}
}
