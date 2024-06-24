package com.example.androidexam.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContactPerson {

    @SerializedName("name")
    @Expose
    private Name name;
    @SerializedName("cell")
    @Expose
    private String cell;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

}
