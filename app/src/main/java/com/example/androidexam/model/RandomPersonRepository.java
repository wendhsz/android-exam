package com.example.androidexam.model;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.androidexam.serviceapi.RandomContactPersonApiService;
import com.example.androidexam.serviceapi.RandomPersonApiService;
import com.example.androidexam.serviceapi.RetrofitInstance;
import com.example.androidexam.util.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RandomPersonRepository {

    private ArrayList<Person> persons = new ArrayList<>();

    private ArrayList<ContactPerson> contactPersons = new ArrayList<>();
    private MutableLiveData<List<Person>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public RandomPersonRepository(Application application)
    {
        this.application = application;
    }

    public MutableLiveData<List<Person>> getMutableLiveData(Application application,int page, boolean forceUpdate) {
        RandomPersonApiService apiService = RetrofitInstance.getService(application.getCacheDir(),forceUpdate);
        RandomContactPersonApiService randomContactPersonApiService = RetrofitInstance.getServiceForContactPerson(application.getCacheDir(),forceUpdate);

        Call<Result> callPeople = apiService.getRandomPeople(Util.API_INCLUSION,
                Util.API_NATIONALITY,
                Util.API_RESULT_COUNT,
                Util.API_SEED,
                String.valueOf(page));

        Call<ContactPersonResult> callContactPerson = randomContactPersonApiService.getRandomPeople(Util.API_RANDOM_INCLUSION,
                Util.API_NATIONALITY,
                Util.API_RESULT_COUNT,
                Util.API_SEED_CONTACT_PERSON,
                String.valueOf(page));

        callPeople.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();

                if(result != null && result.getResults() != null)
                {
                    persons = (ArrayList<Person>) result.getResults();

                    mutableLiveData.setValue(persons);

                    callContactPerson.enqueue(new Callback<ContactPersonResult>() {
                        @Override
                        public void onResponse(Call<ContactPersonResult> call, Response<ContactPersonResult> response) {
                            ContactPersonResult contactPersonResult = response.body();
                            if(contactPersonResult != null && contactPersonResult.getResults() != null)
                            {
                                contactPersons = (ArrayList<ContactPerson>) contactPersonResult.getResults();
                                for (int x = 0; x < persons.size(); x++)
                                {
                                    persons.get(x).setContactName(contactPersons.get(x).getName().getLast() + ", " + contactPersons.get(x).getName().getFirst());
                                    persons.get(x).setContactNameNum(contactPersons.get(x).getCell());
                                }
                                Log.d("wendy", "count: " + persons.size());
                                mutableLiveData.setValue(persons);
                            }
                        }

                        @Override
                        public void onFailure(Call<ContactPersonResult> call, Throwable throwable) {

                        }
                    });

                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable throwable) {
            }
        });
        return mutableLiveData;
    }
}
