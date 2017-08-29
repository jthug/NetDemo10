package com.example.machenike.netdemo10.MVP;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.machenike.netdemo10.R;
import com.example.machenike.netdemo10.User;

public class MVPRegisterActivity extends AppCompatActivity implements RegisterView{

    private EditText username;
    private EditText password;
    private String mUsername;
    private String mPassword;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvpregister);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
    }

    public void register(View view) {
        mUsername = username.getText().toString().trim();
        mPassword = password.getText().toString().trim();
        User user = new User();
        user.setPassword(mPassword);
        user.setUserName(mUsername);
        new RegisterPresenter(this).register(user);
    }
//---------------------------------实现自视图接口的方法-----------------------
    @Override
    public void showProgress() {
        mProgressDialog = ProgressDialog.show(this, "注册", "正在注册中.......");
    }

    @Override
    public void hideProgress() {
        mProgressDialog.dismiss();
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
