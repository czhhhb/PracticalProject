package com.czhhhb.model;

public class Book {
    private String name;
    private String price;
    private String sell;

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

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }

    public Book() {
    }

    public Book(String name, String price, String sell) {
        this.name = name;
        this.price = price;
        this.sell = sell;
    }
}
