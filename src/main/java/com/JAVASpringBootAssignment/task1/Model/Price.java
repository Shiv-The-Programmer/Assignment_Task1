package com.JAVASpringBootAssignment.task1.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "price")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_id")
    private int priceId;
    @Column(name = "amount")
    private double amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency_type")
    private CurrencyType currencyType;

    public Price() {
    }

//    public Price(double amount, CurrencyType currencyType) {
//        this.amount = amount;
//        this.currencyType = currencyType;
//    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    @Override
    public String toString() {
        return "Price{" +
                "amount=" + amount +
                ", currencyType=" + currencyType +
                '}';
    }
}
