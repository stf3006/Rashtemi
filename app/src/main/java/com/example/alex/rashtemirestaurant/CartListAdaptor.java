package com.example.alex.rashtemirestaurant;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Alex on 28.11.2016.
 */

public class CartListAdaptor extends ArrayAdapter<CartItem> {

    public CartListAdaptor(Context context, int resource) {
        super(context, resource);
    }

    public CartListAdaptor(Context context, int resource, List<CartItem> objects) {
        super(context, resource, objects);
    }

    @NonNull

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.cartproduct_item_template, null);
        }

        final CartItem cartItem = getItem(position);
        TextView cartItemName = (TextView) convertView.findViewById(R.id.cart_product_name);
        TextView cartItemPrice = (TextView) convertView.findViewById(R.id.cart_product_price);
        TextView cartItemWeight = (TextView) convertView.findViewById(R.id.cart_product_weight);
        ImageButton cartMinusButton = (ImageButton) convertView.findViewById(R.id.ic_cart_minus_img);
        TextView quantity = (TextView) convertView.findViewById(R.id.cart_product_quantity_tv);
        ImageButton cartPlusButton = (ImageButton) convertView.findViewById(R.id.ic_cart_plus_img);

        cartItemName.setText(cartItem.product.name);
        cartItemPrice.setText(cartItem.product.price + " lei");
        cartItemWeight.setText(cartItem.product.weight + " g.");
        cartMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CartHelper.deleteItem(cartItem.product);
                System.out.println("PRODUS STERS DIN COS!" + cartItem.product.name);
                notifyDataSetChanged();
            }
        });
        quantity.setText(""+cartItem.quantity);
        cartPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CartHelper.addProduct(cartItem.product);
                System.out.println("PRODUS ADAUGAT DIN COS!" + cartItem.product.name);
                notifyDataSetChanged();
            }


        });






        return convertView;
    }



}
