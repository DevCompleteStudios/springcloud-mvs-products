package com.yael.springcloud.mvs.products.mvs_products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;



@SpringBootApplication
@EntityScan({"com.yael.libs.msv.commons.entities", "com.yael.springcloud.mvs.products.mvs_products.entities"})
public class MvsProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvsProductsApplication.class, args);
	}

}
