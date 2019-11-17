package com.example.grayhound;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class MyBooking extends AppCompatActivity {

    DatabaseReference db;
    FirebaseHelper helper;
    RecyclerView rv;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_booking);

        rv= (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));

        db= FirebaseDatabase.getInstance().getReference();
        helper=new FirebaseHelper(db);


        adapter=new MyAdapter(this,helper.retrieve());
        rv.setAdapter(adapter);

    }


}
