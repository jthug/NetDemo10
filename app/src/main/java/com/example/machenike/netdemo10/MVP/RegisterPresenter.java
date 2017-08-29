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

public class RegisterPresenter {
    private RegisterView mRegisterView;
    private final RegisterModel mRegisterModel;

    public RegisterPresenter(RegisterView registerView) {
        mRegisterView = registerView;
        mRegisterModel = new RegisterModel();
    }

    public void register(User user){
       /* //显示进度条
        mRegisterView.showProgress();
        RetrofitClient.getInstance().getAPI().postRequest(user).enqueue(new Callback<UserResult>() {
            @Override
            public void onResponse(Call<UserResult> call, Response<UserResult> response) {
                //隐藏进度条
                mRegisterView.hideProgress();
                if (response.isSuccessful()){
                    UserResult userResult = response.body();
                    if (userResult!=null){
                        if (userResult.getErrcode()==1){
                            //成功，弹toast
                            mRegisterView.showMessage("注册成功！");
                            return;
                        }
                        //弹toast
                        mRegisterView.showMessage(userResult.getErrmsg());
                        return;
                    }
                    //弹toast
                    mRegisterView.showMessage("未知错误");
                    return;
                }
                //弹toast
                mRegisterView.showMessage("未知错误");
            }

            @Override
            public void onFailure(Call<UserResult> call, Throwable t) {
                //隐藏进度条
                mRegisterView.hideProgress();
                //失败，弹toast
                mRegisterView.showMessage("注册失败");
            }
        });*/

       mRegisterModel.register(user, new IRegisterModel.RegisterListener() {
           @Override
           public void failed(String msg) {

           }

           @Override
           public void success() {
                mRegisterView.showProgress();
           }
       });
    }
}
