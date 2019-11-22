package com.example.grayhound;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FirebaseViewHoldeder extends RecyclerView.ViewHolder {
    public TextView from,to,date,startTime,reachTime,money,count,bookingID;

    public FirebaseViewHoldeder(@NonNull View itemView) {
        super(itemView);




        from = itemView.findViewById(R.id.rowFrom);
        to = itemView.findViewById(R.id.rowTo);
        date = itemView.findViewById(R.id.rowDate);
        startTime = itemView.findViewById(R.id.rowStartTime);
        reachTime = itemView.findViewById(R.id.rowEndTime);
        money = itemView.findViewById(R.id.rowMoney);
        count = itemView.findViewById(R.id.rowCount);
        bookingID=itemView.findViewById(R.id.idd);

    }
}
