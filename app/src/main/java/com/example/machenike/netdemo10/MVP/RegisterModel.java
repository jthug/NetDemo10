package com.example.machenike.netdemo10.MVP;

import com.example.machenike.netdemo10.RetrofitClient;
import com.example.machenike.netdemo10.User;
import com.example.machenike.netdemo10.UserResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by MACHENIKE on 2017/8/29.
 */

public class RegisterModel implements IRegisterModel{

    @Override
    public void register(User user, final RegisterListener registerListener) {
        //显示进度条
        RetrofitClient.getInstance().getAPI().postRequest(user).enqueue(new Callback<UserResult>() {
            @Override
            public void onResponse(Call<UserResult> call, Response<UserResult> response) {
                //隐藏进度条
                if (response.isSuccessful()){
                    UserResult userResult = response.body();
                    if (userResult!=null){
                        if (userResult.getErrcode()==1){
                            //成功，弹toast
                            registerListener.success();
                            return;
                        }
                        //弹toast
                        registerListener.failed("aaa");
                        return;
                    }
                    //弹toast
                    registerListener.failed("bbb");
                    return;
                }
                //弹toast
                registerListener.failed("ccc");
            }

            @Override
            public void onFailure(Call<UserResult> call, Throwable t) {
                //隐藏进度条
                //失败，弹toast
                registerListener.failed("ddd");
            }
        });
    }
}
