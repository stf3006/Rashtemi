package com.example.alex.rashtemirestaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button contactBtn = (Button)findViewById(R.id.contact_button);
        contactBtn.setOnClickListener(new View.OnClickListener() { // TRECEREA DE LA O ACTIVITATE LA ALTA PRIN BUTON
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(intent);
            }
        });

        Button myaccBtn = (Button)findViewById(R.id.myacc_button);
        myaccBtn.setOnClickListener(new View.OnClickListener() { // TRECEREA DE LA O ACTIVITATE LA ALTA PRIN BUTON
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, MyAccountActivity.class);
                startActivity(intent1);
            }
        });


    }


}
