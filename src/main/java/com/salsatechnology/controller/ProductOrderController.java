package com.salsatechnology.controller;

import com.salsatechnology.dto.ProductOrderDTO;
import com.salsatechnology.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/orders")
public class ProductOrderController {

	@Autowired
	private ProductOrderService productOrderService;

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void createOrder(@RequestBody @Valid ProductOrderDTO productOrderDTO) {
		productOrderService.createOrder(productOrderDTO);
	}

	@GetMapping("/{productType}")
	public ResponseEntity<Object> getProductOrderByProductType(@PathVariable String productType, Pageable pageable) {
		return productOrderService.findProductOrderByProductType(productType, pageable);
	}
}
