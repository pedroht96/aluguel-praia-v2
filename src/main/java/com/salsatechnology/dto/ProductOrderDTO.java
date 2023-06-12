package com.salsatechnology.dto;

import com.salsatechnology.model.ProductType;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ProductOrderDTO {
	
	@NotBlank
	private String userName;
	
	@NotNull
	private ProductType productType;
	
	@NotNull
	private Integer timeHour;
}
