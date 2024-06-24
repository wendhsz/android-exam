package com.example.androidexam.serviceapi;

import android.content.Context;
import android.util.Log;

import com.example.androidexam.util.Util;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import com.example.androidexam.util.Util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitInstance {


    private static Retrofit retrofit = null;

    private static OkHttpClient client = null;


    private static Retrofit initRetrofit(File cacheDir, boolean forceUpdate)
    {
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(cacheDir, cacheSize);

        client = new OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(new CacheInterceptor())
                .build();

        if(forceUpdate)
        {
            try {
                Cache currentCache = client.cache();
                if(currentCache != null)
                {
                    currentCache.evictAll();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if(retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Util.BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static RandomPersonApiService getService(File cacheDir, boolean forceUpdate)
    {

        return initRetrofit(cacheDir,forceUpdate).create(RandomPersonApiService.class);
    }

    public static RandomContactPersonApiService getServiceForContactPerson(File cacheDir,boolean forceUpdate)
    {
        return initRetrofit(cacheDir,forceUpdate).create(RandomContactPersonApiService.class);
    }

    static class CacheInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Response response = chain.proceed(request);

            if (response.cacheResponse() != null) {
                // Cached response is available
                Log.d("wendy","Cached Data1: " + response.peekBody(Long.MAX_VALUE).string());
            } else if (response.networkResponse() != null) {
                // Network response
                Log.d("wendy","Network Data1: " + response.peekBody(Long.MAX_VALUE).string());
            }

            return response;
        }
    }



}
