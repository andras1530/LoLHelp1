package com.example.bandi.lolhelp;

public class User {
    public String firstname;
    public String lastname;
    public String phonenumber;

    public User() {
    }

    public User(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public User(String firstname, String lastname, String phonenumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
