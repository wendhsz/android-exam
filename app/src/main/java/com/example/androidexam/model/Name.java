package com.example.androidexam.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.androidexam.BR;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Name extends BaseObservable implements Serializable {

    @SerializedName("first")
    @Expose
    private String first;
    @SerializedName("last")
    @Expose
    private String last;

    @Bindable
    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
        notifyPropertyChanged(BR.first);
    }

    @Bindable
    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
        notifyPropertyChanged(BR.last);
    }


}