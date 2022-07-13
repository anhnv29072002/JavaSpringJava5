package com.assigment.model;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.assigment.entity.Category;

import lombok.Data;

@Data
public class ProductDTO {

	private Integer id;

	@NotBlank(message = "Không được để trống")
	private String name;

	@NotNull(message = "Không được để trống")
	private double price;

	@NotNull(message = "Không được để trống")
	private int quantity;

	@Temporal(TemporalType.DATE)
	private Date createdDate;

	@NotNull(message = "Không được để trống")
	private Category category;

	private String image;
	
}
