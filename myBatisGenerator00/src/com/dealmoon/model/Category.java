package com.dealmoon.model;

public class Category {
    private Integer id;

    private String catname;

    private String catdescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

    public String getCatdescription() {
        return catdescription;
    }

    public void setCatdescription(String catdescription) {
        this.catdescription = catdescription;
    }
}