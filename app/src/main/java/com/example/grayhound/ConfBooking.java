package com.example.grayhound;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConfBooking extends AppCompatActivity {
Button btnConfBooking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conf_booking);
        final String user = getIntent().getExtras().getString("user");

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
}
