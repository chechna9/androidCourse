package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ListFragment.ItemSelected {


    private TextView tvDescription;

    String[] description;
    FragmentManager manager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        description = getResources().getStringArray(R.array.descriptions);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.listFrag))
                    .hide(manager.findFragmentById(R.id.detailleFrag))
                    .commit();
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailleFrag))
                    .show(manager.findFragmentById(R.id.listFrag))
                    .commit();
        }
    }


    @Override
    public void onItemSelected(int index) {
        DetailleFrag.updateTv(description[index]);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.listFrag))
                    .show(manager.findFragmentById(R.id.detailleFrag))
                    .addToBackStack(null)
                    .commit();
        }
    }
}