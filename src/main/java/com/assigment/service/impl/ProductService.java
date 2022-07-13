package com.assigment.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.assigment.entity.Product;
import com.assigment.repository.IProductRepository;
import com.assigment.service.IProductService;

@Service
public class ProductService implements IProductService {

	@Autowired
	private IProductRepository repository;

	@Override
	public Product insert(Product product) {
		product.setId(null);
		return this.repository.save(product);
	}

	@Override
	public Product update(Product product) {
		Integer id = product.getId();
		if (id != null) {
			Optional<Product> optProduct = this.repository.findById(id);
			if (optProduct.isPresent() == true) {
				return this.repository.save(product);
			}
		}
		return null;
	}

	@Override
	public Product deleteById(Integer id) {
		if (id != null) {
			Optional<Product> optProduct = this.repository.findById(id);
			if (optProduct.isPresent() == true) {
				this.repository.deleteById(id);
				return optProduct.get();
			}
		}
		return null;
	}

	@Override
	public Product getById(Integer id) {
		if (id != null) {
			Optional<Product> optProduct = this.repository.findById(id);
			if (optProduct.isPresent() == true) {
				return optProduct.get();
			}
		}
		return null;
	}

	@Override
	public List<Product> getAll() {
		return this.repository.findAll();
	}

	@Override
	public Page<Product> searchName(String name,Pageable pageable) {
		return this.repository.findByNameLike(name, pageable);
	}

}
