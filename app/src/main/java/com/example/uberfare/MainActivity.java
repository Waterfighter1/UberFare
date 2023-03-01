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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        // Definining the editor to edit the preferences with
        SharedPreferences.Editor editor = sharedPreferences.edit();

        EditText input_miles = (EditText) findViewById(R.id.ipu_mile);
        Spinner input_car = (Spinner) findViewById(R.id.spi_cars);

        Button button = (Button) findViewById(R.id.btn_continue);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, displayPrice.class));

                editor.putString("input_miles", String.valueOf(input_miles.getText()));
                editor.putString("input_car",  input_car.getSelectedItem().toString());
                editor.apply();
            }
        });
    }
}