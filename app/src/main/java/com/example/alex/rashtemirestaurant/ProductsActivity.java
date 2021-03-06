package com.example.alex.rashtemirestaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ProductsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        // Get category id and name from intent extra
        int categoryId = getIntent().getIntExtra("CATEGORY_ID", 1);
        String categoryName = getIntent().getStringExtra("CATEGORY_NAME");
        getSupportActionBar().setTitle(categoryName);

        DatabaseHelper dbh = new DatabaseHelper(this);
        ArrayList<Product> products = dbh.getAllProductsByCategoryId(categoryId);

        ListView productsListView = (ListView) findViewById(R.id.products_lv);
        ProductsListAdapter productsAdapter = new ProductsListAdapter(getApplicationContext(), R.layout.product_item_template, products);

        productsListView.setAdapter(productsAdapter);
    }

    public void ShowBasket(View v) {
        Intent intent = new Intent(ProductsActivity.this, CartActivity.class);
        startActivity(intent);
    }

}
