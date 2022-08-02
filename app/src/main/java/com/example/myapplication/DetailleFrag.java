package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DetailleFrag extends Fragment  {
    static TextView tv;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_detaille, container, false);
        tv = (TextView)rootView.findViewById(R.id.tvDescr);
        tv.setText(getResources().getStringArray(R.array.descriptions)[0]);
        return rootView;
    }

     static void updateTv(String s){
        tv.setText(s);
    }
}