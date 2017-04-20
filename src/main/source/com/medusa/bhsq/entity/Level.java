package com.medusa.bhsq.entity;

import java.io.Serializable;

public class Level implements Serializable{
    private Integer id;

    private String image;

    private Byte number;

    private Integer ex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Byte getNumber() {
        return number;
    }

    public void setNumber(Byte number) {
        this.number = number;
    }

    public Integer getEx() {
        return ex;
    }

    public void setEx(Integer ex) {
        this.ex = ex;
    }
}