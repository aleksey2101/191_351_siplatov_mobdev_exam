package com.example.programm.myapplication_2;

public class MyNew {
    private String title;

    // Image name (Without extension)
    private String imgLink;
    private String date;

    public MyNew(String title, String imgLink, String date) {
        this.title = title;
        this.imgLink = imgLink;
        this.date = date;

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    @Override
    public String toString()  {
        return this.title +" (Population: "+ this.date +")";
    }
}
