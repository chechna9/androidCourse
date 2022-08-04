package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter myAdabter;
    RecyclerView.LayoutManager layoutMnager;
    ArrayList<Person> people;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        recyclerView = findViewById(R.id.list); // link with the rcView
        recyclerView.setHasFixedSize(true); // affect perfomance

        layoutMnager = new LinearLayoutManager(this); //main activity
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
}