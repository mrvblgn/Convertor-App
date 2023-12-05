package com.example.convertorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainRandom extends AppCompatActivity {

    private EditText editTextAdet, editTextMin, editTextMax;
    private Button btnCreateBars;
    private ScrollView scrollView;
    private LinearLayout linearLayoutContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        editTextAdet = findViewById(R.id.etn_adet);
        editTextMin = findViewById(R.id.etn_min);
        editTextMax = findViewById(R.id.etn_max);
        btnCreateBars = findViewById(R.id.btn_olustur);
        scrollView = findViewById(R.id.scrollView);
        linearLayoutContainer = findViewById(R.id.container);

        btnCreateBars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createProgressBars();
            }
        });
    }

    private void createProgressBars() {
        linearLayoutContainer.removeAllViews(); // Önceki ProgressBar'ları temizle

        // Kullanıcının girdiği adet sayısını al
        int adet = Integer.parseInt(editTextAdet.getText().toString());

        // Kullanıcının girdiği minimum ve maksimum değerleri al
        int minGlobal = Integer.parseInt(editTextMin.getText().toString());
        int maxGlobal = Integer.parseInt(editTextMax.getText().toString());

        // Random nesnesi oluştur
        Random random = new Random();

        for (int i = 0; i < adet; i++) {
            int min = random.nextInt((maxGlobal - minGlobal) + 1) + minGlobal;
            int max = random.nextInt((maxGlobal - min) + 1) + min;

            int progress = random.nextInt((max - min) + 1) + min;
            int percentage = (progress - min) * 100 / (max - min);

            ProgressBar progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
            progressBar.setProgress(percentage);

            TextView textView = new TextView(this);
            textView.setText("Min: " + min  + " Değer = " + progress + " Yüzde " + percentage + "%" + " Max: " + max);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            linearLayoutContainer.addView(progressBar, layoutParams);
            linearLayoutContainer.addView(textView, layoutParams);
        }

        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(View.FOCUS_DOWN);
            }
        });
    }
}