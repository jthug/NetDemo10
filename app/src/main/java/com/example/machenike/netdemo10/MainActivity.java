package com.example.machenike.netdemo10;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {


    private Handler mMHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .get()
                .url("https://api.github.com/search/repositories")
                .build();

        //okHttpClient.newCall(request).execute()//同步请求

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //Toast.makeText(MainActivity.this,"失败",Toast.LENGTH_SHORT).show();  运行在子线程
                Log.e("TAG","失败"+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //Toast.makeText(MainActivity.this,"成功",Toast.LENGTH_SHORT).show();
                Log.e("TAG","成功");
            }
        });*/
//--------------------------------------------------------------------------------------

    }

    public void get(View view) {
        HttpClient.getInstance().getRequest().enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG","失败"+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("TAG","成功"+response.body().string());
            }

        });
    }

    public void post(View view) {
        HttpClient.getInstance().postRequest().enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG","失败"+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("TAG","成功"+response.body().string());
            }
        });
    }

    public void form(View view) {
        HttpClient.getInstance().formRequest().enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG","失败"+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("TAG","成功"+response.body().string());
            }
        });
    }

    public void multipart(View view) {
        HttpClient.getInstance().multipartRequest().enqueue(new UICallBack() {
            @Override
            public void onFailureInUI(Call call, IOException e) {
                Toast.makeText(MainActivity.this,"失败"+e.getMessage(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponseInUI(Call call, Response response) throws IOException {
                Toast.makeText(MainActivity.this,"成功"+response.body().string(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void skip(View view) {
        startActivity(new Intent(MainActivity.this,RetrofitActivity.class));
    }
}
