package com.retail.model;

import com.retail.enums.ProductType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
	
	private String productName;
	
	private String productId;
	
	private ProductType productType;
	
	private double rate;
	

}
