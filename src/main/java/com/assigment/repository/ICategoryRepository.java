package com.assigment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assigment.entity.Category;

public interface ICategoryRepository extends JpaRepository<Category, Integer>{

}
