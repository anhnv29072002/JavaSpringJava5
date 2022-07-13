package com.assigment.service;

import java.util.List;

import com.assigment.entity.Category;

public interface ICategoryService {

	public Category insert(Category category);

	public Category update(Category category);

	public Category deleteById(Integer id);

	public Category getById(Integer id);

	public List<Category> getAll();
	
}
