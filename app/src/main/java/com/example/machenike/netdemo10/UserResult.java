package com.example.machenike.netdemo10;

/**
 * Created by MACHENIKE on 2017/8/29.
 */

public class UserResult {

    @Override
    public String toString() {
        return "UserResult{" +
                "errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                ", tokenid=" + tokenid +
                '}';
    }

    /**
     * errcode : 1
     * errmsg : 注册成功！
     * tokenid : 171
     */

    private int errcode;
    private String errmsg;
    private int tokenid;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public int getTokenid() {
        return tokenid;
    }

    public void setTokenid(int tokenid) {
        this.tokenid = tokenid;
    }
}

