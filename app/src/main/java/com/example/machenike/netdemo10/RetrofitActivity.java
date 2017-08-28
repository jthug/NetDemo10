package com.example.machenike.netdemo10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Multipart;

public class RetrofitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
    }

    public void get(View view) {
        RetrofitClient.getInstance().getAPI().getRequest("search","language:java","1").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    ResponseBody body = response.body();
                    try {
                        Toast.makeText(RetrofitActivity.this,"成功"+body.string(),Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                    Toast.makeText(RetrofitActivity.this,"失败"+t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void post(View view) {
        RequestBody requestBody = RequestBody.create(null, "{\n" +
                "\"Password\":\"654321\",\n" +
                "\"UserName\":\"qjd\"\n" +
                "}");
        RetrofitClient.getInstance().getAPI().postRequest(requestBody).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    ResponseBody body = response.body();
                    try {
                        Toast.makeText(RetrofitActivity.this,"成功"+body.string(),Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(RetrofitActivity.this,"失败"+t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void form(View view) {

        RetrofitClient.getInstance().getAPI().formQuest("张三","1212123").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    ResponseBody body = response.body();
                    try {
                        Toast.makeText(RetrofitActivity.this,"成功"+body.string(),Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(RetrofitActivity.this,"失败"+t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void multi(View view) {
        /*MultipartBody.Part part = MultipartBody.Part.createFormData("aaa","{\n" +
                "\"name\": \"yt59856b15cf394e7b84a7d48447d16098\",\n" +
                "\"username\": \"xc62\",\n" +
                "\"nickname\": \"555\",\n" +
                "\"password\": \"123456\",\n" +
                "\"uuid\": \"0F8EC12223174657B2E842076D54C361\"\n" +
                "}");*/
        RequestBody requestBody = RequestBody.create(null, "{\n" +
                "\"name\": \"yt59856b15cf394e7b84a7d48447d16098\",\n" +
                "\"username\": \"xc62\",\n" +
                "\"nickname\": \"555\",\n" +
                "\"password\": \"123456\",\n" +
                "\"uuid\": \"0F8EC12223174657B2E842076D54C361\"\n" +
                "}");
        MultipartBody.Part part = MultipartBody.Part.createFormData("aaa",null,requestBody);
        RetrofitClient.getInstance().getAPI().nultiRequest(part).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    ResponseBody body = response.body();
                    try {
                        Toast.makeText(RetrofitActivity.this,"成功"+body.string(),Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(RetrofitActivity.this,"失败"+t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
