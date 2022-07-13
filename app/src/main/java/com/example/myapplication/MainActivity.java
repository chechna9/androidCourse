package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText etId;
    private Button btnId;
    private TextView tvId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        etId = findViewById(R.id.etId);
        btnId = findViewById(R.id.btnId);
        tvId = findViewById(R.id.tvId);


        btnId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String inputId = etId.getText().toString().trim();
                String dateB = inputId.substring(0, 6);
                int genderN = Integer.parseInt(Character.toString(inputId.charAt(6)));
                int citznN = Integer.parseInt(Character.toString(inputId.charAt(10)));
                int raceN = Integer.parseInt(Character.toString(inputId.charAt(11)));
                int checksumN = Integer.parseInt(Character.toString(inputId.charAt(12)));

                String year = Integer.parseInt(dateB.substring(0, 2)) < 50 ? "20" : "19";
                year += dateB.substring(0, 2);
                String month = dateB.substring(2, 4);
                String day = dateB.substring(4, 6);

                String gender = genderN < 5 ? "female" : "male";
                String citzn = citznN == 0 ? "SA Citizen" : citznN == 1 ? "Permanent Citizen" : "Unknown";
                String race = raceN == 0 ? "Black" : citznN == 1 ? "white" : "Other"; //no offense

                String text = getString(R.string.birthS) +" "+ day + "/" + month + "/" + year + "\n" +
                        getString(R.string.genderS) + " "+gender + "\n" +
                        getString(R.string.citznS) + " "+citzn +"\n" +
                        getString(R.string.raceS) + " "+race;
                tvId.setText(text);


            }
        });
    }
}