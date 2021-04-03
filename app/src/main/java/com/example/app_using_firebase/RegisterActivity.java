package com.example.app_using_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    private EditText username,name,password,email;
    private DatabaseReference databaseReference;
    private Button register;
    private TextView logInUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.reg_username);
        name = findViewById(R.id.reg_fullname);
        email = findViewById(R.id.reg_email);
        password = findViewById(R.id.reg_password);
        register = findViewById(R.id.regBtn);
        logInUser = findViewById(R.id.login_user);


        databaseReference = FirebaseDatabase.getInstance().getReference();
        logInUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));

            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }
}