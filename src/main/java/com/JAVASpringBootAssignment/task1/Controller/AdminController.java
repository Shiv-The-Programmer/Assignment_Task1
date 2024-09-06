package com.JAVASpringBootAssignment.task1.Controller;


import com.JAVASpringBootAssignment.task1.Model.CurrencyType;
import com.JAVASpringBootAssignment.task1.Model.Price;
import com.JAVASpringBootAssignment.task1.Model.Product;
import com.JAVASpringBootAssignment.task1.Service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/admin")
public class AdminController {

    @Autowired
    private ProductService productService;

    // GET all products
    @GetMapping
    public List<Product> retrieveAllProducts() {
        return productService.getAllProducts();
    }

    // GET a product by ID
//    @GetMapping("/{id}")
//    public Product retrieveProductById(@PathVariable int id) {
//        return productService.getProductById(id);
//    }

    @GetMapping("/{id}")
    public Product retrieveProductWithPricesInAllCurrencies(@PathVariable int id) {
        return productService.getProductWithPriceInAllCurrencies(id);
    }

    // GET price by price ID
    @GetMapping("/price/{priceId}")
    public Price getPriceById(@PathVariable int priceId) {
        return productService.getPriceById(priceId);
    }

    // GET product price in specified currency
    @GetMapping("/{id}/price")
    public double retrieveProductPrice(@PathVariable int id, @RequestParam CurrencyType currencyType) {
        return productService.getProductPriceInSpecifiedCurrency(id, currencyType);
    }

    // POST create a new product
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createNewProduct(@RequestBody @Valid Product product) {
        return productService.saveNewProduct(product);
    }

    // PUT update a product by ID
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody @Valid Product product) {
        return productService.updateExistingProduct(id, product);
    }

    // DELETE a product by ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable int id) {
        productService.deleteExistingProduct(id);
    }
}
