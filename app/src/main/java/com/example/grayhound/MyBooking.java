package com.example.grayhound;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.SnapshotParser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

public class MyBooking extends AppCompatActivity {

   private DatabaseReference mBookingData;
    private RecyclerView recyclerView;
   // private LinearLayoutManager linearLayoutManager;
    private FirebaseRecyclerOptions<Pojo> options;
    private FirebaseRecyclerAdapter<Pojo,FirebaseViewHoldeder> adapter;
    private ArrayList<Pojo> arrayList;
    @Override
    protected void onStart() {

        super.onStart();
        adapter.startListening();
    }
    @Override
    protected void onStop() {

        super.onStop();
        adapter.stopListening();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_booking);

        recyclerView = findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        arrayList = new ArrayList<Pojo>();
        mBookingData = FirebaseDatabase.getInstance().getReference().child("sonym3@gmailcom");
        mBookingData.keepSynced(true);
        options = new FirebaseRecyclerOptions.Builder<Pojo>().setQuery(mBookingData,Pojo.class).build();


        adapter = new FirebaseRecyclerAdapter<Pojo, FirebaseViewHoldeder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FirebaseViewHoldeder firebaseViewHoldeder, int i, @NonNull Pojo pojo) {

                firebaseViewHoldeder.from.setText(pojo.getFrom());
                firebaseViewHoldeder.to.setText(pojo.getTo());
                firebaseViewHoldeder.date.setText(pojo.getDate());
                firebaseViewHoldeder.start.setText(pojo.getReach());
                firebaseViewHoldeder.end.setText(pojo.getEnd());
                firebaseViewHoldeder.count.setText(pojo.getCount());
                firebaseViewHoldeder.money.setText(pojo.getMoney());
            }

            @NonNull
            @Override
            public FirebaseViewHoldeder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new FirebaseViewHoldeder(LayoutInflater.from(MyBooking.this).inflate(R.layout.booking_row,parent,false));
            }
        };
        recyclerView.setAdapter(adapter);
    }
}