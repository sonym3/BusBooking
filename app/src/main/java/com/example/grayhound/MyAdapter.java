package com.example.grayhound;



import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context c;
    ArrayList<String> myBooking;

    public MyAdapter(Context c, ArrayList<String> spacecrafts) {
        this.c = c;
        this.myBooking = spacecrafts;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(c).inflate(R.layout.model,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.hBookingID.setText(myBooking.get(position));
        holder.hDate.setText(myBooking.get(position));
        holder.hMoney.setText(myBooking.get(position));
        holder.hEndTime.setText(myBooking.get(position));
        holder.hStartTime.setText(myBooking.get(position));
        holder.hCount.setText(myBooking.get(position));
        holder.hTo.setText(myBooking.get(position));
        holder.hFrom.setText(myBooking.get(position));
    }

    @Override
    public int getItemCount() {
        return myBooking.size();
    }
}
