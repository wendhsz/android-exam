package com.example.androidexam.model;


import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.androidexam.BR;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Person extends BaseObservable implements Serializable{

    @SerializedName("name")
    @Expose
    private Name name;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("dob")
    @Expose
    private Dob dob;
    @SerializedName("cell")
    @Expose
    private String cell;

    private String contactName;
    private String contactNameNum;

//    @SerializedName("picture")
//    @Expose
//    private Picture picture;


    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNameNum() {
        return contactNameNum;
    }

    public void setContactNameNum(String contactNameNum) {
        this.contactNameNum = contactNameNum;
    }

    @Bindable
    public Name getName() {
        return name;
    }


    public void setName(Name name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
        notifyPropertyChanged(BR.location);
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }

    @Bindable
    public Dob getDob() {
        return dob;
    }

    public void setDob(Dob dob) {
        this.dob = dob;
        notifyPropertyChanged(BR.dob);
    }

    @Bindable
    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
        notifyPropertyChanged(BR.cell);
    }

//    public Picture getPicture() {
//        return picture;
//    }
//
//    public void setPicture(Picture picture) {
//        this.picture = picture;
//    }

}
