package com.example.alex.rashtemirestaurant;

/**
 * Created by Emilian on 24.11.2016.
 */

public class Category {
    public String name;
    public int id;

    public Category(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return name;
    }
}
