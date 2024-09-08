package com.JAVASpringBootAssignment.task1.Controller;

import com.JAVASpringBootAssignment.task1.Model.CurrencyType;
import com.JAVASpringBootAssignment.task1.Model.Product;
import com.JAVASpringBootAssignment.task1.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Mapping for GET all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Mapping for GET a product by ID
    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    // Mapping for GET the product price in specified currency
    @GetMapping("/product/price/{productID}/{currencyType}")
    public double getProductPriceInSpecifiedCurrency(
            @PathVariable int productID, @PathVariable CurrencyType currencyType) {
        return productService.getProductPriceInSpecifiedCurrency(productID, currencyType);
    }

    // Mapping for GET a product with price in all currencies
    @GetMapping("/product/with-prices/{id}")
    public Product retrieveProductWithPricesInAllCurrencies(@PathVariable int id) {
        return productService.getProductWithPriceInAllCurrencies(id);
    }
}
