package com.example.bandi.lolhelp;

public class User {
    public String firstname;
    public String lastname;
    public String phonenumber;
    public String image;

    public User() {
    }

    public User(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public User(String firstname, String lastname, String phonenumber,String image) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", image= '" + image + '\'' +
                '}';
    }
}
