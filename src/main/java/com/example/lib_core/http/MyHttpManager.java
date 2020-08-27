package com.example.lib_core.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyHttpManager {
    private static MyHttpManager myHttpManager;

    public static MyHttpManager getInstance(){
        if (myHttpManager==null){
            myHttpManager = new MyHttpManager();
        }
        return myHttpManager;
    }

    private Retrofit retrofit;

    public Retrofit getRetrofit(String baseUrl) {
        if (retrofit==null){
            create(baseUrl);
        }
        return retrofit;
    }

    private void create(String baseUrl) {
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(getClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public OkHttpClient getClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new  OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1,TimeUnit.MINUTES)
                .readTimeout(1,TimeUnit.MINUTES)
                .addInterceptor(interceptor)
                .build();
        return client;
    }
}
