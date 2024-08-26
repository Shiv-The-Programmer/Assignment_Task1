package com.JAVASpringBootAssignment.task1.Model;

import jakarta.persistence.*;


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

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productColour='" + productColour + '\'' +
                ", productSize='" + productSize + '\'' +
                '}';
    }
}
