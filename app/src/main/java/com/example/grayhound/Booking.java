package com.example.grayhound;

public class Booking {
    public String bookingID;
    public String from;
    public String to;
    public String date;
    public String startTime;
    public String reachTime;
    public String count;
    public String money;

    public Booking(String bookingID, String from, String to, String date, String startTime, String reachTime, String count, String money) {
        this.bookingID = bookingID;
        this.from = from;
        this.to = to;
        this.date = date;
        this.startTime = startTime;
        this.reachTime = reachTime;
        this.count = count;
        this.money = money;
    }
public Booking(){

}
    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setReachTime(String reachTime) {
        this.reachTime = reachTime;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getDate() {
        return date;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getReachTime() {
        return reachTime;
    }

    public String getCount() {
        return count;
    }

    public String getMoney() {
        return money;
    }
}
