package com.example.alex.rashtemirestaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        Button loginBtn = (Button)findViewById(R.id.login_btn);
        final EditText ed1 = (EditText)findViewById(R.id.username_login_et);
       final  EditText ed2 = (EditText)findViewById(R.id.password_login_et);
        Boolean logat = false;

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = ed1.getText().toString();
                String s2 = ed2.getText().toString();

                if(s1.equals("") || s1.equals("")){
                    Toast.makeText(getApplicationContext(),"Please, insert data!",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
