package com.JAVASpringBootAssignment.task1;

import com.JAVASpringBootAssignment.task1.Model.CurrencyType;
import com.JAVASpringBootAssignment.task1.Model.Price;
import com.JAVASpringBootAssignment.task1.Model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Task1Application {

	public static void main(String[] args) {

//		Product product = new Product();
//		Price price = new Price();
//		price.setAmount(100.0);
//		price.setCurrencyType(CurrencyType.RUPEE);
//		product.setPrice(price);
//		product.setProductName("T-Shirt");
//		System.out.println(product);
		SpringApplication.run(Task1Application.class, args);
	}

}
