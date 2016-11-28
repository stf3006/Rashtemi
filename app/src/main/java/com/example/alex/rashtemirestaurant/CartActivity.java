package com.example.alex.rashtemirestaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        List<CartItem> cartItems = CartHelper.getCatalog();

        ListView cartListView = (ListView) findViewById(R.id.Cart_listview);
        CartListAdaptor cartListAdaptor = new CartListAdaptor(getApplicationContext(), R.layout.cartproduct_item_template, cartItems );

        cartListView.setAdapter(cartListAdaptor);
    }
}
