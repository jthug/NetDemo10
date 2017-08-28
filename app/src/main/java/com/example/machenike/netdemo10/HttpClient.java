package com.example.machenike.netdemo10;

import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by MACHENIKE on 2017/8/28.
 */

public class HttpClient {
    private static HttpClient mHttpClient;
    private final OkHttpClient mOkHttpClient;

    private HttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        mOkHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
    }

    public static synchronized HttpClient getInstance(){

        if (mHttpClient==null){
            mHttpClient = new HttpClient();
        }
        return mHttpClient;
    }

    public Call getRequest(){
        Request request = new Request.Builder()
                .url("https://api.github.com/search/repositories")
                .build();
        return mOkHttpClient.newCall(request);
    }

    public Call postRequest(){
        RequestBody requestBody = RequestBody.create(null, "{\n" +
                "\"Password\":\"654321\",\n" +
                "\"UserName\":\"qjd\"\n" +
                "}");
        Request request = new Request.Builder()
                .url("http://admin.syfeicuiedu.com/Handler/UserHandler.ashx?action=register")
                .post(requestBody)
                .build();
        return mOkHttpClient.newCall(request);
    }

    public Call formRequest(){
        FormBody formBody = new FormBody.Builder()
                .add("username", "张三")
                .add("password", "123456")
                .build();
        Request request = new Request.Builder()
                .url("http://wx.feicuiedu.com:9094/yitao/UserWeb?method=register")
                .post(formBody)
                .build();
        return mOkHttpClient.newCall(request);
    }

    public Call multipartRequest(){
        RequestBody requestBody = RequestBody.create(null, "{\n" +
                "\"name\": \"yt59856b15cf394e7b84a7d48447d16098\",\n" +
                "\"username\": \"xc62\",\n" +
                "\"nickname\": \"555\",\n" +
                "\"password\": \"123456\",\n" +
                "\"uuid\": \"0F8EC12223174657B2E842076D54C361\"\n" +
                "}");
        MultipartBody multipartBody = new MultipartBody.Builder()
                .addPart(requestBody)
                .build();
        Request request = new Request.Builder()
                .url("http://wx.feicuiedu.com:9094/yitao/UserWeb?method=update")
                .post(multipartBody)
                .build();
        return mOkHttpClient.newCall(request);
    }
}
