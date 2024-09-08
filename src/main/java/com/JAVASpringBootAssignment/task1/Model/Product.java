package com.JAVASpringBootAssignment.task1.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.util.Map;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid")
    private int productID;

    @Column(name = "productcolour")
    private String productColour;

    @Column(name = "productdescription")
    private String productDescription;

    @Column(name = "productname")
    private String productName;

    @Column(name = "productsize")
    private String productSize;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "price_id")
    private Price price;


    // ALTER TABLE product ADD CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES category(category_id);
    // To add foreign key
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category productCategory;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<CurrencyType, Double> priceInAllCurrencies;

    // Getters and Setters

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductColour() {
        return productColour;
    }

    public void setProductColour(String productColour) {
        this.productColour = productColour;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Category getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Category productCategory) {
        this.productCategory = productCategory;
    }

    public Map<CurrencyType, Double> getPriceInAllCurrencies() {
        return priceInAllCurrencies;
    }

    public void setPriceInAllCurrencies(Map<CurrencyType, Double> priceInAllCurrencies) {
        this.priceInAllCurrencies = priceInAllCurrencies;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productColour='" + productColour + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productName='" + productName + '\'' +
                ", productSize='" + productSize + '\'' +
                ", price=" + price +
                ", productCategory=" + productCategory +
                ", priceInAllCurrencies=" + priceInAllCurrencies +
                '}';
    }
}
