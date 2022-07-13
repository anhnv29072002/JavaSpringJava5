package com.assigment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
@Entity
@Table
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Không được để trống")
	@Column
	private String username;
	
	@NotBlank(message = "Không được để trống")
	@Column
	private String password;
	
	@NotBlank(message = "Không được để trống")
	@Column
	private String fullname;
	
	@NotBlank(message = "Không được để trống")
	@Email(message = "Không đúng định dạng email")
	@Column
	private String email;
	
	@Column
	private String photo;
	
	@NotNull(message = "Không được để trống")
	@Column
	private int admin;
	
}
