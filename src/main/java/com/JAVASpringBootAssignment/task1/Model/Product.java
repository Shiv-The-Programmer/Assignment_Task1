package com.JAVASpringBootAssignment.task1.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.util.List;
import java.util.Map;


@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid") // Matching the database column name
    private int productID;

    @Column(name = "productcolour") // Matching the database column name
    private String productColour;

    @Column(name = "productdescription") // Matching the database column name
    private String productDescription;

    @Column(name = "productname") // Matching the database column name
    private String productName;

    @Column(name = "productsize") // Matching the database column name
    private String productSize;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "price_id")
    private Price price;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<CurrencyType,Double> priceInAllCurrencies;




    public Product() {
    }

//    public Product(int productID, String productName, String productDescription, String productColour, String productSize) {
//        this.productID = productID;
//        this.productName = productName;
//        this.productDescription = productDescription;
//        this.productColour = productColour;
//        this.productSize = productSize;
//    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductColour() {
        return productColour;
    }

    public void setProductColour(String productColour) {
        this.productColour = productColour;
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


    public Map<CurrencyType, Double> getPriceInAllCurrencies() {
        return priceInAllCurrencies;
    }

    public void setPriceInAllCurrencies(Map<CurrencyType, Double> priceInAllCurrencies) {
        this.priceInAllCurrencies = priceInAllCurrencies;
    }


//    @Override
//    public String toString() {
//        return "Product{" +
//                "productID=" + productID +
//                ", productName='" + productName + '\'' +
//                ", productDescription='" + productDescription + '\'' +
//                ", productColour='" + productColour + '\'' +
//                ", productSize='" + productSize + '\'' +
//                '}';
//    }


    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productColour='" + productColour + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productName='" + productName + '\'' +
                ", productSize='" + productSize + '\'' +
                ", price=" + price +
                '}';
    }
}
