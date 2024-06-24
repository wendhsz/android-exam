package com.example.androidexam.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.androidexam.BR;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Location extends BaseObservable implements Serializable {

    @SerializedName("street")
    @Expose
    private Street street;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("postcode")
    @Expose
    private Integer postcode;
    @SerializedName("coordinates")
    @Expose
    private Coordinates coordinates;
    @SerializedName("timezone")
    @Expose
    private Timezone timezone;

    @Bindable
    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
        notifyPropertyChanged(BR.street);
    }

    @Bindable
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
        notifyPropertyChanged(BR.city);
    }

    @Bindable
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        notifyPropertyChanged(BR.state);
    }

    @Bindable
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
        notifyPropertyChanged(BR.country);
    }

    @Bindable
    public Integer getPostcode() {
        return postcode;
    }

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
        notifyPropertyChanged(BR.postcode);
    }

    @Bindable
    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
        notifyPropertyChanged(BR.coordinates);
    }

    @Bindable
    public Timezone getTimezone() {
        return timezone;
    }

    public void setTimezone(Timezone timezone) {
        this.timezone = timezone;
        notifyPropertyChanged(BR.timezone);
    }

}
