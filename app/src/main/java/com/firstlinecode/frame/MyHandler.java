package com.firstlinecode.frame;

import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/3/16 0016.
 */

public class MyHandler {
    public void doLogin(View view){
        Toast.makeText(view.getContext(),"点击了登录",Toast.LENGTH_SHORT).show();
    }
    public boolean canLogin(String name,String password){
        if (!TextUtils.isEmpty(name)&&!TextUtils.isEmpty(password)){
            return true;
        }else {
            return false;
        }
    }
}
