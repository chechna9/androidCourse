package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;


public class Activity2 extends AppCompatActivity {

    private TextView tvId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        tvId = findViewById(R.id.tv1);
        String name = getIntent().getStringExtra("name");
        tvId.setText("Welcome to Activity 2  "+name);

    }
}