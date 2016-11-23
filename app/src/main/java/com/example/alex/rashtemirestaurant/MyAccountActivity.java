package com.example.alex.rashtemirestaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        Button signupBtn = (Button)findViewById(R.id.signup_btn);
        signupBtn.setOnClickListener(new View.OnClickListener() { // TRECEREA DE LA O ACTIVITATE LA ALTA PRIN BUTON
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MyAccountActivity.this, SignUpActivity.class);
                startActivity(intent1);
            }
        });
    }
}
