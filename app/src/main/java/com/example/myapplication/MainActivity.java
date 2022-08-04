package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {
    RecyclerView recyclerView;
    RecyclerView.Adapter myAdabter;
    RecyclerView.LayoutManager layoutMnager;
    ArrayList<Person> people;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                people.add(new Person("Sami","Imas","plane"));
                myAdabter.notifyDataSetChanged();
            }
        });
        recyclerView = findViewById(R.id.list); // link with the rcView
        recyclerView.setHasFixedSize(true); // affect perfomance

//        layoutMnager = new LinearLayoutManager(this); //main activity
//        layoutMnager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false); //main activity
        layoutMnager = new GridLayoutManager(this,2,GridLayoutManager.HORIZONTAL,false);//main activity
        recyclerView.setLayoutManager(layoutMnager);
        people = new ArrayList<Person>();
        people.add(new Person("Yacine","Chehnca9","bus"));
        people.add(new Person("Amir","Almama","plane"));
        people.add(new Person("Mazene","Chehnca9","bus"));
        people.add(new Person("Amir","Almama","plane"));
        people.add(new Person("Mazene","Chehnca9","bus"));
        people.add(new Person("Amir","Almama","plane"));
        people.add(new Person("Mazene","Mazin","bus"));

        myAdabter = new PersonAdapter(this,people);

        recyclerView.setAdapter(myAdabter);
    }

    @Override
    public void onItemCLicked(int index) {
        Toast.makeText(this,"surname "+people.get(index).getSurName(),Toast.LENGTH_SHORT).show();
    }
}