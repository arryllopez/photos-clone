package com.ontariotech.marco.photos.clone;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;

public class Photo {

    private String id;

    @NotEmpty
    private String fileName;

    @JsonIgnore
    private byte[] data;

    //raw data


    public byte[] getData() {
        return data;
    }

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

    public void setData(byte[] bytes) {
        this.data = bytes;
    }
}
