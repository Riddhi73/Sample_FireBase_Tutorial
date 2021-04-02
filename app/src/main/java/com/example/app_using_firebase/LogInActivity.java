package com.example.app_using_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogInActivity extends AppCompatActivity {


    private EditText loginemail,loginpassword;
    private Button loginBtn;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        loginemail = findViewById(R.id.login_emailEt);
        loginpassword = findViewById(R.id.login_passwordEt);
        loginBtn = findViewById(R.id.LogInbtn);
        firebaseAuth = FirebaseAuth.getInstance();
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailtxt = loginemail.getText().toString();
                String passwordtxt = loginpassword.getText().toString();
                loginUser(emailtxt,passwordtxt);
            }
        });
    }

    private void loginUser(String emailtxt, String passwordtxt) {

        firebaseAuth.signInWithEmailAndPassword(emailtxt,passwordtxt).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(LogInActivity.this, "LogIn Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LogInActivity.this,MainActivity.class));
                finish();
            }
        });



    }
}