package com.JAVASpringBootAssignment.task1.Service;

import com.JAVASpringBootAssignment.task1.Model.Product;
import com.JAVASpringBootAssignment.task1.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    //######################### Read ###################### //

    // GET all products
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    // GET one product with product id
    public Product getProductById(int id){
        return productRepository.findById(id).orElse(null);
    }

    // ##################### Create ###################### //

    // POST a new product
    public Product saveNewProduct(Product product){
        return productRepository.save(product);
    }

    // ################# Update ##################### //

    public Product updateExistingProduct(int id, Product updatedProduct){
        Product existingProduct = productRepository.findById(id).orElse(null);
        if(existingProduct!=null){
            existingProduct.setProductName(updatedProduct.getProductName());
            existingProduct.setProductDescription(updatedProduct.getProductDescription());
            existingProduct.setProductColour(updatedProduct.getProductColour());
            existingProduct.setProductSize(updatedProduct.getProductSize());
            return productRepository.save(existingProduct);
        }
        return null;
    }

    // ################# Delete ###################### //

    public void deleteExistingProduct(int id){
        Product existingProduct = productRepository.findById(id).orElse(null);
        if(existingProduct!=null){
            productRepository.deleteById(id);
        }

    }








}
