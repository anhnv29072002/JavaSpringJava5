package com.assigment.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assigment.entity.Product;
import com.assigment.model.ProductDTO;

@Service
public class ProductMapper {
	
	@Autowired
	private ModelMapper mapper;
	
	public Product convertToEntity(ProductDTO productDTO) {
		Product product = this.mapper.map(productDTO, Product.class);
		return product;
	}
	
	public ProductDTO convertToDTO(Product product) {
		ProductDTO productDTO = this.mapper.map(product, ProductDTO.class);
		return productDTO;
	}
	
	public Product convertToEntityTC(ProductDTO productDTO) {
		Product product = new Product();
		product.setName(productDTO.getName());
		product.setPrice(productDTO.getPrice());
		product.setQuantity(productDTO.getQuantity());
		product.setCreatedDate(productDTO.getCreatedDate());
		product.setCategory(productDTO.getCategory());
//		product.setImage(productDTO.getImage().getOriginalFilename());
		return product;
	}
	
}
