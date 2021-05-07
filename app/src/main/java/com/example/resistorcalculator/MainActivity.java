package com.example.resistorcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtUser, txtPassword;
    private Button btnLogin;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUser = findViewById(R.id.txtUser);
        txtPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        username = "Esther";
        password = "password";
    }

    public void login(View view){
        Toast.makeText(this, "Logging in...", Toast.LENGTH_SHORT).show();
        String username_login = txtUser.getText().toString();
        String password_login = txtPassword.getText().toString();

        if(username_login.equals(username) && password_login.equals(password)){
            Toast.makeText(this, "Login Successful.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Home_Activity.class);
            intent.putExtra("username", username);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Invalid credentials.", Toast.LENGTH_SHORT).show();
        }
    }

}