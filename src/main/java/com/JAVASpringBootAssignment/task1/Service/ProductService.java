package com.JAVASpringBootAssignment.task1.Service;

import com.JAVASpringBootAssignment.task1.Model.Category;
import com.JAVASpringBootAssignment.task1.Model.CurrencyType;
import com.JAVASpringBootAssignment.task1.Model.Price;
import com.JAVASpringBootAssignment.task1.Model.Product;
import com.JAVASpringBootAssignment.task1.Repository.CategoryRepository;
import com.JAVASpringBootAssignment.task1.Repository.PriceRepository;
import com.JAVASpringBootAssignment.task1.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }

    public double getProductPriceInSpecifiedCurrency(int productID, CurrencyType currencyType) {
        Product product = productRepository.findById(productID).orElseThrow(() -> new IllegalArgumentException("Product not found"));

        double amount = product.getPrice().getAmount();
        CurrencyType productCurrencyType = product.getPrice().getCurrencyType();

        if (productCurrencyType == currencyType) {
            return amount;
        }

        // Conversion logic
        return switch (currencyType) {
            case RUPEE -> convertToRupee(amount, productCurrencyType);
            case DOLLAR -> convertToDollar(amount, productCurrencyType);
        };
    }

    public double convertToDollar(double amount, CurrencyType currencyType) {
        return switch (currencyType) {
            case RUPEE -> amount * 0.012; // Example rate
            case DOLLAR -> amount; // Same currency
        };
    }

    public double convertToRupee(double amount, CurrencyType currencyType) {
        return switch (currencyType) {
            case DOLLAR -> amount * 75.0; // Example rate
            case RUPEE -> amount; // Same currency
        };
    }

    public Product getProductWithPriceInAllCurrencies(int productID) {
        Product product = productRepository.findById(productID).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        double baseAmount = product.getPrice().getAmount();
        CurrencyType baseCurrency = product.getPrice().getCurrencyType();

        Map<CurrencyType, Double> priceInAllCurrencies = new HashMap<>();
        priceInAllCurrencies.put(baseCurrency, baseAmount);
        priceInAllCurrencies.put(CurrencyType.DOLLAR, convertToDollar(baseAmount, baseCurrency));
        priceInAllCurrencies.put(CurrencyType.RUPEE, convertToRupee(baseAmount, baseCurrency));

        product.setPriceInAllCurrencies(priceInAllCurrencies);

        return product;
    }

    public Product saveNewProduct(Product product) {
        System.out.println("Product before save: " + product);

        if (product.getProductCategory() != null && product.getProductCategory().getCategoryId() != 0) {
            Category category = categoryRepository.findById(product.getProductCategory().getCategoryId())
                    .orElseThrow(() -> new IllegalArgumentException("Category not found"));

            product.setProductCategory(category);
        }

        return productRepository.save(product);
    }

    public Product updateExistingProduct(int id, Product updatedProduct) {
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found"));

        existingProduct.setProductName(updatedProduct.getProductName());
        existingProduct.setProductDescription(updatedProduct.getProductDescription());
        existingProduct.setProductSize(updatedProduct.getProductSize());
        existingProduct.setProductColour(updatedProduct.getProductColour());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setProductCategory(updatedProduct.getProductCategory());

        return productRepository.save(existingProduct);
    }

    public void deleteExistingProduct(int id) {
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        productRepository.delete(existingProduct);
    }
}
