package com.salsatechnology.dto;

import com.salsatechnology.model.ProductType;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateProductOrderDTO {

	@NotNull
	private ProductType productType;

	@NotNull
	private Integer newValue;
}
