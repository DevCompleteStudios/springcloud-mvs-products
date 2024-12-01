package com.yael.springcloud.mvs.products.mvs_products.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yael.springcloud.mvs.products.mvs_products.entities.Product;






public interface ProductsRepository extends JpaRepository<Product, Long> {

}
