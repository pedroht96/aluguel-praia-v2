package com.salsatechnology.repository;

import com.salsatechnology.model.ProductOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrderRepository extends PagingAndSortingRepository<ProductOrder, Long> {

    @Query(value = "SELECT * FROM product_order WHERE product_type = :productType", nativeQuery = true)
    Page<ProductOrder> findProductOrder(@Param("productType") String productType, Pageable pageable);

}
