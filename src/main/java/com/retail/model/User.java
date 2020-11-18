package com.retail.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.retail.constants.Constants;
import com.retail.enums.UserType;

import lombok.Getter;

@Getter
public class User {
		
	private UserType userType;

	@NotNull
	private String userId;

	@NotNull
	private String userName;

	@NotNull
	private LocalDateTime createdOn;
	
	public User(UserType userType, String userId, String userName, LocalDateTime createdOn) {
		super();
		this.userType = userType;
		this.userId = userId;
		this.userName = userName;
		this.createdOn = createdOn;
	}	
	
	public boolean isLoyalUser() {
		LocalDateTime dateToCompare = LocalDateTime.now().minusYears(Constants.USER_LOYALTY_TIME_PERIOD_IN_YRS);
		return createdOn.isBefore(dateToCompare) && (UserType.CUSTOMER == userType);
	}
}
