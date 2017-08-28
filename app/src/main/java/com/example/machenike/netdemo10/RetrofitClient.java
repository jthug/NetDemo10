package com.example.machenike.netdemo10;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/**
 * Created by MACHENIKE on 2017/8/28.
 */

public class RetrofitClient {
    private static RetrofitClient mRetrofitClient;
    private final Retrofit mRetrofit;

    private RetrofitClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .client(okHttpClient)
                .build();
    }

    public static synchronized RetrofitClient getInstance(){
        if (mRetrofitClient==null){
            mRetrofitClient = new RetrofitClient();
        }
        return mRetrofitClient;
    }

    public RetrofitAPIs getAPI(){
        return mRetrofit.create(RetrofitAPIs.class);
    }
}
