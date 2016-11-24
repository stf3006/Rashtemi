package com.example.alex.rashtemirestaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {
    List<Category> categories = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        DatabaseHelper dbh = new DatabaseHelper(this);
        ArrayList<Category> categories = dbh.getAllCategories();

        final ArrayAdapter<Category> categoriesAdapter = new ArrayAdapter<Category>(this, android.R.layout.simple_list_item_1, categories);

        ListView mylistView = (ListView) findViewById(R.id.menu_listview);
        mylistView.setAdapter(categoriesAdapter);

        mylistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                              @Override
                                              public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                  Category categSelectata = categoriesAdapter.getItem(position);
                                                  System.out.println(categSelectata.id);
                                              }
                                          }

        );
    }
}
