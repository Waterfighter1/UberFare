package com.example.uberfare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class confirmDriver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_driver);

        // Defining The Back Button
        Button buttonBack = (Button) findViewById(R.id.btn_back);
        // Defining The Time Text
        TextView timeText = (TextView) findViewById(R.id.txt_time);

        // Adding The Back Buttons Listener
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Starting The New Activity (Display Price)
                startActivity(new Intent(confirmDriver.this, displayPrice.class));
            }
        });

        // Define Random Number
        Random rand = new Random();

        // Generate Random Number (1-60)
        int estimated_minutes = rand.nextInt(61);

        // Set The Text Of The Time
        timeText.setText(String.valueOf(timeText.getText()) + " " + String.valueOf(estimated_minutes) + " minutes!");
    }


}