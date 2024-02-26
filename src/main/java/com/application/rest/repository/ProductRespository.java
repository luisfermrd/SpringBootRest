package com.application.rest.repository;

import com.application.rest.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Repository
public interface ProductRespository extends JpaRepository<Product, Long> {
    List<Product> findProductByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
}
