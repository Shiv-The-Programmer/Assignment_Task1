package com.JAVASpringBootAssignment.task1.Controller;

import com.JAVASpringBootAssignment.task1.Model.CurrencyType;
import com.JAVASpringBootAssignment.task1.Model.Product;
import com.JAVASpringBootAssignment.task1.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Mapping for GET all products
//    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @GetMapping
    public List<Product> retrieveAllProducts() {
        return productService.getAllProducts();
    }

    // Mapping for GET a product by ID
    @GetMapping("/{id}")
    public Product retrieveProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @GetMapping("/{id}/price")
    public double retrieveProductPrice(@PathVariable int id, @RequestParam CurrencyType currencyType) {
        return productService.getProductPriceInSpecifiedCurrency(id, currencyType);
    }


    // ###################### Removing create, update and delete rights from normal customer, only admin has the access to do it
    // Mapping for POST create a new product
//    @PostMapping
//    public Product createNewProduct(@RequestBody Product product) {
//        return productService.saveNewProduct(product);
//    }
//
//    // Mapping for PUT update a product by ID
//    @PostMapping("/{id}")
//    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
//        return productService.updateExistingProduct(id, product);
//    }
//
//    // Mapping for DELETE a product by ID
//    @DeleteMapping("/{id}")
//    public void deleteProduct(@PathVariable int id) {
//        productService.deleteExistingProduct(id);
//    }

    // swagger UI to test in browser url -
    // http://localhost:8080/swagger-ui/index.html
}
