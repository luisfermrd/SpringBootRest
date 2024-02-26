package com.application.rest.persistence.impl;

import com.application.rest.entities.Product;
import com.application.rest.persistence.IProductDAO;
import com.application.rest.repository.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class ProductDAOImpl implements IProductDAO {

    @Autowired
    private ProductRespository productRespository;

    @Override
    public List<Product> findAll() {
        return productRespository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRespository.findById(id);
    }

    @Override
    public List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productRespository.findProductByPriceBetween(minPrice, maxPrice);
    }

    @Override
    public void save(Product product) {
        productRespository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productRespository.deleteById(id);
    }
}
