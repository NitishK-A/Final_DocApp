package com.example.nitishatal.docapp;

public class appoint {
    String name,mobile,description,date,time;
    String pending;
    public appoint() {
    }

    public appoint(String name, String mobile, String description, String date, String time, String pending) {
        this.name = name;
        this.mobile = mobile;
        this.description = description;
        this.date = date;
        this.time = time;
        this.pending = pending;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPending() {
        return pending;
    }

    public void setPending(String pending) {
        this.pending = pending;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
