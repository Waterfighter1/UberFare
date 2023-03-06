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

        // Defining Forward Button
        Button buttonCont = (Button) findViewById(R.id.btn_continue);
        // Defining Back Button
        Button buttonBack = (Button) findViewById(R.id.btn_back);

        // Defining Forward Button Listener
        buttonCont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start New Activity (Confirm Driver)
                startActivity(new Intent(displayPrice.this, confirmDriver.class));
            }
        });

        // Defining Back Button Listener
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start New Activity (Main Activity)
                startActivity(new Intent(displayPrice.this, MainActivity.class));
            }
        });

        // Getting Shared Preferences
        SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        String miles = sharedPreferences.getString("input_miles", "0");
        String car = sharedPreferences.getString("input_car", "");

        // Defining Text Views
        TextView txtMile = (TextView) findViewById(R.id.txt_mile);
        TextView txtCar = (TextView) findViewById(R.id.txt_car);
        TextView txtTot = (TextView) findViewById(R.id.txt_total);

        // Call Calc Total And Assign It To A Variable
        double calculatedTotal = calcTotal(Integer.valueOf(miles), car);

        // Update The Text
        txtMile.setText(txtMile.getText() + " " + miles);
        txtCar.setText(txtCar.getText() + car);
        txtTot.setText(txtTot.getText() + String.valueOf(calculatedTotal));


    }

    static double calcTotal(int miles, String car) {
        // Defining Base Fee
        double total = 3.00;

        // Looking For The $ In The Car Name
        if (car.contains("$")) {
            // Going Forward In The Index (Grabbing The Number)
            int position = car.indexOf("$") + 1;
            // Update Total
            total += Integer.parseInt(String.valueOf(car.charAt(position)));
        }
        // Update Total With Miles * Miles Rate
        total += miles * 3.25;

        return total;
    }

}