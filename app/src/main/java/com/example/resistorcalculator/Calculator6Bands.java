package com.example.resistorcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Calculator6Bands extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator6_bands);
    }

    public void calculate(View view){
        Intent intent = new Intent(this, Calculator_Activity.class);
        intent.putExtra("username", "Esther");
        startActivity(intent);
    }

    public void home(View view){
        Intent intent = new Intent(this, Home_Activity.class);
        intent.putExtra("username","Esther");
        startActivity(intent);
    }
}