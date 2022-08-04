package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {
    private ArrayList<Person> people;
    ItemClicked activity;
    public PersonAdapter(Context context, ArrayList list) {
        people = list;
        activity = (ItemClicked) context;
    }
    public interface ItemClicked{ // create interface to be reused
        void onItemCLicked(int index);
    }
    //link the layout
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPref;
        TextView tvName, tvSurName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPref = itemView.findViewById(R.id.ivPict);
            tvName = itemView.findViewById(R.id.tvName);
            tvSurName = itemView.findViewById(R.id.tvSurname);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.onItemCLicked(people.indexOf((Person)view.getTag()));
                }
            });
        }


    }
    //link the layout

    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,parent,false);

        return new ViewHolder(view);
    }
    // will run at every item
    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder holder, int position) {
         holder.itemView.setTag(people.get(position));
         holder.tvName.setText(people.get(position).getName());
         holder.tvSurName.setText(people.get(position).getSurName());
        if (people.get(position).getPref().equals("bus")){
            holder.ivPref.setImageResource(R.drawable.bus);
        }
        else {
            holder.ivPref.setImageResource(R.drawable.plane);
        }
    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}
