package com.example.resistorcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Home_Activity extends AppCompatActivity {

    private String username;
    private TextView txtGreeting;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);

        txtGreeting = findViewById(R.id.txtGreeting);
        btnCalculate = findViewById(R.id.btnCalculate);

        Intent intent = getIntent();
        username = intent.getStringExtra("username");
        txtGreeting.setText("Hi " + username);
        Toast.makeText(this, "Hi " + username, Toast.LENGTH_SHORT).show();

    }

    public void calculate(View view){
        Intent intent = new Intent(this, Calculator_Activity.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }

    public void home(View view){
        Intent intent = new Intent(this, Home_Activity.class);
        intent.putExtra("username","Esther");
        startActivity(intent);
    }
}