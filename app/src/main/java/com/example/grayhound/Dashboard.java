package com.example.grayhound;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Dashboard extends AppCompatActivity {

    Spinner from,to,time,count;
    private Button search;
    private TextView dateSlot;
    private int mYear, mMonth, mDay;
    final Calendar defaultMaxDate = Calendar.getInstance(Locale.getDefault());

    String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        from=(Spinner)findViewById(R.id.leavingFrom);
        to=(Spinner)findViewById(R.id.goingTo);
      //  time=(Spinner)findViewById(R.id.timeOfTravel);
        count=(Spinner)findViewById(R.id.numberOfPeople);
        search=(Button) findViewById(R.id.btnSearch);
        dateSlot=(TextView) findViewById(R.id.pickDate);


        user = getIntent().getExtras().getString("user");
        defaultMaxDate.set(2019, Calendar.DECEMBER, 30);

        dateSlot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(Dashboard.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                dateSlot.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        }, mYear, mMonth, mDay);




                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.getDatePicker().setMaxDate(defaultMaxDate.getTimeInMillis());
                datePickerDialog.show();
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(from.getSelectedItem().equals(to.getSelectedItem())){
                    Toast.makeText(getApplicationContext(), "Choose different Destination", Toast.LENGTH_LONG).show();
                    return;
                }

                if(TextUtils.isEmpty(dateSlot.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Pick a Date", Toast.LENGTH_LONG).show();
                    return;
                }

                Intent intent = new Intent(Dashboard.this, SearchResult.class);
                intent.putExtra("from",from.getSelectedItem().toString());
                intent.putExtra("to",to.getSelectedItem().toString());
                intent.putExtra("date",dateSlot.getText().toString());
               // intent.putExtra("time",time.getSelectedItem().toString());
                intent.putExtra("count",count.getSelectedItem().toString());
                intent.putExtra("user",user);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mbk:
                getBookingDetails();
                return  true;
            case R.id.out:
                getLost();
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }

    private void getLost() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(Dashboard.this, MainActivity.class);
        startActivity(intent);
    }

    private void getBookingDetails() {
        Intent intent = new Intent(Dashboard.this, MyBooking.class);
        intent.putExtra("user",user);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        // do nothing.
    }
}
