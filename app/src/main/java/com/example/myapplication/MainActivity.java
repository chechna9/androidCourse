package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DecimalFormat formatter = new DecimalFormat("#0.0");
        setContentView(R.layout.main_activity);
        EditText etId = findViewById(R.id.etId);
        TextView tvId = findViewById(R.id.tv2Id);
        Button btnId = findViewById(R.id.btnId);
        tvId.setVisibility(View.INVISIBLE);
        btnId.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        if (etId.getText().toString().trim().isEmpty()){

                        }
                        else {

                            double temp = Double.parseDouble(etId.getText().toString().trim())/3 + 4;
                            String sTemp = formatter.format(temp);
                            tvId.setText(getString(R.string.reslut)+" "+sTemp);
                            tvId.setVisibility(View.VISIBLE);
                        }

                    }
                }
        );
    }
}