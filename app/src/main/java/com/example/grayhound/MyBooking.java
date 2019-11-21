package com.example.grayhound;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MyBooking extends AppCompatActivity {
    private RecyclerView mBookingList;
    private DatabaseReference mBookingData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_booking);

        mBookingData= FirebaseDatabase.getInstance().getReference().child("comgooglefirebaseauthinternalzzl@28fc17e");
        mBookingData.keepSynced(true);


        mBookingList=(RecyclerView)findViewById(R.id.myRe);
        mBookingList.setHasFixedSize(true);
        mBookingList.setLayoutManager(new LinearLayoutManager(this));

    }


    @Override
    protected void onStart() {
        super.onStart();


        FirebaseRecyclerOptions<Pojo> options =
                new FirebaseRecyclerOptions.Builder<Pojo>()
                        .setQuery(mBookingData, Pojo.class)
                        .build();

        FirebaseRecyclerAdapter<Pojo,PojoHolder> firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<Pojo, PojoHolder>
                (options) {
            @Override
            protected void onBindViewHolder(@NonNull PojoHolder pojoHolder, int i, @NonNull Pojo pojo) {

                pojoHolder.setFrom(pojo.getFrom());
            }

            @NonNull
            @Override
            public PojoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return null;
            }
        };
        mBookingList.setAdapter(firebaseRecyclerAdapter);
    }

    public static class PojoHolder extends RecyclerView.ViewHolder{
        View mView;
        public PojoHolder(View itemView){
            super(itemView);
            mView=itemView;
        }

        public void setFrom(String from){
            TextView sFrom=(TextView)mView.findViewById(R.id.rowFrom);
            sFrom.setText(from);

        }
    }
}
