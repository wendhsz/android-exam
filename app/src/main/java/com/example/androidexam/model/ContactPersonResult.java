package com.example.androidexam.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ContactPersonResult {
    @SerializedName("results")
    @Expose
    private List<ContactPerson> results;
    @SerializedName("info")
    @Expose
    private Info info;

    public List<ContactPerson> getResults() {
        return results;
    }

    public void setResults(List<ContactPerson> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

}