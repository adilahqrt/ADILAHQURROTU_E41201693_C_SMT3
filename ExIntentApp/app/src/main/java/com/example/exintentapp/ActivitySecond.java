package com.example.exintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivitySecond extends AppCompatActivity {

    TextView textHello;
    private String nama;
    private String KEY_NAME = "NAMA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textHello = (TextView) findViewById(R.id.textHelo);

        Bundle extras = getIntent().getExtras();
        nama = extras.getString(KEY_NAME);
        textHello.setText("Hello, " + nama + "!");
    }
}