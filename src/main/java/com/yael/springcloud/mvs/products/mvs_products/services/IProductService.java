package com.yael.springcloud.mvs.products.mvs_products.services;

import java.util.List;
import java.util.Optional;

import com.yael.springcloud.mvs.products.mvs_products.entities.Product;





public interface IProductService {
    public List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    void deleteById(Long id);
}
