package com.yael.springcloud.mvs.products.mvs_products.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yael.libs.msv.commons.entities.Product;






public interface ProductsRepository extends JpaRepository<Product, Long> {

}
