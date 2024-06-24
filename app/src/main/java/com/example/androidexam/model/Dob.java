package com.example.androidexam.model;

import android.os.Build;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Dob extends BaseObservable implements Serializable {

    @SerializedName("date")
    @Expose
    private String date;

    @Bindable
    public String getDate() {
        if(Build.VERSION.SDK_INT >= 26)
        {
            ZonedDateTime dateTime = ZonedDateTime.parse(date, DateTimeFormatter.ISO_ZONED_DATE_TIME);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
            return dateTime.format(formatter);
        }
        else
        {
            org.threeten.bp.ZonedDateTime dateTime = org.threeten.bp.ZonedDateTime.parse(date, org.threeten.bp.format.DateTimeFormatter.ISO_ZONED_DATE_TIME);
            org.threeten.bp.format.DateTimeFormatter formatter = org.threeten.bp.format.DateTimeFormatter.ofPattern("MMMM dd, yyyy");
            return dateTime.format(formatter);
        }
    }
    public void setDate(String date) {
        this.date = date;
        notifyPropertyChanged(BR.date);
    }

    public void setAge(){

    }

    public int getAge()
    {
        if(Build.VERSION.SDK_INT >= 26)
        {
            ZonedDateTime dateTime = ZonedDateTime.parse(date, DateTimeFormatter.ISO_ZONED_DATE_TIME);
            ZonedDateTime currDate = ZonedDateTime.now();
            return Period.between(dateTime.toLocalDate(), currDate.toLocalDate()).getYears();
        }else{
            org.threeten.bp.ZonedDateTime dateTime = org.threeten.bp.ZonedDateTime.parse(date, org.threeten.bp.format.DateTimeFormatter.ISO_ZONED_DATE_TIME);
            org.threeten.bp.ZonedDateTime currDate = org.threeten.bp.ZonedDateTime.now();
            return org.threeten.bp.Period.between(dateTime.toLocalDate(),currDate.toLocalDate()).getYears();
        }
    }

}