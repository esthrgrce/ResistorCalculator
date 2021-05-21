package com.example.resistorcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculator_Activity extends AppCompatActivity {

    private String username;
    private TextView txtGreeting2;
    private Button btn4Bands, btn5Bands, btn6Bands;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_);
        Intent intent = getIntent();
        username = intent.getStringExtra("username");
        txtGreeting2 = findViewById(R.id.txtGreeting2);
        txtGreeting2.setText("Hi " + username);
        btn4Bands = findViewById(R.id.btn4Bands);
        btn5Bands = findViewById(R.id.btn5Bands);
        btn6Bands = findViewById(R.id.btn6Bands);
    }

    public void bands4(View view){
        Intent intent = new Intent(this, Calculator4Bands.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }
    public void bands5(View view){
        Intent intent = new Intent(this, Calculator5Bands.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }
    public void bands6(View view){
        Intent intent = new Intent(this, Calculator6Bands.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }

    public void calculate(View view){
        Intent intent = new Intent(this, Calculator_Activity.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }

    public void home(View view){
        Intent intent = new Intent(this, Home_Activity.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }

    public void notes(View view){
        Intent intent = new Intent(this, Notes_Activity.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }
}