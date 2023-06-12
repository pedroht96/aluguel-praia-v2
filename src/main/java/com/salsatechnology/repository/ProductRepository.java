package com.salsatechnology.repository;

import com.salsatechnology.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    @Query(value = "SELECT * from product WHERE product_type = :productType", nativeQuery = true)
    Product findProductByType(@Param("productType") String productType);

    @Query(value = "SELECT * FROM product", nativeQuery = true)
    Page<Product> findProducts(Pageable pageable);
}
