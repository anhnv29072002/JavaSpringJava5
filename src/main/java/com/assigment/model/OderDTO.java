package com.assigment.model;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.assigment.entity.Account;

import lombok.Data;

@Data
public class OderDTO {

	private Integer id;
	
	@NotNull(message = "Không được để trống")
	@NotEmpty(message = "Không được trống")
	private Account account;
	
	@NotNull(message = "Không được để trống")
	@NotBlank(message = "Không được để trống")
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	@NotBlank(message = "Không được để trống")
	private String address;
	
}
