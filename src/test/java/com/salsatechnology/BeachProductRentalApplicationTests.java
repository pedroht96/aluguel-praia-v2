package com.salsatechnology;

import com.salsatechnology.dto.ProductOrderDTO;
import com.salsatechnology.model.Product;
import com.salsatechnology.model.ProductOrder;
import com.salsatechnology.model.ProductType;
import com.salsatechnology.repository.ProductOrderRepository;
import com.salsatechnology.repository.ProductRepository;
import com.salsatechnology.service.ProductOrderService;
import com.salsatechnology.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


class BeachProductRentalApplicationTests {


    @Mock
    private ProductOrderRepository productOrderRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;


    @InjectMocks
    private ProductOrderService productOrderService;

    public BeachProductRentalApplicationTests() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindProductOrderByProductType() {
        Pageable pageable = Pageable.ofSize(10).withPage(0);

        List<ProductOrder> productOrders = new ArrayList<>();
        Page<ProductOrder> productOrderPage = new PageImpl<>(productOrders, pageable, productOrders.size());

        when(productOrderRepository.findProductOrder(String.valueOf(ProductType.SURFBOARD), pageable)).thenReturn(productOrderPage);

        ResponseEntity<Object> response = productOrderService.findProductOrderByProductType(String.valueOf(ProductType.SURFBOARD), pageable);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testCreateOrderWithValidProductType() {
        ProductOrderDTO productOrderDTO = new ProductOrderDTO();
        productOrderDTO.setUserName("test");
        productOrderDTO.setProductType(ProductType.SURFBOARD);
        productOrderDTO.setTimeHour(4);

        Product product = new Product();
        product.setProductValue(45L);
        product.setUserAmount(45L);
        when(productRepository.findProductByType(String.valueOf(ProductType.SURFBOARD))).thenReturn(product);

        ResponseEntity<Object> response = productOrderService.createOrder(productOrderDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testCreateOrderWithInvalidProductType() {
        ProductOrderDTO productOrderDTO = new ProductOrderDTO();
        productOrderDTO.setProductType((ProductType.SURFBOARD));

        when(productRepository.findProductByType("INVALID_TYPE")).thenReturn(null);

        ResponseEntity<Object> response = productOrderService.createOrder(productOrderDTO);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void testFindProductByProductType() {
        String productType = String.valueOf(ProductType.SURFBOARD);
        Product expectedProduct = new Product();

        when(productRepository.findProductByType(productType)).thenReturn(expectedProduct);

        ResponseEntity<Object> response = productService.findProductByProductType(productType);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedProduct, response.getBody());
    }

}

