package com.example.alex.rashtemirestaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by Alex on 28.11.2016.
 */

// atribut product, si cantitate
public class CartHelper {

    public static List<CartItem> catalog = new Vector<CartItem>();;

    public static List<CartItem> getCatalog(){
        return catalog;
    }
    public static void addProduct(Product p){

        for(CartItem cartItem : catalog) {
            if(p.id == cartItem.product.id){
                cartItem.quantity += 1;
                return ;
            }

        }

        CartItem ct = new CartItem(p,1);
        catalog.add(ct);
    }

    public static void deleteItem(Product p){
        for(CartItem cartItem : catalog){
            if(p.id == cartItem.product.id){
                cartItem.quantity -= 1;

                if(cartItem.quantity == 0){
                    catalog.remove(cartItem);
                }

                return;
            }

        }
    }

}
