package com.assigment.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assigment.entity.Category;
import com.assigment.model.CategotyDTO;

@Service
public class CategoryMapper {

	@Autowired
	private ModelMapper mapper;
	
	public Category convertToEntity(CategotyDTO categotyDTO) {
		Category category = this.mapper.map(categotyDTO, Category.class);
		return category;
	}
	
	public CategotyDTO convertToDTO(Category categoty) {
		CategotyDTO categotyDTO = this.mapper.map(categoty, CategotyDTO.class);
		return categotyDTO;
	}
	
}
