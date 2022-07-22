package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et;
    private Button act2;
    private Button act3;
    private TextView tvResult;
    final int Acivity3=3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        act2 = findViewById(R.id.act2);
        act3 = findViewById(R.id.act3);
        et = findViewById(R.id.etId1);
        tvResult = findViewById(R.id.tvResult);
        tvResult.setVisibility(View.INVISIBLE);
        act2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = et.getText().toString();
                if(!name.isEmpty()){
                    Intent intent = new Intent(MainActivity.this,com.example.myapplication.Activity2.class);
                    intent.putExtra("name",name);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this,"Empty Name",Toast.LENGTH_SHORT).show();
                }

            }
        });

        act3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,com.example.myapplication.Activity3.class);
                startActivityForResult(intent,Acivity3);
            }
        });




    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Acivity3){
            tvResult.setVisibility(View.VISIBLE);
            if(resultCode == RESULT_OK){
                String surname = data.getStringExtra("surname");
                tvResult.setText("Did They call you "+surname+"?");
                return;
            }
            if (resultCode == RESULT_CANCELED){
                tvResult.setText("No Data");
                return;
            }

        }
    }
}