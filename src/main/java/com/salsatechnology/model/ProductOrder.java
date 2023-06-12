package com.salsatechnology.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "product_order")
public class ProductOrder {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String userName;
	
	@Enumerated(EnumType.STRING)	
	private ProductType productType;
	
	private Integer timeHour;
	private Long productValue;
	private Long productTotal;
	private Long userAmount;
	
	
	
}
