package com.example.resistorcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Calculator5Bands extends AppCompatActivity {

    private String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator5_bands);
        Intent intent = getIntent();
        username = intent.getStringExtra("username");
    }

    public void calculate(View view){
        Intent intent = new Intent(this, Calculator_Activity.class);
        intent.putExtra("username", username);
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