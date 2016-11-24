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

        Category pizza = new Category("Pizza", 1);
        Category paste = new Category("Paste", 2);
        Category penis = new Category("Pizda", 3);
        categories.add(pizza);
        categories.add(paste);
        categories.add(penis);

        final ArrayAdapter<Category> categories1;
        categories1 = new ArrayAdapter<Category>(this, android.R.layout.simple_list_item_1, categories);

        ListView mylistView = (ListView) findViewById(R.id.menu_listview);
        mylistView.setAdapter(categories1);

        mylistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                              @Override
                                              public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                    Category categSelectata = categories1.getItem(position);
                                                  System.out.println(categSelectata.id);
                                              }
                                          }

        );
    }
}
