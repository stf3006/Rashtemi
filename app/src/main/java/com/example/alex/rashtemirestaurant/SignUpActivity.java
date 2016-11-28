package com.example.alex.rashtemirestaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button createNewAccount = (Button)findViewById(R.id.createAccount_button);
        final EditText editTextName = (EditText)findViewById(R.id.name_signup_et);
        final EditText editTextPhone = (EditText)findViewById(R.id.phone_signup_et);
        final EditText editTextUsername = (EditText)findViewById(R.id.username_signup_et);
        final EditText editTextPassword = (EditText)findViewById(R.id.password_signup_et);
        final EditText editTextConfirmPass = (EditText)findViewById(R.id.confirmPassword_et);

        createNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = editTextName.getText().toString();
                String s2 = editTextPhone.getText().toString();
                String s3 = editTextUsername.getText().toString();
                String s4 = editTextPassword.getText().toString();
                String s5 = editTextConfirmPass.getText().toString();

                if(s1.equals("") || s2.equals("") || s3.equals("") || s4.equals("") || s5.equals("")){
                    Toast.makeText(getApplicationContext(),"Please, insert data!",Toast.LENGTH_LONG).show();
                }

                if(!s4.equals(s5)){
                    Toast.makeText(getApplicationContext(),"Passwords don't match!",Toast.LENGTH_LONG).show();
                }


            }
        });

    }
}
