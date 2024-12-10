package com.yael.springcloud.mvs.products.mvs_products.controllers;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yael.libs.msv.commons.entities.Product;
import com.yael.springcloud.mvs.products.mvs_products.services.IProductService;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
public class ProductController {

    @Autowired
    IProductService productService;


    @GetMapping
    public List<Product> FindAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> Details(@PathVariable Long id) throws InterruptedException {
        if( id.equals(10L) ){
            throw new IllegalStateException("Pructo no encontrado");
        }

        if( id.equals(7L) ){
            TimeUnit.SECONDS.sleep(3L);
        }

        Optional<Product> product = productService.findById(id);

        if(product.isPresent()){
            return ResponseEntity.ok(product.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Product> create( @RequestBody Product product ){
        Product p =  productService.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(p);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        Product p = productService.save(product);
        return ResponseEntity.ok(p);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
