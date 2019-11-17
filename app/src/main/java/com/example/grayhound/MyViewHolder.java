package com.example.grayhound;


import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder  {

    TextView hBookingID,hFrom,hTo,hStartTime,hEndTime,hCount,hMoney,hDate;

    public MyViewHolder(View itemView) {
        super(itemView);

        hBookingID=(TextView) itemView.findViewById(R.id.model_bookingID);
        hFrom=(TextView) itemView.findViewById(R.id.model_from);
        hTo=(TextView) itemView.findViewById(R.id.model_to);
        hCount=(TextView) itemView.findViewById(R.id.model_count);
        hStartTime=(TextView) itemView.findViewById(R.id.model_timestart);
        hEndTime=(TextView) itemView.findViewById(R.id.model_timereach);
        hMoney=(TextView) itemView.findViewById(R.id.model_money);
        hDate=(TextView) itemView.findViewById(R.id.model_date);
    }
}