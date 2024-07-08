package com.example.embeddedf;

public class Deal {
    private String email;
    private String name;
//    private String presence;
//    private String title;

    public Deal() {
    }

    public Deal(String email, String name){   //String presence, String title)
        this.email = email;
        this.name = name;
        //this.presence = presence;
        //this.title = title;
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

//    //public String getPresence() {
//      //  return presence;
//   // }
//
//    public void setPresence(String presence) {
//        this.presence = presence;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
}
