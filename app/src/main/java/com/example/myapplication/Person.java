package com.example.myapplication;

public class Person {
    private String name;
    private String surName;
    private String pref;

    public Person(String name, String surName, String pref) {
        this.name = name;
        this.surName = surName;
        this.pref = pref;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPref() {
        return pref;
    }

    public void setPref(String pref) {
        this.pref = pref;
    }
}
