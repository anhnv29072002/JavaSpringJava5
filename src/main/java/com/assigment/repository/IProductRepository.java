package com.assigment.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.assigment.entity.Product;

public interface IProductRepository extends JpaRepository<Product, Integer>{
	public Page<Product> findByNameLike(String name,Pageable pageable);
}
