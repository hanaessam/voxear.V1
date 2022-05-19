package com.example.startupdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.findBtn);
        Button button4 = findViewById(R.id.adjustAlarm);
        Button button5 = findViewById(R.id.spaekbtn);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUpActivity();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignInActivity();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFindMyDeviceActivity();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdjustAlarmActivity();
            }
        });


        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSpeakActivity();
            }
        });

    }

    public void openSignInActivity() {
        Intent intent = new Intent(this, SignIn.class);
        startActivity(intent);
    }
    public void openSignUpActivity() {
        Intent intent2 = new Intent(this, SignUp.class);
        startActivity(intent2);
    }
    public void openFindMyDeviceActivity() {
        Intent intent3 = new Intent(this, FindMyDevice.class);
        startActivity(intent3);
    }

    public void openSpeakActivity() {
        Intent intent5 = new Intent(this, Speak.class);
        startActivity(intent5);
    }
    public void openAdjustAlarmActivity() {
        Intent intent4 = new Intent(this, AdjustAlarm.class);
        startActivity(intent4);
    }
}