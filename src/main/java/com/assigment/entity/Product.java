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
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Không được để trống")
	@Column
	private String name;
	
	@NotNull(message = "Không được để trống")
	@Column
	private double price;
	
	@NotNull(message = "Không được để trống")
	@Column
	private int quantity;
	
	@Temporal(TemporalType.DATE)
	@Column
	private Date createdDate;
	
	@NotNull(message = "Không được để trống")
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@Column
	private String image;
	
}
