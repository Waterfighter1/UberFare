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

        Button buttonBack = (Button) findViewById(R.id.btn_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(confirmDriver.this, displayPrice.class));
            }
        });

        Random rand = new Random();
        int estimated_minutes = rand.nextInt(61);

        TextView timeText = (TextView) findViewById(R.id.txt_time);
        timeText.setText(String.valueOf(timeText.getText()) + " " + String.valueOf(estimated_minutes) + " minutes!");
    }


}