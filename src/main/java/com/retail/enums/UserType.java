package com.retail.enums;

public enum UserType {
	EMPLOYEE(30),
	AFFILIATE(10),
	CUSTOMER(5);
	
	private double discount;
	
	UserType(double discount) {
		this.discount = discount;
	}
	
	public double getDiscount() {
		return discount;
	}

}
