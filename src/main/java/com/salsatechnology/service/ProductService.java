package com.salsatechnology.service;

import com.salsatechnology.dto.UpdateProductOrderDTO;
import com.salsatechnology.model.Product;
import com.salsatechnology.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {

	private final ProductRepository productRepository;

	public ResponseEntity<Object> findProductByProductType(String productType) {
		return new ResponseEntity<>(productRepository.findProductByType(productType),HttpStatus.OK);
	}

	public ResponseEntity<Object> findProducts(Pageable pageable) {
		Page<Product> list = productRepository.findAllProducts(pageable);
		return new ResponseEntity<>(new PageImpl<Product>(list.toList(), pageable, list.getTotalElements()),
				HttpStatus.OK);
	}

	public ResponseEntity<Object> updateProduct(UpdateProductOrderDTO updateProductOrderDTO) {
		Product product = productRepository.findProductByType(updateProductOrderDTO.getProductType().toString());
		if(Objects.nonNull(product)){
			product.setProductValue(Long.valueOf(updateProductOrderDTO.getNewValue()));
			productRepository.save(product);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
