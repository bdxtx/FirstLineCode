package com.firstlinecode.frame;

import android.databinding.ObservableField;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;


/**
 * Created by Administrator on 2018/3/16 0016.
 */

public class LoginViewHelper {
    //监听属性
    public ObservableField<String> username=new ObservableField<>();
    public ObservableField<String> password=new ObservableField<>();

    public void doLogin(View view){
        Toast.makeText(view.getContext(),"正在登录",Toast.LENGTH_SHORT).show();
//        return false;
    }

}
