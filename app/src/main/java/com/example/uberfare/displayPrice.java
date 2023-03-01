package com.example.uberfare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class displayPrice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_price);

        Button buttonCont = (Button) findViewById(R.id.btn_continue);
        buttonCont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(displayPrice.this, confirmDriver.class));
            }
        });

        Button buttonBack = (Button) findViewById(R.id.btn_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(displayPrice.this, MainActivity.class));
            }
        });


        SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        String miles = sharedPreferences.getString("input_miles", "0");
        String car = sharedPreferences.getString("input_car", "");

        TextView txtMile = (TextView) findViewById(R.id.txt_mile);
        TextView txtCar = (TextView) findViewById(R.id.txt_car);
        TextView txtTot = (TextView) findViewById(R.id.txt_total);


        double calculatedTotal = calcTotal(Integer.valueOf(miles), car);

        txtMile.setText(txtMile.getText() + " " + miles);
        txtCar.setText(txtCar.getText() + car);
        txtTot.setText(txtTot.getText() + String.valueOf(calculatedTotal));


    }

    static double calcTotal(int miles, String car) {
        double total = 3.00;

        if (car.contains("$")) {
            int position = car.indexOf("$") + 1;
            total += Integer.parseInt(String.valueOf(car.charAt(position)));
        }

        total += miles * 3.25;

        return total;
    }

}