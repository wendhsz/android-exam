package com.example.androidexam.serviceapi;

import com.example.androidexam.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface RandomPersonApiService {

    @Headers("Cache-Control: public, max-age=3600")
    @GET("api")
    Call<Result> getRandomPeople(@Query("inc") String inclusion, @Query("nat") String nationality,
                                 @Query("results") String resultCount,
                                 @Query("seed") String seed,
                                 @Query("page") String page);

}
