package com.assigment.entity;

import java.util.Map;

import lombok.Data;

@Data
public class Cart {
	
	private Product product;
	
	private int quantity;
	
	public Integer quantityUp() {
		return this.quantity++;
	}
	
	public Integer quantityDown() {
		return this.quantity--;
	}
	
}
