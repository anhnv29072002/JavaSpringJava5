package com.assigment.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table
public class Oder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "Không được để trống")
	@NotEmpty(message = "Không được trống")
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Account account;
	
	@NotNull(message = "Không được để trống")
	@NotBlank(message = "Không được để trống")
	@Temporal(TemporalType.DATE)
	@Column
	private Date createdDate;
	
	@NotBlank(message = "Không được để trống")
	@Column
	private String address;
	
}
