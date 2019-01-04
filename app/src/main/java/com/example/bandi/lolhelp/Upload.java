package com.example.bandi.lolhelp;

public class Upload {

    private String title,description,firstrune,firstsp1,firstsp2,firstsp3,firstsp4,secondrune,secondsp1,secondsp2;;
    private String image;
    private String phonenumber;

    public Upload(){

    }

    public Upload(String title, String image,String description ,String firstrune, String firstsp1,String firstsp2,String firstsp3 ,String firstsp4,String secondrune,String secondsp1,String secondsp2,String phonenumber) {
        if(title.trim().equals("")) {
          title = "No Name";
        }
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

    public void setTitle(String mtitle) {
        this.title = mtitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String mdescription) {
        this.description = mdescription;
    }

    public String getFirstrune() {
        return firstrune;
    }

    public void setFirstrune(String mfirstrune) {
        this.firstrune = mfirstrune;
    }

    public String getFirstsp1() {
        return firstsp1;
    }

    public void setFirstsp1(String mfirstsp1) {
        this.firstsp1 = mfirstsp1;
    }

    public String getFirstsp2() {
        return firstsp2;
    }

    public void setFirstsp2(String mfirstsp2) {
        this.firstsp2 = mfirstsp2;
    }

    public String getFirstsp3() {
        return firstsp3;
    }

    public void setFirstsp3(String mfirstsp3) {
        this.firstsp3 = mfirstsp3;
    }

    public String getFirstsp4() {
        return firstsp4;
    }

    public void setFirstsp4(String mfirstsp4) {
        this.firstsp4 = mfirstsp4;
    }

    public String getSecondrune() {
        return secondrune;
    }

    public void setSecondrune(String msecondrune) {
        this.secondrune = msecondrune;
    }

    public String getSecondsp1() {
        return secondsp1;
    }

    public void setSecondsp1(String msecondsp1) {
        this.secondsp1 = msecondsp1;
    }

    public String getSecondsp2() {
        return secondsp2;
    }

    public void setSecondsp2(String msecondsp2) {
        this.secondsp2 = msecondsp2;
    }

    public String getImage(){
        return image;
    }
    public void setImage(String image){
        this.image = image;
    }
}
