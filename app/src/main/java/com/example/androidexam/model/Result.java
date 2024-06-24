package com.example.androidexam.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result  {

    @SerializedName("results")
    @Expose
    private List<Person> personList;
    @SerializedName("info")
    @Expose
    private Info info;

    public List<Person> getResults() {
        return personList;
    }

    public void setResults(List<Person> people) {
        this.personList = people;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

}