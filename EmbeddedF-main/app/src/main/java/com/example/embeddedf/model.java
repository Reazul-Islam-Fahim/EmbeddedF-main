package com.example.embeddedf;

public class model {
    String email,name,number,title,purl;

    public model() {
    }

    public model(String email, String name, String number, String title, String purl) {
        this.email = email;
        this.name = name;
        this.number = number;
        this.title = title;
        this.purl = purl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getpurl() {
        return purl;
    }

    public void setpurl(String purl) {
        this.purl = purl;
    }
}
