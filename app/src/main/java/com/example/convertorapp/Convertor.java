package com.example.convertorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Convertor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertor);

        Spinner spinner = findViewById(R.id.spinner_1);
        List<String> options = new ArrayList<>();
        options.add("İkilik");
        options.add("Sekizlik");
        options.add("On altılık");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, options);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Spinner spinner2 = findViewById(R.id.spinner_2);
        List<String> options2 = new ArrayList<>();
        options2.add("Kilobyte");
        options2.add("Byte");
        options2.add("Kibibyte");
        options2.add("Bit");

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, options2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        EditText editTextNumber = findViewById(R.id.et_decimal);
        TextView decSonuc = findViewById(R.id.dec_sonuc);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedOption = parent.getItemAtPosition(position).toString();

                String input = editTextNumber.getText().toString();

                if (!input.isEmpty()) {
                    int number = Integer.parseInt(input);

                    switch (selectedOption) {
                        case "İkilik":
                            String binary = Integer.toBinaryString(number);
                            decSonuc.setText("İkilik: " + binary);
                            break;
                        case "Sekizlik":
                            String octal = Integer.toOctalString(number);
                            decSonuc.setText("Sekizlik: " + octal);
                            break;
                        case "On altılık":
                            String hex = Integer.toHexString(number);
                            decSonuc.setText("On altılık: " + hex);
                            break;
                    }
                } else {
                    Toast.makeText(Convertor.this, "Lütfen bir sayı girin", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Hiçbir şey seçilmediğinde çağrılır
            }
        });


        EditText editTextNumberByte = findViewById(R.id.et_byte);
        TextView byteSonuc = findViewById(R.id.byte_sonuc);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedOption = parent.getItemAtPosition(position).toString();
                String input = editTextNumberByte.getText().toString();

                if (!input.isEmpty()) {
                    double megaByte = Double.parseDouble(input);

                    switch (selectedOption) {
                        case "Kilobyte":
                            double kiloByte = megaByte * 1024;
                            byteSonuc.setText("Kilobyte: " + kiloByte);
                            break;
                        case "Byte":
                            double byteValue = megaByte * 1024 * 1024;
                            byteSonuc.setText("Byte: " + byteValue);
                            break;
                        case "Kibibyte":
                            double kibiByte = megaByte * 1024;
                            byteSonuc.setText("Kibibyte: " + kibiByte);
                            break;
                        case "Bit":
                            double bit = megaByte * 1024 * 1024 * 8;
                            byteSonuc.setText("Bit: " + bit);
                            break;
                    }
                } else {
                    Toast.makeText(Convertor.this, "Lütfen bir sayı girin", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Hiçbir şey seçilmediğinde çağrılır
            }
        });

        RadioButton radioButtonFahrenheit = findViewById(R.id.radioButton);
        RadioButton radioButtonKelvin = findViewById(R.id.radioButton2);
        EditText editTextCelsius = findViewById(R.id.et_celc);
        TextView celsiusSonuc = findViewById(R.id.celc_sonuc);

        radioButtonFahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editTextCelsius.getText().toString();
                if (!input.isEmpty()) {
                    double celsius = Double.parseDouble(input);

                    double fahrenheit = celsius * 9/5 + 32;

                    celsiusSonuc.setText("Fahrenheit: " + fahrenheit);
                } else {
                    Toast.makeText(Convertor.this, "Lütfen bir sayı girin", Toast.LENGTH_SHORT).show();
                }
            }
        });

        radioButtonKelvin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editTextCelsius.getText().toString();
                if (!input.isEmpty()) {
                    double celsius = Double.parseDouble(input);

                    double kelvin = celsius + 273.15;

                    celsiusSonuc.setText("Kelvin: " + kelvin);
                } else {
                    Toast.makeText(Convertor.this, "Lütfen bir sayı girin", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}



