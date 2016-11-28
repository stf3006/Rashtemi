package com.example.alex.rashtemirestaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by Alex on 28.11.2016.
 */

// atribut product, si cantitate
public class Cart {

    public static List<CartItem> catalog;
    public static List<Product> cart;



    public static List<CartItem> getCatalog(){
        if(catalog == null){
            catalog = new Vector<CartItem>();

        }
        return catalog;
    }


}
