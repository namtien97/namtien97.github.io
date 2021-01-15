package com.example.topcar.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Locale;

public class Car {
    @JsonIgnore
    public int id;

    public String model;
    public String manufacturer;
    public int price;
    public int sales;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public boolean matchWithKeyword(String keyword){
        String keywordLowerCase = keyword.toLowerCase();
        return (model.toLowerCase().contains(keywordLowerCase)|| manufacturer.toLowerCase().contains(keywordLowerCase));
    }
}
