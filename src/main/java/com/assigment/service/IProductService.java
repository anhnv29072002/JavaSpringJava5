package com.assigment.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.assigment.entity.Product;

public interface IProductService {

	public Product insert(Product product);

	public Product update(Product product);

	public Product deleteById(Integer id);

	public Product getById(Integer id);

	public List<Product> getAll();
	
	public Page<Product> searchName(String name,Pageable pageable);
	
}
