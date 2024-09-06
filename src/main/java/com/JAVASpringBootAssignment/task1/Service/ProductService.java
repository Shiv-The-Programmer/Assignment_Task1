package com.JAVASpringBootAssignment.task1.Service;

import com.JAVASpringBootAssignment.task1.Model.CurrencyType;
import com.JAVASpringBootAssignment.task1.Model.Price;
import com.JAVASpringBootAssignment.task1.Model.Product;
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

    // GET all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // GET one product by ID
    public Product getProductById(int id) {
        return productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }

    // GET product price in specified currency
    public double getProductPriceInSpecifiedCurrency(int productID, CurrencyType currencyType) {
        Product product = productRepository.findById(productID).orElseThrow(() -> new IllegalArgumentException("Product not found"));

        double amount = product.getPrice().getAmount();
        CurrencyType productCurrencyType = product.getPrice().getCurrencyType();

        if (productCurrencyType == currencyType) {
            return amount;
        }

        // Conversion logic based on currencyType
        return switch (currencyType) {
            case RUPEE -> convertToRupee(amount, productCurrencyType);
            case DOLLAR -> convertToDollar(amount, productCurrencyType);
        };
    }

    public double convertToDollar(double amount, CurrencyType currencyType) {
        // Example conversion rates; adjust as necessary
        return switch (currencyType) {
            case RUPEE -> amount * 0.012; // Example rate
            case DOLLAR -> amount; // Same currency
        };
    }

    public double convertToRupee(double amount, CurrencyType currencyType) {
        // Example conversion rates; adjust as necessary
        return switch (currencyType) {
            case DOLLAR -> amount * 75.0; // Example rate
            case RUPEE -> amount; // Same currency
        };
    }

