package com.retail.service;

import java.util.List;

import com.retail.exception.CustomException;
import com.retail.model.Item;
import com.retail.model.User;

public interface DiscountService {
	
	public double calculatePayableAmount(User user, List<Item> items) throws CustomException;

}
