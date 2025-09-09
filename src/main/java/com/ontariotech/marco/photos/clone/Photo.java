package com.ontariotech.marco.photos.clone;

public class Photo {

    private String id;
    private String fileName;

    //raw data

    //empty constructor
    public Photo() {
    }

    //constructor
    public Photo(String id, String fileName)  {
        this.id = id;
        this.fileName = fileName;
    }

    //getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
