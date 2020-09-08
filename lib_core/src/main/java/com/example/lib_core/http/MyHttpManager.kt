package com.example.lib_core.http

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class MyHttpManager {
    private var retrofit: Retrofit? = null

    //获取retrofit
    fun getRetrofit(baseUrl: String): Retrofit? {
        if (retrofit == null) {
            create(baseUrl)
        }
        return retrofit
    }

    private fun create(baseUrl: String) {
        retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    //返回okHttpClient
    val client: OkHttpClient
        get() {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            return OkHttpClient.Builder()
                    .connectTimeout(1, TimeUnit.MINUTES)
                    .writeTimeout(1, TimeUnit.MINUTES)
                    .readTimeout(1, TimeUnit.MINUTES)
                    .addInterceptor(interceptor)
                    .build()
        }

    companion object {
        private var myHttpManager: MyHttpManager? = null

        //单例
        val instance: MyHttpManager?
            get() {
                if (myHttpManager == null) {
                    myHttpManager = MyHttpManager()
                }
                return myHttpManager
            }
    }
}