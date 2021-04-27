package com.czhhhb.model;

public class Book {
    private String name;
    private String price;
    private String sale;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public Book() {
    }

    public Book(String name, String price, String evaluate) {
        this.name = name;
        this.price = price;
        this.sale = evaluate;
    }
}
