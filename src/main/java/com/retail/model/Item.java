package com.retail.model;

import javax.validation.constraints.NotNull;

import com.retail.enums.ProductType;

import lombok.Getter;

@Getter
public class Item {
	
	private Product product;
	
	@NotNull
	private int quantity;
	
	private double totalCost;
	
	public Item(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.totalCost = product.getRate() * quantity;
	}

	public double getDiscountedPrice(double discountPercentage) {
		if(product.getProductType() != ProductType.GROCERY && discountPercentage != 0 ) {
			return (totalCost - totalCost * discountPercentage/100);
		}
		return totalCost;
	}

}
