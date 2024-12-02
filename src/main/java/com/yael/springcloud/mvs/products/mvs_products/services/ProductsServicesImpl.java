package com.yael.springcloud.mvs.products.mvs_products.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yael.springcloud.mvs.products.mvs_products.entities.Product;
import com.yael.springcloud.mvs.products.mvs_products.repositories.ProductsRepository;


@Service
public class ProductsServicesImpl implements IProductService {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private Environment env;

    
    @Override
    @Transactional(readOnly=true)
    public List<Product> findAll() {
        return productsRepository.findAll()
            .stream().map( p -> {
                p.setPort(Integer.parseInt(env.getProperty("local.server.port")));
                return p;
            }).toList();
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<Product> findById(Long id) {
        return productsRepository.findById(id)
            .map( p -> {
                p.setPort(Integer.parseInt(env.getProperty("local.server.port")));
                return p;
            });
    }

}
