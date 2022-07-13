package com.assigment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name = "oder_details")
public class OderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Oder oder;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@NotNull(message = "Không được để trống")
	@Column
	private double price;
	
	@NotNull(message = "Không được để trống")
	@Column
	private int quantity;
	
	@NotNull(message = "Không được để trống")
	@Column(name = "tong_tien")
	private double tongTien;
	
}
