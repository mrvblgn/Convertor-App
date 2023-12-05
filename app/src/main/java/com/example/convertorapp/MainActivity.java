package com.example.convertorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCon = findViewById(R.id.btn_con);
        btnCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Convertor.class);
                startActivity(intent);
            }
        });

        Button btnRan = findViewById(R.id.btn_ran);
        btnRan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainRandom.class);
                startActivity(intent);
            }
        });

        Button btnSms = findViewById(R.id.btn_sms);
        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Sms.class);
                startActivity(intent);
            }
        });


        final Button conButton = findViewById(R.id.btn_con);
        final Button ranButton = findViewById(R.id.btn_ran);
        final Button smsButton = findViewById(R.id.btn_sms);

        conButton.setVisibility(View.INVISIBLE);
        ranButton.setVisibility(View.INVISIBLE);
        smsButton.setVisibility(View.INVISIBLE);

        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);

        conButton.postDelayed(new Runnable() {
            @Override
            public void run() {
                conButton.setVisibility(View.VISIBLE);
                conButton.startAnimation(animation);
            }
        }, 1000);

        ranButton.postDelayed(new Runnable() {
            @Override
            public void run() {
                ranButton.setVisibility(View.VISIBLE);
                ranButton.startAnimation(animation);
            }
        }, 2000);

        smsButton.postDelayed(new Runnable() {
            @Override
            public void run() {
                smsButton.setVisibility(View.VISIBLE);
                smsButton.startAnimation(animation);
            }
        }, 3000);
    }
}