package com.Mobile.App.Library;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList<String> room_id, room_title, room_description, room_capacity;

    CustomAdapter(Activity activity, Context context, ArrayList<String> room_id, ArrayList<String> room_title,
                  ArrayList<String> room_description, ArrayList<String> room_capacity) {
        this.activity = activity;
        this.context = context;
        this.room_id = room_id;
        this.room_title = room_title;
        this.room_description = room_description;
        this.room_capacity = room_capacity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.room_id_txt.setText(String.valueOf(room_id.get(position)));
        holder.room_title_txt.setText(String.valueOf(room_title.get(position)));
        holder.room_description_txt.setText(String.valueOf(room_description.get(position)));
        holder.room_capacity_txt.setText(String.valueOf(room_capacity.get(position)));

        // RecyclerView onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(room_id.get(position)));
                intent.putExtra("title", String.valueOf(room_title.get(position)));
                intent.putExtra("description", String.valueOf(room_description.get(position)));
                intent.putExtra("capacity", String.valueOf(room_capacity.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });

        // Animate RecyclerView
        Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
        holder.mainLayout.setAnimation(translate_anim);
    }

    @Override
    public int getItemCount() {
        return room_id.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView room_id_txt, room_title_txt, room_description_txt, room_capacity_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            room_id_txt = itemView.findViewById(R.id.book_id_txt);
            room_title_txt = itemView.findViewById(R.id.book_title_txt);
            room_description_txt = itemView.findViewById(R.id.book_author_txt);
            room_capacity_txt = itemView.findViewById(R.id.book_pages_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
    }
