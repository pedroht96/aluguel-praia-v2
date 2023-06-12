package com.salsatechnology.service;

import com.salsatechnology.dto.ProductOrderDTO;
import com.salsatechnology.model.Product;
import com.salsatechnology.model.ProductOrder;
import com.salsatechnology.repository.ProductOrderRepository;
import com.salsatechnology.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductOrderService {

	private final ProductOrderRepository productOrderRepository;
	private final ProductRepository productRepository;
	
	@Transactional
	public ResponseEntity<Object> createOrder(ProductOrderDTO productOrderDTO) {
		Product product = productRepository.findProductByType(productOrderDTO.getProductType().toString());
		if(Objects.nonNull(product)){
			ProductOrder productOrder = productOrderRepository.save(createProductOrder(productOrderDTO, product));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Object> findProductOrderByProductType(String productType, Pageable pageable) {
		Page<ProductOrder> list = productOrderRepository.findProductOrder(productType, pageable);
		return new ResponseEntity<>(new PageImpl<ProductOrder>(list.toList(), pageable,
				list.getTotalElements()), HttpStatus.OK);
	}

	private ProductOrder createProductOrder(ProductOrderDTO productOrderDTO, Product product) {

		Long total = calcProductTotal(product.getProductValue(), productOrderDTO.getTimeHour());
		Long userAmount = calcUserAmountValue(total, product.getUserAmount());

		ProductOrder productOrder = new ProductOrder();
		productOrder.setUserName(productOrderDTO.getUserName());
		productOrder.setProductType(productOrderDTO.getProductType());
		productOrder.setTimeHour(productOrderDTO.getTimeHour());
		
		productOrder.setProductValue(product.getProductValue());
		productOrder.setProductTotal(total);
		productOrder.setUserAmount(userAmount);
		return productOrder;
	}

	private Long calcProductTotal(Long productValue, Integer timeHour){
		return productValue * timeHour;
	}

	private Long calcUserAmountValue(Long total, Long userAmount){
		return ((total / (100 * 100)) * userAmount);
	}

}
