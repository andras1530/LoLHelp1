package com.example.bandi.lolhelp;

public class Model {

    private String title,description,firstrune,firstsp1,firstsp2,firstsp3,firstsp4,secondrune,secondsp1,secondsp2; // Kell talaljon a firebase-el (Database)
    private String image;
    private String phonenumber;
    //Konstruktor

    public Model(){

    }


   //Getterek-Setterek
    public Model(String title,String description,String firstrune,String firstsp1,String firstsp2,String firstsp3,String firstsp4,String secondrune,String secondsp1,String secondsp2,String image,String phonenumber){
        this.title = title;
        this.description = description;
        this.firstrune = firstrune;
        this.firstsp1 = firstsp1;
        this.firstsp2 = firstsp2;
        this.firstsp3 = firstsp3;
        this.firstsp4 = firstsp4;
        this.secondrune = secondrune;
        this.secondsp1 = secondsp1;
        this.secondsp2 = secondsp2;
        this.image = image;
        this.phonenumber = phonenumber;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFirstrune() {
        return firstrune;
    }

    public void setFirstrune(String firstrune) {
        this.firstrune = firstrune;
    }

    public String getFirstsp1() {
        return firstsp1;
    }

    public void setFirstsp1(String firstsp1) {
        this.firstsp1 = firstsp1;
    }

    public String getFirstsp2() {
        return firstsp2;
    }

    public void setFirstsp2(String firstsp2) {
        this.firstsp2 = firstsp2;
    }

    public String getFirstsp3() {
        return firstsp3;
    }

    public void setFirstsp3(String firstsp3) {
        this.firstsp3 = firstsp3;
    }

    public String getFirstsp4() {
        return firstsp4;
    }

    public void setFirstsp4(String firstsp4) {
        this.firstsp4 = firstsp4;
    }

    public String getSecondrune() {
        return secondrune;
    }

    public void setSecondrune(String secondrune) {
        this.secondrune = secondrune;
    }

    public String getSecondsp1() {
        return secondsp1;
    }

    public void setSecondsp1(String secondsp1) {
        this.secondsp1 = secondsp1;
    }

    public String getSecondsp2() {
        return secondsp2;
    }

    public void setSecondsp2(String secondsp2) {
        this.secondsp2 = secondsp2;
    }
}
