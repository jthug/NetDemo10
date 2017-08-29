package com.example.machenike.netdemo10.MVP;

import com.example.machenike.netdemo10.User;

/**
 * Created by MACHENIKE on 2017/8/29.
 */

public interface IRegisterModel {
    void register(User user,RegisterListener registerListener);

    interface RegisterListener{
        void failed(String msg);
        void success();
    }
}
