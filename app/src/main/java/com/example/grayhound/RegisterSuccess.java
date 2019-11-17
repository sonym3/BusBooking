package com.example.grayhound;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterSuccess extends AppCompatActivity {

    Button btnSuccessForward;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_success);

        btnSuccessForward=(Button)findViewById(R.id.btnClickHereRegisterSuccess);

        btnSuccessForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterSuccess.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
