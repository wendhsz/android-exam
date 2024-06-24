package com.example.androidexam.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.androidexam.model.Person;
import com.example.androidexam.model.RandomPersonRepository;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private RandomPersonRepository repository;

    Application application;

    private MutableLiveData<List<Person>> persons = new MutableLiveData<>();

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.repository = new RandomPersonRepository(application);
        this.application = application;

    }

    public LiveData<List<Person>> getAllPerson(int page, boolean forceUpdate)
    {
        persons = repository.getMutableLiveData(application, page, forceUpdate);
        return persons;
    }



}
