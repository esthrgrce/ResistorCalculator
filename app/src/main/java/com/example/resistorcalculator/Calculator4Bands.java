package com.example.resistorcalculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Calculator4Bands extends AppCompatActivity {

    private Button btnMag1, btnMag2, btnMultiplier, btnTolerance;
    private String[] toleranceList;
    private String[] magnitudeList;
    private String[] colorsList;
    private AlertDialog.Builder builder;
    private AlertDialog alert;
    private int mag1, mag2, multiplier;
    private double tolerance, min, max;
    private TextView txtResistance, txtTolerance, txtMin, txtMax;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator4_bands);
        btnMag1 = findViewById(R.id.btnMag1);
        btnMag2 = findViewById(R.id.btnMag2);
        btnMultiplier = findViewById(R.id.btnMultiplier);
        btnTolerance = findViewById(R.id.btnTolerance);
        txtResistance = findViewById(R.id.txtResistance);
        txtTolerance = findViewById(R.id.txtTolerance);
        txtMin = findViewById(R.id.txtMin);
        txtMax = findViewById(R.id.txtMax);

        magnitudeList = new String[]{"Black", "Brown", "Red", "Orange", "Yellow", "Green", "Blue", "Violet", "Gray", "White"};
        toleranceList = new String[]{"Silver", "Gold"};
        colorsList = new String[]{"#191818","#8E6545","#AA0808","#FF5722","#FFEB3B","#23CF2A","#041365","#82059E","#82059E","#FFFFFF","#B3B1B1","#E4AE09"};
        builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose color:");

        mag1 = 1;
        mag2 = 0;
        multiplier = 0;
        tolerance = 0.05;

        initialize(mag1,mag2,multiplier,tolerance);
        setColors();
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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setColors(){
        btnMag1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(colorsList[mag1])));
        btnMag2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(colorsList[mag2])));
        btnMultiplier.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(colorsList[multiplier])));
        if(tolerance == 0.05){
            btnTolerance.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(colorsList[11])));
        }else{
            btnTolerance.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(colorsList[10])));
        }
    }

    private double getResistance(int m1, int m2, int multi){
        mag1 = m1;
        mag2 = m2;
        multiplier = multi;
        String concat = String.valueOf(mag1) + String.valueOf(mag2);
        double resistanceNum = Integer.parseInt(concat);
        return resistanceNum * Math.pow(10,multiplier);
    }

    private double getMin(double resistance, double tolerance){
        return resistance - (resistance*tolerance);
    };
    private double getMax(double resistance, double tolerance){
        return resistance + (resistance*tolerance);
    };

    public void initialize(int m1, int m2, int multi, double tole){
        double resistance = getResistance(m1,m2,multi);
        tolerance = tole;
        min = getMin(resistance, tolerance);
        max = getMax(resistance, tolerance);
        if(resistance > 1000){
            txtResistance.setText(String.valueOf(resistance/1000) + "k ohms");
            txtMin.setText(String.valueOf(min/1000) + "k ohms");
            txtMax.setText(String.valueOf(max/1000) + "k ohms");
        }else{
            txtResistance.setText(String.valueOf(resistance) + " ohms");
            txtMin.setText(String.valueOf(min) + " ohms");
            txtMax.setText(String.valueOf(max) + " ohms");
        }
        txtTolerance.setText(String.valueOf(tolerance*100) + " %");
    }

    public void setTolerance(View view){
        int tol;
        if(tolerance == 0.05){
            tol = 1;
        }else{
            tol = 0;
        }
        builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        builder.setSingleChoiceItems(toleranceList, tol, new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which == 0){
                    tolerance = 0.10;
                }else{
                    tolerance = 0.05;
                }
                initialize(mag1,mag2,multiplier,tolerance);
                setColors();
            }
        });

        alert = builder.create();
        alert.show();
    }

    public void setMag1(View view){
        builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        builder.setSingleChoiceItems(magnitudeList, mag1, new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mag1 = which;
                initialize(mag1,mag2,multiplier,tolerance);
                setColors();
            }
        });

        alert = builder.create();
        alert.show();
    }

    public void setMag2(View view){
        builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        builder.setSingleChoiceItems(magnitudeList, mag2, new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mag2 = which;
                initialize(mag1,mag2,multiplier,tolerance);
                setColors();
            }
        });

        alert = builder.create();
        alert.show();
    }

    public void setMultiplier(View view){
        builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        builder.setSingleChoiceItems(magnitudeList, multiplier, new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(DialogInterface dialog, int which) {
                multiplier = which;
                initialize(mag1,mag2,multiplier,tolerance);
                setColors();
            }
        });

        alert = builder.create();
        alert.show();
    }

}