package com.example.uberfare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        // Definining the editor to edit the preferences with
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Defining Objects
        EditText input_miles = (EditText) findViewById(R.id.ipu_mile);
        Spinner input_car = (Spinner) findViewById(R.id.spi_cars);
        Button button = (Button) findViewById(R.id.btn_continue);
        // Giving The Forward Button Its On Click
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // New Activity
                startActivity(new Intent(MainActivity.this, displayPrice.class));

                // Add Data To Shared Values
                editor.putString("input_miles", String.valueOf(input_miles.getText()));
                editor.putString("input_car", input_car.getSelectedItem().toString());
                editor.apply();
            }
        });
    }
}