package com.assigment.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.assigment.entity.Oder;
import com.assigment.entity.Product;

import lombok.Data;

@Data
public class OderDetailsDTO {
	
	private Integer id;

	private Oder oder;
	
	private Product product;
	
	@NotNull(message = "Không được để trống")
	private double price;
	
	@NotNull(message = "Không được để trống")
	private int quantity;
	
	@NotNull(message = "Không được để trống")
	private double tongTien;
	
}
