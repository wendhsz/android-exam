package com.example.androidexam.util;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

import java.net.NetworkInterface;


public class Util {
    public static final String BASE_URL = "https://randomuser.me/";
    public static final String API_INCLUSION = "name,location,email,dob,cell,picture";
    public static final String API_RANDOM_INCLUSION = "name,cell";
    public static final String API_NATIONALITY = "us";
    public static final String API_SEED = "e6aa10cad30dd6ba";

    public static final String API_SEED_CONTACT_PERSON = "04605d63f9c5421b";
    public static final String API_RESULT_COUNT = "20";
//    public static final String API_PAGE_START = "1";

//    public static Boolean isNetworkAvailable(Context context) {
//        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            Network nw = connectivityManager.getActiveNetwork();
//            if (nw == null) return false;
//            NetworkCapabilities actNw = connectivityManager.getNetworkCapabilities(nw);
//            return actNw != null && (actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) || actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) || actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) || actNw.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH));
//        } else {
//            NetworkInfo nwInfo = connectivityManager.getActiveNetworkInfo();
//            return nwInfo != null && nwInfo.isConnected();
//        }
//    }


}
