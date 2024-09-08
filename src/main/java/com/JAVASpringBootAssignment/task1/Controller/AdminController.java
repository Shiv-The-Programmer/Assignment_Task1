package com.JAVASpringBootAssignment.task1.Controller;

import com.JAVASpringBootAssignment.task1.Model.CurrencyType;
import com.JAVASpringBootAssignment.task1.Model.Product;
import com.JAVASpringBootAssignment.task1.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductService productService;

    // GET all products
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // GET a product by ID
    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @GetMapping("/product/price/{productID}/{currencyType}")
    public double getProductPriceInSpecifiedCurrency(
            @PathVariable int productID, @PathVariable CurrencyType currencyType) {
        return productService.getProductPriceInSpecifiedCurrency(productID, currencyType);
    }

    @GetMapping("/product/with-prices/{id}")
    public Product retrieveProductWithPricesInAllCurrencies(@PathVariable int id) {
        return productService.getProductWithPriceInAllCurrencies(id);
    }

    // POST a new product
    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product) {
        return productService.saveNewProduct(product);
    }

    // PUT to update an existing product
    @PutMapping("/product/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
        return productService.updateExistingProduct(id, product);
    }

    // DELETE a product by ID
    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteExistingProduct(id);
    }
}
