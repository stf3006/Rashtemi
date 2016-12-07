package com.example.alex.rashtemirestaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

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

        Button placeOrderButton = (Button) findViewById(R.id.place_order_btn);
        placeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CartActivity.this, "Order placed successfully!", Toast.LENGTH_LONG).show();
            }
        });

        cartListView.setAdapter(cartListAdaptor);
    }
}
