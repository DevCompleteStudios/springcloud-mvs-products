package com.yael.springcloud.mvs.products.mvs_products.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.yael.springcloud.mvs.products.mvs_products.entities.Product;
import com.yael.springcloud.mvs.products.mvs_products.services.IProductService;





@RestController
public class ProductController {

    @Autowired
    IProductService productService;


    @GetMapping
    public List<Product> FindAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> Details(@PathVariable Long id){
        Optional<Product> product = productService.findById(id);

        if(product.isPresent()){
            return ResponseEntity.ok(product.get());
        }
        return ResponseEntity.notFound().build();
    }


}
