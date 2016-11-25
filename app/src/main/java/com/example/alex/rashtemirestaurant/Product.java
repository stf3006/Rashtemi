package com.example.alex.rashtemirestaurant;

/**
 * Created by Rares on 25.11.2016.
 */

public class Product {
    public int id;
    public String name;
    public int price;
    public int category;
    public int weight;

    public Product(int id, String name, int price, int category, int weight) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name;
    }
}
