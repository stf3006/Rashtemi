package com.example.alex.rashtemirestaurant;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Rares on 28.11.2016.
 */

public class ProductsListAdapter extends ArrayAdapter<Product> {
    public ProductsListAdapter(Context context, int resource) {
        super(context, resource);
    }

    public ProductsListAdapter(Context context, int resource, List<Product> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.product_item_template, null);
        }

        final Product product = getItem(position);
        TextView productName = (TextView)convertView.findViewById(R.id.product_name_tv);
        TextView productPrice = (TextView)convertView.findViewById(R.id.product_price_tv);
        ImageButton productAddButton = (ImageButton)convertView.findViewById(R.id.product_add_button);

        productName.setText(product.name);
        productPrice.setText(product.price + " lei");
        productAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("ADAUG IN COS " + product.name);
            }
        });


        return convertView;
    }
}
