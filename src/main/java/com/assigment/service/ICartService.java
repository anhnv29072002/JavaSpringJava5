package com.assigment.service;

import java.util.Collection;
import java.util.Map;

import com.assigment.entity.Cart;

public interface ICartService {

	public double getTotal();

	public void delete(int productId);

	public void addToCart(Cart cart);

	public Collection<Cart> getAll();

	void updateToCartDown(int productId);

	void updateToCartUp(int productId);
	
}
