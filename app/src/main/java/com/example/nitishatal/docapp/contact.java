package com.example.nitishatal.docapp;

public class contact {
    String name,email,subject,msg;

    public  contact(){

    }


    public contact(String name, String email, String subject, String msg) {
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.msg = msg;

    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getSubject() {
        return subject;
    }

    public String getMsg() {
        return msg;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }




}
