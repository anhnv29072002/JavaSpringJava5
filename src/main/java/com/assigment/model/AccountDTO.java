package com.assigment.model;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class AccountDTO {
	
	private Integer id;
	
	@NotBlank(message = "Không được để trống")
	private String username;
	
	@NotBlank(message = "Không được để trống")
	private String password;
	
	@NotBlank(message = "Không được để trống")
	private String fullname;
	
	@NotBlank(message = "Không được để trống")
	@Email(message = "Không đúng định dạng email")
	private String email;
	
	private String photo;
	
	@NotNull(message = "Không được để trống")
	private int admin;
	
	
}
