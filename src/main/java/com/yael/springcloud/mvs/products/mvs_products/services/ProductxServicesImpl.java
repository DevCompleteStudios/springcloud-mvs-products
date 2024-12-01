package com.yael.springcloud.mvs.products.mvs_products.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yael.springcloud.mvs.products.mvs_products.entities.Product;
import com.yael.springcloud.mvs.products.mvs_products.repositories.ProductsRepository;


@Service
public class ProductxServicesImpl implements IProductService {

    @Autowired
    ProductsRepository productsRepository;

    
    @Override
    @Transactional(readOnly=true)
    public List<Product> findAll() {
        return productsRepository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<Product> findById(Long id) {
        return productsRepository.findById(id);
    }

}
