package com.example.grayhound;

public class Pojo {
    private  String bookingID;
    private String from;
    private String to;
    private String date;
    private String money;
    private String count;
    private String reach;
    private String end;

    public Pojo(String bookingID, String from, String to, String date, String money, String count, String reach, String end) {
        this.bookingID = bookingID;
        this.from = from;
        this.to = to;
        this.date = date;
        this.money = money;
        this.count = count;
        this.reach = reach;
        this.end = end;
    }

    public Pojo() {
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getReach() {
        return reach;
    }

    public void setReach(String reach) {
        this.reach = reach;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