//    GET product price in specified currency

    public Product getProductWithPriceInAllCurrencies(int productID){
        Product product = productRepository.findById(productID).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        if(product==null){
            throw new IllegalArgumentException("Product Not Found");
        }
        double baseAmount = product.getPrice().getAmount();
        CurrencyType baseCurrency = product.getPrice().getCurrencyType();
        Map<CurrencyType,Double> priceInAllCurrencies = new HashMap<>();
        priceInAllCurrencies.put(baseCurrency,baseAmount);
        priceInAllCurrencies.put(CurrencyType.DOLLAR,convertToDollar(baseAmount,baseCurrency));
        priceInAllCurrencies.put(CurrencyType.RUPEE,convertToDollar(baseAmount,baseCurrency));
//        product.setPriceInAllCurrencies(priceInAllCurrencies);
        return product;

    }


    // GET price by price ID
    public Price getPriceById(int priceId) {
        return priceRepository.findById(priceId).orElse(null);
    }

    // POST a new product
    public Product saveNewProduct(Product product) {
        // Ensure Price is saved or set correctly
        if (product.getPrice() != null) {
            priceRepository.save(product.getPrice());
        }
        return productRepository.save(product);
    }

    // PUT update a product by IDpackage com.JAVASpringBootAssignment.task1.Service;
    //
    //import com.JAVASpringBootAssignment.task1.Model.CurrencyType;
    //import com.JAVASpringBootAssignment.task1.Model.Price;
    //import com.JAVASpringBootAssignment.task1.Model.Product;
    //import com.JAVASpringBootAssignment.task1.Repository.PriceRepository;
    //import com.JAVASpringBootAssignment.task1.Repository.ProductRepository;
    //import org.springframework.beans.factory.annotation.Autowired;
    //import org.springframework.stereotype.Service;
    //
    //import java.util.HashMap;
    //import java.util.List;
    //import java.util.Map;
    //
    //@Service
    //public class ProductService {
    //
    //    @Autowired
    //    private ProductRepository productRepository;
    //
    //    @Autowired
    //    private PriceRepository priceRepository;
    //
    //    // GET all products
    //    public List<Product> getAllProducts() {
    //        return productRepository.findAll();
    //    }
    //
    //    // GET one product by ID
    //    public Product getProductById(int id) {
    //        Product product = productRepository.findById(id).orElse(null);
    //        if(product!=null){
    //            if(product.getPriceInAllCurrencies()==null){
    //
    //            }
    //        }
    //        return productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
    //    }
    //
    //    // GET product price in specified currency
    //    public double getProductPriceInSpecifiedCurrency(int productID, CurrencyType currencyType) {
    //        Product product = productRepository.findById(productID).orElseThrow(() -> new IllegalArgumentException("Product not found"));
    //
    //        double amount = product.getPrice().getAmount();
    //        CurrencyType productCurrencyType = product.getPrice().getCurrencyType();
    //
    //        if (productCurrencyType == currencyType) {
    //            return amount;
    //        }
    //
    //        // Conversion logic based on currencyType
    //        return switch (currencyType) {
    //            case RUPEE -> convertToRupee(amount, productCurrencyType);
    //            case DOLLAR -> convertToDollar(amount, productCurrencyType);
    //        };
    //    }
    //
    //    public double convertToDollar(double amount, CurrencyType currencyType) {
    //        // Example conversion rates; adjust as necessary
    //        return switch (currencyType) {
    //            case RUPEE -> amount * 0.012; // Example rate
    //            case DOLLAR -> amount; // Same currency
    //        };
    //    }
    //
    //    public double convertToRupee(double amount, CurrencyType currencyType) {
    //        // Example conversion rates; adjust as necessary
    //        return switch (currencyType) {
    //            case DOLLAR -> amount * 75.0; // Example rate
    //            case RUPEE -> amount; // Same currency
    //        };
    //    }
    //
    ////    GET product price in specified currency
    //
    //    public Product getProductWithPriceInAllCurrencies(int productID){
    //        Product product = productRepository.findById(productID).orElseThrow(() -> new IllegalArgumentException("Product not found"));
    //        if(product==null){
    //            throw new IllegalArgumentException("Product Not Found");
    //        }
    //        double baseAmount = product.getPrice().getAmount();
    //        CurrencyType baseCurrency = product.getPrice().getCurrencyType();
    //        Map<CurrencyType,Double> priceInAllCurrencies = new HashMap<>();
    //        priceInAllCurrencies.put(baseCurrency,baseAmount);
    //        priceInAllCurrencies.put(CurrencyType.DOLLAR,convertToDollar(baseAmount,baseCurrency));
    //        priceInAllCurrencies.put(CurrencyType.RUPEE,convertToDollar(baseAmount,baseCurrency));
    //        product.setPriceInAllCurrencies(priceInAllCurrencies);
    //        return product;
    //
    //    }
    //
    //
    //    // GET price by price ID
    //    public Price getPriceById(int priceId) {
    //        return priceRepository.findById(priceId).orElse(null);
    //    }
    //
    //    // POST a new product
    //    public Product saveNewProduct(Product product) {
    //        // Ensure Price is saved or set correctly
    //        if (product.getPrice() != null) {
    //            priceRepository.save(product.getPrice());
    //        }
    //        return productRepository.save(product);
    //    }
    //
    //    // PUT update a product by ID
    //    public Product updateExistingProduct(int id, Product updatedProduct) {
    //        return productRepository.findById(id).map(existingProduct -> {
    //            existingProduct.setProductName(updatedProduct.getProductName());
    //            existingProduct.setProductDescription(updatedProduct.getProductDescription());
    //            existingProduct.setProductColour(updatedProduct.getProductColour());
    //            existingProduct.setProductSize(updatedProduct.getProductSize());
    //            existingProduct.setPrice(updatedProduct.getPrice());
    //            existingProduct.setPriceInAllCurrencies(updatedProduct.getPriceInAllCurrencies());
    //            return productRepository.save(existingProduct);
    //        }).orElseThrow(() -> new IllegalArgumentException("Product not found"));
    //    }
    //
    //    // DELETE a product by ID
    //    public void deleteExistingProduct(int id) {
    //        if (productRepository.existsById(id)) {
    //            productRepository.deleteById(id);
    //        } else {
    //            throw new IllegalArgumentException("Product not found");
    //        }
    //    }
    //}
    public Product updateExistingProduct(int id, Product updatedProduct) {
        Product existingProduct = productRepository.findById(id).orElse(null);

        if (existingProduct == null) {
            return null;  // Handle product not found
        }

        // Update basic product fields
        existingProduct.setProductColour(updatedProduct.getProductColour());
        existingProduct.setProductDescription(updatedProduct.getProductDescription());
        existingProduct.setProductName(updatedProduct.getProductName());
        existingProduct.setProductSize(updatedProduct.getProductSize());

        // Update the price and currency if the updated product has a new price
        if (updatedProduct.getPrice() != null) {
            Price existingPrice = existingProduct.getPrice();
            Price updatedPrice = updatedProduct.getPrice();

            // Update the price amount
            existingPrice.setAmount(updatedPrice.getAmount());

            // Update the currency type
            existingPrice.setCurrencyType(updatedPrice.getCurrencyType());

            // Set the updated price in the product
            existingProduct.setPrice(existingPrice);
        }

        // Save and return the updated product
        return productRepository.save(existingProduct);
    }

    // DELETE a product by ID
    public void deleteExistingProduct(int id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Product not found");
        }
    }
}
