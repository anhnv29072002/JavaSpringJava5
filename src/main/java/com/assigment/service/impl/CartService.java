package com.assigment.service.impl;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assigment.entity.Cart;
import com.assigment.entity.Product;
import com.assigment.service.ICartService;

@Service
public class CartService implements ICartService{

	private Map<Integer, Cart> mapCart;
	
	@Autowired
	private ProductService service;
	public CartService(Map<Integer, Cart> mapCart) {
		this.mapCart = mapCart;
	}
	
	@Override
	public Collection<Cart> getAll(){
		for (Entry<Integer, Cart> entry : mapCart.entrySet()) {
			Product p = this.service.getById(entry.getKey());
			entry.getValue().setProduct(p);
			
		}
		return this.mapCart.values();
	}
	
	@Override
	public void addToCart(Cart cart) {
		Cart cart2 = this.mapCart.get(cart.getProduct().getId());
		if(cart2 != null) {
			cart2.setQuantity(cart2.getQuantity() + cart.getQuantity());
		}else {
			this.mapCart.put(cart.getProduct().getId(), cart);
			this.getAll();
		}
	}
	
	@Override
	public void delete(int productId) {
		this.mapCart.remove(productId);
	}
	
	@Override
	public void updateToCartUp(int productId) {
		Cart cart = this.mapCart.get(productId);
		cart.quantityUp();
		if(cart.getQuantity() <= 0) {
			this.mapCart.remove(productId);
		}
		this.getAll();
	}
	
	@Override
	public void updateToCartDown(int productId) {
		Cart cart = this.mapCart.get(productId);
		cart.quantityDown();
		if(cart.getQuantity() <= 0) {
			this.mapCart.remove(productId);
		}
	}
	
	@Override
	public double getTotal() {
		return this.mapCart.values().stream().mapToDouble(cart->cart.getQuantity() * cart.getProduct().getPrice()).sum();
	}

}
