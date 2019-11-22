package com.example.grayhound;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ConfBooking extends AppCompatActivity {
Button btnConfBooking,btnMore;
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conf_booking);
        final String user = getIntent().getExtras().getString("user");
        imageView=(ImageView)findViewById(R.id.runningBus);
        btnConfBooking=(Button)findViewById(R.id.btnConfBooking);
        btnConfBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfBooking.this, MyBooking.class);
                intent.putExtra("user",user);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        // do nothing.
    }
}
