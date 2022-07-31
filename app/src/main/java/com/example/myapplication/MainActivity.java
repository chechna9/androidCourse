package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFragment.ItemSelected {


    private TextView tvDescription;

    ArrayList<String> description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
//

        description = new ArrayList<String>();

        description.add("Description for item 1 ");
        description.add("Description for item 2 ");
        description.add("Description for item 3 ");


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);

    }

    @Override
    public void onItemSelected(int index) {
        DetailleFrag.updateTv(description.get(index));

    }
}