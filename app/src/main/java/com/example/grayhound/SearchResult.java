package com.example.grayhound;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Time;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class SearchResult extends AppCompatActivity {

    TextView from,to,date,timeslot1,timeslotEnd,count,money;
    Button confBooking;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        final String user = getIntent().getExtras().getString("user");
        from=(TextView)findViewById(R.id.searchResultFrom);
        to=(TextView)findViewById(R.id.searchResultTo);
        date=(TextView)findViewById(R.id.searchResultDate);
       // time=(TextView)findViewById(R.id.searchResultTime);
        count=(TextView)findViewById(R.id.searchResultCount);

        confBooking=(Button)findViewById(R.id.confirmBooking);
        final String value1 = getIntent().getExtras().getString("from");
        from.setText(value1);

        final String value2 = getIntent().getExtras().getString("to");
        to.setText(value2);

        final String value3 = getIntent().getExtras().getString("date");
        date.setText(value3);
/*
        String value4 = getIntent().getExtras().getString("time");
        time.setText(value4);*/

        final String value5 = getIntent().getExtras().getString("count");
        count.setText(value5);
        final Booking userx = new Booking();

        userx.setFrom(value1);
        userx.setTo(value2);
        userx.setDate(value3);
        userx.setCount(value5);
        int random1 = (int)(Math.random()*((24-1)+1))+1;;
        String start=random1+":00H";

        userx.setStartTime(start);
        int random2 = (int)(Math.random()*((24-(random1+1))+1))+(random1+1);
        String end=random2+":00H";
        userx.setReachTime(end);
        int random3 = (int)(Math.random()*((100-20)+1))+20;;
        String moneytotal=random3+"$";
        userx.setMoney(moneytotal);


        int y = (int)(Math.random()*((100000-1)+1))+1;;
        final String bookingID=y+"";

        userx.setBookingID(bookingID);
        timeslot1=(TextView)findViewById(R.id.timeSlotstart1);
        timeslot1.setText(start);

        timeslotEnd=(TextView)findViewById(R.id.timeSlotEnd1);
        timeslotEnd.setText(end);

        money =(TextView)findViewById(R.id.Price);
        money.setText(moneytotal);

        confBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference reference ;
                reference = FirebaseDatabase.getInstance().getReference();
                reference.child(user.replace(".","")).child(bookingID).setValue(userx);
                Intent intent = new Intent(SearchResult.this, ConfBooking.class);
                intent.putExtra("user",user);
                startActivity(intent);
            }
        });

    }
}
