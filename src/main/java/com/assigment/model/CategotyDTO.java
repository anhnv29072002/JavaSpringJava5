package com.assigment.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.assigment.entity.Account;

import lombok.Data;

@Data
public class CategotyDTO {
	
	private Integer id;
	
	@NotBlank(message = "Không được để trống")
	private String name;
	
	@NotNull(message = "Không được để trống")
	private Account account;
}
