package com.assigment.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assigment.entity.Category;
import com.assigment.repository.ICategoryRepository;
import com.assigment.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private ICategoryRepository repository;

	@Override
	public Category insert(Category category) {
		category.setId(null);
		return this.repository.save(category);
	}

	@Override
	public Category update(Category category) {
		Integer id = category.getId();
		if (id != null) {
			Optional<Category> optCategory = this.repository.findById(id);
			if (optCategory.isPresent() == true) {
				return this.repository.save(category);
			}
		}
		return null;
	}

	@Override
	public Category deleteById(Integer id) {
		if (id != null) {
			Optional<Category> optCategory = this.repository.findById(id);
			if (optCategory.isPresent() == true) {
				this.repository.deleteById(id);
				return optCategory.get();
			}
		}
		return null;
	}

	@Override
	public Category getById(Integer id) {
		if (id != null) {
			Optional<Category> optCategory = this.repository.findById(id);
			if (optCategory.isPresent() == true) {
				return optCategory.get();
			}
		}
		return null;
	}

	@Override
	public List<Category> getAll() {
		return this.repository.findAll();
	}

}
