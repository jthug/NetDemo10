package com.example.machenike.netdemo10;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    private EditText mUsername;
    private EditText mPassword;
    private String mUsername1;
    private String mPassword1;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mUsername = (EditText) findViewById(R.id.username);
        mPassword = (EditText) findViewById(R.id.password);
    }

    public void register(View view) {
        mUsername1 = mUsername.getText().toString().trim();
        mPassword1 = mPassword.getText().toString().trim();

        User user = new User();
        user.setUserName(mUsername1);
        user.setPassword(mPassword1);
        mProgressDialog = ProgressDialog.show(this, "注册", "玩命儿注册中.....");
        RetrofitClient.getInstance().getAPI().postRequest(user).enqueue(new Callback<UserResult>() {


            @Override
            public void onResponse(Call<UserResult> call, Response<UserResult> response) {
                mProgressDialog.dismiss();
                if (response.isSuccessful()){
                    UserResult userResult = response.body();
                    if (userResult!=null){
                        if (userResult.getErrcode()==1){
                            Toast.makeText(RegisterActivity.this,"注册成功！！",Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Toast.makeText(RegisterActivity.this,userResult.getErrmsg(),Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Toast.makeText(RegisterActivity.this,"未知错误！",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserResult> call, Throwable t) {
                mProgressDialog.dismiss();
                Toast.makeText(RegisterActivity.this,"注册失败",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
