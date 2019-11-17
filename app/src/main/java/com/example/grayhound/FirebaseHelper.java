package com.example.grayhound;



import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;


import java.util.ArrayList;

public class FirebaseHelper {

    DatabaseReference db;
    Boolean saved=null;
    ArrayList<String> myBooking=new ArrayList<>();

    public FirebaseHelper(DatabaseReference db) {
        this.db = db;
    }


    //READ
    public ArrayList<String> retrieve()
    {
        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return myBooking;
    }

    private void fetchData(DataSnapshot dataSnapshot)
    {
        myBooking.clear();
        for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            String bookingID=ds.getValue(Booking.class).getBookingID();
            myBooking.add(bookingID);

            String from=ds.getValue(Booking.class).getFrom();
            myBooking.add(from);

            String to=ds.getValue(Booking.class).getTo();
            myBooking.add(to);

            String date=ds.getValue(Booking.class).getDate();
            myBooking.add(date);

            String startTime=ds.getValue(Booking.class).getStartTime();
            myBooking.add(startTime);

            String reachTime=ds.getValue(Booking.class).getReachTime();
            myBooking.add(reachTime);

            String count=ds.getValue(Booking.class).getCount();
            myBooking.add(count);

            String money =ds.getValue(Booking.class).getMoney();
            myBooking.add(money);

               }
    }

}